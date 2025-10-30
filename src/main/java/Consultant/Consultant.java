package Consultant;

public class Consultant
{

    private String id;                      //fldConsultantID;
    private String name;                    //fldConsultantFullName;
    private String phoneNr;                 //fldConsultantPhoneNr;
    private String email;                   //fldConsultantEmail;

    public Consultant () {}

    public Consultant(String id, String name, String phoneNr, String email)
    {
        this.id = id;
        this.name = name;
        this.phoneNr = phoneNr;
        this.email = email;
    }

    @Override
    public String toString()
    {
        return this.id + " " + this.name + " " + this.phoneNr + " " + this.email;
    }

    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPhoneNr()
    {
        return this.phoneNr;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setId(String newId)
    {
        this.id = newId;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setPhoneNr(String newPhoneNr)
    {
        this.phoneNr = newPhoneNr;
    }

    public void setEmail(String newEmail) {this.email = newEmail;}

}

