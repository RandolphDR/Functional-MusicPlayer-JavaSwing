package MusicPLayerTestPackage;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class AnimationGUI {

    private static int counter = 0;
    private static JLabel value = new JLabel("0");
    private static JLabel image = new JLabel("");
    private static Timer timer = new Timer();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation GUI");
        JPanel panel = new JPanel();
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);

        slider.addChangeListener(new Slider());

        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);

        panel.add(slider);
        panel.add(value);
        panel.add(image);
    }

    private static class Slider implements ChangeListener {

        public void stateChanged(ChangeEvent event) {
            JSlider source = (JSlider) event.getSource();

            TimerTask task = new TimerTask() {
                public void run() {
                    image.setIcon(new ImageIcon(counter + "AppLogo.png"));
                    counter++;
                    if (counter > 12) {
                        counter = 0;
                    }
                }
            };

            if (!source.getValueIsAdjusting()) {
                value.setText("" + (int) source.getValue());
                int speed = source.getValue() * 100;
                timer.scheduleAtFixedRate(task, 0, speed);
            }
        }
    }
}