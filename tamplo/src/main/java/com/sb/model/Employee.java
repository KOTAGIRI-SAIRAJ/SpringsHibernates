package com.sb.model;



import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    @NotNull
    private String email;

    @Column
    @Min(10000)
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_card_id")
    private AccessCard accessCard;

    @OneToMany(mappedBy = "task")
    private List<Task> taskList = new ArrayList<Task>();

    @ManyToMany()
    @JoinTable(name = "employee_meetings",
            joinColumns = { @JoinColumn(name = "fk_employee") },
            inverseJoinColumns =   { @JoinColumn(name = "fk_meeting") })
    private List<Meeting> meetingsList = new ArrayList<Meeting>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Meeting> getMeetingsList() {
        return meetingsList;
    }

    public void setMeetingsList(List<Meeting> meetingsList) {
        this.meetingsList = meetingsList;
    }

}
