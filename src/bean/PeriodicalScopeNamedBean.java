package bean;

import annotation.InjectRandomInt;
import api.NamedBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by rpadalka on 4/5/17.
 */
@Component
@Scope("periodical")
public class PeriodicalScopeNamedBean implements NamedBean {

    @Value("${keyPeriodicalNamedScope}")
    private String value;
    @InjectRandomInt(min = 1, max = 10)
    private int randomInt;

    @Override
    public String getValues() {
        return this.getClass().getName() + "\n" + "value = '" + value + "'";
    }

    public int getRandomInt() {
        return randomInt;
    }
}
