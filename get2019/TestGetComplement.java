package get2019;
import static org.junit.Assert.*;
import org.junit.Test;
public class TestGetComplement{
	@Test
	public void testGetComplement()
	{
		int input[]={1,2,3,4,5,6,7,8,9,10};
		int k=0;
		int expected[]=new int[990];
		for(int i=11;i<=1000;i++)
			expected[k++]=i;
		intSet inputSet=new intSet(input,10);
		intSet actual=inputSet.getComplement();
		int[] actualSet=actual.getSet();
		assertArrayEquals("Actual Output does not match the expected ouput",expected,actualSet);
	}
	@Test
	public void testGetComplementNullSet()
	{
		int input[]={};
		int k=0;
		int expected[]=new int[1000];
		for(int i=1;i<=1000;i++)
			expected[k++]=i;
		intSet inputSet=new intSet(input,0);
		intSet actual=inputSet.getComplement();
		int[] actualSet=actual.getSet();
		
		assertArrayEquals("Actual Output does not match the expected ouput",expected,actualSet);
	}
	@Test(expected=AssertionError.class)
	public void testGetComplementInvalidValues()
	{
		int input[]={100,200,2000,1001};
		
		
			
		intSet inputSet=new intSet(input,4);
		
		
		intSet actualResult=inputSet.getComplement();
	}
	
	
}