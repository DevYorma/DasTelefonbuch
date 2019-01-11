package database;

public class Entry {
    private String firstname = "";
    private String lastname = "";
    private String phonenumber = "";
    private String street = "";
    private String housenumber = "";
    private String town = "";
    private String postcode = "";


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

    public void setFirstname(String value) { firstname = value; }
    public void setLastname(String value) { lastname = value; }
    public void setPhonenumber(String value) { phonenumber = value; }
    public void setStreet(String value) { street = value; }
    public void setHousenumber(String value) { housenumber = value; }
    public void setTown(String value) { town = value; }
    public void setPostcode(String value) { postcode = value; }
}
