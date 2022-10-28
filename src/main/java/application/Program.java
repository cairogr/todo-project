package application;

import controller.ProjectController;
import model.Project;
import util.ConnectionFactory;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {

        ProjectController projectController = new ProjectController();
        Project project = new Project();

        project.setName("Teste 1");
        project.setDescription("asdasdasdsa");

        projectController.save(project);










    }
}
