package customerTracking;

import java.util.ArrayList;

/**
 * A customer class with name, ID, and Geography.
 * @author USER
 *
 */

public class Customer {
	// static variables shared across all instances of Customer
	/**
	 * Company for all customers
	 */
	static final String COMPANY = "CVS";
	/**
	 * stores list of all customers.
	 */
static ArrayList<Customer> CUSTOMERS  = new ArrayList<Customer>();

static Counter COUNTER;

//instance var's
/**
 * name of customer
 */
String name;

/**
 * Geography of customer..
 */
String geography;
/**
 * ID of customer..
 */
int ID;
//constructor
public Customer(String name, String geography) {
		this.name = name;
		this.geography = geography;
		
		//get unique ID from counter...
		this.ID = Customer.COUNTER.getCount(); 
		
		//increment counter
		Customer.COUNTER.increment();
		
		//
		Customer.CUSTOMERS.add(this);
}

//methods
/**
 * Prints all customers for the company..
 */
public static void printAllCustomers() {
	System.out.println("All customers");
	
	//iterate over statically references list of customers...
	for(Customer c : Customer.CUSTOMERS) {
		System.out.println(c);
	}
	System.out.println("\n");
}
/**
 * compares 2 customers for equality...
 * if they have the same name and geography, they are equal...
 */
public boolean equals(Object obj) {
	
	//cast object to customer
	Customer otherCustomer = (Customer)obj;
	
	//compare name and geography for customers
	if (this.name.equals(otherCustomer.name) &&  this.geography.equals(otherCustomer.geography)){
		return true;
	}
	return false;
}

/**
 * returns id, name of Customer and geography...
 */
public String toString() {
	return this.ID + ":" + this.name + ", location: " + this.geography + ", company: " + Customer.COMPANY;
}

public static int findCustomer(Customer customer) {
	int index = -1;
	
	for (int i = 0; i < Customer.CUSTOMERS.size(); i++) {
		if (Customer.CUSTOMERS.get(i).equals(customer)) { // this calls equals method in customer class
			
			//set default index
			index = i;
			break;
		}
	}
	return index;
}

public static void removeCustomer(Customer customer) {
	
	int removeIndex = Customer.findCustomer(customer);
	
	if (removeIndex>=0) {
		Customer.CUSTOMERS.remove(removeIndex);
	}
}
	public static void main(String[] args) {
		//initialize counter for generating unique  ID for each customer
		Customer.COUNTER = new Counter(1);
		
		//
		Customer c1 = new Customer("cheyun", "Los angeles");
	
		//print all customers
		Customer.printAllCustomers();
		
		Customer c2 = new Customer("Luiz", "Kenya");
		Customer.printAllCustomers();
		
		Customer c3 = new Customer("Lee", "Brasil");
		Customer.printAllCustomers();
		
		Customer.removeCustomer(c3);
		Customer.printAllCustomers();
		
		Customer.removeCustomer(c2);
		Customer.printAllCustomers();
		
		
		
	}
}
