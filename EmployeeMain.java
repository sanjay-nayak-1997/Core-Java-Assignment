import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeVo {
	
	int empid;
	String empname;
	double annualIncome;
	double incometax;
	public EmployeeVo(int empid, String empname, double annualIncome, double incometax) {
		this.empid = empid;
		this.empname = empname;
		this.annualIncome = annualIncome;
		this.incometax = incometax;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public double getIncometax() {
		return incometax;
	}
	public void setIncometax(double incometax) {
		this.incometax = incometax;
	}
	@Override
	public String toString() {
		return "EmployeeVo [empid=" + empid + ", empname=" + empname + ", annualIncome=" + annualIncome + ", incometax="
				+ incometax + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(annualIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + empid;
		result = prime * result + ((empname == null) ? 0 : empname.hashCode());
		temp = Double.doubleToLongBits(incometax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVo other = (EmployeeVo) obj;
		if (Double.doubleToLongBits(annualIncome) != Double.doubleToLongBits(other.annualIncome))
			return false;
		if (empid != other.empid)
			return false;
		if (empname == null) {
			if (other.empname != null)
				return false;
		} else if (!empname.equals(other.empname))
			return false;
		if (Double.doubleToLongBits(incometax) != Double.doubleToLongBits(other.incometax))
			return false;
		return true;
	}
	
}

class EmployeeBo
{
	public void calincometax(EmployeeVo e) {
		
		e.incometax=(e.annualIncome*0.3); 

	}
	
}

class EmployeeSort implements Comparator<EmployeeVo>{

	@Override
	public int compare(EmployeeVo e1, EmployeeVo e2) {
		return (int)(e2.incometax-e1.incometax);
	}
	
}

public class EmployeeMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		int num;
		int eid;
		String ename;
		double einc;
		System.out.println("Enter the number of employees : ");
		num=Integer.parseInt(br.readLine());
		
		EmployeeVo[] emp=new EmployeeVo[num];
		EmployeeBo b=new EmployeeBo();
		for(int j=0;j<num;j++)
		{
			EmployeeVo e=new EmployeeVo(0, null, 0.0, 0.0);
			emp[j]=e;
		}
		for(int c=0;c<num;c++)
		{
			System.out.println("Enter the employee ID   : ");
			eid=Integer.parseInt(br.readLine());
			System.out.println("Enter the employee name : ");
			ename=br.readLine();
			System.out.println("Enter the annual income : ");
			einc=Double.parseDouble(br.readLine());
			emp[c]=new EmployeeVo(eid, ename, einc, 0.0);
			b.calincometax(emp[c]);
		}
		
		List<EmployeeVo> empl=Arrays.asList(emp);
		
		Collections.sort(empl, new EmployeeSort());
		System.out.println();
		System.out.println("EMPLOYEE DETAILS");
		System.out.println("---------------------");
		
		for(EmployeeVo e:emp)
		{
			System.out.println("Employee ID               :   " + e.empid);
			System.out.println("Emplpoyee Name            :   " + e.empname);
			System.out.println("Annual Income             :   " + e.annualIncome);
			System.out.println("Income Tax                :   " + e.incometax);
		}
	}

}
