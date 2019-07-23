import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestIfSymmetric {

	@Test
	public void testIfSymmetricTrue() {
		Element e1=new Element(1,2,20);
		Element e2=new Element(3,4,30);
		Element e3=new Element(2,1,20);
		Element e4=new Element(4,3,30);
		ArrayList<Element> inputMatrix=new ArrayList<Element>();
		inputMatrix.add(e1);
		inputMatrix.add(e2);
		inputMatrix.add(e3);
		inputMatrix.add(e4);
		SparseMatrix inputSparseMatrix=new SparseMatrix(inputMatrix,5,5);
		assertTrue(SparseMatrix.checkIfSymmetric(inputSparseMatrix));
	}
	@Test
	public void testIfSymmetricFalse() {
		Element e1=new Element(2,2,20);
		Element e2=new Element(3,4,30);
		Element e3=new Element(2,1,20);
		Element e4=new Element(4,3,30);
		ArrayList<Element> inputMatrix=new ArrayList<Element>();
		inputMatrix.add(e1);
		inputMatrix.add(e2);
		inputMatrix.add(e3);
		inputMatrix.add(e4);
		SparseMatrix inputSparseMatrix=new SparseMatrix(inputMatrix,5,5);
		assertFalse(SparseMatrix.checkIfSymmetric(inputSparseMatrix));
	}

}
