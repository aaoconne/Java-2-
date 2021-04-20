import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before; 

public class ListTester{
    private LinkedList<Dog> list; 

    @Before 
    public void Setup(){
        Dog fifi = new Dog("Fifi", 12, 8);
        Dog butch = new Dog("Butch", 10, 10);
        Dog leonard = new Dog("Leonard", 22, 13);
        Dog spot = new Dog("Spot", 17, 9);
        Dog jack = new Dog("Jack", 18, 18);
        list = new LinkedList<Dog>();
        list.add(fifi);
        list.add(butch);
        list.add(leonard);
        list.add(spot);
        list.add(jack,1);

    }
    @Test
    public void testForward(){
        Iterator<Dog> iter = list.getIterator();
        String output = "";
        while (iter.hasNext()) {
            Dog foo = iter.next();
            output += foo.toString() + "\n";
        }
        
        String expectedOutput = "Dog: Fifi , height: 8 weight: 12\n"+
        "Dog: Jack , height: 18 weight: 18\n"+
        "Dog: Butch , height: 10 weight: 10\n"+
        "Dog: Leonard , height: 13 weight: 22\n"+
        "Dog: Spot , height: 9 weight: 17\n";
        assertEquals(expectedOutput, output);
    }
    @Test
    public void testBackward(){
        Iterator<Dog> iter = list.getIterator();
        String output = "";
        iter.setToEnd();
        while (iter.hasPrior()) {
            Dog foo = iter.prior();
            output += foo.toString() + "\n";
        }
        
        String expectedOutput =  "Dog: Spot , height: 9 weight: 17\n"+
        "Dog: Leonard , height: 13 weight: 22\n"+
        "Dog: Butch , height: 10 weight: 10\n"+
        "Dog: Jack , height: 18 weight: 18\n"+
        "Dog: Fifi , height: 8 weight: 12\n";
        assertEquals(expectedOutput, output);
    }

}