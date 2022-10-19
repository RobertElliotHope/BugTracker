import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SideMenuButton extends JToggleButton
{

	private final SideSubMenu sideSubMenu;
	private final String label;

	public SideMenuButton(SideSubMenu sideSubMenu, String label)
	{
		super(label);
		this.sideSubMenu = sideSubMenu;
		this.label = label;

		// Disable default graphics
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);

		// Add the 'show content' action to the button
		addActionListener(showContent());
	}

	@Override
	protected void paintComponent(Graphics g)
	{

		// Enable anti aliasing
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// Add selection colours
		if (getModel().getGroup() != null && getModel().getGroup().isSelected(getModel()))
		{
			// Set the text colour to white, change the button colour to show it is selected
			// and make the button rounded on the left
			setForeground(Color.WHITE);
			g2.setColor(Color.decode("#BC2551"));
			g2.fillRoundRect((int) (getWidth() * 0.05), 0, getWidth(), getHeight(), 8, 8);
		}
		else
		{
			// Set the text colour to a darker colour to show it is unselected
			setForeground(Color.decode("#8A5C8F"));
		}

		super.paintComponent(g);
		g2.dispose();
	}

	private ActionListener showContent()
	{
		return e ->
		{
			// Set the tab in the sub menu and dashboard
			Dashboard dashboard = Main.panel.getReportView().getDashboard();

			sideSubMenu.getCardLayout().show(sideSubMenu.getContentPanel(), getFormattedName());
			dashboard.getCardLayout().show(dashboard.getContentPanel(), getFormattedName());

			// Repaint custom close button
			Main.panel.repaint();
		};
	}

	public String getFormattedName()
	{
		return label.toUpperCase().replace(' ', '_');
	}
}
