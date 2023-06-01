package MusicPLayerTestPackage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VolumeAdjuster extends JFrame implements ChangeListener {
	
    private JSlider slider;
    private JLabel label;
    private Clip clip;
    
    float defaultvol;
    
    VolumeAdjuster() {
    	
    }
    
    public VolumeAdjuster(float defaultvol) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
    	super("Volume Adjuster TEST RANDOLPH");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500,400);
        
            File file = new File("Sugarcane-Leonora.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
           
            float volume = (float) defaultvol / 100f;
            
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         
            gainControl.setValue(20 * (float) Math.log(volume));
            
        
        slider = new JSlider();
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setValue( (int) defaultvol);
        slider.setOrientation(JSlider.VERTICAL);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setForeground(new Color(0x123456));
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        slider.setFocusable(false);
        
       label = new JLabel();
       
       label.setText("VOLUME: " + slider.getValue());
       label.setBorder(BorderFactory.createLineBorder(Color.red, 1));
       label.setFont(new Font("Calibir", Font.BOLD, 15));
       label.setForeground(new Color(0x123456));
       label.setPreferredSize(new Dimension(0,50));
       label.setVerticalAlignment(JLabel.CENTER);
       label.setHorizontalAlignment(JLabel.CENTER);
        add(slider, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
        
        this.defaultvol = defaultvol;
        
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.print("Enter Default VOLUME: ");
    	float defaultvol = sc.nextFloat();
    	
        new VolumeAdjuster(defaultvol);
    }

	@Override
	public void stateChanged(ChangeEvent e) {
		
		JSlider source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting()) {
            float volume = (float) source.getValue() / 100f;
            //clip.setFramePosition(0);
           // clip.stop();
           // clip.setMicrosecondPosition(0);
           // clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log(volume));
             
        }
        
        if(e.getSource() == slider) {
        	
        	 int value = slider.getValue();
             label.setText("Volume: " + value);
             System.out.println("Volume Adjusted: " + value);
      
        }

	}
}