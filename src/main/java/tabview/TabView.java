package tabview;

import javax.swing.*;
import java.awt.*;

public abstract class TabView extends JPanel
{

    private final String name;

    public TabView(String name)
    {
        this.name = name;

        GridBagConstraints c = new GridBagConstraints();

        // Configure panel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //setOpaque(true);
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        setBackground(Color.magenta);

        // Create dummy information
        //add(new JButton(name.toUpperCase().replace(' ', '_')));

    }

    @Override
    public String getName()
    {
        return name;
    }
}
