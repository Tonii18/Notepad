package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import roundedComponents.RoundPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class NotePanel extends RoundPanel {

	/**
	 * Create the panel.
	 */
	public NotePanel(String content, int r1, int r2) {
		super(r1, r2);
		setBackground(new Color(125, 125, 125));
		setLayout(null);
		
		JCheckBox isDone = new JCheckBox("");
		isDone.setBorder(null);
		isDone.setOpaque(false);
		isDone.setHorizontalAlignment(SwingConstants.CENTER);
		isDone.setBounds(6, 5, 50, 50);
		isDone.setIcon(new ImageIcon(getClass().getResource("/Ellipse.png")));
		
		if(isDone.isSelected()) {
			isDone.setSelectedIcon(new ImageIcon(getClass().getResource("/Checked.pnh")));
		}
		add(isDone);
		
		JLabel task = new JLabel("   ");
		task.setFont(new Font("Inter 28pt SemiBold", Font.PLAIN, 20));
		task.setForeground(new Color(255, 255, 255));
		task.setBounds(66, 11, 460, 38);
		task.setText(content);
		add(task);
	}
}
