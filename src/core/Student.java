package core;

public class Student {
    private String name;
    private String id;
    private String email;
    private DayOfBirth dob;
    private Grade grade;
    // setter
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDob(DayOfBirth dob) {
        this.dob = dob;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    // getter
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public DayOfBirth getDob() {
        return dob;
    }
    public Grade getGrade() {
        return grade;
    }

}
