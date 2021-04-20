import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Formatter;


public class StudentDatabaseSerializedFileWriter {

    private static FileOutputStream outFile;
    private static ObjectOutputStream outObj;

    public static void openFile (String filename) {

        try {
            outFile = new FileOutputStream(filename);
            outObj = new ObjectOutputStream(outFile);
        }   
        catch (IOException e) {
            System.err.println("Error opening file. " + filename + "  Terminating");
            System.exit(1);
        }        
    }    

    public static void writeData(StudentDatabase db) {
        try {
            outObj.writeObject(db);
        } catch (IOException e) {
            System.err.println("Error writing object.  Terminating");
            System.exit(1);
        }
    }

    public static void closeFile() {
        try{
            if(outFile != null)
                outFile.close(); 
            if(outObj != null)
                outObj.close();
            outFile = null; 
            outObj = null; 
        } 
        catch (IOException e) {
            System.err.println("Error closing file.  Terminating");
            System.exit(1);
        }
    }

}
