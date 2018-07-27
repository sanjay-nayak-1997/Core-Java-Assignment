import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int[] arr= new int[8];
		
		System.out.println("Enter the numbers :-");
		for(int i=0;i<8;i++)
		{
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		boolean result=checkTriplets(arr);
		System.err.println(result);
	}

}
