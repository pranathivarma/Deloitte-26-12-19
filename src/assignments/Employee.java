package assignments;

public class Employee extends Person {
	
	protected int EmpId;
	protected Department d;
	public Employee(String name, int empId, Department string) {
		super(name);
		this.EmpId = empId;
		this.d = string;
	}
	
	public Employee(String name, Address addr, int id, Department dept) {
		super(name,addr);
		this.EmpId=id;
		this.d=dept;
		
	}
	
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public Department getD() {
		return d;
	}
	public void setD(Department d) {
		this.d = d;
	}
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", d=" + d + "]";
	}

	
	
}
