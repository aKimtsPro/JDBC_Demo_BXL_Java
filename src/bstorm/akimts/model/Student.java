package bstorm.akimts.model;

import java.time.LocalDateTime;

public class Student {

    private long id;
    private String firstname;
    private String lastname;
    private LocalDateTime birthdate;
    private String login;
    private long sectionId;
    private int yearResult;
    private String courseId;


    public Student() {
    }

    public Student(long id, String firstname, String lastname, LocalDateTime birthdate, String login, long sectionId, int yearResult, String courseId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.login = login;
        this.sectionId = sectionId;
        this.yearResult = yearResult;
        this.courseId = courseId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public int getYearResult() {
        return yearResult;
    }

    public void setYearResult(int yearResult) {
        this.yearResult = yearResult;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
