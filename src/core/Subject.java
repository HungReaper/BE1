package core;

public class Subject {
    private String name;
    private String id;
    private String credit;

    public Subject(String name, String id, String credit) {
        this.name = name;
        this.id = id;
        this.credit = credit;
    }

    public Subject() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
