import Customer.Customer;
import Customer.CustomerDao;
import Customer.CustomerDaoImpl;
import Skill.Skill;
import Skill.SkillDAO;
import Skill.SkillDAOImpl;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        /*
        CustomerDao dao = new CustomerDaoImpl();

        Customer c = new Customer("TEST","John Doe","NULL","11223344","jd@gmail.com");
        dao.saveCustomer(c); // her gemmes det nye customer

        String [] customers = dao.getAllCustomers(); // her hentes alle customers som tekst

        for (int i = 0; i < customers.length; i++)
        {
            System.out.println(customers[i]);
        }

        */

        /*
        SkillDAO dao = new SkillDAOImpl();

        try {

            Skill newSkill = new Skill("S001", "Java Programming");
            dao.saveSkill(newSkill);
            Skill TEST = new Skill("S009", "ØKO");
            dao.saveSkill(TEST);
            Skill TEST2 = new Skill("S005", "Revisor");
            dao.saveSkill(TEST2);

            Skill skillFromDB = dao.getSkillById("S001");
            if (skillFromDB != null) {
                System.out.println("Skill hentet fra DB: " + skillFromDB);
            }

            List<Skill> allSkills = dao.getAllSkills();
            System.out.println("Alle skills i databasen:");
            for (Skill s : allSkills) {
                System.out.println(" - " + s);
            }
            dao.deleteSkill("S001");
            System.out.println("Skill slettet.");

        } catch (Exception e) {
            e.printStackTrace();
        }

         */


        Menu menu = new Menu();

        menu.runProgram();
    }
}
