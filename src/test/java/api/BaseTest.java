package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.Status;
import model.Ticket;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import java.io.IOException;

/** Абстрактный класс, содержащий общие для всех тестов методы */
public abstract class BaseTest {
    @BeforeClass
    public void prepare() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        String baseUri = System.getProperty("base.uri");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"base.uri\"");
        }
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://at-sandbox.workbench.lanit.ru")
                .addHeader("base_uri", System.getProperty("base.uri"))
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        RestAssured.filters(new ResponseLoggingFilter());
    }

    protected Ticket buildNewTicket(Status status, int priority) {
        Ticket ticket = new Ticket();
        ticket.setStatus(status.getCode());
        ticket.setPriority(priority);
        ticket.setTitle("sometitle");
        ticket.setQueue(2);
        return ticket;
    }

    protected Ticket createTicket(Ticket ticket) {
        Ticket a = given()
                .spec(requestSpecification)
                .body(ticket)
                .when().post("/api/tickets/")
                .then().statusCode(201)
                .extract().as(Ticket.class);

        // todo: отправить HTTP запрос для создания тикета
        return a;
    }
}
