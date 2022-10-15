import javax.swing.*;
import java.awt.*;

public class MainReportView extends JPanel
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
}