package cms;

import java.util.List;

public class Utility {

    public static void validateEmail(String email) throws CustomerException {
        if (email == null || !email.contains("@") || !email.endsWith(".com")) {
            throw new CustomerException("Invalid Email");
        }
    }

    public static void checkDuplicate(String email, List<Customer> list)
            throws CustomerException {

        Customer temp = new Customer(email);

        if (list.contains(temp)) {
            throw new CustomerException("Email already exists");
        }
    }
}

/*package cms;
import java.util.List;

public class Utility
{
	public static void checkforDuplicates(String email,List<Customer>customers) throws CustomerException
	{
		Customer newcust= new Customer(email);
		if(customers.contains(newcust))
			throw new CustomerException("Email already Registered");
	}
	
	public static void validateEmail(String email) throws CustomerException
	{
		if(email==null||!email.contains("@")||!email.endsWith(".com"))
			throw new CustomerException("Invalid Email");
	}
}
*/