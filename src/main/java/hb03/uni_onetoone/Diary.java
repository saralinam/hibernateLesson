package hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary { //this will be default diary

    @Id
    private int Id;

    private String name;

    @OneToOne // in my dairy Table new column be added with default name "student_id"
    @JoinColumn(name = "std_id")
    private Student03 student;


    //getter - setter


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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }


    //to String

    @Override
    public String toString() {
        return "Diary{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }



}
