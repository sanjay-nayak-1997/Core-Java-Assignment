
public class UserMainCode {

	public static boolean checkTriplets(int[] a)
	{
		boolean result=false;
		int b,c;
		for(int i=0;i<a.length;i++)
		{
				b=i+1;
				c=i+2;
				if(b<a.length && c<a.length)
				{
					if(a[i]==a[b] && a[i]==a[c])
					{
						result=true;
					}
				}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] arr= {7,3,3,5,5,5,2,3};
		
		boolean result=checkTriplets(arr);
		System.err.println(result);
	}

}
