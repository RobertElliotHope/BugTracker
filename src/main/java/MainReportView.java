import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainReportView extends JPanel implements ActionListener
{

	private final JPanel topPanel;
	private final SideView sideView;

	private final JButton bugsButton;
	private final JButton homeButton;
	private final JButton button2;
	private final JButton button3;
	private final JButton button4;

	public MainReportView()
	{
		// Configure the ReportView panel
		setLayout(new BorderLayout());

		// Add the side menu
		sideView = new SideView();
		topPanel = new JPanel();

		// Configure top panel
		topPanel.setLayout(new GridBagLayout());
		topPanel.setBackground(Color.MAGENTA);

		// Declare and initialise GridBagConstraints
		GridBagConstraints c = new GridBagConstraints();

		// Top panel content
		JLabel title = new JLabel("RobsBugTracker.com");
		title.setFont(new Font("Consolas", Font.PLAIN, 48));
		c.fill = GridBagConstraints.CENTER;
		c.insets = new Insets(10, 0, 0, 0);
		c.gridwidth = 5;
		c.weightx = 1;
		c.ipady = 25;
		c.gridx = 0;
		c.gridy = 0;
		topPanel.add(title, c);

		// Create and position buttons
		homeButton = new JButton("Home");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 75, 10, 0);
		c.gridwidth = 1;
		c.weightx = 0.5;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 1;
		homeButton.addActionListener(this);
		topPanel.add(homeButton, c);

		button2 = new JButton("Top Button 2");
		c.insets = new Insets(0, 0, 10, 0);
		c.gridx = 1;
		button2.addActionListener(this);
		topPanel.add(button2, c);

		button3 = new JButton("Top Button 3");
		c.gridx = 2;
		button3.addActionListener(this);
		topPanel.add(button3, c);

		button4 = new JButton("Top Button 4");
		c.gridx = 3;
		button4.addActionListener(this);
		topPanel.add(button4, c);

		bugsButton = new JButton("Bugs");
		c.insets = new Insets(0, 0, 10, 75);
		c.gridx = 4;
		bugsButton.addActionListener(this);
		topPanel.add(bugsButton, c);

		// Finally, add all panels to the ReportView panel
		add(topPanel, BorderLayout.NORTH);
		add(sideView);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Find which button is being pressed and assign actions to them
		Object source = e.getSource();

		if (source == homeButton)
		{
			System.out.println("homeButton");
		}
		else if (source == button2)
		{
			System.out.println("button2");
		}
		else if (source == button3)
		{
			System.out.println("button3");
		}
		else if (source == button4)
		{
			System.out.println("button4");
		}
		else if (source == bugsButton)
		{
			System.out.println("bugsButton");
		}
	}
}