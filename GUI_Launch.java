
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class GUI_Launch extends JFrame {

	DrawJPanel jpFun;

	private DrawJPanel jpWriteAndDraw;

	public GUI_Launch() {
		JPanel jp = new JPanel();

		jp.setLayout(new BorderLayout());

		CenterJPanel jp4 = new CenterJPanel();

		jpFun = new DrawJPanel();

		jp.add(jpFun, BorderLayout.CENTER);
		MyColorChooserJPanel color = new MyColorChooserJPanel();
		MyColorChooserJPanel jpColorInHere = new MyColorChooserJPanel();
		jp.add(jpColorInHere, BorderLayout.NORTH);
		add(jp);

		jp.add(jp4);

		add(jp);

		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		System.out.println("CMP342 Project");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				GUI_Launch gui = new GUI_Launch();
			}

		});
		System.out.println("Completed Gui ");
	}
}
