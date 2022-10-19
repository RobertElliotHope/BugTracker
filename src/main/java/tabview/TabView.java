package tabview;

import javax.swing.*;
import java.awt.*;

public abstract class TabView extends JPanel
{

	private final String name;

	public TabView(String name)
	{
		this.name = name;

		// Configure panel
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setOpaque(false);

		// Create dummy information
		add(new JButton(name.toUpperCase().replace(' ', '_')));

	}

	@Override
	public String getName()
	{
		return name;
	}
}
