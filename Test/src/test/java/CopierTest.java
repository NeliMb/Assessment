import org.junit.Test;
import org.mockito.ArgumentCaptor;
import java.util.List;
import static org.mockito.Mockito.*;

public class CopierTest {

    @Test
    //Test case
    public void testingCopy() {
        // Create mock objects
        ISource source = mock(ISource.class);
        IDestination destination = mock(IDestination.class);

        // The behavior defining of ISource mock
        when(source.readChar()).thenReturn('T', 'e', 's', 't', 'i', 'n', 'g', '\n');

        // Creating the Copier instance of the copier class with the mock objects
        Copier copier = new Copier(source, destination);

        // Calling the copy method to the copier
        copier.copy();

        //Checks that the writeChar method on the destination mock is called exactly 7 times with any character.
        verify(destination, times(7)).writeChar(anyChar());
        verify(destination, never()).writeChar('\n'); // Ensure newline is not written

        // Capture and print the results
        //System.out.println("Test results");
        printCapturedOutput(destination);

    }
    private void printCapturedOutput(IDestination destination) {

        // Using ArgumentCaptor to capture and inspect the parameters passed to writeChar
        //Captures the arguments for Character passed to the writeChar method
        ArgumentCaptor<Character> argumentCaptor = ArgumentCaptor.forClass(Character.class);


        //checks that the writeChar method on the destination mock is called at least once
        // and captures the arguments each time it is called.
        verify(destination, atLeastOnce()).writeChar(argumentCaptor.capture());

        // Retrieves all the captured characters
        List<Character> capturedCharacters = argumentCaptor.getAllValues();

        // Print the captured output
        System.out.print("Captured results of writeChar method: ");
        //Iterates through the list of captured characters and prints each character.
        for (Character character : capturedCharacters)
            System.out.print(character);

    }
}

