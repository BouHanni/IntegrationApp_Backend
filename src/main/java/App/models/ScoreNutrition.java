package App.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NUTRITION_SCORE")
public class ScoreNutrition {
    @Id
    private int id;
    private String classe;
    @Column(name = "lower_bound")
    private int lBound;
    @Column(name = "upper_bound")
    private int uBound;
    private String color;

    public ScoreNutrition(int id, String classe, int lBound, int uBound, String color) {
        this.id = id;
        this.classe = classe;
        this.lBound = lBound;
        this.uBound = uBound;
        this.color = color;
    }

    public ScoreNutrition() {
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

    public int getlBound() {
        return lBound;
    }

    public void setlBound(int lBound) {
        this.lBound = lBound;
    }

    public int getuBound() {
        return uBound;
    }

    public void setuBound(int uBound) {
        this.uBound = uBound;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
