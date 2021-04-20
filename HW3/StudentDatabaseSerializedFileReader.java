import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentDatabaseSerializedFileReader {

    private static FileInputStream inFile;
    private static ObjectInputStream inObj;

    public static void openFile(String filename) {

        try {
            inFile = new FileInputStream(filename);
            inObj = new ObjectInputStream(inFile);

        } catch (IOException e) {
            System.err.println("Error opening file. " + filename + " Terminating");
            System.exit(1);
        }
    }

    public static StudentDatabase readData() {
        StudentDatabase db = new StudentDatabase();
        try {
            db = (StudentDatabase) inObj.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Error converting to student database. Terminating");
            System.exit(1);
        } catch (IOException c) {
            System.err.println("Error reading object.  Terminating");
            System.exit(1);
        }
        return db;
    }

    public static void closeFile() {
        try {
            if (inFile != null)
                inFile.close();
            if (inObj != null)
                inObj.close();
            inFile = null;
            inObj = null;
        } catch (IOException e) {
            System.err.println("Error closing file. Terminating");
            System.exit(1);
        }
    }

}
