import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestAddMatrix {

	@Test
	public void testAddMatrix()
	{
	Element matrix1element1=new Element(1,1,1);
	Element matrix1element2=new Element(2,1,2);
	Element matrix2element1=new Element(0,1,3);
	Element matrix2element2=new Element(1,1,4);
	Element matrix2element3=new Element(2,0,5);
	Element sumElement1=new Element(1,1,5);
	Element sumElement2=new Element(2,1,2);
	Element sumElement3=new Element(0,1,3);
	Element sumElement4=new Element(2,0,5);
	
	ArrayList<Element> matrix1=new ArrayList<Element>();
	ArrayList<Element> matrix2=new ArrayList<Element>();
	ArrayList<Element> sumMatrix=new ArrayList<Element>();
	matrix1.add(matrix1element1);
	matrix1.add(matrix1element2);
	matrix2.add(matrix2element1);
	matrix2.add(matrix2element2);
	matrix2.add(matrix2element3);
	sumMatrix.add(sumElement1);
	sumMatrix.add(sumElement2);
	sumMatrix.add(sumElement3);
	sumMatrix.add(sumElement4);
	SparseMatrix sparseMatrix1=new SparseMatrix(matrix1,3,3);
	SparseMatrix sparseMatrix2=new SparseMatrix(matrix2,3,3);
	SparseMatrix actualSum=SparseMatrix.addMatrix(sparseMatrix1,sparseMatrix2);
	ArrayList<Element> actualSumMatrix=actualSum.getSparseMatrix();
	for(int i=0;i<actualSumMatrix.size();i++)
	{
		Element element1=actualSumMatrix.get(i);
		Element element2=sumMatrix.get(i);
		assertEquals(element1.x,element2.x);
		assertEquals(element1.y,element2.y);
		assertEquals(element1.value,element2.value);
		
	}
	}
	@Test(expected=AssertionError.class)
	public void testAddMatrixUnequalRowsAndColumns()
	{
	Element matrix1element1=new Element(1,1,1);
	Element matrix1element2=new Element(2,1,2);
	Element matrix2element1=new Element(0,1,3);
	Element matrix2element2=new Element(1,1,4);
	Element matrix2element3=new Element(2,0,5);
	Element sumElement1=new Element(1,1,5);
	Element sumElement2=new Element(2,1,2);
	Element sumElement3=new Element(0,1,3);
	Element sumElement4=new Element(2,0,5);
	
	ArrayList<Element> matrix1=new ArrayList<Element>();
	ArrayList<Element> matrix2=new ArrayList<Element>();
	ArrayList<Element> sumMatrix=new ArrayList<Element>();
	matrix1.add(matrix1element1);
	matrix1.add(matrix1element2);
	matrix2.add(matrix2element1);
	matrix2.add(matrix2element2);
	matrix2.add(matrix2element3);
	sumMatrix.add(sumElement1);
	sumMatrix.add(sumElement2);
	sumMatrix.add(sumElement3);
	sumMatrix.add(sumElement4);
	SparseMatrix sparseMatrix1=new SparseMatrix(matrix1,4,4);
	SparseMatrix sparseMatrix2=new SparseMatrix(matrix2,3,3);
	SparseMatrix actualSum=SparseMatrix.addMatrix(sparseMatrix1,sparseMatrix2);
	
	
}
	@Test(expected=AssertionError.class)
	public void testAddMatrixEmptyArray()
	{
	Element matrix1element1=new Element(1,1,1);
	Element matrix1element2=new Element(2,1,2);
	
	Element sumElement1=new Element(1,1,5);
	Element sumElement2=new Element(2,1,2);
	Element sumElement3=new Element(0,1,3);
	Element sumElement4=new Element(2,0,5);
	
	ArrayList<Element> matrix1=new ArrayList<Element>();
	ArrayList<Element> matrix2=new ArrayList<Element>();
	ArrayList<Element> sumMatrix=new ArrayList<Element>();
	matrix1.add(matrix1element1);
	matrix1.add(matrix1element2);
	sumMatrix.add(sumElement1);
	sumMatrix.add(sumElement2);
	sumMatrix.add(sumElement3);
	sumMatrix.add(sumElement4);
	SparseMatrix sparseMatrix1=new SparseMatrix(matrix1,4,4);
	SparseMatrix sparseMatrix2=new SparseMatrix(matrix2,0,0);
	SparseMatrix actualSum=SparseMatrix.addMatrix(sparseMatrix1,sparseMatrix2);
	
	
}
		
		
	
}
