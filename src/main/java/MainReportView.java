import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainReportView extends JPanel implements ActionListener
{

	public MainReportView()
	{
		// Configure and add contents to the ReportView panel
		setLayout(new BorderLayout());

		SideMenu sideMenu = new SideMenu();
		Dashboard dashboard = new Dashboard();

		add(sideMenu, BorderLayout.WEST);
		add(dashboard, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// Find which button is being pressed and assign actions to them
		Object source = e.getSource();
	}
}