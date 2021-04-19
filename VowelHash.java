import java.lang.*;
import java.io.*;
import java.util.*;
class VowelHash
{
	public int oddsum(int num)
	{
		int sum=0;
		for(int i=1;i<=num;i++)
		{
			if(i%2!=0)
			{
				sum=sum+i;
			}
		}
		int res=sum;
		return digitsum(res);
	}
	public int digitsum(int res)
	{
		int temp,sum1=0;
		while(res!=0 || sum1>9)
		{
			if(res==0)
			{
				res=sum1;
				sum1=0;
			}
			temp=res%10;
			sum1=sum1+temp;
			res=res/10;
		}
		return sum1;
	}
	public String vowelrep(String instr)
	{
		int index,m,z=0;
		String repnum,outstr="";
		char repchar;
		for(int j=0;j<instr.length();j++)
		{
			char c=instr.charAt(j);
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
			{
				index=j;
				m=index*5;
				repnum=String.valueOf(oddsum(m));
				repchar=repnum.charAt(0);
				outstr=instr.substring(0,j)+repchar+instr.substring(j+1);//instr.replace(instr.charAt(j),repchar);
				instr=outstr.replaceAll("\\s","");
				z++;
			}
			if(z==0)
			{
				outstr=String.valueOf(-1);			
			}
		}
		return outstr;
	}
	public static void main(String args[])
	{
		VowelHash obj=new VowelHash();
		//System.out.println(obj.oddsum(10));
		Scanner sc=new Scanner(System.in);
		String instr=sc.nextLine();
		System.out.println(obj.vowelrep(instr));
	}
}
