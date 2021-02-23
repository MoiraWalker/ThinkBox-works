package nl.walker.novi.thinkbox.domain;
import javax.persistence.*;
import java.io.File;

@Entity
public class Work extends Post {
    private String description;
    private String link;

    public Work() {

    }

    public Work(long id, String title, String projectId, PostType type, String description, String link) {
        super(id, title, projectId, type);
        this.description = description;
        this.link = link;
    }

    //  ##### constructor met project
//    public Work(long id, String title, String projectId, PostType type, Project project, String description, String link) {
//        super(id, title, projectId, type, project);
//        this.description = description;
//        this.link = link;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
}
