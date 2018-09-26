
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyColorChooserJPanel extends JPanel implements ActionListener {

	static JButton jbColor;

	static Color mColor;

	public MyColorChooserJPanel() {

		jbColor = new JButton("colors options");
		jbColor.addActionListener(this);
		add(jbColor);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color bgColor = JColorChooser.showDialog(this, "pick a color", Color.RED);
		mColor = bgColor;
		setBackground(bgColor);

	}

	public static Color getmColor() {
		return mColor;
	}

	public static void setJbColor(JButton jbColor) {
		MyColorChooserJPanel.jbColor = jbColor;
	}
}
