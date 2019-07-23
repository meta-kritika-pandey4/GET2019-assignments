package get2019;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestEvaluate {

	@Test
	public void testEvaluate() {
		Term term1=new Term(5,3);
		Term term2=new Term(2,2);
		Term term3=new Term(8,0);
		Term[] polynomial=new Term[3];
		polynomial[0]=term1;
		polynomial[1]=term2;
		polynomial[2]=term3;		
		Poly poly1=new Poly(polynomial,3);
		double actual=poly1.evaluate(2);
		double expected=(double)56;
		assertEquals("Actual and expected values are different",expected,actual,0);
		}
	

}
