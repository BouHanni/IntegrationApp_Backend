package App.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Order {

    @Id
    private long id;

    @OneToMany
    private List<Product> productList;


    @NotNull
    private String email;

    public Order(long id, List<Product> productList, @Email(message = "Email should be valid") @NotNull String email) {
        this.id = id;
        this.productList = productList;
        this.email = email;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
