package App.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rule {

    @Id
    @Column(name = "id")
    private int id;
    private String name;
    private double min_bound;
    private int points;
    private String component;

    public Rule(int id, String name, double min_bound, int points, String compponent) {
        this.id = id;
        this.name = name;
        this.min_bound = min_bound;
        this.points = points;
        this.component = compponent;
    }

    public Rule() {
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

    public double getMin_bound() {
        return min_bound;
    }

    public void setMin_bound(double min_bound) {
        this.min_bound = min_bound;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
