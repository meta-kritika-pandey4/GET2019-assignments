import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestEvaluateTranspose {

	@Test
	public void testEvaluateTranspose() {
		Element matrix1element1=new Element(1,1,20);
		Element matrix1element2=new Element(3,4,30);
		Element matrix1element3=new Element(2,1,20);
		Element matrix1element4=new Element(4,3,30);
		Element matrix2element1=new Element(1,1,20);
		Element matrix2element2=new Element(4,3,30);
		Element matrix2element3=new Element(1,2,20);
		Element matrix2element4=new Element(3,4,30);
		ArrayList<Element> inputMatrix=new ArrayList<Element>();
		inputMatrix.add(matrix1element1);
		inputMatrix.add(matrix1element2);
		inputMatrix.add(matrix1element3);
		inputMatrix.add(matrix1element4);
		ArrayList<Element> transposeMatrix=new ArrayList<Element>();
		SparseMatrix sm1=new SparseMatrix(inputMatrix,5,5);
		SparseMatrix actualTransposeMatrix=SparseMatrix.evaluateTranspose(sm1);
		ArrayList<Element> actualTransposeList=new ArrayList<Element>();
		for(int i=0;i<actualTransposeList.size();i++)
		{
			Element element1=transposeMatrix.get(i);
			Element element2=actualTransposeList.get(i);
			assertEquals(element1.x,element2.x);
			assertEquals(element1.y,element2.y);
			assertEquals(element1.value,element2.value);
			
		}
	}
}