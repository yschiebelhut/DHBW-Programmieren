package coronawarn;

import java.util.Date;
import java.util.UUID;

/**
 * @author Matrikel-Nr. 3354235
 */
public class Token {

	private String value;
	private Date date;

	public Token() {
		this.value = UUID.randomUUID().toString();
		this.date = new Date();
	}

	public Token(String value, Date date) {
		this.value = value;
		this.date = date;
	}

	public String toString() {
		return this.value + " @ " + this.date.toString();
	}

	public String getValue() {
		return value;
	}

	public Date getDate() {
		return date;
	}
}
