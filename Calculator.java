import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Arithmetic{
	
	int num1,num2;

	public Arithmetic(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public abstract int calculate();
	
}

class Addition extends Arithmetic
{

	public Addition(int num1, int num2) {
		super(num1, num2);
	}

	@Override
	public int calculate() {
		return num1+num2;
	}
	
}

class Subtraction extends Arithmetic
{

	public Subtraction(int num1, int num2) {
		super(num1, num2);
	}

	@Override
	public int calculate() {
		return num1-num2;
	}
	
}

class Multiplication extends Arithmetic
{

	public Multiplication(int num1, int num2) {
		super(num1, num2);
	}

	@Override
	public int calculate() {
		return num1*num2;
	}
	
	
}

class Divide extends Arithmetic
{

	public Divide(int num1, int num2) {
		super(num1, num2);
	}

	@Override
	public int calculate() {
		return num1/num2;
	}
	
	
}

public class Calculator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr); 
		int n1,n2,ch;
		
		System.out.println("Enter number-1 : ");
		n1=Integer.parseInt(br.readLine());
		System.out.println("Enter number-2 : ");
		n2=Integer.parseInt(br.readLine());
		
		System.out.println("0.ADDITION");
		System.out.println("1.SUBTRACTION");
		System.out.println("2.MULTIPLICATION");
		System.out.println("3.DIVISION");
		System.out.println("Enter your choice : ");
		ch=Integer.parseInt(br.readLine());
		
		Addition add=new Addition(n1, n2);
		Subtraction sub= new Subtraction(n1, n2);
		Multiplication mul=new Multiplication(n1, n2);
		Divide div=new Divide(n1, n2);
		
		Arithmetic[] a= {add,sub,mul,div};
		
		int ele=(ch==0)?0:(ch==1)?1:(ch==2)?2:(ch==3)?3:4;
		
		Arithmetic ar=a[ele];
		
		System.out.println("Result = " + ar.calculate());
	}

}
