package code;

public class Certificate {
    private String recipient;
    private String course;
    private String instructor;

    public Certificate(String recipient, String course, String instructor) {
        this.recipient = recipient;
        this.course = course;
        this.instructor = instructor;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
