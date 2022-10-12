package coronawarn;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Matrikel-Nr. 3354235
 */
public class CoronaWarnTerm extends JFrame implements CoronaWarnClient {

	private JPhone phone;
	private WarnStatus status = WarnStatus.UNKNOWN;
	private List<Token> nearTokens = new ArrayList<>();
	private List<Token> ownTokens = new ArrayList<>();

	private JPanel panelNorth = new JPanel();
	private JPanel panelCenter = new JPanel(new GridLayout(4, 1, 5, 5));
	private JPanel panelSouth = new JPanel();

	private JLabel lblStatus = new JLabel();
	private JLabel lblSeenTokens = new JLabel();

	private List<JButton> buttons = new ArrayList<>();

	public CoronaWarnTerm(JPhone phone) {
		this.phone = phone;
		this.ownTokens = CoronaWarn.loadTokens(this.phone);
		Token newToken = new Token();
		this.ownTokens.add(newToken);
		CoronaWarn.saveToken(this.phone, newToken);
		CoronaWarnAPI.sendToken(this);


		this.setTitle(this.phone.getOwner());

		this.lblStatus.setText(this.status.getText());
		this.lblStatus.setBackground(this.status.getColor());
		this.lblStatus.setOpaque(true);
		this.lblStatus.setHorizontalAlignment(JLabel.CENTER);
		this.lblStatus.setPreferredSize(new Dimension(150, 100));
		this.panelNorth.add(lblStatus);


		JButton btnNewToken = new JButton("New Token");
		btnNewToken.addActionListener(e -> {
			this.newToken();
		});
		this.buttons.add(btnNewToken);
		this.panelCenter.add(btnNewToken);

		JButton btnCheck = new JButton("Check for infections");
		btnCheck.addActionListener(e -> {
			if (CoronaWarnAPI.checkInfection(this)) {
				this.status = WarnStatus.ALARM;
			} else {
				this.status = WarnStatus.OK;
			}
			this.lblStatus.setText(this.status.getText());
			this.lblStatus.setBackground(this.status.getColor());
		});
		this.buttons.add(btnCheck);
		this.panelCenter.add(btnCheck);

		JButton btnClear = new JButton("Clear tokens");
		btnClear.addActionListener(e -> {
			this.nearTokens.clear();
			this.ownTokens.clear();
			CoronaWarn.clearTokenStore(this.phone);
			this.newToken();
		});
		this.buttons.add(btnClear);
		this.panelCenter.add(btnClear);

		JButton btnReport = new JButton("Report infection");
		btnReport.addActionListener(e -> {
			CoronaWarnAPI.reportInfection(this);
			for (JButton b :
					this.buttons) {
				b.setEnabled(false);
			}
			this.status = WarnStatus.INFECTED;
			this.lblStatus.setText(this.status.getText());
			this.lblStatus.setBackground(this.status.getColor());
		});
		this.buttons.add(btnReport);
		this.panelCenter.add(btnReport);


		this.lblSeenTokens.setText("Seen Tokens: " + this.nearTokens.size());
		this.lblSeenTokens.setHorizontalAlignment(JLabel.CENTER);
		this.lblSeenTokens.setToolTipText(this.getCurrentToken().toString());
		this.panelSouth.add(lblSeenTokens);


		this.add(panelNorth, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelSouth, BorderLayout.SOUTH);

		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		Thread t = new Thread(() -> {
			while (!this.status.equals(WarnStatus.INFECTED)) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.newToken();
			}
		});
		t.start();
	}

	@Override
	public Token getCurrentToken() {
		Token mostRecent = this.ownTokens.get(0);
		for (Token t :
				this.ownTokens) {
			if (t.getDate().after(mostRecent.getDate())) {
				mostRecent = t;
			}
		}
		return mostRecent;
	}

	@Override
	public List<Token> getAllTokens() {
		return this.ownTokens;
	}

	@Override
	public List<Token> getAllSeenTokens() {
		return this.nearTokens;
	}

	@Override
	public void tokenReceived(Token token) {
		this.nearTokens.add(token);
	}

	private void newToken() {
		System.out.println("creating");
		Token t = new Token();
		ownTokens.add(t);
		CoronaWarn.saveToken(this.phone, t);
		CoronaWarnAPI.sendToken(this);

		this.lblSeenTokens.setToolTipText(this.getCurrentToken().toString());
	}
}
