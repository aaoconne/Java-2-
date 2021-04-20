import java.util.ArrayList;

public class StudentDatabaseIO {

    public static void formattedToSerialized(String inputFilename, String outputFilename) { 
        StudentDatabaseCSVFileReader.openFile(inputFilename);
        StudentDatabase db = StudentDatabaseCSVFileReader.readData();
        StudentDatabaseCSVFileReader.closeFile();

        db.sortByGPA();
        
        StudentDatabaseSerializedFileWriter.openFile(outputFilename);
        StudentDatabaseSerializedFileWriter.writeData(db);
        StudentDatabaseSerializedFileWriter.closeFile();
         
    }
    public static void serializedToFormatted(String inputFilename, String outputFilename) { 
        StudentDatabaseSerializedFileReader.openFile(inputFilename);
        StudentDatabase db = StudentDatabaseSerializedFileReader.readData();
        StudentDatabaseSerializedFileReader.closeFile();

        db.sortByGPA();
        StudentDatabaseCSVFileWriter.openFile(outputFilename);
        StudentDatabaseCSVFileWriter.writeData(db);
        StudentDatabaseCSVFileWriter.closeFile();
         
    }
    public static void formattedToFormatted(String inputFilename, String outputFilename) { 
        StudentDatabaseCSVFileReader.openFile(inputFilename);
        StudentDatabase db = StudentDatabaseCSVFileReader.readData();
        StudentDatabaseCSVFileReader.closeFile();

        db.sortByGPA();
        StudentDatabaseCSVFileWriter.openFile(outputFilename);
        StudentDatabaseCSVFileWriter.writeData(db);
        StudentDatabaseCSVFileWriter.closeFile();
         
    }
    public static void serializedToSerialized(String inputFilename, String outputFilename) { 
        StudentDatabaseSerializedFileReader.openFile(inputFilename);
        StudentDatabase db = StudentDatabaseSerializedFileReader.readData();
        StudentDatabaseSerializedFileReader.closeFile();

        db.sortByGPA();
         
        StudentDatabaseSerializedFileWriter.openFile(outputFilename);
        StudentDatabaseSerializedFileWriter.writeData(db);
        StudentDatabaseSerializedFileWriter.closeFile();
    }
}
