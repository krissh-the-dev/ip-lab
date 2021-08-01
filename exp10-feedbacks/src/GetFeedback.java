import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class GetFeedback {
	public List<CustomerFeedback> getAllFeedbacks() {
		List<CustomerFeedback> feedbacks = new ArrayList<>();

		try {
			File feedbacksFile = new File("feedbacks.dat");
			if (!feedbacksFile.exists()) {
				CustomerFeedback fb = new CustomerFeedback(1, "John", "LG TV", "Good");
				feedbacks.add(fb);
				saveFeedBacks(feedbacks);
			} else {
				FileInputStream fileIpStream = new FileInputStream(feedbacksFile);
				ObjectInputStream OIpStream = new ObjectInputStream(fileIpStream);
				feedbacks = (List<CustomerFeedback>) OIpStream.readObject();
				OIpStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return feedbacks;
	}

	private void saveFeedBacks(List<CustomerFeedback> feedbacks) {
		try {
			File feedbacksFile = new File("feedbacks.dat");
			FileOutputStream fileOutputStream = new FileOutputStream(feedbacksFile);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(feedbacks);
			objectOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
