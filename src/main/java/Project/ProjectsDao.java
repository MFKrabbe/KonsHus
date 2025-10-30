package Project;

public interface ProjectsDao {
    void saveProject(Project projects) throws Exception;

    Project getProject(String id) throws Exception;

    String [] getAllProjects() throws Exception;

    void updateProject(String id, Project projects) throws Exception;

    void deleteProject(String id) throws Exception;


}
