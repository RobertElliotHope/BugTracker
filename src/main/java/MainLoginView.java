import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

public class MainLoginView extends JPanel implements ActionListener
{

	private final JTextField usernameField;
	private final JPasswordField passwordField;

	public MainLoginView()
	{
		JLabel title = new JLabel("Login");
		usernameField = new JTextField("Username");
		passwordField = new JPasswordField("Password");
		JButton loginButton = new JButton("Login");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.decode("#212327"));

		// Configure the title colour
		title.setForeground(Color.WHITE);
		title.setAlignmentX(CENTER_ALIGNMENT);

		// Configure the username field
		usernameField.setMaximumSize(new Dimension(200, 25));
		hideTextOnFocus(usernameField);

		// Configure the password field
		passwordField.setMaximumSize(new Dimension(200, 25));
		hideTextOnFocus(passwordField);

		// Configure the login button
		loginButton.setFocusable(false);
		loginButton.setAlignmentX(CENTER_ALIGNMENT);
		loginButton.addActionListener(this);

		// Add components
		add(Box.createVerticalGlue());
		add(title);
		add(Box.createVerticalStrut(5));
		add(usernameField);
		add(Box.createVerticalStrut(5));
		add(passwordField);
		add(Box.createVerticalStrut(5));
		add(loginButton);
		add(Box.createVerticalGlue());
	}

	// Hides text in fields when focussed, saving the user the need to manually delete existing default text
	public void hideTextOnFocus(JTextField field)
	{
		String prevText = field.getText();

		field.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{
				if (field.getText().equals(prevText)) field.setText("");
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				if (!field.getText().equals(prevText) && field.getText().isEmpty()) field.setText(prevText);
			}
		});
	}

	// Compares entered text to values in database
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String username = usernameField.getText();
		if (username != null && !username.isEmpty())
		{
			try
			{
				if (DatabaseUtils.compareValue(DatabaseUtils.usersURL, "Username", usernameField.getText()) &&
						DatabaseUtils.compareValue(DatabaseUtils.usersURL, "Password", new String(passwordField.getPassword())))
				{
					Main.panel.loginWasSuccessful();
				}
				else
				{
					Main.panel.loginDidFail();
				}

			} catch (SQLException ex)
			{
				throw new RuntimeException(ex);
			}
		}
	}
}