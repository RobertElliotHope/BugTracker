import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main
{

	public static JFrame frame;
	public static MainView panel;

	public static void main(String[] args) throws SQLException
	{

		SwingUtilities.invokeLater(() ->
		{

			frame = new JFrame("Bug Tracker");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setMinimumSize(new Dimension(800, 600));
			frame.setResizable(false);

			panel = new MainView();
			frame.add(panel);
			frame.pack();
			panel.requestFocusInWindow();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

		});

		DatabaseUtils.init();
	}
}
