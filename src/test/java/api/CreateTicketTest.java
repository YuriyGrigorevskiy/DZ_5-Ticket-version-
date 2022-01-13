package api;

import model.Status;
import model.Ticket;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

/** Создание и проверка тикета */
public class CreateTicketTest extends BaseTest {

    @Test
    public void createTicketTest() {

        Ticket ticket = createTicket( buildNewTicket(Status.OPEN,2));
        Assert.assertNotNull(Ticket.class);

        getTicket(ticket.getId());
    }

    protected Ticket getTicket(int id) {
        given()
                .spec(requestSpecification)
                .pathParam("id", id)
                .when()
                .get("/api/tickets/{id}")
                .then()
                .statusCode(200);
        return null;
    }
}
