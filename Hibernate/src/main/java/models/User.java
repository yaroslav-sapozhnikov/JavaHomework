package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Auto> autos;

    public User(){}

    public User(String name, int age){
        this.name = name;
        this.age = age;
        autos = new ArrayList<Auto>();
    }

    public void addAuto(Auto auto){
        auto.setUser(this);
        autos.add(auto);
    }

    public void removeAuto(Auto auto){
        autos.remove(auto);
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
