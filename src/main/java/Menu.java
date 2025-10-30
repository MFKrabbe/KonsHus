import Customer.Customer;
import Customer.CustomerDao;
import Customer.CustomerDaoImpl;
import Skill.Skill;
import Skill.SkillDAO;
import Skill.SkillDAOImpl;

import java.util.List;
import java.util.Scanner;

public class Menu
{
    public Menu() {}
    CustomerDao dao = new CustomerDaoImpl();
    SkillDAO skillDAO = new SkillDAOImpl();
    Scanner in = new Scanner(System.in);

    public void displayCustomers() throws Exception
    {
        System.out.println("Here are the customers");
        String[] customers = dao.getAllCustomers(); // her hentes alle customers som tekst
        for (int i = 0; i < customers.length; i++)
        {
            System.out.println(customers[i]);
        }
    }
    public void displaySkills() throws Exception
    {
        // Denne case skal vise alle skills
        List<Skill> skills = skillDAO.getAllSkills();
        if (skills.isEmpty()) //Tjekker om der er en værdi
        {
            System.out.println("Ingen kompetencer fundet.");//Printes hvis der ingen værdi er i tblSkill->fldSkillCategory
        } else
        {
            System.out.println("\n--- Alle skills ---");
            for (Skill s : skills) //Ellers printes alle kompetencer i tblSkill->fldSkillCategory ud til konsol
            {
                System.out.println(s);
            }
        }
    }

    public void runProgram() throws Exception
    {
        boolean isOn = true;
        do
        {
            System.out.println("What do you want to view?");
            System.out.println(" ");
            System.out.println("0: To Exit");
            System.out.println("1: Customers");
            System.out.println("2: Consultants");
            System.out.println("3: Projects");
            System.out.println("4: Hours");
            System.out.println("5: Skills");

            int nrEntered;
            if (in.hasNextInt())
            {
                nrEntered = in.nextInt();
                in.nextLine();
                switch (nrEntered)
                {
                    case 0:
                        //exit program
                        isOn = false;
                        break;
                    case 1:
                        //enter customers
                        System.out.println("0: Exit customer System");
                        System.out.println("1: Do you want to view customers?");
                        System.out.println("2: Do you want to edit existing customer?");
                        System.out.println("3: Do you want to delete existing customer?");
                        System.out.println("4: Do you want to add new customer?");


                        if (in.hasNextInt())
                        {
                            nrEntered = in.nextInt();
                            in.nextLine();
                            switch (nrEntered)
                            {
                                case 0:
                                    System.out.println("Returning to menu");
                                    break;
                                case 1:
                                    displayCustomers();
                                    continue;
                                case 2:
                                    displayCustomers();
                                    System.out.println("Which customers do you want to update?");
                                    String upId = in.next();
                                    in.nextLine();
                                    System.out.println("What do you want to update?\n");
                                    System.out.println("0: Cancel Update");
                                    System.out.println("1: Full name");
                                    System.out.println("2: Cvr number");
                                    System.out.println("3: Phone number");
                                    System.out.println("4: Email");

                                    if(in.hasNextInt())
                                    {
                                        nrEntered = in.nextInt();
                                        in.nextLine();
                                        switch (nrEntered)
                                        {
                                            case 0:
                                                break;
                                            case 1:
                                                System.out.println("What is the new name?");
                                                String newName = in.nextLine();
                                                dao.updateCustomerName(upId, newName);
                                                break;
                                            case 2:
                                                System.out.println("What is the new cvr nr?");
                                                String newCvrNr = in.nextLine();
                                                dao.updateCustomerCvrNr(upId, newCvrNr);
                                                break;
                                            case 3:
                                                System.out.println("What is the new phone number?");
                                                String newPhoneNr = in.nextLine();
                                                dao.updateCustomerPhoneNr(upId, newPhoneNr);
                                                break;
                                            case 4:
                                                System.out.println("What is the new Email?");
                                                String newEmail = in.nextLine();
                                                dao.updateCustomerEmail(upId, newEmail);
                                                break;
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Please input a number (0 to exit)");
                                        in.nextLine();
                                    }
                                    break;
                                case 3:
                                    displayCustomers();
                                    System.out.println("What customer do you want to delete?");
                                    String delId = in.next();
                                    dao.deleteCustomer(delId);
                                    in.nextLine();  //clears input
                                    System.out.println("Customer deleted successfully");
                                    break;
                                case 4:
                                    System.out.println("Adding new customer");

                                    System.out.println("\nPlease enter full name");
                                    String fullName = in.nextLine();

                                    System.out.println("\nPlease enter 8 digit cvr number (Type NULL if no cvrNr)");
                                    String cvrNr = in.next();
                                    in.nextLine();

                                    System.out.println("\nPlease enter phone number (10 digits)");
                                    String phoneNr = in.next();
                                    in.nextLine();

                                    System.out.println("\nPlease enter Email");
                                    String email = in.next();
                                    in.nextLine();

                                    Customer c = new Customer(fullName, cvrNr, phoneNr, email);
                                    dao.saveCustomer(c); // her gemmes det nye customer
                                    break;
                            }
                        } else
                        {
                            System.out.println("please input a number (0 to exit)");
                            in.nextLine();
                        }
                        break;
                    case 2:
                        //enter consultants
                        break;
                    case 3:
                        //enter Projects
                        break;
                    case 4:
                        //enter Hours
                        break;
                    case 5:
                        //enter Skills
                        boolean programRunning = true;
                        while (programRunning)
                        {

                            System.out.println("0: Exit skill System");
                            System.out.println("1: Do you want to view skills?");
                            System.out.println("2: Do you want to add new skill?");
                            System.out.println("3: Do you want to edit existing skill?");
                            System.out.println("4: Do you want to delete existing skill?");

                            String choice = in.nextLine();
                            try
                            {
                                switch (choice)
                                {
                                    case "1":
                                        displaySkills();
                                        break;
                                    case "2":
                                        // Denne case skal gemme i dbKonsulenternesHus
                                        displaySkills();
                                        System.out.print("Input ID: ");
                                        String id = in.nextLine();
                                        System.out.print("Input category: ");
                                        String category = in.nextLine();
                                        Skill newSkill = new Skill(id, category);
                                        skillDAO.saveSkill(newSkill);
                                        break;
                                    case "3":
                                        // Denne case skal opdatere en enkelt kompetence i fldSkillCategory ud fra fldSkillID
                                        displaySkills();
                                        System.out.print("What skill do you want to update?");
                                        String updateId = in.nextLine();
                                        System.out.print("Input new category: ");
                                        String newCategory = in.nextLine();
                                        Skill updatedSkill = new Skill(updateId, newCategory);
                                        skillDAO.updateSkill(updateId, updatedSkill);
                                        break;
                                    case "4":
                                        // Denne case skal slette en kompetence i tblSkill->fldSkillCategory
                                        displaySkills();
                                        System.out.print("What skill do you want to delete?");
                                        String deleteId = in.nextLine();
                                        skillDAO.deleteSkill(deleteId);
                                        break;
                                    case "0":
                                        programRunning = false;
                                        System.out.println("Turning off program...");
                                        break;

                                    default:
                                        System.out.println("Invalid choice – Try again.");
                                }
                            } catch (Exception e)
                            {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        break;
                    default:
                        System.out.println("Please input 1-5 or press 0 to exit");
                        break;
                }
            }
            else
            {
                System.out.println("please input a number (0 to exit)");
                in.nextLine();
            }
        }while(isOn);
    }
}



/*public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        SkillDAO skillDAO = new SkillDAOImpl();
        boolean programRunning = true;

        while (programRunning)
        {
            System.out.println("\n      === MENU ===");
            System.out.println("1. Vis alle kompetencer");
            System.out.println("2. Tilføj ny kompetence");
            System.out.println("3. Opdater en kompetence");
            System.out.println("4. Slet en kompetence");
            System.out.println("0. Afslut program");
            System.out.print("Vælg en mulighed fra 1. til 4. og 0. for at afslutte: ");

            String choice = scanner.nextLine();

            try
            {
                switch (choice)
                {
                    case "1":
                        // Denne case skal vise alle skills
                        List<Skill> skills = skillDAO.getAllSkills();
                        if (skills.isEmpty()) //Tjekker om der er en værdi
                        {
                            System.out.println("Ingen kompetencer fundet.");//Printes hvis der ingen værdi er i tblSkill->fldSkillCategory
                        } else
                        {
                            System.out.println("\n--- Alle skills ---");
                            for (Skill s : skills) //Ellers printes alle kompetencer i tblSkill->fldSkillCategory ud til konsol
                            {
                                System.out.println(s);
                            }
                        }
                        break;

                    case "2":
                        // Denne case skal gemme i dbKonsulenternesHus
                        System.out.print("Indtast ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Indtast kategori: ");
                        String category = scanner.nextLine();
                        Skill newSkill = new Skill(id, category);
                        skillDAO.saveSkill(newSkill);
                        break;

                    case "3":
                        // Denne case skal opdatere en enkelt kompetence i fldSkillCategory ud fra fldSkillID
                        System.out.print("Indtast ID på skill der skal opdateres: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Indtast ny kategori: ");
                        String newCategory = scanner.nextLine();
                        Skill updatedSkill = new Skill(updateId, newCategory);
                        skillDAO.updateSkill(updateId, updatedSkill);
                        break;

                    case "4":
                        // Denne case skal slette en kompetence i tblSkill->fldSkillCategory
                        System.out.print("Indtast ID på kompetence der skal slettes: ");
                        String deleteId = scanner.nextLine();
                        skillDAO.deleteSkill(deleteId);
                        break;

                    case "0":
                        programRunning = false;
                        System.out.println("Program afsluttes...");
                        break;

                    default:
                        System.out.println("Ugyldigt valg – prøv igen.");
                }
            } catch (Exception e)
            {
                System.out.println("Fejl: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

 */