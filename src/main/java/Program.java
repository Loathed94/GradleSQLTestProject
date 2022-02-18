import customers.Customer;
import dbhelper.SqliteHelper;


import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        SqliteHelper sqliteHelper = new SqliteHelper();
        ArrayList<Customer> customers = sqliteHelper.selectAllCustomers();
        //TO CRAIG  ---  I want to find Customer AAAAB in Northwind
        Customer customer = sqliteHelper.selectSpecificCustomer("AAAAB");

        //printCustomers(customers);
        //TO CRAIG ---  Print says AAAAB does not exist (and yes I ran with addNewCustomer first in separate run before trying to get the customer)
        printCustomer(customer);
        System.out.println("Testing New SQL");
        customers = sqliteHelper.selectAllCustomersOrderByCity();
        //printCustomers(customers);
        //TO CRAIG  ---  I want to add the Customer below (AAAAB) to northwind.
        //Customer christian = new Customer("AAAAB", "Christian Neij", "Göteborg", "0987654321");
        //System.out.println(sqliteHelper.addNewCustomer(christian));
    }

    public static void printCustomers(ArrayList<Customer> customers) {
        if(customers.size() != 0) {
            for (Customer c : customers) {
                System.out.println("-------------------------------");
                System.out.println(c.getCustomerID());
                System.out.println(c.getContactName());
                System.out.println(c.getCity());
                System.out.println(c.getPhone());
            }
        } else {
            System.out.println("No customers returned");
        }
    }
    public static void printCustomer(Customer customer) {
        if(customer != null){
            System.out.println("-------------------------------");
            System.out.println(customer.getCustomerID());
            System.out.println(customer.getContactName());
            System.out.println(customer.getCity());
            System.out.println(customer.getPhone());
        } else {
            System.out.println("No customer with that ID exists");
        }

    }
}
