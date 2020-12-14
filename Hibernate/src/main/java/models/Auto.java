package models;


import javax.persistence.*;

@Entity
@Table(name= "autos")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "model")
    private String model;

    @Column(name= "color")
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public Auto(){}

    public Auto(String model, String color){
        this.color = color;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public User getUser() {
        return user;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", user=" + user +
                '}';
    }

}
