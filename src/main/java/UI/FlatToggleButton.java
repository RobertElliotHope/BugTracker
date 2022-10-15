package UI;

import javax.swing.*;

import java.awt.*;

public class FlatToggleButton extends JToggleButton
{

	public FlatToggleButton(String label)
	{
		super(label);

		// Disable default graphics
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		// Enable anti aliasing
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Add selection colours
		if (getModel().getGroup() != null && getModel().getGroup().isSelected(getModel()))
		{
			setForeground(Color.WHITE);
			g2.setColor(Color.decode("#BC2551"));
			g2.fillRoundRect((int) (getWidth() * 0.05), 0, getWidth(), getHeight(), 8, 8);
		}
		else
		{
			setForeground(Color.decode("#8A5C8F"));
		}

		g2.dispose();
		super.paintComponent(g);
	}
}
