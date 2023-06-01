package MusicPLayerTestPackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VolumeSlider extends JFrame implements ChangeListener {
    private static final long serialVersionUID = 1L;

    private JSlider volumeSlider = new JSlider(0, 100, 50);
   
    private Clip clip;

    public VolumeSlider() {
        super("Volume Slider");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 50));
        panel.add(volumeSlider);

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        volumeSlider.addChangeListener(this);

        try {
            File file = new File("Sugarcane-Leonora.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VolumeSlider();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            float volume = (float) source.getValue() / 100f;
            //clip.setFramePosition(0);
           // clip.stop();
           // clip.setMicrosecondPosition(0);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(10f * (float) Math.log10(volume));
        }
    }
}
