package cms;

import java.time.LocalDate;
import java.util.*;

public class CustomerTester {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Customer> list = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n1.SignUp 2.SignIn 3.ChangePass 4.Delete 5.Display 0.Exit");

            try {
                switch (sc.nextInt()) {

                    case 1:
                        System.out.println("Enter details:");
                        String fn = sc.next();
                        String ln = sc.next();
                        String email = sc.next();
                        String pass = sc.next();
                        double amt = sc.nextDouble();
                        LocalDate dob = LocalDate.parse(sc.next());
                        ServicePlan plan = ServicePlan.valueOf(sc.next().toUpperCase());

                        Utility.validateEmail(email);
                        Utility.checkDuplicate(email, list);

                        Customer c = new Customer(fn, ln, email, pass, amt, dob, plan);
                        list.add(c);

                        System.out.println("Added: " + c);
                        break;

                    case 2:
                        System.out.println("Enter email & password:");
                        String e = sc.next();
                        String p = sc.next();

                        boolean found = false;
                        for (Customer cust : list) {
                            if (cust.getEmail().equals(e) && cust.getPassword().equals(p)) {
                                System.out.println("Login Success");
                                found = true;
                                break;
                            }
                        }
                        if (!found) System.out.println("Invalid login");
                        break;

                    case 3:
                        System.out.println("Enter email oldPass newPass:");
                        String em = sc.next();
                        String oldP = sc.next();
                        String newP = sc.next();

                        for (Customer cust : list) {
                            if (cust.getEmail().equals(em) && cust.getPassword().equals(oldP)) {
                                cust.setPassword(newP);
                                System.out.println("Password Updated");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Enter email & password:");
                        String de = sc.next();
                        String dp = sc.next();

                        Iterator<Customer> itr = list.iterator();

                        while (itr.hasNext()) {
                            Customer cust = itr.next();
                            if (cust.getEmail().equals(de) && cust.getPassword().equals(dp)) {
                                itr.remove();
                                System.out.println("Deleted");
                            }
                        }
                        break;

                    case 5:
                        list.forEach(System.out::println);
                        break;

                    case 0:
                        exit = true;
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}

/*package cms;
import java.time.LocalDate;
import java.util.*;

public class CustomerTester
{
	public static void main(String[] args)
	{
		try(Scanner sc=new Scanner(System.in))
		{
			List<Customer> customerList=new ArrayList<>();
			boolean exit=false;
			
			while(!exit)
			{
				System.out.println("\n---CMS MENU");
				System.out.println("1.Sign up 2.Sign In 3.Change Password 4.Unsubscribe 5.Display all 0.Exit");
				try
				{
					switch(sc.nextInt())
					{
					case 1: //Sign Up
						System.out.println("Enter your First name, last name, Email, Password, Regamount, Dob(yyyy-mm-dd),plan");
						String fn =sc.next();
						String ln=sc.next();
						String email=sc.next();
						String password=sc.next();
						double regamount=sc.nextDouble();
						LocalDate dob = LocalDate.parse(sc.next());
						ServicePlan plan=ServicePlan.valueOf(sc.next().toUpperCase());
						
						Utility.validateEmail(email);
						Utility.checkforDuplicates(email, customerList);
						
						Customer newCustomer= new Customer(fn,ln,email,password,regamount,dob,plan);
						customerList.add(newCustomer);
						
						System.out.println("Regisration Successfull : "+ newCustomer);
						break;
						
					case 2: //Sign In
						System.out.println("Enter Email and Password");
						String signInemail=sc.next();
						String signInpassword=sc.next();
						
						boolean found=false;
						for(Customer c: customerList)
						{
							if(c.getEmail().equals(signInemail) && c.getPassword().equals(signInpassword))
							{
								System.out.println("Login Successfull");
								found=true;
								break;
							}
						}
						if(!found)
						{
							System.out.println("Invalid Credentials");
						}
						break;
						
					case 3: //Change Password
						System.out.println("Enter Email, Old Password, New Password");
						String changepassEmail=sc.next();
						String oldPass=sc.next();
						String newPass=sc.next();
						
						boolean updated=false;
						for(Customer c:customerList)
						{
							if(c.getEmail().equals(changepassEmail) && c.getPassword().equals(oldPass))
							{
								c.setPassword(newPass);
								System.out.println("Password Changed");
								updated=true;
								break;
							}
						}
						if(!updated)
						{
							System.out.println("Invalid credentials");
						}
						break;
						
					case 4: //Unsubscribe
						System.out.println("Enter Email and Password");
						String delEmail=sc.next();
						String delPass=sc.next();
						
						Iterator <Customer> itr=customerList.iterator();
						boolean deleted=false;
						
						while(itr.hasNext());
						{
							Customer c=itr.next();
							if(c.getEmail().equals(delEmail) && c.getPassword().equals(delPass))
							{
								itr.remove();
								System.out.println("Account deleted");
								deleted=true;
								break;
							}
						}
						if(!deleted)
							System.out.println("Invalid Credentials");
						break;
						
					case 5: //Display
						if(customerList.isEmpty())
							System.out.println("No Customers Found");
						else
							customerList.forEach(System.out::println);
						break;
						
					case 0: //Exit
						exit=true;
						System.out.println("Exiting..");
						break;
						
					default:
						System.out.println("Invalid Choice");	
					}
				}
				catch (Exception e)
				{
                    System.out.println("Error: " + e.getMessage());
                    sc.nextLine();
                    sc.close();
				}
			}
		}
	}
}
*/