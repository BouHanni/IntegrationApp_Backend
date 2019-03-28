package App.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    private int id;
    private String barCode;

    @Autowired
    @ElementCollection
    private List<String> qualities;
    @Autowired
    @ElementCollection
    private List<String> defaults;
    private int nutritionScore;
    private String classe;
    private String color;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;




    public Product(String barCode) {
        this.barCode = barCode;

    }

    public Product() {

    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }



    public List<String> getQualities() {
        return qualities;
    }

    public void setQualities(List<String> qualities) {
        this.qualities = qualities;
    }

    public List<String> getDefaults() {
        return defaults;
    }

    public void setDefaults(List<String> defaults) {
        this.defaults = defaults;
    }

    public double getScore() {
        return nutritionScore;
    }

    public void setScore(int score) {
        this.nutritionScore = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
