import api.NamedBean;
import bean.PeriodicalScopeBean;
import bean.PeriodicalScopeNamedBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rpadalka on 4/3/17.
 */
public class ScopesTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("xmlConfigAppContext.xml");

        PeriodicalScopeNamedBean periodicalScopeNamedBean = xmlApplicationContext.getBean("periodicalScopeNamedBean", PeriodicalScopeNamedBean.class);
        NamedBean namedBean = xmlApplicationContext.getBean("periodicalScopeNamedBean", NamedBean.class);
        PeriodicalScopeBean periodicalScopeBean = xmlApplicationContext.getBean("periodicalScopeBean", PeriodicalScopeBean.class);

        System.out.println("\n");
        System.out.println("periodicalScopeNamedBean = " + periodicalScopeNamedBean.getClassName());
        System.out.println("namedBean = " + namedBean.getClassName());
        System.out.println("periodicalScopeBean = " + periodicalScopeBean.getClassName());
        System.out.println("\n");
        System.out.println("periodicalScopeNamedBean.randomIntValue = " + periodicalScopeNamedBean.getRandomInt());
        System.out.println("periodicalScopeBean.randomIntValue = " + periodicalScopeBean.getRandomInt());
    }
}
