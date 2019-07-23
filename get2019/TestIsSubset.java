package get2019;
import static org.junit.Assert.*;
import org.junit.Test;
public class TestIsSubset{
	@Test
	public void testIsSubsetTrue()
	{
		int input[]={5,4,9,4,9,5};
		int subset[]={4,9,4};
		intSet inputSet=new intSet(input,6);
		intSet inputSubset=new intSet(subset,3);
		boolean expected=true;
		assertEquals("Actual Output does not match the expected ouput",expected,inputSet.isSubset(inputSubset));
	}
	@Test
	public void testIsSubsetFalse()
	{
		int input[]={5,4,9,4,9,5};
		int subset[]={4,9,5,6};
		intSet inputSet=new intSet(input,6);
		intSet inputSubset=new intSet(subset,4);
		boolean expected=false;
		assertEquals("Actual Output does not match the expected ouput",expected,inputSet.isSubset(inputSubset));
	}
	@Test(expected=AssertionError.class)
	public void testIsSubsetInvalidValues()
	{
		int input[]={100,200,2000,1001};
		int subset[]={100,2000};			
		intSet inputSet=new intSet(input,4);
		intSet inputSubset=new intSet(subset,2);		
		boolean actualResult=inputSet.isSubset(inputSubset);
	}
}