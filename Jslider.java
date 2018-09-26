
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Jslider extends Frame {

	JLabel label;
	JSlider slider;

	public Jslider() {
		JPanel jp = new JPanel();

		jp.setLayout(new BorderLayout());

		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(1, 1));

		label = new JLabel();
		slider = new JSlider(JSlider.VERTICAL, 0, 30, 0);
		label.setOpaque(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);

		westPanel.add(slider);

		jp.add(westPanel, BorderLayout.EAST);

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				{

				}

			}
		});
	}
}
