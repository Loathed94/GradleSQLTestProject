package dbhelper;

import customers.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SqliteHelper {
    // Setup
    String URL = "jdbc:sqlite:src/main/resources/Northwind_small.sqlite";
    Connection conn = null;

    public ArrayList<Customer> selectAllCustomers(){
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Id,ContactName,City,Phone FROM customer");
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getString("Id"),
                                resultSet.getString("ContactName"),
                                resultSet.getString("City"),
                                resultSet.getString("Phone")
                        ));
            }
        }
        catch (Exception ex){
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
        }
        finally {
            try {
                // Close Connection
                conn.close();
            }
            catch (Exception ex){
                System.out.println("Something went wrong while closing connection.");
                System.out.println(ex.toString());
            }
            return customers;
        }
    }

    public Customer selectSpecificCustomer(String customerId){
        Customer customer = null;
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Id,ContactName,City,Phone FROM customer WHERE Id = ?");
            preparedStatement.setString(1, customerId); // Corresponds to 1st '?' (must match type)
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                customer = new Customer(
                                resultSet.getString("Id"),
                                resultSet.getString("ContactName"),
                                resultSet.getString("City"),
                                resultSet.getString("Phone")
                        );
            }

        }
        catch (Exception ex){
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
        }
        finally {
            try {
                // Close Connection
                conn.close();
            }
            catch (Exception ex){
                System.out.println("Something went wrong while closing connection.");
                System.out.println(ex.toString());
            }
            return customer;
        }
    }

    public ArrayList<Customer> selectAllCustomersOrderByCity(){

        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("SELECT Id,ContactName,City,Phone FROM customer ORDER BY City");
            // Execute Statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process Results
            while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getString("Id"),
                                resultSet.getString("ContactName"),
                                resultSet.getString("City"),
                                resultSet.getString("Phone")
                        ));
            }
        }
        catch (Exception ex){
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
        }
        finally {
            try {
                // Close Connection
                conn.close();
            }
            catch (Exception ex){
                System.out.println("Something went wrong while closing connection.");
                System.out.println(ex.toString());
            }
            return customers;
        }
    }

    public Boolean addNewCustomer(Customer customer){

        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("INSERT INTO Customer(Id,ContactName,City,Phone) VALUES(?,?,?,?)");

            preparedStatement.setString(1, customer.getCustomerID());
            preparedStatement.setString(2, customer.getContactName());
            preparedStatement.setString(3, customer.getCity());
            preparedStatement.setString(4, customer.getPhone());
            // Execute Statement
            preparedStatement.executeUpdate();

            // Process Results
            /*while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getString("Id"),
                                resultSet.getString("ContactName"),
                                resultSet.getString("City"),
                                resultSet.getString("Phone")
                        ));
            }*/
        }
        catch (Exception ex){
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
            return false;
        }
        finally {
            try {
                // Close Connection
                conn.close();
            }
            catch (Exception ex){
                System.out.println("Something went wrong while closing connection.");
                System.out.println(ex.toString());
                return false;
            }
            //return customers;
        }
        return true;
        //return false;
    }

    public Boolean updateExistingCustomer(Customer updatedCustomer){

        try {
            // Open Connection
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");

            // Prepare Statement
            PreparedStatement preparedStatement =
                    conn.prepareStatement("UPDATE Customer SET ContactName = ?, City = ?, Phone = ? WHERE Id LIKE ?");

            preparedStatement.setString(1, updatedCustomer.getContactName());
            preparedStatement.setString(2, updatedCustomer.getCity());
            preparedStatement.setString(3, updatedCustomer.getPhone());
            preparedStatement.setString(4, updatedCustomer.getCustomerID());

            // Execute Statement
            preparedStatement.executeUpdate();

            // Process Results
            /*while (resultSet.next()) {
                customers.add(
                        new Customer(
                                resultSet.getString("Id"),
                                resultSet.getString("ContactName"),
                                resultSet.getString("City"),
                                resultSet.getString("Phone")
                        ));
            }*/
        }
        catch (Exception ex){
            System.out.println("Something went wrong...");
            System.out.println(ex.toString());
            return false;
        }
        finally {
            try {
                // Close Connection
                conn.close();

            }
            catch (Exception ex){
                System.out.println("Something went wrong while closing connection.");
                System.out.println(ex.toString());
                return false;
            }
            //return customers;
        }
        return true;
    }

}
