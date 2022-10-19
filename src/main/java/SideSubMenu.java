import tabview.*;

import javax.swing.*;
import java.awt.*;

public class SideSubMenu extends JPanel
{

	private final CardLayout cardLayout;
	private final JPanel contentPanel;

	public SideSubMenu()
	{

		// Configure the side submenu
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);
		GridBagConstraints c = new GridBagConstraints();

		// Add the content panel
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.decode("#f3ebf5"));
		c.fill = GridBagConstraints.BOTH;
		add(contentPanel, c);

		// Add the toggle panel button
		TogglePanelButton togglePanelButton = new TogglePanelButton(this, contentPanel);
		add(togglePanelButton, c);

		// Add a cardlayout for the different tab types
		cardLayout = new CardLayout();
		contentPanel.setLayout(cardLayout);

		// Add the various views
		contentPanel.add(new MilestonesTabView(), "MILESTONES");
		contentPanel.add(new BugsTabView(), "BUGS");
		contentPanel.add(new TimesheetTabView(), "TIMESHEET");
		contentPanel.add(new FeedTabView(), "FEED");
		contentPanel.add(new ProfileTabView(), "MY_PROFILE");
	}

	public CardLayout getCardLayout()
	{
		return cardLayout;
	}

	public JPanel getContentPanel()
	{
		return contentPanel;
	}
}
