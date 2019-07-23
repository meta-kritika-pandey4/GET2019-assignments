package get2019;

public class Poly {
	Term[] polynomial;
	
	int numberOfTerms;
	Poly(Term[] polynomial,int numberOfTerms)
	{
		this.polynomial=polynomial;		
		this.numberOfTerms=numberOfTerms;
	}
	public int degree()
	{
		int degree=0;
		for(Term term:polynomial)
		{
			if(term.exponent>degree)
				degree=term.exponent;
			
		}
		return degree;
	}
	public double evaluate(double x)
	{
		int length=polynomial.length;
		double result=0;
		for(int i=0;i<length;i++)
		{
			Term term=polynomial[i];
			result+=term.coefficient*Math.pow(x, term.exponent);
			
		}
		return result;
		 
	}
	public Poly addPoly(Poly p1,Poly p2)
	{
		int length1=p1.polynomial.length;
		int length2=p2.polynomial.length;
		int i=0,j=0,k=0;
		int resultDegree=p1.degree()+p2.degree();
		Term[] resultPolynomial=new Term[resultDegree];
		Term term;
		Poly p3=new Poly(resultPolynomial,k);
		while(i<length1&&j<length2)
		{
			if(p1.polynomial[i].exponent>p2.polynomial[j].exponent)
			{
				term=new Term(p1.polynomial[i].coefficient,p1.polynomial[i++].exponent);
				
			}
			else if(p1.polynomial[i].exponent<p2.polynomial[j].exponent)
			{
				
				term=new Term(p2.polynomial[j].coefficient,p2.polynomial[j++].exponent);
				
			}
			else
			{
				term=new Term(p1.polynomial[i++].coefficient+p2.polynomial[j].coefficient,p1.polynomial[j++].exponent);
				
				
			}
			
			p3.polynomial[k++]=term;
		}
		while(i<length1)
		{
			term=p1.polynomial[i++];
			p3.polynomial[k++]=term;
		}
		while(j<length2)
		{
			term=p2.polynomial[j++];
			p3.polynomial[k++]=term;
		}
		p3.numberOfTerms=k;
		
		return p3;
		
	}
	public Poly multiplyPoly(Poly p1,Poly p2)
	{
		int resultDegree=p1.degree()+p2.degree(),k=0;
		Term[] resultPoly=new Term[resultDegree];
		Poly p3=new Poly(resultPoly,numberOfTerms);
		for(int i=0;i<p1.polynomial.length;i++)
		{
			Term p1Term=p1.polynomial[i];
			for(int j=0;j<p2.polynomial.length;j++)
			{
				p3.polynomial[k].coefficient=p1.polynomial[i].coefficient*p2.polynomial[j].coefficient;
				p3.polynomial[k++].exponent=p1.polynomial[i].exponent+p2.polynomial[j].exponent;
			}
		}
		for(int i=0;i<p3.polynomial.length-1;i++)
		{
			for(int j=i+1;j<p3.polynomial.length;j++)
			{
				if(p3.polynomial[i].exponent==p3.polynomial[j].exponent)
				{
					p3.polynomial[i].coefficient=p3.polynomial[i].coefficient+p3.polynomial[j].coefficient;
					for(int z=j;z<resultDegree-1;z++)
					{
						polynomial[z]=polynomial[z+1];
					}
					k--;
					
				}
			}
		}
		p3.numberOfTerms=k;
		return p3;
	}
}
class Term
{
	int coefficient;
	int exponent;
	Term(int coefficient,int exponent)
	{
		this.coefficient=coefficient;
		this.exponent=exponent;
	}
}