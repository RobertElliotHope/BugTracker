package main;

import database.DatabaseUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;

public class Main
{

    public static JFrame frame;
    public static MainView panel;

    public static void main(String[] args) throws SQLException
    {

        // Create and configure window
        SwingUtilities.invokeLater(() ->
        {

            // Create and configure the frame
            frame = new DragFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setMinimumSize(new Dimension(800, 600));
            frame.setUndecorated(true);
            frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 25, 25));

            // Add the panel to the frame
            frame.add(panel = new MainView());

            // Pack the frame and show it
            frame.pack();
            panel.requestFocusInWindow(); // To prevent the focus
            frame.setVisible(true);
        });

        // Create the database and the test account
        DatabaseUtils.init();
    }
}
