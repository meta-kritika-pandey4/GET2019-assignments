package get2019;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class TestIsMember {
	private int x;
	private boolean expectedResult;
	public TestIsMember(int x,boolean expectedResult)
	{
		this.x=x;
		this.expectedResult=expectedResult;
	}
	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][]{{1,false},{45,true}});
	
	}
	@Test
	public void testIsMember()
	{
		int set[]={12,45,24,10,36,15};
		intSet setObj=new intSet(set,set.length);
		boolean actualResult=setObj.isMember(x);
		assertEquals("Actual and Expected Results do not match",expectedResult,actualResult);
	}

}
