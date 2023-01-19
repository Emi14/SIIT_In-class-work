package week11;

import org.h2.tools.Console;
import org.junit.jupiter.api.*;
import org.siit.week11.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorsBooksTest
{
    private static Connection dbConnection;

    @BeforeAll
    public static void setup() throws SQLException
    {
        dbConnection = DriverManager.getConnection("jdbc:h2:mem:testcase", "sa", "");
        org.h2.tools.Server.createWebServer().start();
    }

    @AfterAll
    public static void cleanUp() throws SQLException
    {
        dbConnection.close();
    }

    @Test
    @Order(1)
    public void createData() throws SQLException
    {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS authors\n" +
                "(\n" +
                "    id bigint NOT NULL,\n" +
                "    name character varying(100) NOT NULL,\n" +
                "    email character varying(100) NOT NULL,\n" +
                "    CONSTRAINT authors_pkey PRIMARY KEY (id)\n" +
                ")");
        preparedStatement.execute();
        preparedStatement = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS bookz\n" +
                "            (\n" +
                "                    id bigint NOT NULL,\n" +
                "                    carte character varying(100) NOT NULL,\n" +
                "                    autor bigint NOT NULL,\n" +
                "                    CONSTRAINT books_pkey PRIMARY KEY (id),\n" +
                "                    CONSTRAINT \"authorsFK\" FOREIGN KEY (autor)\n" +
                "                    REFERENCES authors (id) \n)");
        preparedStatement.execute();
    }

    @Test
    @Order(2)
    public void insertData() {
        Main.addAuthorAndBookWithConnection(dbConnection,6, "Dj Bobo", "bobo@bobo.bo", 6, "BoBook");
    }

    @Test
    @Order(3)
    public void selectData() {
        System.out.println(Main.selectAllBooks(dbConnection));
    }
}
