package get2019;

import static org.junit.Assert.*;

import org.junit.Test;
public class TestSize{
	@Test
	public void testSize1()
	{
		int input[]={5,4,9,4,9,5};
		intSet inputSet=new intSet(input,6);
		int expected=6;
		assertEquals("Actual Output does not match the expected ouput",expected,inputSet.size());
	}
	@Test
	public void testSizeZero()
	{
		int input[]={1,4,1,5};
		intSet inputSet=new intSet(input,0);
		int expected=0;
		assertEquals("Actual Output does not match the expected ouput",expected,inputSet.size());
	}
	
}
