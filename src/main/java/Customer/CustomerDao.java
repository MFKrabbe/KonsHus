package Customer;

public interface CustomerDao
{
    // Create in CRUD
    void saveCustomer(Customer c) throws Exception;
    // Read in CRUD
    Customer getCustomer(String id) throws Exception; // id er primærnøglen i databasen
    String[] getAllCustomers() throws Exception;
    // Update in CRUD
    void updateCustomerName(String id, String newName) throws Exception;
    void updateCustomerCvrNr(String id, String newCvrNr) throws Exception;
    void updateCustomerPhoneNr(String id, String newPhoneNr) throws Exception;
    void updateCustomerEmail(String id, String newEmail) throws Exception;
    // Delete in CRUD
    void deleteCustomer(String id) throws Exception;

}

/*
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




public int getProductSupplierID();
    public void setProductSupplierID(int supplierID);
    public String getProductSupplierName();
    public void setProductSupplierName(String productSupplierName);
    public String getProductSupplierPhoneNo();
    public void setProductSupplierPhoneNo(String productSupplierPhoneNo);
 */
