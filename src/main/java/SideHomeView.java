import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideHomeView extends JPanel implements ActionListener
{

	private final JPanel splitPanel;
	private final JPanel leftPanel;
	private final JPanel rightPanel;

	public SideHomeView()
	{
		setLayout(new GridLayout());
		setBackground(Color.GREEN);

		splitPanel = new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();

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
