import UI.FlatToggleButton;

import javax.swing.*;
import java.awt.*;

public class SideMenu extends JPanel
{

	public SideMenu()
	{

		// Configure panel
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#3B173F"));
		setPreferredSize(new Dimension(200, 0));

		GridBagConstraints c = new GridBagConstraints();
		ButtonGroup buttonGroup = new ButtonGroup();

		// Create and configure the toggle buttons
		FlatToggleButton milestonesButton = new FlatToggleButton("Milestones");
		milestonesButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(25, 12, 0, 0);
		c.weighty = 0;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		add(milestonesButton, c);

		FlatToggleButton bugsButton = new FlatToggleButton("Bugs");
		bugsButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.insets = new Insets(5, 12, 0, 0);
		c.gridy = 1;
		add(bugsButton, c);

		FlatToggleButton timesheetButton = new FlatToggleButton("Timesheet");
		timesheetButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.gridy = 2;
		add(timesheetButton, c);

		FlatToggleButton feedButton = new FlatToggleButton("Feed");
		feedButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.gridy = 3;
		add(feedButton, c);

		FlatToggleButton profileButton = new FlatToggleButton("My Profile");
		profileButton.setHorizontalAlignment(SwingConstants.LEFT);
		c.weighty = 1;
		c.gridy = 4;
		add(profileButton, c);

		// Add the buttons to the button group, so that they can be selected one at a time
		buttonGroup.add(milestonesButton);
		buttonGroup.add(bugsButton);
		buttonGroup.add(timesheetButton);
		buttonGroup.add(feedButton);
		buttonGroup.add(profileButton);
	}
}

