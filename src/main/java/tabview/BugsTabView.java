package tabview;

import javax.swing.*;

public class BugsTabView extends TabView
{

    public BugsTabView()
    {
        super("BUGS");

        add(new JButton("All Projects"));
        add(new JButton("Mercury App"));
        add(new JButton("Venus Cloud"));
        add(new JButton("Jupiter Hardware"));
    }
}
