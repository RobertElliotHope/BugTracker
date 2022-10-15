import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel
{

	public CardLayout cardLayout;

	public Dashboard()
	{
		// Initialise and set cardLayout
		cardLayout = new CardLayout();
		setLayout(cardLayout);

		// Add the various cards (views)
		add(new DashboardHome(), "HOME_VIEW");
		add(new DashboardViewBugs(), "BUGS_VIEW");

		// Show the Login View
		cardLayout.first(this);
	}
}

