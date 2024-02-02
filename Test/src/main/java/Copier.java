//import org.junit.Test;

public class Copier {

    //variable represents the source from which the Copier will read data.
    private  final ISource source;

    // variable represents the destination where the Copier will write the data.
    private  final IDestination destination;

    //initializing the Copier with a specific source and destination.
    public Copier(ISource source, IDestination destination) {
        this.source = source;
        this.destination = destination;
    }


    public void copy() {
        char currentChar;
        //The loop to reads one character at a time from the source until it encounters a newline character
        while ((currentChar = source.readChar()) != '\n') {
            destination.writeChar(currentChar);
        }
    }

}
