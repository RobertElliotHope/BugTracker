import javax.swing.*;
import java.awt.*;

public class SideView extends JPanel
{

	public CardLayout cardLayout;

	public SideView()
	{
		// Initialise and set cardLayout
		cardLayout = new CardLayout();
		setLayout(cardLayout);

		// Add the various cards (views)
		add(new SideHomeView(), "HOME_VIEW");
		add(new SideBugsView(), "BUGS_VIEW");

		// Show the Login View
		cardLayout.first(this);
	}
}

