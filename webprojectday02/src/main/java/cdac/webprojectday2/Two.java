package cdac.webprojectday2;

public class Two {
	
	public static void main(String[] args)
	{
		int[] a = {2,4,3,5,6,-2,4,7,8,9};
		
		for(int i=0;i<a.length-1;i++)
		{
			for(int j = i+1;j<a.length;j++)
			{
				if(a[i]+a[j]==7){
					System.out.print("[" +a[i]+","+a[j]+"]");
				}
			}
		}
	}

}
