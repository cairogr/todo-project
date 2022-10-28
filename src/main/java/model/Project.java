package model;

import java.util.Date;

public class Project {
    private int id;
    private String name;
    private String description;
    private Date updateDate;
    private Date createDate;


    public Project(int id, String name, String description, Date updateDate, Date createDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.updateDate = updateDate;
        this.createDate = createDate;
    }

    public Project() {
        this.createDate = new Date();
        this.updateDate = new Date();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                '}';
    }
}
