package in.kirthika.service;

public class DonorManager {
	String bloodGroup;
	String name;
	Long mobileNumber;
	int age;
	
	public DonorManager(String bloodGroup,String name, Long mobileNumber,int age) 
	{   this.bloodGroup=bloodGroup;
		this.name=name;
		this. mobileNumber=mobileNumber;
		this.age=age;
		
	}

	@Override
	public String toString() {
		return "DonorManager [bloodGroup=" + bloodGroup + ", name=" + name + ", mobileNumber=" + mobileNumber + ", age="
				+ age + "]";
	}

	

}
	

