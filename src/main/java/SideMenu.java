import javax.swing.*;
import java.awt.*;

public class SideMenu extends JPanel
{

	public SideMenu()
	{

		// Configure panel
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#3B173F"));

		// Create the GridBag constraints
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		// Create the title section
		JPanel titleSection = new JPanel(new GridBagLayout());
		titleSection.setBackground(Color.decode("#300c33"));
		add(titleSection, c);

		// Create the title
		JLabel title = new JLabel("Bug Tracker");
		title.setFont(new Font("DIALOG", Font.PLAIN, 20));
		title.setForeground(Color.decode("#b63a6e"));
		c.anchor = GridBagConstraints.PAGE_START;
		c.weightx = 0.5;
		c.insets = new Insets(15, 25, 15, 50);
		titleSection.add(title, c);

		// Create the submenu
		SideSubMenu subMenu = new SideSubMenu();

		// Create the button group
		ButtonGroup buttonGroup = new ButtonGroup();

		// Create and configure the toggle buttons
		SideMenuButton milestonesButton = new SideMenuButton(subMenu, "Milestones");
		milestonesButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.insets = new Insets(25, 12, 0, 0);
		c.gridy = 1;
		add(milestonesButton, c);

		SideMenuButton bugsButton = new SideMenuButton(subMenu, "Bugs");
		bugsButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.insets = new Insets(5, 12, 0, 0);
		c.gridy = 2;
		add(bugsButton, c);

		SideMenuButton timesheetButton = new SideMenuButton(subMenu, "Timesheet");
		timesheetButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.gridy = 3;
		add(timesheetButton, c);

		SideMenuButton feedButton = new SideMenuButton(subMenu, "Feed");
		feedButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.gridy = 4;
		add(feedButton, c);

		SideMenuButton profileButton = new SideMenuButton(subMenu, "My Profile");
		profileButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.weighty = 1;
		c.gridy = 5;
		add(profileButton, c);

		// Add the buttons to the button group, so that they can be selected one at a time
		buttonGroup.add(milestonesButton);
		buttonGroup.add(bugsButton);
		buttonGroup.add(timesheetButton);
		buttonGroup.add(feedButton);
		buttonGroup.add(profileButton);
		buttonGroup.setSelected(milestonesButton.getModel(), true);

		// Add the side submenu
		c.insets = new Insets(0, 0, 0, 0);
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 6;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 0;
		add(subMenu, c);
	}
}

