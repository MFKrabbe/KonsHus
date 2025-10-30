package Project;

public class Project
{

    private String id;                     //fldprojectID;
    private String name;                   //fldprojectName
    private String start;                  //fldprojectStartDate
    private String slut;                   //fldprojectSlutDate
    private double price;                  //fldProjectPrice
    private String cId;                    //fldCustomerID




    public Project() {}

    public Project(String id, String name, String start, String slut, String cId, double price)
    {
        this.id = id;
        this.name = name;
        this.start = start;
        this.slut = slut;
        this.price = price;
        this.cId = cId;
    }

    @Override
    public String toString()
    {
        return this.id + " " + this.name + " " + this.start + " " + this.slut + " " + this.price + " " + this.cId;
    }

    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getStart()
    {
        return this.start;
    }

    public String getSlut()
    {
        return this.slut;
    }

    public double getPrice()
    {
        return this.price;
    }

    public String getCId()
    {
        return this.cId;
    }


    public void setId(String newId)
    {
        this.id = newId;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setStart(String newStart)
    {
        this.start = newStart;
    }

    public void setSlut(String newSlut)
    {
        this.slut = newSlut;
    }

    public void setPrice(double newPrice)
    {
        this.price = newPrice;
    }

    public void setCId(String newCId) {this.cId = newCId;}

}



