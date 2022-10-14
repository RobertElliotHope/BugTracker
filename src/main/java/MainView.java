import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel
{

	public CardLayout cardLayout;

	public MainView()
	{
		// Initialise and set cardLayout
		cardLayout = new CardLayout();
		setLayout(cardLayout);

		// Add the various cards (views)
		add(new MainLoginView(), "LOGIN_VIEW");
		add(new MainReportView(), "REPORT_VIEW");

		// Show the Login View
		cardLayout.first(this);
	}

	// Show ReportView if login was successful
	public void loginWasSuccessful()
	{
		cardLayout.show(Main.panel, "REPORT_VIEW");
	}

	// Show popup error message if login was unsuccessful
	public void loginDidFail()
	{
		JOptionPane.showMessageDialog(Main.panel, "Check your username or password and try again.",
				"Login Error", JOptionPane.ERROR_MESSAGE);
	}
}

