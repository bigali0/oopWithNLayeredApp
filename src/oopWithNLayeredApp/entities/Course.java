package oopWithNLayeredApp.entities;

public class Course {
    private int id;
    private String name;
    private int coursePrice;

    public Course() {
    }

    public Course(int id, String name, int coursePrice) {
        this.id = id;
        this.name = name;
        this.coursePrice = coursePrice;
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

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int price) {
        this.coursePrice = price;
    }
}
