package App.Services;

import App.models.Product;
import Utils.Constants;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private JSONObject getProductByQR(final String barCode) throws UnirestException {
        JSONObject jsonResponse
                = Unirest.get("https://fr.openfoodfacts.org/api/v0/produit/" + barCode + ".json")
                .header("accept", "application/json").queryString("apiKey", "123")
                .asJson()
                .getBody()
                .getObject();
        return jsonResponse;
    }

    public Product getProductSummary(final String barCode) throws UnirestException {
        final JSONObject jsonResponse = getProductByQR(barCode);
        if (jsonResponse.getInt("status") != 1) {
            return null;
        } else {
            JSONObject nutrimentsNode = jsonResponse.getJSONObject("product").getJSONObject("nutriments");
            Product p =new Product(barCode);
            constuctSummary(nutrimentsNode,p);
            return p;
        }
    }


    private void constuctSummary(final JSONObject nutrimentsNode, Product p) throws UnirestException {

         List<String> qualities = new ArrayList<String>();

        List<String> defaults = new ArrayList<String>();
        int nutritionScore = 0;

        for (String element : Constants.getNegatives()) {
            final int points = ScoringService.getPoints(element, nutrimentsNode.getDouble(element));
            if (points <= 3) {
                qualities.add(element);
                nutritionScore += points;
            } else if (points >= 7) {
                defaults.add(element);
                nutritionScore -= points;
            }
        }

        for (String element : Constants.getPositives()) {
            final int points = ScoringService.getPoints(element, nutrimentsNode.getDouble(element));
            if (points >= 2) {
                qualities.add(element);
                nutritionScore += points;
            } else if (points <= 0) {
                defaults.add(element);
                nutritionScore -= points;
            }
        }
        p.setScore(nutritionScore);
        p.setDefaults(defaults);
        p.setQualities(qualities);
        p.setClasse(ScoringService.getClasse(nutritionScore).getClasse());
        p.setColor(ScoringService.getClasse(nutritionScore).getColor());

    }



}
