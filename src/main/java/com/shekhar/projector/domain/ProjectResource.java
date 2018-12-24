package com.shekhar.projector.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by shekhar.kumar on 10/29/2018.
 */
@Entity
public class ProjectResource {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Employee employee;
    @OneToOne
    private Designation designatedAs;
    private Date designatedOn;
    @ManyToOne
    private Employee reportsTo;

    public ProjectResource(){};

    public ProjectResource(Employee employee, Designation designatedAs, Date designatedOn, Employee reportsTo) {
        this.employee = employee;
        this.designatedAs = designatedAs;
        this.designatedOn = designatedOn;
        this.reportsTo = reportsTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Designation getDesignatedAs() {
        return designatedAs;
    }

    public void setDesignatedAs(Designation designatedAs) {
        this.designatedAs = designatedAs;
    }

    public Date getDesignatedOn() {
        return designatedOn;
    }

    public void setDesignatedOn(Date designatedOn) {
        this.designatedOn = designatedOn;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectResource that = (ProjectResource) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ProjectResource{" +
                "id=" + id +
                ", employee=" + employee +
                ", designatedAs=" + designatedAs +
                ", designatedOn=" + designatedOn +
                ", reportsTo=" + reportsTo +
                '}';
    }
}