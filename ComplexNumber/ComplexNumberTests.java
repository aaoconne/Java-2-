import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComplexNumberTests {
	private static ComplexNumber posNum;
	private static ComplexNumber negNum; 
	private static ComplexNumber zeroNum;
	private static ComplexNumber sum;
	//tester class setup 
	@BeforeClass 
	public static void setup(){
		posNum = new ComplexNumber(2, 5);
		negNum = new ComplexNumber(-1, -7);
		zeroNum = new ComplexNumber(0, 0);
		sum = new ComplexNumber(1, -2);
		//creation of complex numbers that have either negative values,
		//positve values, or zero as values 
	}

@Test
public void testAdd(){ //testing the add method 
	assertEquals(negNum.add(zeroNum), negNum);
	assertEquals(posNum.add(zeroNum), negNum);
	}

 @Test 
 public void testSubtract(){ //testing the subtract method 
	assertEquals(negNum.subtract);
	}

 @Test 
 public void testMultiply(){
 	assertEquals();
 	assertEquals();
 	}

 @Test
 public void testDivide(){
 	assertEquals();
 	assertEquals();
 	}

 @Test
 public void testEquals(){
	 assertTrue(negNum.equals(negNum));
	 assertTrue(!posNum.equals(zeroNum));
 	}

}
