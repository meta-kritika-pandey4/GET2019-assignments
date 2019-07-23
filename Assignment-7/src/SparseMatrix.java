import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
public final class SparseMatrix {
	private int rows;
	private int columns;
	private ArrayList<Element> sparseMatrix=new ArrayList<Element>();
	public ArrayList<Element> getSparseMatrix()
	{
		ArrayList sparseMatrixList = (ArrayList) this.sparseMatrix.clone();
		return sparseMatrixList;
	}
	SparseMatrix(ArrayList<Element> sparseMatrix,int rows,int columns)
	{
		this.sparseMatrix=sparseMatrix;
		this.rows=rows;
		this.columns=columns;
	}
	public static SparseMatrix evaluateTranspose(SparseMatrix inputMatrix) 
	{
		ArrayList<Element> sparseMatrixTranspose=new ArrayList<Element>();
		for(Element numElement:inputMatrix.sparseMatrix)
		{
			Element temp=new Element(numElement.y,numElement.x,numElement.value);
			sparseMatrixTranspose.add(temp);
			}
		
		SparseMatrix result=new SparseMatrix(sparseMatrixTranspose,inputMatrix.columns,inputMatrix.rows);
		return result;


	}
	public static boolean checkIfSymmetric(SparseMatrix inputMatrix)
	{
		boolean result=true;
		int k=0;
		int count=0;
		SparseMatrix sparseMatrixTranspose=evaluateTranspose(inputMatrix);
		ArrayList<Element> transpose=sparseMatrixTranspose.sparseMatrix;
		
			for(Element element:inputMatrix.sparseMatrix)
			{
				int x=element.x;
				int y=element.y;
				int value=element.value;
				k=0;
				for(int j=k;j<transpose.size();j++)
				{
					k++;
					Element transposeElement=transpose.get(j);
					if(x==transposeElement.x&&y==transposeElement.y&&value==transposeElement.value)
					{
						count++;
						transpose.remove(j);
					}
			}
				
				
			}
			if(count==inputMatrix.sparseMatrix.size())
				result=true;
			else
				result=false;
			
		
		return result;
	
}
	public static int valueAtPosition(int x,int y,ArrayList<Element> matrix)
	{
		int elementValue=0;
		for(Element element:matrix)
		{
			int rowIndex=element.x;
			int columnIndex=element.y;
			if(rowIndex==x&&columnIndex==y)
				 elementValue=element.value;
		}
		return elementValue;
		
	}
	public static int indexOfElementAtSamePosition(Element checkElement,ArrayList<Element> matrix)
	{
		int x=checkElement.x;
		int y=checkElement.y;
		int i=0;
		for(Element element:matrix)
		{
			
			if(element.x==x&&element.y==y)
				return i;
			i++;
			
		}
		return -1;
	}
	
	public static SparseMatrix addMatrix(SparseMatrix inputMatrix1,SparseMatrix inputMatrix2)
	{
		ArrayList<Element> matrix1=inputMatrix1.sparseMatrix;
		ArrayList<Element> matrix2=inputMatrix2.sparseMatrix;
		ArrayList<Element> sumMatrix=matrix1;
		if(!((inputMatrix1.rows==inputMatrix2.rows)&&(inputMatrix2.columns==inputMatrix2.columns)))
			{
			System.out.println("Unequal number of rows and columns of the two input matrices");
			throw new AssertionError("Unequal number of rows and columns of the two input matrices");
			}
		else if((inputMatrix1.rows==0)||(inputMatrix1.columns==0)||(inputMatrix2.rows==0)||(inputMatrix2.columns==0))
			{
			System.out.println("Either of the Arrays is empty");
			throw new AssertionError("Either of the Arrays is empty");
			}
		else
		{
			
			for(Element element:matrix2)
			{
				int index=indexOfElementAtSamePosition(element,sumMatrix);
				if(index==-1)
					sumMatrix.add(element);
				else
				{
					Element matrix1Element=sumMatrix.remove(index);
					matrix1Element.value+=element.value;
					sumMatrix.add(index,matrix1Element);
				}
				
				
				
			}
		}
		SparseMatrix result=new SparseMatrix(sumMatrix,inputMatrix1.rows,inputMatrix2.columns);
		return result;
		
	}
	public static SparseMatrix multiplyMatrix(SparseMatrix inputMatrix1,SparseMatrix inputMatrix2)
	{
		ArrayList<Element> matrix1=inputMatrix1.sparseMatrix;
		ArrayList<Element> matrix2=inputMatrix2.sparseMatrix;
		ArrayList<Element> productMatrix=matrix1;
		Element product;
	
		if(!(inputMatrix1.columns==inputMatrix2.rows))
			throw new AssertionError("Not fit for multiplication");
		else
		{
			int row1=inputMatrix1.rows;
			int row2=inputMatrix2.rows;
			int column1=inputMatrix1.columns;
			int column2=inputMatrix2.columns;
			for(int i=0;i<row1;i++)
			{
				for(int j=0;j<column2;j++)
				{
					int sum=0;
					boolean flag=false;
					for(int k=0;k<column1;k++)
					{
						int temp1=valueAtPosition(i,k,matrix1);
						int temp2=valueAtPosition(k,j,matrix2);
						if(!(temp1==0||temp2==0))
						{
							flag=true;
							sum+=temp1*temp2;
						}
					}
					if(flag)
					{
						product=new Element(i,j,sum);
						productMatrix.add(product);
					}
				}
				
			}
		}
	
		SparseMatrix result=new SparseMatrix(productMatrix,inputMatrix1.rows,inputMatrix2.columns);
		return result;
		
	}
	public static void main(String[] args)
	{
		Element e1=new Element(1,1,20);
		Element e2=new Element(3,4,30);
		Element e3=new Element(2,1,20);
		Element e4=new Element(4,3,30);
		ArrayList<Element> inputMatrix=new ArrayList<Element>();
		inputMatrix.add(e1);
		inputMatrix.add(e2);
		inputMatrix.add(e3);
		inputMatrix.add(e4);
		SparseMatrix sm1=new SparseMatrix(inputMatrix,5,5);
		SparseMatrix transposeMatrix=evaluateTranspose(sm1);
		for(Element element:transposeMatrix.sparseMatrix)
		{
			System.out.println(element.x+" "+element.y+" "+element.value);
		}
		boolean result=checkIfSymmetric(sm1);
		System.out.println(result);
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
		ArrayList<Element> actualSumMatrix=actualSum.sparseMatrix;
		for(int i=0;i<actualSumMatrix.size();i++)
		{
			Element element1=actualSumMatrix.get(i);
			Element element2=sumMatrix.get(i);
			System.out.println(element1.x+" "+element2.x);
			System.out.println(element1.y+" "+element2.y);
			System.out.println(element1.value+" "+element2.value);
			
		}
		
		
	}
		
		
		
	}


class Element
{
	int x;
	int y;
	int value;
	Element(int x,int y,int value)
	{
		this.x=x;
		this.y=y;
		this.value=value;
	}
}

