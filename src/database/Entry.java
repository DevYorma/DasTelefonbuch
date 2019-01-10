package database;

public class Entry {
    private String firstname = "";
    private String lastname = "";
    private String phonenumber = "";
    private String street = "";
    private String housenumber = "";
    private String town = "";
    private String postcode = "12345";


    public Entry(String firstname, String lastname, String phonenumber, String street, String housenumber, String town, String postcode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.street = street;
        this.town = town;
        this.postcode = postcode;
        this.housenumber = housenumber;
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getPhonenumber() { return phonenumber; }
    public String getStreet() { return street; }
    public String getHousenumber() { return housenumber; }
    public String getTown() { return town; }
    public String getPostcode() { return postcode; }

    protected void setFirstname(String value) { firstname = value; }
    protected void setLastname(String value) { lastname = value; }
    protected void setPhonenumber(String value) { phonenumber = value; }
    protected void setStreet(String value) { street = value; }
    protected void setHousenumber(String value) { housenumber = value; }
    protected void setTown(String value) { town = value; }
    protected void setPostcode(String value) { postcode = value; }
}
