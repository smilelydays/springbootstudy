package com.smilelydays.springbootstudy;

import com.smilelydays.springbootstudy.controller.HelloController;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class SpringbootstudyApplication {

    public static void main(String[] args) {
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

		HelloController helloController = new HelloController();

		WebServer webServer = serverFactory.getWebServer(servletContext ->
				servletContext
						.addServlet("frontController", new HttpServlet() {
							@Override
							protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
								if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
									String name = req.getParameter("name");
									String ret = helloController.hello(name);

									resp.setStatus(HttpStatus.OK.value());
									resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
									resp.getWriter().println(ret);
								} else {
									resp.setStatus(HttpStatus.NOT_FOUND.value());
								}
							}
						})
						.addMapping("/*")
		);
        webServer.start();
    }
}
