package com.serdar.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

//	@Bean
//	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//		
//		/**
//		 * Create custom specific route to uri("http://httpbin.org:80").
//		 * Also it allows to add header and requestparameters to request.
//		 * call http://localhost:8765/get and route to http://httpbin.org:80 adding Header MyHeader, Param My Value.
//		 * 
//		 * */
//		
//		//Functions have inputs and return result. input type PredicateSpec , output type Buildable<Route>
//		Function<PredicateSpec, Buildable<Route>> routeFunction =
//				p -> p.path("/get")
//						.filters(f->f.addRequestHeader("MyHeader", "MyURI")
//								.addRequestParameter("Param", "MyValue"))//adding to request
//						.uri("http://httpbin.org:80");
//		
//		return builder.routes()
//				.route(routeFunction)
//				.build();
//	}
	
	
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		/**
		 * Create custom specific route to uri("http://httpbin.org:80").
		 * Also it allows to add header and requestparameters to request.
		 * call http://localhost:8765/get and route to http://httpbin.org:80 adding Header MyHeader, Param My Value.
		 * 
		 **/
		
		//Functions have inputs and return result. input type PredicateSpec , output type Buildable<Route>
		Function<PredicateSpec, Buildable<Route>> routeFunction =
				p -> p.path("/get")
						.filters(f->f.addRequestHeader("MyHeader", "MyURI")
								.addRequestParameter("Param", "MyValue"))//adding to request
						.uri("http://httpbin.org:80");
		
		Function<PredicateSpec, Buildable<Route>> routeFunction2 = 
				p -> p.path("/currency-exchange/**")
				.uri("lb://currency-exchange");//lb loadbalancer
		
		
		
		return builder.routes()
				.route(routeFunction)
				.route(routeFunction2)
				.route(r -> r.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(r -> r.path("/currency-conversion-feign/**")
						.uri("lb://currency-conversion"))
				
				.route(r -> r.path("/currency-conversion-new/**")//route new to feign
						.filters(f -> 
										f.rewritePath(
												"/currency-conversion-new/(?<segment>.*)", 
												"/currency-conversion-feign/${segment}"))
						
						.uri("lb://currency-conversion"))
				
				.build();
	}
}
