package postprocessor;

import annotation.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
/*import java.lang.reflect.Proxy;*/
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*import org.springframework.cglib.proxy.Proxy;*/

/**
 * Created by rpadalka on 4/5/17.
 */
@Component
public class InjectRandomIntBeanFactoryPostProcessor implements BeanPostProcessor {

    private Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class<?> beanClass = o.getClass();
        Field[] declaredFields = beanClass.getDeclaredFields();

        for (Field field : declaredFields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);

            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();

                Random random = new Random();
                int randomInt = min + random.nextInt(max - min);

                field.setAccessible(true);
                ReflectionUtils.setField(field, o, randomInt);

                map.put(s, beanClass);
            }
        }

        System.out.println("postProcessBeforeInitialization BeanName = " + s + beanClass.getName());

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        /*Class beanClass = map.get(s);

        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> method.invoke(o, args));
        }*/

        System.out.println("postProcessAfterInitialization BeanName = " + s + o.toString());
        System.out.println("map size = " + map.size());

        return o;
    }
}
