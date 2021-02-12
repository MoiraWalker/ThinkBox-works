package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Project;
import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();
    Project getProjectById(long id);
    void deleteProject(long id);
    long saveProject(Project project);
    void updateProject(long id, Project project);
}
