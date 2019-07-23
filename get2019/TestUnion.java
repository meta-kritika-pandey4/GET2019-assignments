package get2019;

import static org.junit.Assert.*;

import org.junit.Test;
public class TestUnion{
	@Test
	public void testGetUnion()
	{
		int input1[]={1,2,3,4,5,6,7,8,9,10};
		int input2[]={2,3,11,12};
		intSet inputSet1=new intSet(input1,10);
		intSet inputSet2=new intSet(input2,4);
		intSet actual=inputSet1.getUnion(inputSet1,inputSet2);
		int[] actualSet=actual.getSet();
		int[] expected={1,2,3,4,5,6,7,8,9,10,11,12};
		assertArrayEquals("Actual Output does not match the expected ouput",expected,actualSet);
	}
	@Test
	public void testGetUnionNullArray()
	{
		int input1[]={1,2,3,4,5,6,7,8,9,10};
		int input2[]={2,3,11,12};
		intSet inputSet1=new intSet(input1,10);
		intSet inputSet2=new intSet(input2,4);
		intSet actual=inputSet1.getUnion(inputSet1,inputSet2);
		int[] actualSet=actual.getSet();
		int[] expected={1,2,3,4,5,6,7,8,9,10,11,12};
		assertArrayEquals("Actual Output does not match the expected ouput",expected,actualSet);
	}
	@Test(expected=AssertionError.class)
	public void testGetUnionInvalidValues()
	{
		int input1[]={1,2000,3,4,5,6,7,8,9,1000};
		int input2[]={2,3,11,12};
		intSet inputSet1=new intSet(input1,10);
		intSet inputSet2=new intSet(input2,4);
		intSet actual=inputSet1.getUnion(inputSet1,inputSet2);
	}
	
	
}