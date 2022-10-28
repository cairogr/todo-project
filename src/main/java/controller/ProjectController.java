package controller;

import model.Project;
import model.Task;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {

    public void save(Project project) {

        String sql = "INSERT INTO project (name, description, updateDate, createDate) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreateDate().getTime()));
            statement.setDate(4, new Date(project.getUpdateDate().getTime()));
            statement.execute();


        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar os dados" + e);
        } finally {

            ConnectionFactory.closeConnection(conn, statement);
        }


    }

    public void update(Project project) {

        String sql = "UPDATE project SET name = ?, description = ?, updateDate = ?, createDate  = ?, WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreateDate().getTime()));
            statement.setDate(4, new Date(project.getUpdateDate().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();


        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar os dados" + e);
        } finally {

            ConnectionFactory.closeConnection(conn, statement);
        }

    }

    public void deleteById(int idProject) {

        String sql = "DELETE FROM projects WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {

            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, idProject);
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar os dados" + e);
        } finally {

            ConnectionFactory.closeConnection(conn, statement);
        }


    }

    public List<Project> getAll() {

        String sql = "SELECT * FROM tasks";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();


        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreateDate(resultSet.getDate("createDate"));
                project.setUpdateDate(resultSet.getDate("updateDate"));

                projects.add(project);

            }
        }
        catch (Exception e){
            throw new RuntimeException("Erro ao listar projetos" + e.getMessage(), e);

        }

        finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }

        return projects;

    }

}
