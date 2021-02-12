package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.Thought;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import nl.walker.novi.thinkbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Project> getAllProjects() {

        // Ook de token binnenkrijgen.
        // gebruikersnaam uit token halen
        // Id ophalen die bij gebruikersnaam hoort.
        // via projectrepository findByUserId();
         //

        List<Project> projects = projectRepository.findAll();

        return projects;
    }

    @Override
    public Project getProjectById(long id) {
        if (projectRepository.existsById(id)) {
            return projectRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteProject(long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveProject(Project project) {
        Optional<User> optUser = userRepository.findByUsername("user");
        project.setUser(optUser.get());
        return projectRepository.save(project).getId();
    }

    @Override
    public void updateProject(long id, Project project) {
        if (projectRepository.existsById(id)) {
            try {
                Project existingProject = projectRepository.findById(id).orElse(null);
                existingProject.setTitle(project.getTitle());
                existingProject.setPrivateView(project.getPrivateView());
                projectRepository.save(existingProject);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }
}
