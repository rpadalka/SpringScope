import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rpadalka on 4/3/17.
 */
public class ScopesTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("xmlConfigAppContext.xml");

        System.out.println("test");
    }
}
