package com.busyzero.demo.v11;

import com.busyzero.demo.formatter.Formatter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigRegistry;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.context.support.GenericWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.List;


@EnableKrAutoConfiguration
public class SpringApplicationBootstrap {

    private static List<ApplicationContextInitializer> initializerList;

    public static void main(String[] args) {
        ConfigurableEnvironment environment = new StandardEnvironment();
        MutablePropertySources sources = environment.getPropertySources();
        sources.addFirst(new SimpleCommandLinePropertySource(args));

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext();
//        context = new AnnotationConfigServletWebServerApplicationContext();
        context.setEnvironment(environment);

        applyInitializerList(context);

//        ((AnnotationConfigRegistry)context).register(SpringApplicationBootstrap.class);
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getBeanFactory();
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(registry);
        beanDefinitionReader.registerBean(SpringApplicationBootstrap.class);
        context.refresh();

        SelectedBean bean = context.getBean(SelectedBean.class);
        System.out.println(bean.getDesc());

        OneBean oneBean = context.getBean(OneBean.class);
        System.out.println(oneBean.getName());

        TwoBean twoBean = context.getBean(TwoBean.class);
        System.out.println(twoBean.getName());

        Formatter formatter = context.getBean(Formatter.class);
        System.out.println(formatter.format("\n哈哈哈，这是我的formatter"));

        context.close();
    }

    private static void applyInitializerList(ConfigurableApplicationContext context) {
        if (initializerList == null || initializerList.isEmpty()) {
            return;
        }
        initializerList.stream().forEach(applicationContext -> applicationContext.initialize(context));
    }


//    public static class KrWebServerApplicationContext  extends GenericWebApplicationContext implements ConfigurableApplicationContext{
//
//        @Override
//        public void refresh() throws BeansException, IllegalStateException {
//            try {
//                super.refresh();
//            }
//            catch (RuntimeException ex) {
//                stopAndReleaseWebServer();
//                throw ex;
//            }
//        }
//
//
//        @Override
//        protected void onRefresh() {
//            super.onRefresh();
//            try {
//                createWebServer();
//            }
//            catch (Throwable ex) {
//                throw new ApplicationContextException("Unable to start web server", ex);
//            }
//        }
//
//        @Override
//        protected void finishRefresh() {
//            super.finishRefresh();
//            WebServer webServer = startWebServer();
//            if (webServer != null) {
//                publishEvent(new ServletWebServerInitializedEvent(webServer, this));
//            }
//        }
//
//        @Override
//        protected void onClose() {
//            super.onClose();
//            stopAndReleaseWebServer();
//        }
//
//        private void createWebServer() {
//            WebServer webServer = new TomcatWebServer();
//            ServletContext servletContext = getServletContext();
//            if (webServer == null && servletContext == null) {
//                ServletWebServerFactory factory = getWebServerFactory();
//                this.webServer = factory.getWebServer(getSelfInitializer());
//            }
//            else if (servletContext != null) {
//                try {
//                    getSelfInitializer().onStartup(servletContext);
//                }
//                catch (ServletException ex) {
//                    throw new ApplicationContextException("Cannot initialize servlet context",
//                            ex);
//                }
//            }
//            initPropertySources();
//        }
//    }


}
