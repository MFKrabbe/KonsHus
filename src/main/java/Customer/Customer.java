package Customer;

public class Customer
{
    private String id;                              //fldCustomerID in database
    private String name;                            //fldCustomerName
    private String cvrNr;                           //fldCvrNr
    private String phoneNr;                         //fldCustomerPhoneNr
    private String email;                           //fldCustomerEmail

    public Customer(){}

    public Customer(String name, String cvrNr, String phoneNr, String email)
    {
        //this.id = id;
        this.name = name;
        this.cvrNr = cvrNr;
        this.phoneNr = phoneNr;
        this.email = email;
    }

    @Override
    public String toString()
    {
        return this.id + " " + this.name + " " + this.cvrNr + " " + this.phoneNr + " " + this.email;
    }

    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCvrNr()
    {
        return this.cvrNr;
    }

    public String getPhoneNr()
    {
        return phoneNr;
    }

    public String getEmail()
    {
        return email;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setCvrNr(String cvrNr)
    {
        this.cvrNr = cvrNr;
    }

    public void setPhoneNr(String phoneNr)
    {
        this.phoneNr = phoneNr;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
