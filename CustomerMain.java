package cmsSelf;
import java.time.LocalDate;
import java.util.*;

public class CustomerMain {

	public static void main(String[] args)
	{
		try(Scanner sc=new Scanner(System.in))
		{
			List<Customer> customerList=new ArrayList<>();
			customerList.add(new Customer("Aditya", "Molwane", "adi@gmail.com", "123",
			        2000, LocalDate.of(2002, 1, 10), ServicePlan.GOLD));

			customerList.add(new Customer("Rahul", "Sharma", "rahul@abc.com", "111",
			        1000, LocalDate.of(2001, 5, 15), ServicePlan.SILVER));

			customerList.add(new Customer("Sneha", "Patil", "sneha@xyz.com", "222",
			        5000, LocalDate.of(2000, 8, 20), ServicePlan.DIAMOND));

			customerList.add(new Customer("Amit", "Verma", "amit@test.com", "333",
			        3000, LocalDate.of(1999, 12, 5), ServicePlan.GOLD));

			customerList.add(new Customer("Pooja", "Kulkarni", "pooja@mail.com", "444",
			        10000, LocalDate.of(1998, 3, 25), ServicePlan.PLATINUM));
			boolean exit=false;
			
			while(!exit)
			{
				System.out.println("1.Sign up 2.Sign In 3.Change Password 4.Unsubscribe 5.Display 6.Search all 7.Sort by Amount (Comparator) 8.Sort by ID (Comparable) 9.Sort by DOB Oldest To Youngest (Comparator) 0.Exit");
				
				try
				{
					switch(sc.nextInt())
					{
						case 1: //Sign up
						System.out.println("Enter First name, Last name, Email, Password, Registration Amount, Date of Birth, Plan");
						String fn=sc.next();
						String ln=sc.next();
						String email=sc.next();
						String password=sc.next();
						double regamount=sc.nextDouble();
						LocalDate dob=LocalDate.parse(sc.next());
						ServicePlan plan=ServicePlan.valueOf(sc.next().toUpperCase());
						
						Utility.validateEmail(email);
						Utility.checkforduplicates(email, customerList);
						
						Customer newCustomer = new Customer(fn,ln,email,password,regamount,dob,plan);
						customerList.add(newCustomer);
						System.out.println("Customer Registration Successful");
						break;
						
						case 2: //Sign in
							System.out.println("Enter em pass");
							String signemail=sc.next();
							String signpass=sc.next();
							
							boolean found=false;
							for(Customer c:customerList)
							{
								if(c.getEmail().equals(signemail) && c.getPassword().equals(signpass))
								{
									System.out.println("Login Successful");
									found=true;
									break;
								}
							}
							if(!found)
							{
								System.out.println("Invalid");
							}
							break;
							
						case 3: //Change Password
							System.out.println("Enter em pass");
							String passemail=sc.next();
							String oldpass=sc.next();
							boolean updated=false;
							
							for(Customer c:customerList)
							{
								if(c.getEmail().equals(passemail)&&c.getPassword().equals(oldpass))
								{
									System.out.println("Enter new Pass");
									String newpass=sc.next();
									c.setPassword(newpass);
									updated=true;
									System.out.println("Password Changed");
									break;
								}
							}
							if(!updated)
							{
								System.out.println("Invalid Cred");
							}
							break;
							
						case 4: //Delete Obj
							System.out.println("Enter Email and Password");
							String delEmail=sc.next();
							String delPass=sc.next();
							
							Iterator<Customer>itr=customerList.iterator();
							boolean deleted=false;
							
							while(itr.hasNext())
							{
								Customer c=itr.next();
								if(c.getEmail().equals(delEmail) && c.getPassword().equals(delPass))
								{
									itr.remove();
									System.out.println("Deleted");
									deleted=true;
									break;
								}
							}
							if(!deleted)
							{
								System.out.println("Invalid Cred");
							}
							break;
							
						case 5: //Display all
							if(customerList.isEmpty())
							{
								System.out.println("NO customers");
							}
							else
							{
								customerList.forEach(System.out::println);
							}
							break;
							
						case 6: // Search by Email
							System.out.println("Enter Email");
							System.out.println(Utility.Search(sc.next(), customerList));
	                        break;
	                        
						case 7: //Sort by Reg Amount using Comparator
							Collections.sort(customerList, (a, b) ->
                            Double.compare(a.getRegamount(), b.getRegamount()));

							for (Customer c : customerList)
								System.out.println(c);
							break;
							
						case 8: //Sort by ID using Comparable
						    Collections.sort(customerList);   // uses compareTo()

						    for (Customer c : customerList)
						        System.out.println(c);

						    break;
						    
						case 9: //oldest to youngest dob sort (Comparator)
							Collections.sort(customerList, (c1, c2) -> 
					        c1.getDob().compareTo(c2.getDob()));

							for (Customer c : customerList)
								System.out.println(c);
							break;
							
						case 10:
							Collections.sort(customerList, (c1, c2) ->
					        c1.getPlan().compareTo(c2.getPlan()));

							for (Customer c : customerList)
								System.out.println(c);
							break;
							
						case 0: //Exit
							exit=true;
							System.out.println("Exiting");
							break;
						default:
							System.out.println("Invalid Choice");
							break;
					}
				} catch(Exception e)
				{
					System.out.println("Error: " + e.getMessage());
	                sc.nextLine();
				}
			}
		}
	}

}

/*package cmsSelf;
import java.time.LocalDate;
import java.util.*;

public class CustomerMain {

	public static void main(String[] args)
	{
		try(Scanner sc=new Scanner(System.in))
		{
			List<Customer> customerList=new ArrayList<>();
			customerList.add(new Customer("Aditya", "Molwane", "adi@gmail.com", "123",
			        2000, LocalDate.of(2002, 1, 10), ServicePlan.GOLD));

			customerList.add(new Customer("Rahul", "Sharma", "rahul@abc.com", "111",
			        1000, LocalDate.of(2001, 5, 15), ServicePlan.SILVER));

			customerList.add(new Customer("Sneha", "Patil", "sneha@xyz.com", "222",
			        5000, LocalDate.of(2000, 8, 20), ServicePlan.DIAMOND));

			customerList.add(new Customer("Amit", "Verma", "amit@test.com", "333",
			        3000, LocalDate.of(1999, 12, 5), ServicePlan.GOLD));

			customerList.add(new Customer("Pooja", "Kulkarni", "pooja@mail.com", "444",
			        10000, LocalDate.of(1998, 3, 25), ServicePlan.PLATINUM));
			boolean exit=false;
			
			while(!exit)
			{
				System.out.println("1.Sign up 2.Sign In 3.Change Password 4.Unsubscribe 5.Display 6.Search all 7.Sort by Amount (Comparator) 8.Sort by ID (Comparable) 9.Sort by DOB Oldest To Youngest (Comparator) 0.Exit");
				
				try
				{
					switch(sc.nextInt())
					{
						case 1: //Sign up
						System.out.println("Enter First name, Last name, Email, Password, Registration Amount, Date of Birth, Plan");
						String fn=sc.next();
						String ln=sc.next();
						String email=sc.next();
						String password=sc.next();
						double regamount=sc.nextDouble();
						LocalDate dob=LocalDate.parse(sc.next());
						ServicePlan plan=ServicePlan.valueOf(sc.next().toUpperCase());
						
						Utility.validateEmail(email);
						Utility.checkforduplicates(email, customerList);
						
						Customer newCustomer = new Customer(fn,ln,email,password,regamount,dob,plan);
						customerList.add(newCustomer);
						System.out.println("Customer Registration Successful");
						break;
						
						case 2: //Sign in
							System.out.println("Enter em pass");
							String signemail=sc.next();
							String signpass=sc.next();
							
							boolean found=false;
							for(Customer c:customerList)
							{
								if(c.getEmail().equals(signemail) && c.getPassword().equals(signpass))
								{
									System.out.println("Login Successful");
									found=true;
									break;
								}
							}
							if(!found)
							{
								System.out.println("Invalid");
							}
							break;
							
						case 3: //Change Password
							System.out.println("Enter em pass");
							String passemail=sc.next();
							String oldpass=sc.next();
							boolean updated=false;
							
							for(Customer c:customerList)
							{
								if(c.getEmail().equals(passemail)&&c.getPassword().equals(oldpass))
								{
									System.out.println("Enter new Pass");
									String newpass=sc.next();
									c.setPassword(newpass);
									updated=true;
									System.out.println("Password Changed");
									break;
								}
							}
							if(!updated)
							{
								System.out.println("Invalid Cred");
							}
							break;
							
						case 4: //Delete Obj
							System.out.println("Enter Email and Password");
							String delEmail=sc.next();
							String delPass=sc.next();
							
							Iterator<Customer>itr=customerList.iterator();
							boolean deleted=false;
							
							while(itr.hasNext())
							{
								Customer c=itr.next();
								if(c.getEmail().equals(delEmail) && c.getPassword().equals(delPass))
								{
									itr.remove();
									System.out.println("Deleted");
									deleted=true;
									break;
								}
							}
							if(!deleted)
							{
								System.out.println("Invalid Cred");
							}
							break;
							
						case 5: //Display all
							if(customerList.isEmpty())
							{
								System.out.println("NO customers");
							}
							else
							{
								customerList.forEach(System.out::println);
							}
							break;
							
						case 6: // Search by Email
							System.out.println("Enter Email");
							System.out.println(Utility.Search(sc.next(), customerList));
	                        break;
	                        
						case 7: //Sort by Reg Amount using Comparator
							Collections.sort(customerList, (a, b) ->
                            Double.compare(a.getRegamount(), b.getRegamount()));

							for (Customer c : customerList)
								System.out.println(c);
							break;
							
						case 8: //Sort by ID using Comparable
						    Collections.sort(customerList);   // uses compareTo()

						    for (Customer c : customerList)
						        System.out.println(c);

						    break;
						    
						case 9: //oldest to youngest dob sort (Comparator)
							Collections.sort(customerList, (c1, c2) -> 
					        c1.getDob().compareTo(c2.getDob()));

							for (Customer c : customerList)
								System.out.println(c);
							break;
							
						case 10:
							Collections.sort(customerList, (c1, c2) ->
					        c1.getPlan().compareTo(c2.getPlan()));

							for (Customer c : customerList)
								System.out.println(c);
							break;
							
						case 0: //Exit
							exit=true;
							System.out.println("Exiting");
							break;
						default:
							System.out.println("Invalid Choice");
							break;
					}
				} catch(Exception e)
				{
					System.out.println("Error: " + e.getMessage());
	                sc.nextLine();
				}
			}
		}
	}

}
*/
