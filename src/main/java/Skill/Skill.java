package Skill;

import java.sql.Statement;
import java.util.Scanner;

//import static jdk.jfr.internal.test.DeprecatedMethods.counter;

public class Skill

{
    private String ID;
    private String Category;
    public Skill()
    {
    }

    public Skill(String ID, String Category)
    {

        this.ID = ID;
        this.Category = Category;
    }


    @Override
    public String toString() {return this.ID + " " + this.Category + " ";}

    public String getID() {return this.ID;}

    public String getCategory() {return this.Category;}

    public void setID(String newID) {this.ID = newID;}

    public void setCategory(String newCategory) {this.Category = newCategory;}

}
