package com.busyzero.demo.v11;

import com.busyzero.demo.formatter.Formatter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import java.util.List;


@EnableKrAutoConfiguration
public class SpringApplicationBootstrap {

    private static List<ApplicationContextInitializer> initializerList;

    public static void main(String[] args) {
        ConfigurableEnvironment environment = new StandardEnvironment();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setEnvironment(environment);

        applyInitializerList(context);

        context.register(SpringApplicationBootstrap.class);
        context.refresh();
//
//        SelectedBean bean = context.getBean(SelectedBean.class);
//        System.out.println(bean.getDesc());

        OneBean oneBean = context.getBean(OneBean.class);
        System.out.println(oneBean.getName());

        TwoBean twoBean = context.getBean(TwoBean.class);
        System.out.println(twoBean.getName());

        Formatter formatter = context.getBean(Formatter.class);
        System.out.println(formatter.format("\n哈哈哈，这是我的formatter"));

        context.close();
    }

    private static void applyInitializerList(AnnotationConfigApplicationContext context) {
        if (initializerList == null || initializerList.isEmpty()) {
            return;
        }
        initializerList.stream().forEach(applicationContext -> applicationContext.initialize(context));
    }


}
