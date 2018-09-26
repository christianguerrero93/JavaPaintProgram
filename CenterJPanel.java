
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CenterJPanel extends JPanel
		implements KeyListener, MouseListener, ActionListener, MouseMotionListener, ChangeListener {

	public int control = 0;

	private Font font;
	private FontMetrics fm;

	private JButton jb1;

	protected int lastX;
	protected int lastY;
	protected boolean mouseIsPressed;
	protected Color lineColor;
	protected int diameter;
	protected String shapeType;
	protected boolean shapeOn;
	protected int sliderNumber = 0;
	protected JSlider sliderControl;

	int x = 0;
	int y = 0;
	JButton jbColor;

	JButton jb;

	JSlider south;

	public CenterJPanel() {
		super();

		font = new Font("serif", Font.BOLD, 25);

		fm = getFontMetrics(font);
		addKeyListener(this);

		JButton JB = new JButton("circle");
		add(JB);
		JB.addActionListener(this);

		JButton JB2 = new JButton("rectangular");
		add(JB2);
		JB2.addActionListener(this);

		JButton JB3 = new JButton("square");
		JB3.addActionListener(this);

		JButton JB4 = new JButton("Line");
		add(JB4);
		JB4.addActionListener(this);

		jb = new JButton("reset");
		add(jb, BorderLayout.SOUTH);
		jb.addActionListener(this);

		sliderControl = new JSlider();
		sliderControl = new JSlider(JSlider.VERTICAL, 0, 30, 0);

		sliderControl.setMajorTickSpacing(10);
		sliderControl.setMinorTickSpacing(1);
		sliderControl.setPaintLabels(true);
		sliderControl.setPaintTicks(true);

		sliderControl.addChangeListener(this);

		add(sliderControl, BorderLayout.NORTH);

		lastX = 0;
		lastY = 0;
		diameter = 30;
		shapeOn = false;
		addMouseListener(this);
		addMouseMotionListener(this);

		setBackground(Color.BLUE);
		mouseIsPressed = false;

	}

	private void drawCircle(Graphics g) {

		g.fillOval(lastX - diameter / 2, lastY - diameter / 2, diameter, diameter);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (control == 1) {

			int diameter = 50;
			Graphics g = getGraphics();
			g.setColor(MyColorChooserJPanel.getmColor());

			g.fillOval(x - diameter / 2, y - diameter / 2, diameter, diameter);
			g.dispose();

		}
		if (control == 2) {
			x = e.getX();
			y = e.getY();
			Graphics a = getGraphics();
			a.setColor(MyColorChooserJPanel.getmColor());
			a.fillRect(x, y, 70, 100);
			a.dispose();

		}
		if (control == 3) {

			Graphics b = getGraphics();

			b.setColor(MyColorChooserJPanel.getmColor());

			b.fillRect(x, y, 40, 40);
			b.dispose();
		}
		if (control == 4) {

			if (shapeOn) {
				Graphics g = getGraphics();
				drawCircle(g);

				g.dispose();
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		requestFocus();
		record(e.getX(), e.getY());

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		mouseIsPressed = true;
		record(e.getX(), e.getY());
		if (control == 4) {
			mouseIsPressed = true;
			record(e.getX(), e.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseIsPressed = false;
		x = e.getX();
		y = e.getY();
		if (control == 4) {
			mouseIsPressed = false;
			int x = e.getX();
			int y = e.getY();
			Graphics g = getGraphics();
			g.drawLine(lastX, lastY, x, y);

			record(x, y);
			g.dispose();

			System.out.println("Released AT:  " + x + " , " + y);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String face = e.getActionCommand();

		if (face.equalsIgnoreCase("reset")) {
			repaint();

		}

		if (face.equalsIgnoreCase("circle")) {

			control = 1;
		}
		if (face.equalsIgnoreCase("rectangular")) {

			control = 2;

		}
		if (face.equalsIgnoreCase("square")) {

			control = 3;
		}
		if (face.equalsIgnoreCase("line")) {

			control = 4;
		}
	}

	protected void record(int x, int y) {
		lastX = x;
		lastY = y;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (control == 4) {

			mouseIsPressed = true;
			int x = e.getX();
			int y = e.getY();
			Graphics g = getGraphics();
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(MyColorChooserJPanel.getmColor());

			g2d.setStroke(new BasicStroke(sliderNumber));

			g2d.drawLine(lastX, lastY, x, y);

			record(x, y);
			g.dispose();
			System.out.println("DRAGGED AT: " + x + ", " + y);

		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		sliderNumber = (int) source.getValue();
		{

		}
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
			Graphics gPlain = getGraphics();
			Graphics2D g = (Graphics2D) gPlain;
			g.setColor(MyColorChooserJPanel.mColor);

			fm = getFontMetrics(font);

			System.out.println(fm.getDescent());
			g.setFont(font);
			lastX += fm.stringWidth(s) + 10;
			g.drawString(s, lastX, lastY);
			g.dispose();
		}
		System.out.println("IN key typed " + s);

	}

}
