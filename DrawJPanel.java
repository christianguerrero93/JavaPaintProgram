
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawJPanel extends CenterJPanel implements KeyListener {

	private Font font;
	private FontMetrics fm;
	private int fontSize = 50;

	private JButton jb1;

	public DrawJPanel() {
		super();

		font = new Font("serif", Font.BOLD, fontSize);
		font.getSize();

		fm = getFontMetrics(font);
		addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

		String s = String.valueOf(e.getKeyChar());
		if (!mouseIsPressed) {
			Graphics g = getGraphics();
			Graphics2D h = (Graphics2D) g;
			h.setFont(new Font(font.getFamily(), font.getStyle(), fontSize));

			g.setColor(Color.RED);
			lastX += fm.stringWidth(s);
			g.drawString(s, lastX, lastY);

			g.dispose();
		}
		System.out.println("IN key typed " + s);

	}

}
