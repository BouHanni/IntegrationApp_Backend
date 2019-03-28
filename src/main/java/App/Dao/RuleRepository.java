package App.Dao;

import App.models.Rule;
import org.springframework.data.repository.CrudRepository;


public interface RuleRepository  extends CrudRepository<Rule, Long> {
}
