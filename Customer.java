package cms;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String firstName, lastName, email, password;
    private double registrationAmount;
    private LocalDate dob;
    private ServicePlan plan;

    private static int idCounter = 100;

    // Main constructor
    public Customer(String firstName, String lastName, String email,
                    String password, double registrationAmount,
                    LocalDate dob, ServicePlan plan) {

        this.id = ++idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationAmount = registrationAmount;
        this.dob = dob;
        this.plan = plan;
    }

    // Constructor for duplicate check
    public Customer(String email) {
        this.email = email;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // equals + hashCode (IMPORTANT)
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Customer) {
            Customer c = (Customer) obj;
            return this.email.equals(c.email);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return id + " | " + firstName + " | " + email + " | " + plan;
    }
}


/*package cms;
import java.util.Scanner;
import java.time.*;
public class Customer
{
	private int id;
	private String first_name,last_name,email,password;
	private double registrationAmount;
	
	private LocalDate dob;
	private ServicePlan plan;
	
	private static int idcounter;
	
	static
	{
		idcounter=100;
	}

	public Customer(String first_name, String last_name, String email, String password,
			double registrationAmount, LocalDate dob, ServicePlan plan) {
		super();
		this.id = ++idcounter;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.dob = dob;
		this.plan = plan;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public double getRegistrationAmount() {
		return registrationAmount;
	}

	public ServicePlan getPlan() {
		return plan;
	}
	
	
	public Customer(String email)
	{
		this.email=email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", registrationAmount=" + registrationAmount + ", dob=" + dob + ", plan="
				+ plan + "]";
	}
	
	
}*/
