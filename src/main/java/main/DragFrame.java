package main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragFrame extends JFrame // Makes the frame draggable from an area of choice
{

    int mouseX, mouseY;

    public DragFrame()
    {

        // Get the mouse position
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        // Create a draggable area the top
        addMouseMotionListener(new MouseMotionAdapter()
        {

            @Override
            public void mouseDragged(MouseEvent e)
            {
                if (SwingUtilities.isLeftMouseButton(e) && (mouseY < 75))
                {
                    setLocation(
                        getLocation().x + e.getX() - mouseX,
                        getLocation().y + e.getY() - mouseY);
                }
            }
        });
    }
}
