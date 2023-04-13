package main;

import main.Dashboard;
import sidemenu.SideMenu;

import javax.swing.*;
import java.awt.*;

public class MainReportView extends JPanel
{

    private final Dashboard dashboard;

    public MainReportView()
    {
        // Configure and add contents to the ReportView panel
        setLayout(new BorderLayout());

        // Create and add the side menu and dashboard to the ReportView panel
        SideMenu sideMenu = new SideMenu();
        dashboard = new Dashboard();
        add(sideMenu, BorderLayout.WEST);
        add(dashboard, BorderLayout.CENTER);
    }

    public Dashboard getDashboard()
    {
        return dashboard;
    }
}