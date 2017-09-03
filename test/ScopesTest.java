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
        System.out.println("ScopesTest");
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("xmlConfigAppContext.xml");

        System.out.println("ScopesTest");
        NamedBean namedBean = xmlApplicationContext.getBean("namedBean", NamedBean.class);
        System.out.println("namedBean = " + namedBean.getValues());
        System.out.println();

        System.out.println("ScopesTest");
        PeriodicalScopeNamedBean periodicalScopeNamedBean = xmlApplicationContext.getBean("periodicalScopeNamedBean", PeriodicalScopeNamedBean.class);
        System.out.println("periodicalScopeNamedBean = " + periodicalScopeNamedBean.getValues());
        System.out.println("periodicalScopeNamedBean.randomIntValue = " + periodicalScopeNamedBean.getRandomInt());
        System.out.println();

        System.out.println("ScopesTest");
        PeriodicalScopeBean periodicalScopeBean = xmlApplicationContext.getBean("periodicalScopeBean", PeriodicalScopeBean.class);
        System.out.println("periodicalScopeBean = " + periodicalScopeBean.getValues());
        System.out.println("periodicalScopeBean.randomIntValue = " + periodicalScopeBean.getRandomInt());
    }
}
