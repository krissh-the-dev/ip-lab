import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "CustomerFeedback")
public class CustomerFeedback implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String product;
	private String feedback;

	public CustomerFeedback() {
	}

	public CustomerFeedback(int id, String name, String product, String feedback) {
		this.id = id;
		this.name = name;
		this.product = product;
		this.feedback = feedback;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getProduct() {
		return product;
	}

	@XmlElement
	public void setProduct(String product) {
		this.product = product;
	}

	public String getFeedback() {
		return feedback;
	}

	@XmlElement
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
