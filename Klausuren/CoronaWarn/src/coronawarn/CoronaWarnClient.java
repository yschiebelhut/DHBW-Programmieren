package coronawarn;

import java.util.List;

/**
 * @author Matrikel-Nr. 3354235
 */
public interface CoronaWarnClient {
	public Token getCurrentToken();

	public List<Token> getAllTokens();

	public List<Token> getAllSeenTokens();

	public void tokenReceived(Token token);
}
