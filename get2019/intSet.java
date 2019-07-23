package get2019;

import java.util.Arrays;
import java.util.List;


final class intSet {
	private int[] set;
	private int size;
	public int[] getSet()
	{
		return this.set;
	}
	public boolean checkValid()
	{
		for(int i=0;i<this.set.length;i++)
		{
			if(this.set[i]<1||this.set[i]>1000)
				return false;

		}
		return true;
	}
	intSet(int[] inputSet,int size)
	{
		set=inputSet;
		this.size=size;		
	}
	public boolean isMember(int x)
	{
		for(int i=0;i<size;i++)
		{
			if(set[i]==x)
				return true;
		}
		return false;
	}
	public int size()
	{

		return size;
	}
	public boolean isSubset(intSet x)
	{
		if(!x.checkValid())
			throw new AssertionError("Invalid values");
		if(!this.checkValid())
			throw new AssertionError("Invalid values");
		boolean flag=true;
		for(int i=0;i<x.size();i++)
		{
			if(!this.isMember(x.set[i]))
				flag=false;
		}
		return flag;
	}
	public intSet getComplement()
	{
		if(!this.checkValid())
			throw new AssertionError("Invalid values");
		int complementSize=1000-this.size;
		int[] complementArray=new int[complementSize];
		int k=0;


		for(int i=1;i<=1000;i++)
		{
			if(this.isMember(i)==false)
			{
				complementArray[k++]=i;
				if(complementArray[k-1]>1000||complementArray[k-1]<=0)
				{
					System.out.println("AssertionError:Invalid values");
					throw new AssertionError("Invalid Values in set");
				}
			}
		}
		intSet complementSet=new intSet(complementArray,complementSize);
		return complementSet;


	}
	public intSet getUnion(intSet set1,intSet set2)
	{
		if(!set1.checkValid())
			throw new AssertionError("Invalid values");
		if(!set2.checkValid())
			throw new AssertionError("Invalid values");
		int[] union=new int[set1.size+set2.size];
		int k=0;
		for(int i=0;i<set1.size;i++)
		{
			union[k++]=set1.set[i];
		}
		for(int j=0;j<set2.size;j++)
		{
			if(set1.isMember(set2.set[j])==false)
			{
				union[k++]=set2.set[j];
			}
		}
		int[] unionSetArray=Arrays.copyOf(union,k);

		intSet unionSet=new intSet(unionSetArray,k);
		return unionSet;
	}


}