package week7.phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.siit.week7.io.phonebook.Phonebook;
import org.siit.week7.io.phonebook.exception.NameNotFoundInPhonebookException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {

    Phonebook phonebook;

    @BeforeEach
    void setUp() {
        phonebook = new Phonebook();
    }

    @Test
    public void testReadPhonebookFile_whenFileIsNotFound_thenRuntimeExceptionIsThrown() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> Phonebook.readPhonebookFile("fsafsa"));
        assertEquals(Phonebook.INVALID_FILE_NAME, exception.getMessage());
    }

    @Test
    public void testReadPhonebookFile_whenFileIsFound_thenResponseIsPresent() {
        Map<String, String> result = Phonebook.readPhonebookFile("src/main/resources/in/phonebook.txt");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testSearchInPhonebook_whenGivenNameIsNotFound_thenExceptionIsThrown() {
        Map<String, String> phonebookFile = Phonebook.readPhonebookFile("src/main/resources/in/phonebook.txt");
        assertThrows(NameNotFoundInPhonebookException.class, () -> Phonebook.searchInPhonebook(phonebookFile, "invalidInput"));
    }

    @Test
    public void testSearchInPhonebook_whenGivenNameIsFound_thenTheCorrectNumberIsReturned() throws NameNotFoundInPhonebookException {
        //Maritza 8205261190
        Map<String, String> phonebookFile = Phonebook.readPhonebookFile("src/main/resources/in/phonebook.txt");
        String phoneNumber = Phonebook.searchInPhonebook(phonebookFile, "Maritza");
        assertEquals("8205261190", phoneNumber);
    }
}