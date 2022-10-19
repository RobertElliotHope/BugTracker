import javax.swing.*;
import java.awt.*;

public class MainView extends JLayeredPane
{

	private final CardLayout cardLayout;
	private final JPanel mainPanel;
	private final MainReportView reportView;

	public MainView()
	{

		// Create and configure mainPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(cardLayout = new CardLayout());
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Add the main views to mainPanel
		mainPanel.add(new MainLoginView(), "LOGIN");
		mainPanel.add(reportView = new MainReportView(), "REPORT");
		cardLayout.first(mainPanel);

		// Add the close button to the layeredPane
		JButton closeButton = new ExitButton(Main.frame);
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		add(closeButton, c);

		// Add mainPanel to the layeredPane
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		add(mainPanel, c);
	}

	// Show ReportView if login was successful
	public void loginWasSuccessful()
	{
		cardLayout.show(mainPanel, "REPORT");
		repaint();
	}

	// Show popup error message if login was unsuccessful
	public void loginDidFail()
	{
		JOptionPane.showMessageDialog(Main.panel, "Check your username or password and try again.",
				"Login Error", JOptionPane.ERROR_MESSAGE);
	}

	public MainReportView getReportView()
	{
		return reportView;
	}
}


