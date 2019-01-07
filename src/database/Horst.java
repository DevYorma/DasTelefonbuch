package database;

public class Horst {
    private String firstname = "";
    private String lastname = "";
    private String phonenumber = "";
    private String street = "";
    private String housenumber = "";
    private String town = "";
    private int plz = 12345;


    public Horst(String firstname, String lastname, String phonenumber, String street, String housenumber, String town, int plz) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.street = street;
        this.town = town;
        this.plz = plz;
        this.housenumber = housenumber;
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getPhonenumber() { return phonenumber; }
    public String getStreet() { return street; }
    public String getHousenumber() { return housenumber; }
    public String getTown() { return town; }
    public int getPLZ() { return plz; }
}
