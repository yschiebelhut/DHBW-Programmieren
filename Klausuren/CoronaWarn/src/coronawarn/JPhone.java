package coronawarn;

/**
 * @author Matrikel-Nr. 3354235
 */
public class JPhone {

	private String id;
	private String owner;

	public JPhone(String id, String owner) {
		this.id = id;
		this.owner = owner;
	}

	public String getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}
}
