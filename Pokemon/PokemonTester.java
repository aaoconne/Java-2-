package HW2;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;
import org.junit.*;

public class PokemonTester {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ByteArrayOutputStream errorOutput = new ByteArrayOutputStream();
    private String lineSeparator = System.getProperty("line.separator");

        Pokemon bob; 
        Pokemon joe; 
        Pokemon haydar;
        Pokemon stimpy;

        PokemonTrainer larry;
        PokemonTrainer camille;
        PokemonTrainer devin;

    @Before
    public void setup() {
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(errorOutput));

        // build some Pokemon objects
        bob = new Pokemon("Bob",100,17);
        joe = new Pokemon("Joe",80,12);
        haydar = new Pokemon("Haydar",70,22);
        stimpy = new Pokemon("Stimpy",95,11);

        // build some PokemonTrainer objects
        larry = new PokemonTrainer("Larry");
        camille = new PokemonTrainer("Camille");
        devin = new PokemonTrainer("Devin");

        bob.addObserver(larry);
        bob.addObserver(camille);

        // devin is responsible for haydar and stimpy
        haydar.addObserver(devin);
        stimpy.addObserver(devin);

        // camille is also responsible for stimpy
        stimpy.addObserver(camille);

        // only larry is responsible for joe's well being
        joe.addObserver(larry);

    } // end @Before method

    @Test
    public void testAttack() {
        stimpy.attack(haydar); // stimpy is the first one to get into trouble
        haydar.attack(stimpy); // haydar, or course, retaliates
        bob.attack(joe);     // now it's bob's turn to get into the fray
        joe.attack(haydar);
        String expected = "PokemonTrainer Devin is notified that Pokemon Stimpy attacked Pokemon Haydar using Body Slam for 11 damage.\n" +
        "PokemonTrainer Devin is notified that Pokemon Haydar attacked Pokemon Stimpy using Body Slam for 22 damage.\n"+
        "PokemonTrainer Camille is notified that Pokemon Haydar attacked Pokemon Stimpy using Body Slam for 22 damage.\n"+
        "PokemonTrainer Larry is notified that Pokemon Bob attacked Pokemon Joe using Body Slam for 17 damage.\n"+
        "PokemonTrainer Devin is notified that Pokemon Joe attacked Pokemon Haydar using Body Slam for 12 damage.";
        assertEquals(expected + lineSeparator, output.toString());
    }

    @Test
    public void testStdErr() {
        System.err.println("good bye");
        assertEquals("good bye" + lineSeparator, errorOutput.toString());
    }

    @After
    public void resetStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    } // end @After method
} // end class RedirectTester