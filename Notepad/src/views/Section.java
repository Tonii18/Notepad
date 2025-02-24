package views;

import java.awt.Color;

import roundedComponents.RoundPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Section extends RoundPanel {

	/**
	 * Create the panel.
	 */
	public Section(int r, int r2) {
		super(r, r2);
		setBackground(new Color(91, 92, 92));
		setLayout(null);
		
		JLabel section = new JLabel("Section 1");
		section.setForeground(new Color(255, 255, 255));
		section.setHorizontalAlignment(SwingConstants.CENTER);
		section.setFont(new Font("Inter 24pt ExtraBold", Font.PLAIN, 25));
		section.setBounds(76, 17, 133, 26);
		add(section);
	}
}
