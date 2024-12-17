package com.restaurant.booking;

import io.muserver.Method;
import io.muserver.MuServer;
import io.muserver.MuServerBuilder;
import io.muserver.handlers.ResourceHandlerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingApplication {

	private static final Logger log = LoggerFactory.getLogger(BookingApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);

		MuServer server = MuServerBuilder.httpServer()
				.withHttpPort(18080)
				.withHttpsPort(18443)
				.addHandler(Method.PUT, "/reservation/add", (request, response, pathParams) -> {
					response.write("Hello, world -- Add");
				})
				.addHandler(Method.POST, "/reservation/{id}", (request, response, pathParams) -> {
					response.write(request.readBodyAsString());
					response.write("Hello, world -- Id");
				})
				.addHandler(Method.GET, "/reservation/list", (request, response, pathParams) -> {

					response.write("list");
				})
				.addHandler(ResourceHandlerBuilder.fileOrClasspath("src/main/resources/web", "/web")//
						.withDefaultFile("/index.html")
						.build())
				.start();

		log.info("Server started at " + server.httpUri() + " and " + server.httpsUri());

	}

}
