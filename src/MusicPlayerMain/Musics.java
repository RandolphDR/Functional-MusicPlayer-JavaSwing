package MusicPlayerMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class Musics extends ProjectConstants{

	protected static JLabel PlayLabel;
	protected static JPanel M1, M2, M3, M4, M5, M6;
	
	protected static File m1, m2, m3, m4, m5, m6;
	protected static Clip c1, c2, c3, c4, c5, c6;
	protected static AudioInputStream audio1, audio2, audio3, audio4, audio5, audio6;
	
	protected static JLabel SongName1, SongName2, SongName3, SongName4, SongName5, SongName6;
	protected static JLabel Album1, Album2, Album3, Album4, Album5, Album6;
	protected static JButton M1Button, M2Button, M3Button, M4Button, M5Button, M6Button;
	
	protected static JButton Play1, Play2, Play3, Play4, Play5, Play6;
	protected static JButton Pause1, Pause2, Pause3, Pause4, Pause5, Pause6;
	protected static JButton Reset1, Reset2, Reset3, Reset4, Reset5, Reset6;
	protected static JButton unLoop1, unLoop2, unLoop3, unLoop4, unLoop5, unLoop6;
	protected static JButton Loop1, Loop2, Loop3, Loop4, Loop5, Loop6;
	
	protected static JPanel PandP1, PandP2, PandP3, PandP4, PandP5, PandP6;
	protected static JPanel LandL1, LandL2, LandL3, LandL4, LandL5, LandL6;
	
	protected static JLabel AlbumLabel1, AlbumLabel2, AlbumLabel3, AlbumLabel4, AlbumLabel5, AlbumLabel6;
	protected static JPanel AlbumPanel1, AlbumPanel2, AlbumPanel3, AlbumPanel4, AlbumPanel5, AlbumPanel6;
	protected static JPanel PlayerControl1, PlayerControl2, PlayerControl3, PlayerControl4, PlayerControl5, PlayerControl6;
	protected static JPanel PlayerUI1, PlayerUI2, PlayerUI3, PlayerUI4, PlayerUI5, PlayerUI6;

	protected static JSlider MusicProgressSlider1, MusicProgressSlider2, MusicProgressSlider3, MusicProgressSlider4, MusicProgressSlider5, MusicProgressSlider6;
	protected static JLabel ProgressPosition1, ProgressPosition2, ProgressPosition3, ProgressPosition4, ProgressPosition5, ProgressPosition6;
	protected static JLabel ProgressLength1, ProgressLength2, ProgressLength3, ProgressLength4, ProgressLength5, ProgressLength6;
	protected static JButton Skip1, Skip2, Skip3, Skip4, Skip5, Skip6;
	protected static JButton Back1, Back2, Back3, Back4, Back5, Back6;

	protected static void PlayDisplay() {
		
		PlayLabel = new JLabel();
		PlayLabel.setIcon(PlayIcon);
		PlayLabel.setBackground(new Color(0,0,0,120));
		PlayLabel.setOpaque(true);
		PlayLabel.setHorizontalAlignment(JLabel.CENTER);
		PlayLabel.setVerticalAlignment(JLabel.CENTER);
		PlayLabel.setBounds(20, 25, 141, 140);
		PlayLabel.setVisible(false);
		
	}
	
	protected static void Music1() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		PlayDisplay();
		
	    m1 = new File("Sugarcane-Leonora.wav");
		audio1 = AudioSystem.getAudioInputStream(m1);
		c1 = AudioSystem.getClip();
		c1.open(audio1);

		Album1 = new JLabel();
		Album1.setText("Sugarcane - Leonora");
		Album1.setFont(new Font("Calibri", Font.BOLD, 15));
		Album1.setForeground(Color.green);
		Album1.setIcon(M1Album);
		Album1.setHorizontalAlignment(JLabel.CENTER);
		Album1.setVerticalAlignment(JLabel.CENTER);
		Album1.setVerticalTextPosition(JLabel.BOTTOM);
		Album1.setHorizontalTextPosition(JLabel.CENTER);
		Album1.setIconTextGap(10);
		Album1.setPreferredSize(new Dimension(140, 140));
		Album1.setLayout(null);
		
		M1Button = new JButton();
		M1Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		M1Button.setFocusable(false);
		M1Button.setBorder(null);
		M1Button.setLayout(new BorderLayout());
		M1Button.setContentAreaFilled(false);
		M1Button.setOpaque(true);
		M1Button.addActionListener(MusicPlayer.action);
		M1Button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				M1Button.doClick();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				PlayLabel.setBackground(new Color(0,0,10,190));
				M1Button.setBackground(new Color(LightSkyBlue[0], LightSkyBlue[1], LightSkyBlue[2]));
					
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
				PlayLabel.setBackground(new Color(0,0,0,120));
				M1Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				PlayLabel.setVisible(true);
				Album1.add(PlayLabel);
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				PlayLabel.setVisible(false);
				Album1.remove(PlayLabel);
			}
			
		});
		
		M1Button.add(Album1, BorderLayout.CENTER);
	
		M1 = new JPanel();
		M1.setPreferredSize(new Dimension(0,0));
		M1.setLayout(new BorderLayout());
		
		M1.add(M1Button, BorderLayout.CENTER);
		
	}
	
    protected static void Music2() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
    	PlayDisplay();
    	
		m2 = new File("Mlrd-Ligaya.wav");
		audio2 = AudioSystem.getAudioInputStream(m2);
		c2 = AudioSystem.getClip();
		c2.open(audio2);
		
		Album2 = new JLabel();
		Album2.setText("MLRD - Ligaya");
		Album2.setFont(new Font("Calibri", Font.BOLD, 15));
		Album2.setForeground(Color.green);
		Album2.setIcon(M2Album);
		Album2.setHorizontalAlignment(JLabel.CENTER);
		Album2.setVerticalAlignment(JLabel.CENTER);
		Album2.setVerticalTextPosition(JLabel.BOTTOM);
		Album2.setHorizontalTextPosition(JLabel.CENTER);
		Album2.setIconTextGap(10);
		Album2.setPreferredSize(new Dimension(140, 140));
		
		M2Button = new JButton();
		M2Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		M2Button.setFocusable(false);
		M2Button.setBorder(null);
		M2Button.setLayout(new BorderLayout());
		M2Button.setContentAreaFilled(false);
		M2Button.setOpaque(true);
		M2Button.addActionListener(MusicPlayer.action);
		M2Button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				M2Button.doClick();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				PlayLabel.setBackground(new Color(0,0,10,190));
				M2Button.setBackground(new Color(LightSkyBlue[0], LightSkyBlue[1], LightSkyBlue[2]));
				
					
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
				PlayLabel.setBackground(new Color(0,0,0,120));
				M2Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				PlayLabel.setVisible(true);
				Album2.add(PlayLabel);
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				PlayLabel.setVisible(false);
				Album2.remove(PlayLabel);
			}
			
		});
		
		M2Button.add(Album2, BorderLayout.CENTER);
	
		M2 = new JPanel();
		M2.setPreferredSize(new Dimension(0,0));
		M2.setLayout(new BorderLayout());
		
		M2.add(M2Button, BorderLayout.CENTER);
		
	}

	protected static void Music3() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		PlayDisplay();
		
		m3 = new File("Dilaw-Uhaw.wav");
		audio3 = AudioSystem.getAudioInputStream(m3);
		c3 = AudioSystem.getClip();
		c3.open(audio3);

		Album3 = new JLabel();
		Album3.setText("Dilaw - Uhaw");
		Album3.setFont(new Font("Calibri", Font.BOLD, 15));
		Album3.setForeground(Color.green);
		Album3.setIcon(M3Album);
		Album3.setHorizontalAlignment(JLabel.CENTER);
		Album3.setVerticalAlignment(JLabel.CENTER);
		Album3.setVerticalTextPosition(JLabel.BOTTOM);
		Album3.setHorizontalTextPosition(JLabel.CENTER);
		Album3.setIconTextGap(10);
		Album3.setPreferredSize(new Dimension(140, 140));

		M3Button = new JButton();
		M3Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		M3Button.setFocusable(false);
		M3Button.setBorder(null);
		M3Button.setLayout(new BorderLayout());
		M3Button.setContentAreaFilled(false);
		M3Button.setOpaque(true);
		M3Button.addActionListener(MusicPlayer.action);
		M3Button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				M3Button.doClick();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				PlayLabel.setBackground(new Color(0,0,10,190));
				M3Button.setBackground(new Color(LightSkyBlue[0], LightSkyBlue[1], LightSkyBlue[2]));
				
					
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
				PlayLabel.setBackground(new Color(0,0,0,120));
				M3Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				PlayLabel.setBounds(20, 25, 142, 140);
				PlayLabel.setVisible(true);
				Album3.add(PlayLabel);
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				PlayLabel.setBounds(20, 25, 141, 140);
				PlayLabel.setVisible(false);
				Album3.remove(PlayLabel);
			}
			
		});
		
		M3Button.add(Album3, BorderLayout.CENTER);
	
		M3 = new JPanel();
		M3.setPreferredSize(new Dimension(0,0));
		M3.setLayout(new BorderLayout());
		
		M3.add(M3Button, BorderLayout.CENTER);

	}

	protected static void Music4() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		PlayDisplay();
		
		m4 = new File("Taeyeon-FourSeasons.wav");
		audio4 = AudioSystem.getAudioInputStream(m4);
		c4 = AudioSystem.getClip();
		c4.open(audio4);

		Album4 = new JLabel();
		Album4.setText("Taeyeon - Four Seasons");
		Album4.setFont(new Font("Calibri", Font.BOLD, 13));
		Album4.setForeground(Color.green);
		Album4.setIcon(M4Album);
		Album4.setHorizontalAlignment(JLabel.CENTER);
		Album4.setVerticalAlignment(JLabel.CENTER);
		Album4.setVerticalTextPosition(JLabel.BOTTOM);
		Album4.setHorizontalTextPosition(JLabel.CENTER);
		Album4.setIconTextGap(10);
		Album4.setPreferredSize(new Dimension(140, 140));

		M4Button = new JButton();
		M4Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		M4Button.setFocusable(false);
		M4Button.setBorder(null);
		M4Button.setLayout(new BorderLayout());
		M4Button.setContentAreaFilled(false);
		M4Button.setOpaque(true);
		M4Button.addActionListener(MusicPlayer.action);
		M4Button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				M4Button.doClick();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				PlayLabel.setBackground(new Color(0,0,10,190));
				M4Button.setBackground(new Color(LightSkyBlue[0], LightSkyBlue[1], LightSkyBlue[2]));
				
					
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
				PlayLabel.setBackground(new Color(0,0,0,120));
				M4Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				PlayLabel.setBounds(20, 27, 142, 141);
				PlayLabel.setVisible(true);
				Album4.add(PlayLabel);
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				PlayLabel.setBounds(20, 25, 141, 140);
				PlayLabel.setVisible(false);
				Album4.remove(PlayLabel);
			}
			
		});
		
		M4Button.add(Album4, BorderLayout.CENTER);
	
		M4 = new JPanel();
		M4.setPreferredSize(new Dimension(0,0));
		M4.setLayout(new BorderLayout());
		
		M4.add(M4Button, BorderLayout.CENTER);

	}
	
	protected static void Music5() throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		PlayDisplay();
		
		m5 = new File("Juan-Demonyo.wav");
		audio5 = AudioSystem.getAudioInputStream(m5);
		c5 = AudioSystem.getClip();
		c5.open(audio5);

		Album5 = new JLabel();
		Album5.setText("Juan Karlos - Demonyo");
		Album5.setFont(new Font("Calibri", Font.BOLD, 13));
		Album5.setForeground(Color.green);
		Album5.setIcon(M5Album);
		Album5.setHorizontalAlignment(JLabel.CENTER);
		Album5.setVerticalAlignment(JLabel.CENTER);
		Album5.setVerticalTextPosition(JLabel.BOTTOM);
		Album5.setHorizontalTextPosition(JLabel.CENTER);
		Album5.setIconTextGap(10);
		Album5.setPreferredSize(new Dimension(140, 140));

		M5Button = new JButton();
		M5Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		M5Button.setFocusable(false);
		M5Button.setBorder(null);
		M5Button.setLayout(new BorderLayout());
		M5Button.setContentAreaFilled(false);
		M5Button.setOpaque(true);
		M5Button.addActionListener(MusicPlayer.action);
		M5Button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				M5Button.doClick();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				PlayLabel.setBackground(new Color(0,0,10,190));
				M5Button.setBackground(new Color(LightSkyBlue[0], LightSkyBlue[1], LightSkyBlue[2]));
				
					
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
				PlayLabel.setBackground(new Color(0,0,0,120));
				M5Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				PlayLabel.setBounds(20, 27, 142, 141);
				PlayLabel.setVisible(true);
				Album5.add(PlayLabel);
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				PlayLabel.setBounds(20, 25, 141, 140);
				PlayLabel.setVisible(false);
				Album5.remove(PlayLabel);
			}
			
		});
		
		M5Button.add(Album5, BorderLayout.CENTER);
	
		M5 = new JPanel();
		M5.setPreferredSize(new Dimension(0,0));
		M5.setLayout(new BorderLayout());
		
		M5.add(M5Button, BorderLayout.CENTER);

	}

	protected static void Music6() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		
		PlayDisplay();
		
	    m6 = new File("Shoti-LDR.wav");
		audio6 = AudioSystem.getAudioInputStream(m6);
		c6 = AudioSystem.getClip();
		c6.open(audio6);

		Album6 = new JLabel();
		Album6.setText("Shoti - LDR (Sped up)");
		Album6.setFont(new Font("Calibri", Font.BOLD, 15));
		Album6.setForeground(Color.green);
		Album6.setIcon(M6Album);
		Album6.setHorizontalAlignment(JLabel.CENTER);
		Album6.setVerticalAlignment(JLabel.CENTER);
		Album6.setVerticalTextPosition(JLabel.BOTTOM);
		Album6.setHorizontalTextPosition(JLabel.CENTER);
		Album6.setIconTextGap(10);
		Album6.setPreferredSize(new Dimension(140, 140));
		Album6.setLayout(null);
	
		M6Button = new JButton();
		M6Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		M6Button.setFocusable(false);
		M6Button.setBorder(null);
		M6Button.setLayout(new BorderLayout());
		M6Button.setContentAreaFilled(false);
		M6Button.setOpaque(true);
		M6Button.addActionListener(MusicPlayer.action);
		M6Button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				M6Button.doClick();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
				PlayLabel.setBackground(new Color(0,0,10,190));
				M6Button.setBackground(new Color(LightSkyBlue[0], LightSkyBlue[1], LightSkyBlue[2]));
					
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			
				PlayLabel.setBackground(new Color(0,0,0,120));
				M6Button.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
				PlayLabel.setVisible(true);
				Album6.add(PlayLabel);
				
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
				PlayLabel.setVisible(false);
				Album6.remove(PlayLabel);
			}
			
		});
		
		M6Button.add(Album6, BorderLayout.CENTER);
	
		M6 = new JPanel();
		M6.setPreferredSize(new Dimension(0,0));
		M6.setLayout(new BorderLayout());
		
		M6.add(M6Button, BorderLayout.CENTER);
		
	}
	
}
