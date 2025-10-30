package Skill;

import java.util.List;

public interface SkillDAO {
    void saveSkill(Skill skill) throws Exception;
    Skill getSkillById(String ID) throws Exception;
    List<Skill> getAllSkills() throws Exception;
    void updateSkill(String ID, Skill skill) throws Exception;
    void deleteSkill(String ID) throws Exception;
}