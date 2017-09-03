package bean;

import api.NamedBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("namedBean")
public class NamedBeanImpl implements NamedBean {

    @Value("${keyNamedScope}")
    private String value;

    @Override
    public String getValues() {
        return this.getClass().getName() + "\n" + "value = '" + value + "'";
    }
}
