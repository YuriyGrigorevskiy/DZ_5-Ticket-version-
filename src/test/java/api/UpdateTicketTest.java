package api;

import model.Status;
import model.Ticket;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

/** Обновление тикета */
public class UpdateTicketTest extends BaseTest {

    @Test
    public void updateTicketTest() {
        Ticket ticket = createTicket( buildNewTicket(Status.CLOSED,2));
        ticket.setStatus(1);
                given()
                .body(ticket)
                .when()
                .put("/api/tickets/")
                .then()
                .statusCode(405);
    }
}
