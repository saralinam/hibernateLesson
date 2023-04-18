package hb02.embeddable;


import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {
   @Id
    private int Id;

   @Column(name = "student_name", length = 100, unique = false, nullable = false)
    private String name;

   private int grade;

    @Embedded//
    private Address address;

    //getter & setter


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //to String
    @Override
    public String toString() {
        return "Student02{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}
