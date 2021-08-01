import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
// import jakarta.servlet.annotation.WebServlet;

@Path("/getFeedbacksService")
// @WebServlet(value = "/getFeedback", asyncSupported = true)
public class FeedbackService {

	GetFeedback getFeedback = new GetFeedback();

	@GET
	@Path("/getFeedback")
	@Produces(MediaType.APPLICATION_XML)
	public List<CustomerFeedback> getFeedback() {
		return getFeedback.getAllFeedbacks();
	}
}
