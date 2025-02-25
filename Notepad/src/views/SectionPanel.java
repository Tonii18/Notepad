package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import roundedComponents.RoundButton;

public class SectionPanel extends RoundButton {

	/**
	 * Create the panel.
	 */
	public SectionPanel(String name, int r1, int r2) {
		super(name, 10, 10);
		setBorder(null);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Inter 24pt SemiBold", Font.PLAIN, 20));
		setBackground(new Color(91, 92, 92));
		setText(name);
		
		// Set a fixed size for the buttons (width and height)
        //setPreferredSize(new java.awt.Dimension(280, 60));  // Change to your preferred size
	}
}
