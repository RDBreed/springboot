# SpringBoot Test Project
Spring Boot test repository that consists of
- Zuul API Proxy (my-zuul-router): Demo Zuul proxy configured to use Eureka for service discovery, Ribbon for client-side loadbalancing and Hysterix as circuit breaker to improve resiliency
- Eureka server  (my-eureka-server): Eureka server used for service discovery and client-side loadbalancing in Zuul
- My SpringBoot API (my-springboot-api): Demo API contains the following endpoints: 
	- Orders: Simple HTTP GET service that takes an id as Path variable. Context URL orders/{id}
	- Quote: Simple HTTP GET service that calls an external random Spring Quote service. Context URL: /quote
	- Sleep: Simple HTTP GET service that takes a time url parameter of type long that specifies the sleep time. Can be used to test test Hystrix functionality in Zuul. Context URL: /sleep?time=<long time>

## How to invoke the APIs when running on localhost 

### Zuul
http://localhost:8080/myspringbootapi/**

### Eureka
http://localhost:8761

### my-spring-boot-api
(use -Dserver.port as JVM startup parameter to specify a dedicated port for each instance)
http://localhost:<server.port>/**
