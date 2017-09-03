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
        System.out.println("BeanFactoryPostProcessor postProcessBeforeInitialization");

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

        showBeanInfo(o, s);

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanFactoryPostProcessor postProcessAfterInitialization");

        Class beanClass = map.get(s);

        /*if (beanClass != null) {
            Object proxyInstance = Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> method.invoke(o, args));
            showBeanInfo(proxyInstance, s);
            System.out.println();

            return proxyInstance;
        }*/

        showBeanInfo(o, s);
        System.out.println();

        return o;
    }

    private void showBeanInfo(Object o, String s) {
        System.out.println("BeanName = " + s);
        System.out.println("BeanClass = " + o.getClass().getName());
        System.out.println("map size = " + map.size());
    }
}
