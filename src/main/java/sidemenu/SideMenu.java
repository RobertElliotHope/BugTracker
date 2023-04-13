package sidemenu;

import main.Dashboard;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SideMenu extends JPanel
{

    public SideMenu()
    {

        // Configure panel
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#3B173F"));

        // Create the GridBag constraints
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Create the title section
        JPanel titleSection = new JPanel(new GridBagLayout());
        titleSection.setBackground(Color.decode("#300c33"));
        add(titleSection, c);

        // Create the title
        JLabel title = new JLabel("Bug Tracker");
        title.setFont(new Font("DIALOG", Font.PLAIN, 20));
        title.setForeground(Color.decode("#b63a6e"));
        c.anchor = GridBagConstraints.PAGE_START;
        c.weightx = 1;
        c.insets = new Insets(15, 25, 15, 50);
        titleSection.add(title, c);

        // Create the submenu
        SideSubMenu subMenu = new SideSubMenu();

        // Create the button group
        ButtonGroup buttonGroup = new ButtonGroup();


        // Create and configure the toggle buttons
        buttonGroup.add(createButton(subMenu, c, "Milestones", new Insets(25, 12, 0, 0), 1, 0));
        Insets buttonInsets = new Insets(5, 12, 0, 0);
        buttonGroup.add(createButton(subMenu, c, "Bugs", buttonInsets, 2, 0));
        buttonGroup.add(createButton(subMenu, c, "Timesheet", buttonInsets, 3, 0));
        buttonGroup.add(createButton(subMenu, c, "Feed", buttonInsets, 4, 0));
        buttonGroup.add(createButton(subMenu, c, "My Profile", buttonInsets, 5, 1));

        // Add the side submenu
        c.insets = new Insets(0, 0, 0, 0);
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 6;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        add(subMenu, c);
    }

    private SideMenuButton createButton(SideSubMenu subMenu, GridBagConstraints c, String label, Insets insets, int gridY, int weightY)
    {
        SideMenuButton button = new SideMenuButton(subMenu, label);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        c.insets = insets;
        c.gridy = gridY;
        c.weighty = weightY;

        button.addActionListener(e ->
        {
            // Set the tab in the sub menu and dashboard
            Dashboard dashboard = Main.panel.getReportView().getDashboard();

            subMenu.getCardLayout().show(subMenu.getContentPanel(), button.getFormattedName());
            dashboard.getCardLayout().show(dashboard.getContentPanel(), button.getFormattedName());

            // Repaint custom close button
            Main.panel.repaint();
        });

        add(button, c);

        return button;
    }
}

