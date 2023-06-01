package MusicPLayerTestPackage;

import javax.swing.JSlider;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;

public class Slider extends JFrame implements ActionListener{

	static JLabel panel;
    static JSlider progressBar, progressBar2;
    static JButton tenBack, tenSkip;
    static JButton play, pause;
    Image icon;
    static Clip clip;
    static File musicFile;
    static JTextField texts;

    Slider() throws LineUnavailableException, UnsupportedAudioFileException, IOException{

        ImageIcon icon=new ImageIcon("FourseasonsAlbum.jpg");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(icon.getImage());
        this.setLayout(new FlowLayout());
        this.setTitle("Music Player");
        this.setSize(420, 200);

        musicFile=new File("Taeyeon-FourSeasons.wav");
        AudioInputStream audioStream=AudioSystem.getAudioInputStream(musicFile);
        clip=AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        progressBar=new JSlider();
        
        progressBar.setUI(new CustomSliderUI(progressBar));
        progressBar.setValue(0);
        progressBar.setMinimum(0);
        progressBar.setMaximum((int)clip.getMicrosecondLength() / 1000000);
        progressBar.setPreferredSize(new Dimension(380,20));
        progressBar.setBackground(Color.white);
        progressBar.setOrientation(JSlider.HORIZONTAL);
        progressBar.setEnabled(false);
        progressBar.addChangeListener(change);
          
        progressBar2=new JSlider();
        
        progressBar2.setValue(0);
        progressBar2.setMinimum(0);
        progressBar2.setMaximum((int)clip.getMicrosecondLength() / 1000000);
        progressBar2.setPreferredSize(new Dimension(380,20));
        progressBar2.setBackground(Color.black);
        progressBar2.setOrientation(JSlider.HORIZONTAL);
        progressBar2.addChangeListener(change);
        
        String Format = String.format("%02d", (int)((clip.getMicrosecondPosition()/1000000)%60));
        
        String text = ((int)(clip.getMicrosecondPosition()/(60000000)) + ":" + Format +" / "+(int)(clip.getMicrosecondLength()/(60000000))+":0"+(int)((clip.getMicrosecondLength()/1000000)%60));
        
        panel = new JLabel();
        
        panel.setText("" + text);
        panel.setForeground(Color.black);
        panel.setPreferredSize(new Dimension(100,100));
        
        tenBack=new JButton("<<");
        tenBack.addActionListener(this);
        tenBack.setFont(new Font("Calibri",Font.BOLD,30));

        tenSkip=new JButton(">>");
        tenSkip.addActionListener(this);
        tenSkip.setFont(new Font("Calibri",Font.BOLD,30));

        play=new JButton("||");
        play.addActionListener(this);
        play.setFont(new Font("Calibri",Font.BOLD,30));

        pause = new JButton(">");
        pause.addActionListener(this);
        pause.setFont(new Font("Calibri",Font.BOLD,30));
        pause.setVisible(false);

        texts = new JTextField();
        texts.setPreferredSize(new Dimension(50,50));
        texts.addActionListener(this);
        
        this.add(progressBar);
     //   this.add(progressBar2);
        this.add(panel);
        this.add(tenBack);
        this.add(tenSkip);
        this.add(texts);
        this.add(play);
        this.add(pause);
        this.setVisible(true);

        
        for(long i = clip.getMicrosecondLength(); i >= clip.getMicrosecondPosition(); i++) {
        	
        	Format = String.format("%02d", (int)((clip.getMicrosecondPosition()/1000000)%60));
            panel.setText((int)(clip.getMicrosecondPosition()/(60000000)) + ":" + Format +" / "+(int)(clip.getMicrosecondLength()/(60000000))+":0"+(int)((clip.getMicrosecondLength()/1000000)%60));
            progressBar.setValue((int)(clip.getMicrosecondPosition()/1000000));

        }
        
        /*while(clip.isRunning()){
            
        	Format = String.format("%02d", (int)((clip.getMicrosecondPosition()/1000000)%60));
            panel.setText((int)(clip.getMicrosecondPosition()/(60000000)) + ":" + Format +" / "+(int)(clip.getMicrosecondLength()/(60000000))+":0"+(int)((clip.getMicrosecondLength()/1000000)%60));
            progressBar.setValue((int)(100*clip.getMicrosecondPosition()/clip.getMicrosecondLength()));
            
            
        }  */
        
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==tenBack) {

            clip.setMicrosecondPosition((long)(clip.getMicrosecondPosition() - 10 * 1000000));
            clip.start();
    }

    if(e.getSource()==tenSkip) {
    
        int getvalue = (int) clip.getMicrosecondPosition() / 1000000;

        if(getvalue >= 0 && getvalue <= 179) {

            clip.setMicrosecondPosition((long)(clip.getMicrosecondPosition() + 10 * 1000000));
            clip.start();

        }
       
}

        
        if(e.getSource() == texts) {
        	
        	String value = texts.getText();
        	
        	int num = Integer.parseInt(value);	
        	
        	if(num >= 0 && num <= 189) {
      
        		int convert = num * 1000000;
    			clip.setMicrosecondPosition((long) convert);
    			clip.start();
    			texts.setText("");
    			
        	} else {
        		
        		texts.setText("");
        	}
        	
        	
        }
    if(e.getSource() == play) {
        clip.stop();
        play.setVisible(false);
        pause.setVisible(true);
      
        
    }

    if(e.getSource() == pause) {

        clip.start();
        pause.setVisible(false);
        play.setVisible(true);
        
       
       
    }
    
    

}
            
    
    static ChangeListener change = new ChangeListener() {
    	
    	public void stateChanged(ChangeEvent e) {
    		
    	
    		/*if(e.getSource() == progressBar) {
    	
    			String Format = String.format("%02d", (int)((clip.getMicrosecondPosition()/1000000)%60));
    			String maxFormat = String.format("%02d", (int)((clip.getMicrosecondLength()/1000000)%60));
    			int value = (int) clip.getMicrosecondPosition() / 60000000;
    			int maximum = (int) clip.getMicrosecondLength() / 60000000;
    			
    			String display = value + ":" + Format + " / " + maximum + ":" + maxFormat ;
    					
    			panel.setText("" + display); */
       		  
    		            
    	   //  panel.setText((int)(clip.getMicrosecondPosition()/(60000000)) + ":" + Format +" / "+(int)(clip.getMicrosecondLength()/(60000000))+":0"+(int)((clip.getMicrosecondLength()/1000000)%60));
    		            
    				if(e.getSource() == progressBar2) {
    					
    					clip.setMicrosecondPosition(progressBar2.getValue() * 1000000);
    				}
    			
    		}
    	
    };

    public static void main(String args []) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        new Slider();
        
    }

    public static class CustomSliderUI extends BasicSliderUI {

        private static final int TRACK_HEIGHT = 2;
        private static final int TRACK_WIDTH = 2;
        private static final int TRACK_ARC = 5;
        private static final Dimension THUMB_SIZE = new Dimension(15, 15);
        private final RoundRectangle2D.Float trackShape = new RoundRectangle2D.Float();

        public CustomSliderUI(final JSlider slider) {

            super(slider);

        }

        @Override
        protected void calculateTrackRect() {
            super.calculateTrackRect();

            if (isHorizontal()) {

                trackRect.y = trackRect.y + (trackRect.height - TRACK_HEIGHT) / 2;
                trackRect.height = TRACK_HEIGHT;
                
            } else {

                trackRect.x = trackRect.x + (trackRect.width - TRACK_WIDTH) / 2;
                trackRect.width = TRACK_WIDTH;

            }

            trackShape.setRoundRect(trackRect.x, trackRect.y, trackRect.width, trackRect.height, TRACK_ARC, TRACK_ARC);

        }

        @Override
        protected void calculateThumbLocation() {

            super.calculateThumbLocation();

            if (isHorizontal()) {

                thumbRect.y = trackRect.y + (trackRect.height - thumbRect.height) / 2;

            } else {

                thumbRect.x = trackRect.x + (trackRect.width - thumbRect.width) / 2;

            }

        }

        @Override
        protected Dimension getThumbSize() {

            return THUMB_SIZE;

        }

        private boolean isHorizontal() {

            return slider.getOrientation() == JSlider.HORIZONTAL;

        }

        public void paint(final Graphics g, final JComponent c) {

            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paint(g, c);

        }

        public void paintTrack(final Graphics g) {

            Graphics2D g2 = (Graphics2D) g;
            Shape clip = g2.getClip();

            boolean horizontal = isHorizontal();
            boolean inverted = slider.getInverted();

            // Paint shadow.
            g2.setColor(Color.LIGHT_GRAY);
            g2.fill(trackShape);

            // Paint track background.
            g2.setColor(Color.LIGHT_GRAY);
            g2.setClip(trackShape);
            trackShape.y += 1;
            g2.fill(trackShape);
            trackShape.y = trackRect.y;

            g2.setClip(clip);

            // Paint selected track.
            if (horizontal) {
                boolean ltr = slider.getComponentOrientation().isLeftToRight();
                if (ltr) inverted = !inverted;
                int thumbPos = thumbRect.x + thumbRect.width / 2;
                if (inverted) {
                    g2.clipRect(0, 0, thumbPos, slider.getHeight());
                } else {
                    g2.clipRect(thumbPos, 0, slider.getWidth() - thumbPos, slider.getHeight());
                }

            } else {
                int thumbPos = thumbRect.y + thumbRect.height / 2;
                if (inverted) {
                    g2.clipRect(0, 0, slider.getHeight(), thumbPos);
                } else {
                    g2.clipRect(0, thumbPos, slider.getWidth(), slider.getHeight() - thumbPos);
                }
            }
            g2.setColor(new Color(100, 150, 255));
            g2.fill(trackShape);
            g2.setClip(clip);
        }

        @Override
        public void paintThumb(final Graphics g) {
        	
            g.setColor(Color.MAGENTA);
            g.fillOval(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
            
        }

        @Override
        public void paintFocus(final Graphics g) {

        }
        
    }
}
