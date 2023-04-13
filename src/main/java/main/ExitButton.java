package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ExitButton extends JButton
{

    private final JFrame frame;

    public ExitButton(JFrame frame)
    {
        super();
        this.frame = frame;

        // Disable default graphics and configure button
        setPreferredSize(new Dimension(25, 25));
        setFont(new Font("DIALOG", Font.PLAIN, 24));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);

        // Add the 'dispose frame' action to the button
        addActionListener(disposeFrame());
    }

    @Override
    protected void paintComponent(Graphics g)
    {

        // Enable anti aliasing
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Draw 'X'
        g2.drawLine(2, 10, getWidth() - 12, getHeight() - 5);
        g2.drawLine(2, getHeight() - 5, getWidth() - 12, 10);

        // Set colour of 'X'
        if (getModel().isRollover())
        {
            // Set to a lighter colour on cursor hover
            setForeground(Color.decode("#919191"));
        }
        else
        {
            // Return to a darker colour when not being interacted with
            setForeground(Color.decode("#5c5c5c"));
        }

        super.paintComponent(g);
        g2.dispose();
    }

    private ActionListener disposeFrame()
    {
        return e -> frame.dispose();
    }
}
