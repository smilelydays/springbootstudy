package com.smilelydays.springbootstudy;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@ComponentScan
@Configuration
public class SpringbootstudyApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
//				dispatcherServlet.setApplicationContext(this); //Bean 생성 시에 셋팅되기 때문에 생략 가능 (ApplicationContextAware 참고)

                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                            servletContext
                                    .addServlet("dispatcherServlet", dispatcherServlet)
                                    .addMapping("/*");
                        }
                );
                webServer.start();
            }
        };
        applicationContext.register(SpringbootstudyApplication.class);
        applicationContext.refresh();
    }
}
