package hb06.bi_onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "t_book06")
public class Book06 {
    @Id
    private int id;

    @Column(name="book_name", nullable = false)
    private String name;

    private int grade;

    //getter-setter


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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //toString

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
              //  ", grade=" + grade +
                '}';
    }
}
