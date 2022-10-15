import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardHome extends JPanel implements ActionListener
{

	public DashboardHome()
	{
		// Configure panel
		setLayout(new GridLayout());
		setBackground(Color.GREEN);

		// Create child panels and configure them
		JPanel splitPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		splitPanel.setLayout(new BorderLayout());
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		rightPanel.setLayout(new GridBagLayout());

		splitPanel.setBackground(Color.CYAN);
		leftPanel.setBackground(Color.BLUE);
		rightPanel.setBackground(Color.YELLOW);

		// Left panel content
		JButton reportButton = new JButton("Report A Bug");
		JButton viewStatusButton = new JButton("View Status");
		reportButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, reportButton.getMinimumSize().height));
		viewStatusButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, viewStatusButton.getMinimumSize().height));
		leftPanel.add(reportButton);
		leftPanel.add(Box.createVerticalStrut(5));
		leftPanel.add(viewStatusButton);

		// Right panel content
		JButton rightButton = new JButton("Right Button 1");
		rightPanel.add(rightButton);

		// Add the splitPanel to the HomeView panel
		splitPanel.add(leftPanel, BorderLayout.WEST);
		splitPanel.add(rightPanel, BorderLayout.CENTER);
		add(splitPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

	}
}
