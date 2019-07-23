import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestSparseMatrix {

	@Test
	public void testSparseMatrix()
	{
		Element matrix1element1=new Element(1,1,1);
		Element matrix1element2=new Element(2,1,2);
		Element matrix2element1=new Element(0,1,3);
		Element matrix2element2=new Element(1,1,4);
		Element matrix2element3=new Element(2,0,5);
		ArrayList<Element> matrix1=new ArrayList<Element>();
		ArrayList<Element> matrix2=new ArrayList<Element>();
		matrix1.add(matrix1element1);
		matrix1.add(matrix1element2);
		matrix2.add(matrix2element1);
		matrix2.add(matrix2element2);
		matrix2.add(matrix2element3);
		
	}

}
