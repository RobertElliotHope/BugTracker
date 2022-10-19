import view.*;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JPanel
{

	private final CardLayout cardLayout;

	public Dashboard()
	{
		// Initialise and set cardLayout
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		setBackground(Color.WHITE);

		// Add the various cards (views)
		add(new MilestonesView(), "MILESTONES");
		add(new BugsView(), "BUGS");
		add(new TimesheetView(), "TIMESHEET");
		add(new FeedView(), "FEED");
		add(new ProfileView(), "MY_PROFILE");
	}

	public CardLayout getCardLayout()
	{
		return cardLayout;
	}

	public JPanel getContentPanel()
	{
		return this;
	}
}

