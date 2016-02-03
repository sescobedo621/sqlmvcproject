package JDBC;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String middleName;
	private char gender;
	private double salary;
	private String address;
	private String city;
	private String state;
	private int zipcode;
	
	public Employee(){
		
	}
	public Employee(int id, String firstName, String lastName, String middleName, char gender, double salary,
			String address, String city, String state, int zipcode)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.gender = gender;
		this.salary = salary;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getMiddleName()
	{
		return middleName;
	}
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}
	public char getGender()
	{
		return gender;
	}
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public double getSalary()
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public int getZipcode()
	{
		return zipcode;
	}
	public void setZipcode(int zipcode)
	{
		this.zipcode = zipcode;
	}
	
}
