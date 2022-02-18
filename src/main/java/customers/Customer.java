package customers;

public class Customer {
    private String customerID;
    private String contactName;
    private String city;
    private String phone;

    public Customer(){

    }

    public Customer(String customerID, String contactName, String city, String phone) {
        this.customerID = customerID;
        this.contactName = contactName;
        this.city = city;
        this.phone = phone;
    }

    // Getters and setters

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
