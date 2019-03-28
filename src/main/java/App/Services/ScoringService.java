package App.Services;

import App.models.Rule;
import App.Dao.RuleRepository;
import App.models.ScoreNutrition;
import App.Dao.ScoreNutritionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ScoringService {
    @Autowired
    private RuleRepository ruleRepository;
    private static List<Rule> rules;

    @Autowired
    private ScoreNutritionRepository scoreNutritionRepository;
    private static List<ScoreNutrition> scoreNutrition;

    @PostConstruct
    public void init(){

        ScoringService.rules = (List<Rule>) ruleRepository.findAll();
        ScoringService.scoreNutrition = (List<ScoreNutrition>) scoreNutritionRepository.findAll();
    }

    public static int getPoints(String type, double value) {
        List<Rule> concernedRules = rules.stream().filter(rule -> Objects.equals(type, rule.getName())).collect(Collectors.toList());
        concernedRules.sort(Comparator.comparingDouble(Rule::getMin_bound).reversed());
        //no need to check if optional is present or not
        return concernedRules.stream().filter(rule -> value - rule.getMin_bound() > 0).findFirst().get().getPoints();
    }

    public static ScoreNutrition getClasse( int  value) {
        return  scoreNutrition.stream().filter(score -> value- score.getlBound()>0 && score.getuBound()-value>0).findFirst().get();
    }


}
