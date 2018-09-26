
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnFace = e.getActionCommand(); 

		switch (btnFace) {

		case "BLUE":
			setBackground(Color.BLUE);
			break;
		case "YELLOW":
			setBackground(Color.YELLOW);
			break;
		case "WHITE":
			setBackground(Color.WHITE);
			break;
		default:

		}

	}

}
