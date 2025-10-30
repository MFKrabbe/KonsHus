package Consultant;

public interface ConsultantDao {

    void saveConsultant(Consultant consultant) throws Exception;

    Consultant getConsultant(String id) throws Exception;

    String [] getAllConsultants() throws Exception;

    void updateConsultant(String id, Consultant consultant) throws Exception;

    void deleteConsultant(String id) throws Exception;



    /*
    public interface DepartmentDao {
    // C i CRUD
    void saveDepartment(Department department) throws Exception;
    // R i CRUD
    Department getDepartment(String no) throws Exception; // no er primærnøglen
    // R i CRUD
    String [] getAllDepartments() throws Exception;
    // U i CRUD
    void updateDepartment(String no, Department department) throws Exception;
    // D i CRUD
    void deleteDepartment(String no) throws Exception;
*/
    }
