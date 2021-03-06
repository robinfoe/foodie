// package com.rfoe.msvc.saga.foodie.consumer;

// import static com.jayway.restassured.RestAssured.given;
// import static com.jayway.restassured.RestAssured.when;
// import static org.hamcrest.CoreMatchers.is;

// import com.jayway.restassured.RestAssured;

// import org.aspectj.lang.annotation.Before;
// import org.junit.jupiter.api.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.IntegrationTest;
// import org.springframework.boot.test.SpringApplicationConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.web.WebAppConfiguration;
// import static org.mockito.Mockito.when;

// @RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(classes = App.class)
// @WebAppConfiguration
// @IntegrationTest({"server.port:0",
//         "spring.datasource.url:jdbc:h2:mem:consumer;DB_CLOSE_ON_EXIT=FALSE"})
// public class HelloControllerTest {
//     @Value("${local.server.port}")
//     int port;

//     @Before
//     public void setUp() throws Exception {
//         RestAssured.port = port;
//     }

//     @Test
//     public void testHello() throws Exception {
//         when().get("/").then()
//                 .body(is("Hello World!"));
//     }

//     @Test
//     public void testCalc() throws Exception {
//         given().param("left", 100)
//                 .param("right", 200)
//                 .get("/calc")
//                 .then()
//                 .body("left", is(100))
//                 .body("right", is(200))
//                 .body("answer", is(300));
//     }
// }