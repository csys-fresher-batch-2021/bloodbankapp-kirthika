package in.kirthika.service;

public class DonorDetail {
	private String bloodGroup;
	private String name;
	private Long mobileNumber;
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public DonorDetail(String bloodGroup,String name, Long mobileNumber,int age) 
	{   this.bloodGroup=bloodGroup;
		this.name=name;
		this. mobileNumber=mobileNumber;
		this.age=age;
		
	}

	@Override
	public String toString() {
		return "DonorManager [name=" + name + ", BloodGroup=" + bloodGroup + ", mobileNumber=" + mobileNumber + ", age="
				+ age + "]";
	}

	

}
	

