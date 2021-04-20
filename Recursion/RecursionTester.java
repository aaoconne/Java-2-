import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

public class RecursionTester{
    String s1, s2, s3, s4;
    ArrayList<String> list, list1;
    
    /**
     * Called before every test. 
     */
    @Before 
    public void setup(){
        s1 = "dog";
        s2 = "shoe";
        s3 = "doggy";
        s4 = "water";
        list = new ArrayList();
        list1 = new ArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

    }
    /**
     * tests the compareTo method. 
     */
    @Test 
    public void testCompareString(){
        int result = Recursion.compareTo(s1, s2);
        assertEquals(-1, result);
        result = Recursion.compareTo(s3, "DOGGY");
        assertEquals(0, result);
        result = Recursion.compareTo(s3, s1);
        assertEquals(1, result);
    }

    /**
     * tests the testfindMinimum method. 
     */
    @Test 
    public void testfindMinimum(){
        assertEquals("dog", Recursion.findMinimum(list));
        assertNotEquals("water", Recursion.findMinimum(list));
        assertEquals("", Recursion.findMinimum(list1));
    }

}