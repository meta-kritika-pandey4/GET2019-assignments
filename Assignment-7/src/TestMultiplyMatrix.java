import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TestMultiplyMatrix {

	@Test
	public void testMultiplyMatrix()
	{
	Element matrix1element1=new Element(1,1,1);
	Element matrix1element2=new Element(2,1,2);
	Element matrix2element1=new Element(0,1,3);
	Element matrix2element2=new Element(1,1,4);
	Element matrix2element3=new Element(2,0,5);
	Element productElement1=new Element(1,1,4);
	Element productElement2=new Element(2,1,8);
	
	
	ArrayList<Element> matrix1=new ArrayList<Element>();
	ArrayList<Element> matrix2=new ArrayList<Element>();
	ArrayList<Element> productMatrix=new ArrayList<Element>();
	matrix1.add(matrix1element1);
	matrix1.add(matrix1element2);
	matrix2.add(matrix2element1);
	matrix2.add(matrix2element2);
	matrix2.add(matrix2element3);
	productMatrix.add(productElement1);
	productMatrix.add(productElement2);
	
	SparseMatrix sparseMatrix1=new SparseMatrix(matrix1,3,3);
	SparseMatrix sparseMatrix2=new SparseMatrix(matrix2,3,3);
	SparseMatrix actualproduct=SparseMatrix.multiplyMatrix(sparseMatrix1,sparseMatrix2);
	ArrayList<Element> actualproductMatrix=actualproduct.getSparseMatrix();
	for(int i=0;i<actualproductMatrix.size();i++)
	{
		Element element1=actualproductMatrix.get(i);
		Element element2=productMatrix.get(i);
		System.out.println(element1.x+" "+element1.x);
		assertEquals(element1.x,element2.x);
		assertEquals(element1.y,element2.y);
		assertEquals(element1.value,element2.value);
		
	}
	}
}
