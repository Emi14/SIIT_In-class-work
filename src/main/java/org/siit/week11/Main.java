package org.siit.week11;

import org.siit.week11.model.Author;
import org.siit.week11.model.Book;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main
{
    public static void main(String[] args)
    {
        initializeJDBCDriver();
        Optional<Connection> connection = getJDBCConnection();
        if (!connection.isPresent()) {
            return;
        }

        List<Author> authors = selectAllAuthors(connection.get());
        System.out.println(authors);

        connection = getJDBCConnection();
        if (!connection.isPresent()) {
            return;
        }
        List<Book> books = selectAllBooks(connection.get());
        System.out.println(books);

        updateBook(3, "Capra cu 4 iezi");
        updateBook(3, "Capra cu 3 iezi");

        addAuthorAndBook(6, "Dj Bobo", "bobo@bobo.bo", 6, "BoBook");
    }

    private static void addAuthorAndBook(int authorId, String authorName, String email, int bookId, String bookName)
    {
        Optional<Connection> optionalConnection = getJDBCConnection();
        if (!optionalConnection.isPresent()) {
            return;
        }
        try (Connection connection = optionalConnection.get())
        {
            try(PreparedStatement authorInsert = connection.prepareStatement("insert into authors values(?, ?, ?)");
                PreparedStatement bookInsert = connection.prepareStatement("insert into bookz values(?, ?, ?)")) {
                authorInsert.setInt(1, authorId);
                authorInsert.setString(2, authorName);
                authorInsert.setString(3, email);
                bookInsert.setInt(1, bookId);
                bookInsert.setString(2, bookName);
                bookInsert.setInt(3, 456);

                connection.setAutoCommit(false);
                authorInsert.executeUpdate();
                bookInsert.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
            }
            catch (SQLException ex) {
                System.err.println(ex.getMessage());
                connection.rollback();
            }
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void addAuthorAndBookWithConnection(Connection connection, int authorId, String authorName, String email, int bookId, String bookName)
    {
        try
        {
            try(PreparedStatement authorInsert = connection.prepareStatement("insert into authors values(?, ?, ?)");
                PreparedStatement bookInsert = connection.prepareStatement("insert into bookz values(?, ?, ?)")) {
                authorInsert.setInt(1, authorId);
                authorInsert.setString(2, authorName);
                authorInsert.setString(3, email);
                bookInsert.setInt(1, bookId);
                bookInsert.setString(2, bookName);
                bookInsert.setInt(3, authorId);

                connection.setAutoCommit(false);
                authorInsert.executeUpdate();
                bookInsert.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
            }
            catch (SQLException ex) {
                System.err.println(ex.getMessage());
                connection.rollback();
            }
        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private static void updateBook(int id, String bookName)
    {
        Optional<Connection> optionalConnection = getJDBCConnection();
        if (!optionalConnection.isPresent()) {
            return;
        }
        try (Connection connection = optionalConnection.get();
            PreparedStatement preparedStatement = connection.prepareStatement("update bookz set carte=? where id=?"))
        {
            preparedStatement.setString(1, bookName);
            preparedStatement.setInt(2, id);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);

        } catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static List<Book> selectAllBooks(Connection connection)
    {
        List<Book> toReturn = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from bookz where carte like '%'");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Book author = Book.builder()
                        .id(resultSet.getInt("id"))
                        .bookName(resultSet.getString("carte"))
                        .authorId(resultSet.getInt("autor"))
                        .build();
                toReturn.add(author);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { }
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException e) { }
            try { connection.close(); } catch (SQLException e) { }
        }
        return toReturn;
    }

    private static List<Author> selectAllAuthors(Connection connection)
    {
        List<Author> toReturn = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("select * from authors");

            while(resultSet.next()) {
                Author author = Author.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .email(resultSet.getString("email"))
                        .build();
                toReturn.add(author);
            }
//            resultSet = statement.executeQuery("update authors set email='cvt@rm.ro' where id=3");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (resultSet != null) try { resultSet.close(); } catch (SQLException e) { }
            if (statement != null) try { statement.close(); } catch (SQLException e) { }
            try { connection.close(); } catch (SQLException e) { }
        }
        return toReturn;
    }

    private static void initializeJDBCDriver()
    {
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            System.err.println(e.getMessage());
        }
    }

    private static Optional<Connection> getJDBCConnection()
    {
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: database may be busy, good to set a higher timeout
        try {
            String url = "jdbc:postgresql://localhost:5432/books?user=postgres&password=admin";
            return Optional.ofNullable(DriverManager.getConnection(url));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
    }
}
