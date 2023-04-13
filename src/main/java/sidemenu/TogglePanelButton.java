package sidemenu;

import main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TogglePanelButton extends JToggleButton
{

    private final JPanel parentPanel;
    private final JPanel targetPanel;

    public TogglePanelButton(JPanel parentPanel, JPanel targetPanel)
    {
        super();
        this.parentPanel = parentPanel;
        this.targetPanel = targetPanel;

        // Disable default graphics and configure button
        setPreferredSize(new Dimension(18, 40));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setRolloverEnabled(true);

        // Add the 'toggle frame' action to the button
        addActionListener(toggleFrame());
    }

    @Override
    protected void paintComponent(Graphics g)
    {

        // Enable anti aliasing
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Set background according to state & set button position
        double buttonPos;
        if (targetPanel.isVisible())
        {

            parentPanel.setBackground(Color.decode("#f3ebf5"));
            buttonPos = 0.5;
        }
        else
        {
            parentPanel.setBackground(Color.WHITE);
            buttonPos = -0.5;
        }

        // Draw button
        g2.fillRoundRect((int) (getWidth() * buttonPos) - 1, 0, getWidth(), getHeight(), 25, 25);

        // Set colour of button
        if (getModel().isPressed())
        {
            // Set to a lighter colour on cursor hover
            setForeground(Color.decode("#919191"));
        }
        else
        {
            // Return to a darker colour when not being interacted with
            setForeground(Color.decode("#c3bfc5"));
        }

        super.paintComponent(g);
        g2.dispose();
    }

    private ActionListener toggleFrame()
    {

        return e ->
        {
            // Set the panel to visible if it isn't already, or vice versa
            targetPanel.setVisible(!targetPanel.isVisible());

            // Repaint custom close button
            Main.panel.repaint();
        };
    }
}
