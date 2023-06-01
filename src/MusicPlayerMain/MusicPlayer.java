package MusicPlayerMain;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.sound.sampled.*;

public class MusicPlayer extends MusicProgressUI {

	private static JLabel MusicIconLabel;
	private static JButton CloseButton;
	private static JButton MaximizeButton;
	private static JButton MinimizeButton;
	private static JLabel MandMLabel;
	private static JButton ExitButton;
	private static JPanel NorthMainNavigation;

	private static JLabel AppTitle;
	private static JLabel PlaylistTitle;
	private static JPanel PlaylistTitlePanel;
	
	private static JPanel SouthInvi, NorthInvi, WestInvi, EastInvi, Section1, Section2, Footer;
	
	private static JPanel MSection;
	private static JPanel SouthPanel;
	protected static JPanel NorthPanel;
	private static JLabel CenterFrame;
	
	private static JPanel TrackPanel, MusicTrackPanel;
	private static JPanel AppPanel;
	private static JFrame PlayerFrame;
	
	protected static JSlider VolumeSlider;
	protected static JLabel VolumeLabel;
    protected static JPanel VolumePanel;
	protected static FloatControl VolumeControl;
	protected static JSlider source;

	protected static JScrollPane Section1ScrollPane;

	protected static JPanel PanelInvi;
	protected static JButton StopMusicButton;

	protected static void NorthPanelComponents() {
		
		StopMusicButton = new JButton();
		StopMusicButton.setText(ExitIcon);
		StopMusicButton.addActionListener(action);
		StopMusicButton.setForeground(Color.black);
		StopMusicButton.setBackground(new Color(AppColor[0],AppColor[1],AppColor[2]));
		StopMusicButton.setBorder(null);
		StopMusicButton.setFocusable(false);
		StopMusicButton.setPreferredSize(new Dimension(0,10));
		StopMusicButton.setVisible(false);
		StopMusicButton.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
				StopMusicButton.setBorder(WhiteBorder);

			}

			public void mouseExited(MouseEvent e) {
				
				StopMusicButton.setBorder(null);

			}

		});

	    PanelInvi = new JPanel();
		PanelInvi.setBackground(new Color(0,0,0,0));
		PanelInvi.setPreferredSize(new Dimension(955, 10));

		AppTitle = new JLabel();
		
		AppTitle.setIcon(ApplicationLogo);
		AppTitle.setText(AppName);
		AppTitle.setFont(new Font("Calibri BOLD", Font.BOLD, 35));
		AppTitle.setForeground(Color.white);
		AppTitle.setHorizontalTextPosition(JLabel.RIGHT);
		AppTitle.setVerticalTextPosition(JLabel.CENTER);
		AppTitle.setHorizontalAlignment(JLabel.CENTER);
		AppTitle.setVerticalAlignment(JLabel.CENTER);
		AppTitle.setIconTextGap(10);
		AppTitle.setPreferredSize(new Dimension(200, 150));
		
		NorthInvi = new JPanel();
		NorthInvi.setBackground(new Color(0,0,0,0));
		NorthInvi.setPreferredSize(new Dimension(0, 10));
		NorthInvi.setLayout(new BorderLayout());

		NorthInvi.add(PanelInvi, BorderLayout.WEST);
		NorthInvi.add(StopMusicButton, BorderLayout.CENTER);

		SouthInvi = new JPanel();
		SouthInvi.setBackground(new Color(0,0,0,0));
		SouthInvi.setPreferredSize(new Dimension(0, 30));
		
        NorthPanel = new JPanel();
		
		NorthPanel.setBackground(new Color(0,0,0,0));
		NorthPanel.setPreferredSize(new Dimension(0,170));
		NorthPanel.setLayout(new BorderLayout());
		
		TrackNavigationPanel();

		NorthPanel.add(TrackPanel, BorderLayout.EAST);
		NorthPanel.add(NorthInvi, BorderLayout.NORTH);
		NorthPanel.add(AppTitle, BorderLayout.WEST);
		NorthPanel.add(SouthInvi, BorderLayout.SOUTH);
				
	}
	
	private void AppHeader() {

		PlaylistTitle = new JLabel();
		PlaylistTitle.setText("Music List");
		PlaylistTitle.setFont(new Font("Calibri Headings", Font.BOLD, 20));
		PlaylistTitle.setForeground(Color.white);

	    PlaylistTitlePanel = new JPanel();
	    PlaylistTitlePanel.setBackground(new Color(0,0,0,0));
	    PlaylistTitlePanel.setPreferredSize(new Dimension(0, 55));
	    PlaylistTitlePanel.setLayout(new FlowLayout(35,35,30));
	    
	    PlaylistTitlePanel.add(PlaylistTitle);
	    
	}
	
	private void Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		Section1 = new JPanel();
		Section1.setBackground(new Color(0,0,0,120));
		Section1.setPreferredSize(new Dimension(1200, 220));
		Section1.setLayout(new GridLayout(0,6,20,0));
	
		ScrollBarUI ScrollPaneUI = new ScrollBarUI();
		ScrollPaneUI.setOrientation(JScrollBar.HORIZONTAL);
	
		Section1ScrollPane = new JScrollPane();
		Section1ScrollPane.setBorder(null);
		Section1ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Section1ScrollPane.setHorizontalScrollBar(ScrollPaneUI);
		Section1ScrollPane.setViewportView(Section1);
		Section1ScrollPane.setOpaque(false);
		Section1ScrollPane.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				
				PlayerFrame.repaint();
			
			}
			
			
		});
		
		Musics.Music1();
		Musics.Music2();
		Musics.Music3();
		Musics.Music4();
		Musics.Music5();
		Musics.Music6();
    
		Section1.add(M1);
		Section1.add(M2);
		Section1.add(M3);
		Section1.add(M4);
		Section1.add(M5);
		Section1.add(M6);
		
		Section2 = new JPanel();
		Section2.setBackground(new Color(0,0,0,120));
		Section2.setPreferredSize(new Dimension(0, 200));
		
		WestInvi = new JPanel();
		WestInvi.setBackground(new Color(0,0,0,0));
		WestInvi.setPreferredSize(new Dimension(30, 0));
		
		EastInvi = new JPanel();
		EastInvi.setBackground(new Color(0,0,0,0));
		EastInvi.setPreferredSize(new Dimension(30, 0));
		
		Footer = new JPanel();
		Footer.setBackground(new Color(0,0,0,0));
		Footer.setPreferredSize(new Dimension(0, 20));
		
		MSection = new JPanel();
	    MSection.setBackground(new Color(0,0,0,0));
	    MSection.setPreferredSize(new Dimension(0, 0));
	    MSection.setLayout(new BorderLayout(0, 25));
	 
	    MSection.add(Section1ScrollPane, BorderLayout.NORTH);
	    MSection.add(Section2, BorderLayout.CENTER);
	    MSection.add(Footer, BorderLayout.SOUTH);
	    
	    
	}
	
	private void SouthPanelComponents() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	    
        SouthPanel = new JPanel();
		SouthPanel.setBackground(new Color(0,0,0,65));
		SouthPanel.setPreferredSize(new Dimension(0,550));
		SouthPanel.setLayout(new BorderLayout(0, 30));
		
		AppHeader();
		Music();
		
		SouthPanel.add(PlaylistTitlePanel, BorderLayout.NORTH);
		SouthPanel.add(MSection, BorderLayout.CENTER);
		
		SouthPanel.add(WestInvi, BorderLayout.WEST);
		SouthPanel.add(EastInvi, BorderLayout.EAST);
		
	}
	
	private void CenterComponents() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		CenterFrame = new JLabel();
		CenterFrame.setIcon(FrameBackground);
		CenterFrame.setHorizontalAlignment(JLabel.CENTER);
		CenterFrame.setVerticalAlignment(JLabel.CENTER);
		
		CenterFrame.setLayout(new BorderLayout());

		NorthPanelComponents();
		SouthPanelComponents();
		
		CenterFrame.add(NorthPanel, BorderLayout.NORTH);
		CenterFrame.add(SouthPanel, BorderLayout.SOUTH);
		
	}

	private void NorthPanelNavigation() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		MusicIconLabel = new JLabel();
		MusicIconLabel.setText(MusicIcon);
		MusicIconLabel.setFont(new Font("Arial", Font.BOLD, 25));
		MusicIconLabel.setForeground(Color.LIGHT_GRAY);
		MusicIconLabel.setPreferredSize(new Dimension(20, 30));

		CloseButton = new JButton();
		CloseButton.setText(CloseIcon);
		CloseButton.setFont(new Font("Arial", Font.PLAIN, 14));
		CloseButton.setForeground(Color.LIGHT_GRAY);
		CloseButton.setBackground(null);
		CloseButton.setBorder(null);
		CloseButton.setFocusable(ButtonFocusable);
		CloseButton.setPreferredSize(new Dimension(45,30));
		CloseButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == CloseButton) {

				   PlayerFrame.setState(JFrame.ICONIFIED);

				}
			}

		});

		SouthPanelComponents();
		Music();
		
		NorthMainNavigation = new JPanel();
		FrameDragListener frameDragListener = new FrameDragListener(NorthMainNavigation);
		MandMLabel = new JLabel();
		MaximizeButton = new JButton();
		MinimizeButton = new JButton();
		
		MinimizeButton.setText(MinimizeIcon);
		MinimizeButton.setFont(new Font("Arial", Font.PLAIN, 23));
		MinimizeButton.setForeground(Color.LIGHT_GRAY);
		MinimizeButton.setBackground(null);
		MinimizeButton.setBorder(null);
		MinimizeButton.setFocusable(ButtonFocusable);
		MinimizeButton.setPreferredSize(new Dimension(45, 30));
		MinimizeButton.setVisible(false);
		
		MinimizeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == MinimizeButton) {
				  	   
				   SouthPanel.setPreferredSize(new Dimension(0, 550));
				   
				   Section1.setPreferredSize(new Dimension(1200, 220));
				   
				   NorthMainNavigation.addMouseListener(frameDragListener);
		           NorthMainNavigation.addMouseMotionListener(frameDragListener);

				   MandMLabel.add(MaximizeButton, BorderLayout.CENTER);
				   MaximizeButton.setVisible(true);
				   MinimizeButton.setVisible(false);
				    
				   AppPanel.setBorder(AppBorder);
				   PlayerFrame.setSize(FrameSize[0], FrameSize[1]);
				   PlayerFrame.setLocationRelativeTo(null);
                   
				}
			}

		});

		MaximizeButton.setText(MaximizeIcon);
		MaximizeButton.setFont(new Font("Arial", Font.BOLD, 23));
		MaximizeButton.setForeground(Color.LIGHT_GRAY);
		MaximizeButton.setBackground(null);
		MaximizeButton.setBorder(null);
		MaximizeButton.setFocusable(ButtonFocusable);
		MaximizeButton.setPreferredSize(new Dimension(45, 30));
		MaximizeButton.setVisible(false);
		
		MaximizeButton.addActionListener(new ActionListener() {
        
			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == MaximizeButton) {
				   
				   SouthPanel.setPreferredSize(new Dimension(0, 600));
				   
				   Section1.setPreferredSize(new Dimension(1500, 220));
				   
				   MandMLabel.add(MinimizeButton, BorderLayout.CENTER);
				   MinimizeButton.setVisible(true);
				   MaximizeButton.setVisible(false);
				  
				   AppPanel.setBorder(null);
				   PlayerFrame.setSize(1535, 815);
				   PlayerFrame.setLocationRelativeTo(null);
				   
				   NorthMainNavigation.removeMouseListener(frameDragListener);
		           NorthMainNavigation.removeMouseMotionListener(frameDragListener);

		           NorthMainNavigation.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						
                         if(e.getClickCount() == 2) {
							
							MinimizeButton.doClick();
						}
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
	
					}
		        	   
		           });
		           
				   
                   
				}
			}

		});

		MandMLabel.setPreferredSize(new Dimension(45, 30));
		MandMLabel.setBackground(null);
		MandMLabel.setLayout(new BorderLayout());
	
		MaximizeButton.setVisible(true);
		MandMLabel.add(MaximizeButton, BorderLayout.CENTER);
		
		ExitButton = new JButton();
		ExitButton.setText(ExitIcon);
		ExitButton.setFont(new Font("Arial", Font.PLAIN, 30));
		ExitButton.setForeground(Color.LIGHT_GRAY);
		ExitButton.setBackground(null);
		ExitButton.setBorder(null);
		ExitButton.setFocusable(ButtonFocusable);
		ExitButton.setPreferredSize(new Dimension(45, 30));
		ExitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == ExitButton) {

				   PlayerFrame.dispose();

				}
			}

		});

		NorthMainNavigation.setPreferredSize(new Dimension(0, 30));
		NorthMainNavigation.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		NorthMainNavigation.addMouseListener(frameDragListener);
		NorthMainNavigation.addMouseMotionListener(frameDragListener);
		NorthMainNavigation.setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));

		NorthMainNavigation.add(MusicIconLabel);
		NorthMainNavigation.add(CloseButton);
		NorthMainNavigation.add(MandMLabel);
		NorthMainNavigation.add(ExitButton);
        
	}

	public static class FrameDragListener extends MouseAdapter {

		private final JPanel NorthMainNavigation;
		private Point mouseDownCompCoords = null;

		public FrameDragListener(JPanel NorthMainNavigation) {
			this.NorthMainNavigation = NorthMainNavigation;
		}

		public void mouseReleased(MouseEvent e) {
			mouseDownCompCoords = null;
			
			
		}

		public void mousePressed(MouseEvent e) {
			mouseDownCompCoords = e.getPoint();
			
			if(e.getClickCount() == 2) {
			   
				 MaximizeButton.doClick();
				 
			}
			
			
		}

		public void mouseDragged(MouseEvent e) {
			Point currCoords = e.getLocationOnScreen();
		    PlayerFrame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y); 
		    PlayerFrame.repaint();
		}

	}
	
	private static void TrackNavigationPanel() {

		NavigationSettings1();
		NavigationSettings2();
		NavigationSettings3();
		NavigationSettings4();
        NavigationSettings5();
		NavigationSettings6();

		MusicTrackPanel = new JPanel();
		MusicTrackPanel.setBackground(new Color(0,0,0,0));
		MusicTrackPanel.setPreferredSize(new Dimension(360, 0));
		MusicTrackPanel.setVisible(true);
		MusicTrackPanel.setLayout(new BorderLayout());

		TrackPanel = new JPanel();
		TrackPanel.setBackground(new Color(0,0,0,0));
		TrackPanel.setPreferredSize(new Dimension(380, 0));
		TrackPanel.setVisible(true);
		TrackPanel.setLayout(new BorderLayout());

		VolumeNavigation();
		TrackPanel.add(VolumePanel, BorderLayout.EAST);
		TrackPanel.add(MusicTrackPanel, BorderLayout.CENTER);
		
		TrackPanel.setVisible(false);

	}

	public MusicPlayer() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		NorthPanelNavigation();
		CenterComponents();
		
		AppPanel = new JPanel();
		AppPanel.setBorder(AppBorder);
		AppPanel.setLayout(new BorderLayout());
		
		AppPanel.add(NorthMainNavigation, BorderLayout.NORTH);
		AppPanel.add(CenterFrame, BorderLayout.CENTER);
		
		PlayerFrame = new JFrame();
		PlayerFrame.setTitle("Music Player Java");
		PlayerFrame.setIconImage(ApplicationLogo.getImage());
		PlayerFrame.setUndecorated(FrameUndecorated);
		PlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PlayerFrame.setSize(FrameSize[0], FrameSize[1]);
		PlayerFrame.setLocationRelativeTo(null);
		PlayerFrame.setLayout(new BorderLayout());
		
		PlayerFrame.add(AppPanel, BorderLayout.CENTER);
		PlayerFrame.setVisible(FrameVisible);

		MusicEngines();

	}

	protected static void VolumeNavigation() {

		VolumeSlider = new JSlider();
		VolumeSlider.setUI(new CustomSliderUI(VolumeSlider));
		VolumeSlider.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		VolumeSlider.setMinimum((int) Minimum);
		VolumeSlider.setMaximum((int) Maximum);
		VolumeSlider.setValue((int) DefaultVolume);
		VolumeSlider.setOrientation(JSlider.VERTICAL);
		VolumeSlider.setFocusable(false);
		VolumeSlider.addChangeListener(change1);
		VolumeSlider.setPreferredSize(new Dimension(20, 50));
		VolumeSlider.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
				VolumeSlider.setBorder(WhiteBorder);

			}

			public void mouseExited(MouseEvent e) {
				
				VolumeSlider.setBorder(null);

			}

		});

		VolumeLabel = new JLabel();
		VolumeLabel.setText("" + VolumeSlider.getValue());
		VolumeLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		VolumeLabel.setForeground(Color.white);
		VolumeLabel.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		VolumeLabel.setVerticalAlignment(JLabel.CENTER);
		VolumeLabel.setHorizontalAlignment(JLabel.CENTER);
		VolumeLabel.setPreferredSize(new Dimension(0,20));
		
		VolumePanel = new JPanel();
		VolumePanel.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		VolumePanel.setBounds(295, 0, 40, 130);
		VolumePanel.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
				VolumeSlider.setBorder(WhiteBorder);

			}

			public void mouseExited(MouseEvent e) {
				
				VolumeSlider.setBorder(null);

			}

		});

		VolumePanel.setLayout(new BorderLayout());
		
		VolumePanel.add(VolumeSlider, BorderLayout.CENTER);
		VolumePanel.add(VolumeLabel, BorderLayout.SOUTH);

		VolumePanel.setVisible(true);

	}

	protected static void NavigationSettings1() {
		
		ProgressPosition1 = new JLabel();
		ProgressPosition1.setText((int)(c1.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c1.getMicrosecondPosition() / 1000000) % 60));
		ProgressPosition1.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressPosition1.setForeground(Color.white);
		ProgressPosition1.setPreferredSize(new Dimension(100, 100));
		ProgressPosition1.setBounds(160, 20, 100, 100);

		ProgressLength1 = new JLabel();
		ProgressLength1.setText((int)(c1.getMicrosecondLength()/(60000000))+":" + String.format("%02d", (int) (c1.getMicrosecondLength() / 1000000) % 60));
		ProgressLength1.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressLength1.setForeground(Color.white);
		ProgressLength1.setPreferredSize(new Dimension(100, 100));
		ProgressLength1.setBounds(320, 20, 100, 100);
		
		MusicProgressSlider1 = new JSlider();
		MusicProgressSlider1.setUI(new ProgressUI(MusicProgressSlider1));
		MusicProgressSlider1.setMinimum(0);
		MusicProgressSlider1.setMaximum((int) c1.getMicrosecondLength() / 1000000);
		MusicProgressSlider1.setValue(0);
		MusicProgressSlider1.setOrientation(JSlider.HORIZONTAL);
		MusicProgressSlider1.setEnabled(false);
		MusicProgressSlider1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		MusicProgressSlider1.setPreferredSize(new Dimension(200, 20));
		MusicProgressSlider1.setBounds(150, 70, 200, 20);

		unLoop1 = new JButton();
		Loop1 = new JButton();
		
		LandL1 = new JPanel();
		LandL1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		LandL1.setPreferredSize(new Dimension(30,25));
		LandL1.setLayout(new BorderLayout());

		Back1 = new JButton();
		Back1.setText("|◀");
		Back1.setFont(new Font("null", Font.BOLD, 12));
		Back1.setForeground(Color.black);
		Back1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Back1.setFocusable(false);
		Back1.setBorder(null);
		Back1.setPreferredSize(new Dimension(30, 25));
		Back1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Back1) {

					c1.setMicrosecondPosition((long) c1.getMicrosecondPosition() - 10 * 1000000);
					c1.start();

				}
			}

		});

		Play1 = new JButton();
		Pause1 = new JButton();
		
		PandP1 = new JPanel();
		PandP1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		PandP1.setPreferredSize(new Dimension(30,25));
		PandP1.setLayout(new BorderLayout());
		
		Reset1 = new JButton();
		
		Play1.setText("▶");
		Play1.setVisible(false);
		Play1.setForeground(Color.black);
		Play1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Play1.setFocusable(false);
		Play1.setBorder(null);
		Play1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Play1) {
				   
	       		    PandP1.add(Pause1);
					Pause1.setVisible(true);
					Play1.setVisible(false);
					PandP1.remove(Play1);
					
					c1.start();
				}
				
			}
			
		});
		
		Pause1.setText("∥∥");
		Pause1.setVisible(true);
		Pause1.setForeground(Color.black);
		Pause1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Pause1.setFocusable(false);
		Pause1.setBorder(null);
		Pause1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Pause1) {
				   
					PandP1.add(Play1);
					Play1.setVisible(true);
					Pause1.setVisible(false);
					PandP1.remove(Pause1);
					
					c1.stop();
					
				}
				
			}
			
		});
		
		Skip1 = new JButton();
		Skip1.setText("▶|");
		Skip1.setFont(new Font("null", Font.BOLD, 12));
		Skip1.setForeground(Color.black);
		Skip1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Skip1.setFocusable(false);
		Skip1.setBorder(null);
		Skip1.setPreferredSize(new Dimension(30, 25));
		Skip1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Skip1) {

					c1.setMicrosecondPosition((long) c1.getMicrosecondPosition() + 10 * 1000000);
					c1.start();

				}
			}
			
		});
	
		Reset1.setText("↻");
		Reset1.setForeground(Color.black);
		Reset1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Reset1.setFont(new Font("null", Font.BOLD, 18));
		Reset1.setFocusable(false);
		Reset1.setBorder(null);
		Reset1.setPreferredSize(new Dimension(30, 25));
		Reset1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == Reset1) {
				
					PandP1.add(Pause1);
					Pause1.setVisible(true);
					Play1.setVisible(false);
					PandP1.remove(Play1);
					
					c1.setMicrosecondPosition(0);
					c1.start();
				}
			}
			
		});
		
		
		unLoop1.setText("⇌");
		unLoop1.setVisible(true);
		unLoop1.setForeground(Color.black);
		unLoop1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		unLoop1.setFocusable(false);
		unLoop1.setFont(new Font("null", Font.BOLD, 18));
		unLoop1.setBorder(null);
		unLoop1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == unLoop1) {
					
				   LandL1.add(Loop1);
				   LandL1.remove(unLoop1);
				   Loop1.setVisible(true);
				   unLoop1.setVisible(false);
				   
				   c1.loop(Clip.LOOP_CONTINUOUSLY);
				   
				}
			}
			
		});
		
		Loop1.setText("⇌¹");
		Loop1.setVisible(false);
		Loop1.setForeground(Color.black);
		Loop1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Loop1.setFocusable(false);
		Loop1.setFont(new Font("null", Font.BOLD, 18));
		Loop1.setBorder(null);
		Loop1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Loop1) {
					
				   LandL1.add(unLoop1);
				   LandL1.remove(Loop1);
				   unLoop1.setVisible(true);  
				   Loop1.setVisible(false);
				   
				   c1.loop(0);
				   
				}
				
			}
			
		});
	
		LandL1.add(unLoop1);
		
	    PandP1.add(Pause1);
	    
	    PlayerControl1 = new JPanel();
	    PlayerControl1.setBackground(new Color(0,0,0,0));
	    PlayerControl1.setLayout(new FlowLayout(FlowLayout.CENTER,7,0));
	    PlayerControl1.setBounds(135,90,220,30);
	
	    PlayerControl1.add(LandL1);
		PlayerControl1.add(Back1);
	    PlayerControl1.add(PandP1);
		PlayerControl1.add(Skip1);
	    PlayerControl1.add(Reset1);
	    
		AlbumLabel1 = new JLabel();
		AlbumLabel1.setIcon(Album1.getIcon());
        AlbumLabel1.setBorder(null);

	    AlbumPanel1 = new JPanel();
	    AlbumPanel1.setBounds(10,10, 130,110);
		AlbumPanel1.setLayout(new BorderLayout());

		AlbumPanel1.add(AlbumLabel1, BorderLayout.CENTER);

		SongName1 = new JLabel();
		SongName1.setText("♪ " + Musics.Album1.getText());
		SongName1.setFont(new Font("Arial", Font.BOLD, 13));
		SongName1.setForeground(Color.LIGHT_GRAY);
        SongName1.setVerticalAlignment(JLabel.CENTER);
        SongName1.setHorizontalAlignment(JLabel.CENTER);
		SongName1.setVerticalTextPosition(JLabel.BOTTOM);
		SongName1.setHorizontalTextPosition(JLabel.CENTER);
		SongName1.setBounds(165, 20, 153, 19);

	    PlayerUI1 = new JPanel();
		PlayerUI1.setPreferredSize(new Dimension(360,0));
	    PlayerUI1.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
	    PlayerUI1.setLayout(null);
	    
	    PlayerUI1.add(Musics.AlbumPanel1);
	    PlayerUI1.add(SongName1);
		PlayerUI1.add(ProgressPosition1);
		PlayerUI1.add(ProgressLength1);
		PlayerUI1.add(MusicProgressSlider1);
	    PlayerUI1.add(Musics.PlayerControl1);

	    PlayerUI1.setVisible(true);
	    
	}
	
	protected static void NavigationSettings2() {
		
		ProgressPosition2 = new JLabel();
		ProgressPosition2.setText((int)(c2.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c2.getMicrosecondPosition() / 1000000) % 60));
		ProgressPosition2.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressPosition2.setForeground(Color.white);
		ProgressPosition2.setPreferredSize(new Dimension(100, 100));
		ProgressPosition2.setBounds(160, 20, 100, 100);

		ProgressLength2 = new JLabel();
		ProgressLength2.setText((int)(c2.getMicrosecondLength()/(60000000))+":" + String.format("%02d", (int) (c2.getMicrosecondLength() / 1000000) % 60));
		ProgressLength2.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressLength2.setForeground(Color.white);
		ProgressLength2.setPreferredSize(new Dimension(100, 100));
		ProgressLength2.setBounds(320, 20, 100, 100);
		
		MusicProgressSlider2 = new JSlider();
		MusicProgressSlider2.setUI(new ProgressUI(MusicProgressSlider2));
		MusicProgressSlider2.setMinimum(0);
		MusicProgressSlider2.setMaximum((int) c2.getMicrosecondLength() / 1000000);
		MusicProgressSlider2.setValue(0);
		MusicProgressSlider2.setOrientation(JSlider.HORIZONTAL);
		MusicProgressSlider2.setEnabled(false);
		MusicProgressSlider2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		MusicProgressSlider2.setPreferredSize(new Dimension(200, 20));
		MusicProgressSlider2.setBounds(150, 70, 200, 20);

		unLoop2 = new JButton();
		Loop2 = new JButton();
		
		LandL2 = new JPanel();
		LandL2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		LandL2.setPreferredSize(new Dimension(30,25));
		LandL2.setLayout(new BorderLayout());
		
		Play2 = new JButton();
		Pause2 = new JButton();
		
		PandP2 = new JPanel();
		PandP2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		PandP2.setPreferredSize(new Dimension(30,25));
		PandP2.setLayout(new BorderLayout());
		
		Reset2 = new JButton();
		
		Back2 = new JButton();
		Back2.setText("|◀");
		Back2.setFont(new Font("null", Font.BOLD, 12));
		Back2.setForeground(Color.black);
		Back2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Back2.setFocusable(false);
		Back2.setBorder(null);
		Back2.setPreferredSize(new Dimension(30, 25));
		Back2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Back2) {

					c2.setMicrosecondPosition((long) c2.getMicrosecondPosition() - 10 * 1000000);
					c2.start();

				}
			}

		});

		Play2.setText("▶");
		Play2.setVisible(false);
		Play2.setForeground(Color.black);
		Play2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Play2.setFocusable(false);
		Play2.setBorder(null);
		Play2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Play2) {
				   
					PandP2.add(Pause2);
					Pause2.setVisible(true);
					Play2.setVisible(false);
					PandP2.remove(Play2);
					
					c2.start();
					
				}
				
			}
			
		});
		

		Skip2 = new JButton();
		Skip2.setText("▶|");
		Skip2.setFont(new Font("null", Font.BOLD, 12));
		Skip2.setForeground(Color.black);
		Skip2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Skip2.setFocusable(false);
		Skip2.setBorder(null);
		Skip2.setPreferredSize(new Dimension(30, 25));
		Skip2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Skip2) {

					c2.setMicrosecondPosition((long) c2.getMicrosecondPosition() + 10 * 1000000);
					c2.start();

				}
			}
			
		});

		Pause2.setText("∥∥");
		Pause2.setVisible(true);
		Pause2.setForeground(Color.black);
		Pause2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Pause2.setFocusable(false);
		Pause2.setBorder(null);
		Pause2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Pause2) {
				   
					PandP2.add(Play2);
					Play2.setVisible(true);
					Play2.setEnabled(true);
					Pause2.setVisible(false);
					PandP2.remove(Pause2);
					
					c2.stop();
					
				}
				
			}
			
		});
		
		Reset2.setText("↻");
		Reset2.setForeground(Color.black);
		Reset2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Reset2.setFont(new Font("null", Font.BOLD, 18));
		Reset2.setFocusable(false);
		Reset2.setBorder(null);
		Reset2.setPreferredSize(new Dimension(30, 25));
		Reset2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == Reset2) {
				
					PandP2.add(Pause2);
					Pause2.setVisible(true);
					Play2.setVisible(false);
					PandP2.remove(Play2);

					c2.setMicrosecondPosition(0);
					c2.start();
				}
			}
			
		});
		
		
		unLoop2.setText("⇌");
		unLoop2.setVisible(true);
		unLoop2.setForeground(Color.black);
		unLoop2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		unLoop2.setFocusable(false);
		unLoop2.setFont(new Font("null", Font.BOLD, 18));
		unLoop2.setBorder(null);
		unLoop2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == unLoop2) {
					
				   LandL2.add(Loop2);
				   LandL2.remove(unLoop2);
				   Loop2.setVisible(true);
				   unLoop2.setVisible(false);
				   
				   c2.loop(Clip.LOOP_CONTINUOUSLY);
				   
				}
			}
			
		});
		
		Loop2.setText("⇌¹");
		Loop2.setVisible(false);
		Loop2.setForeground(Color.black);
		Loop2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Loop2.setFocusable(false);
		Loop2.setFont(new Font("null", Font.BOLD, 18));
		Loop2.setBorder(null);
		Loop2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Loop2) {
					
				   LandL2.add(unLoop2);
				   LandL2.remove(Loop2);
				   unLoop2.setVisible(true);  
				   Loop2.setVisible(false);
				   
				   c2.loop(0);
			
				   try {
					   Thread.sleep(1000);
				   }catch(InterruptedException e1) {
					   e1.printStackTrace();
				   }
				   
				}
				
			}
			
		});
	
		LandL2.add(unLoop2);
		
	    PandP2.add(Pause2);
	    
	    PlayerControl2 = new JPanel();
	    PlayerControl2.setBackground(new Color(0,0,0,0));
	    PlayerControl2.setLayout(new FlowLayout(FlowLayout.CENTER,7,0));
	    PlayerControl2.setBounds(135,90,220,30);
	    
	    PlayerControl2.add(LandL2);
		PlayerControl2.add(Back2);
	    PlayerControl2.add(PandP2);
		PlayerControl2.add(Skip2);
	    PlayerControl2.add(Reset2);
	    
		AlbumLabel2 = new JLabel();
		AlbumLabel2.setIcon(Album2.getIcon());
        AlbumLabel2.setBorder(null);

	    AlbumPanel2 = new JPanel();
	    AlbumPanel2.setBounds(10,10, 130,110);
		AlbumPanel2.setLayout(new BorderLayout());

		AlbumPanel2.add(AlbumLabel2, BorderLayout.CENTER);

		SongName2 = new JLabel();
		SongName2.setText("♪ " + Musics.Album2.getText());
		SongName2.setFont(new Font("Arial ", Font.BOLD, 13));
		SongName2.setForeground(Color.LIGHT_GRAY);
        SongName2.setVerticalAlignment(JLabel.CENTER);
        SongName2.setHorizontalAlignment(JLabel.CENTER);
		SongName2.setVerticalTextPosition(JLabel.BOTTOM);
		SongName2.setHorizontalTextPosition(JLabel.CENTER);
		SongName2.setBounds(165, 20, 153, 19);
		
	    PlayerUI2 = new JPanel();
		PlayerUI2.setPreferredSize(new Dimension(360,0));
	    PlayerUI2.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
	    PlayerUI2.setLayout(null);
	    
	    PlayerUI2.add(Musics.AlbumPanel2);
	    PlayerUI2.add(SongName2);
		PlayerUI2.add(ProgressPosition2);
		PlayerUI2.add(ProgressLength2);
		PlayerUI2.add(MusicProgressSlider2);
	    PlayerUI2.add(Musics.PlayerControl2);

	    PlayerUI2.setVisible(true);
	    
	}

	protected static void NavigationSettings3() {
		
		ProgressPosition3 = new JLabel();
		ProgressPosition3.setText((int)(c3.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c3.getMicrosecondPosition() / 1000000) % 60));
		ProgressPosition3.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressPosition3.setForeground(Color.white);
		ProgressPosition3.setPreferredSize(new Dimension(100, 100));
		ProgressPosition3.setBounds(160, 20, 100, 100);

		ProgressLength3 = new JLabel();
		ProgressLength3.setText((int)(c3.getMicrosecondLength()/(60000000))+":" + String.format("%02d", (int) (c3.getMicrosecondLength() / 1000000) % 60));
		ProgressLength3.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressLength3.setForeground(Color.white);
		ProgressLength3.setPreferredSize(new Dimension(100, 100));
		ProgressLength3.setBounds(320, 20, 100, 100);
		
		MusicProgressSlider3 = new JSlider();
		MusicProgressSlider3.setUI(new ProgressUI(MusicProgressSlider3));
		MusicProgressSlider3.setMinimum(0);
		MusicProgressSlider3.setMaximum((int) c3.getMicrosecondLength() / 1000000);
		MusicProgressSlider3.setValue(0);
		MusicProgressSlider3.setOrientation(JSlider.HORIZONTAL);
		MusicProgressSlider3.setEnabled(false);
		MusicProgressSlider3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		MusicProgressSlider3.setPreferredSize(new Dimension(200, 20));
		MusicProgressSlider3.setBounds(150, 70, 200, 20);

		unLoop3 = new JButton();
		Loop3 = new JButton();
		
		LandL3 = new JPanel();
		LandL3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		LandL3.setPreferredSize(new Dimension(30,25));
		LandL3.setLayout(new BorderLayout());
		
		Play3 = new JButton();
		Pause3 = new JButton();
		
		PandP3 = new JPanel();
		PandP3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		PandP3.setPreferredSize(new Dimension(30,25));
		PandP3.setLayout(new BorderLayout());
		
		Reset3 = new JButton();
		
		Back3 = new JButton();
		Back3.setText("|◀");
		Back3.setFont(new Font("null", Font.BOLD, 12));
		Back3.setForeground(Color.black);
		Back3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Back3.setFocusable(false);
		Back3.setBorder(null);
		Back3.setPreferredSize(new Dimension(30, 25));
		Back3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Back3) {

					c3.setMicrosecondPosition((long) c3.getMicrosecondPosition() - 10 * 1000000);
					c3.start();

				}
			}

		});

		Play3.setText("▶");
		Play3.setVisible(false);
		Play3.setForeground(Color.black);
		Play3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Play3.setFocusable(false);
		Play3.setBorder(null);
		Play3.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Play3) {
				   
					PandP3.add(Pause3);
					Pause3.setVisible(true);
					Play3.setVisible(false);
					PandP3.remove(Play3);
					
					c3.start();
					
				}
				
			}
			
		});
		
		Skip3 = new JButton();
		Skip3.setText("▶|");
		Skip3.setFont(new Font("null", Font.BOLD, 12));
		Skip3.setForeground(Color.black);
		Skip3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Skip3.setFocusable(false);
		Skip3.setBorder(null);
		Skip3.setPreferredSize(new Dimension(30, 25));
		Skip3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Skip3) {

					c3.setMicrosecondPosition((long) c3.getMicrosecondPosition() + 10 * 1000000);
					c3.start();

				}
			}
			
		});

		Pause3.setText("∥∥");
		Pause3.setVisible(true);
		Pause3.setForeground(Color.black);
		Pause3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Pause3.setFocusable(false);
		Pause3.setBorder(null);
		Pause3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Pause3) {
				   
					PandP3.add(Play3);
					Play3.setVisible(true);
					Play3.setEnabled(true);
					Pause3.setVisible(false);
					PandP3.remove(Pause3);
					
					c3.stop();
					
				}
				
			}
			
		});
		
		Reset3.setText("↻");
		Reset3.setForeground(Color.black);
		Reset3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Reset3.setFont(new Font("null", Font.BOLD, 18));
		Reset3.setFocusable(false);
		Reset3.setBorder(null);
		Reset3.setPreferredSize(new Dimension(30, 25));
		Reset3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == Reset3) {
				
					PandP3.add(Pause3);
					Pause3.setVisible(true);
					Play3.setVisible(false);
					PandP3.remove(Play3);
					
					c3.setMicrosecondPosition(0);
					c3.start();

				}
			}
			
		});
		
		
		unLoop3.setText("⇌");
		unLoop3.setVisible(true);
		unLoop3.setForeground(Color.black);
		unLoop3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		unLoop3.setFocusable(false);
		unLoop3.setFont(new Font("null", Font.BOLD, 18));
		unLoop3.setBorder(null);
		unLoop3.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == unLoop3) {
					
				   LandL3.add(Loop3);
				   LandL3.remove(unLoop3);
				   Loop3.setVisible(true);
				   unLoop3.setVisible(false);
				   
				   c3.loop(Clip.LOOP_CONTINUOUSLY);
				   
				}
			}
			
		});
		
		Loop3.setText("⇌¹");
		Loop3.setVisible(false);
		Loop3.setForeground(Color.black);
		Loop3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Loop3.setFocusable(false);
		Loop3.setFont(new Font("null", Font.BOLD, 18));
		Loop3.setBorder(null);
		Loop3.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Loop3) {
					
				   LandL3.add(unLoop3);
				   LandL3.remove(Loop3);
				   unLoop3.setVisible(true);  
				   Loop3.setVisible(false);
				   
				   c3.loop(0);
			
				   try {
					   Thread.sleep(1000);
				   }catch(InterruptedException e1) {
					   e1.printStackTrace();
				   }
				   
				}
				
			}
			
		});
	
		LandL3.add(unLoop3);
		
	    PandP3.add(Pause3);
	    
	    PlayerControl3 = new JPanel();
	    PlayerControl3.setBackground(new Color(0,0,0,0));
	    PlayerControl3.setLayout(new FlowLayout(FlowLayout.CENTER,7,0));
	    PlayerControl3.setBounds(135,90,220,30);
	    
	    PlayerControl3.add(LandL3);
		PlayerControl3.add(Back3);
	    PlayerControl3.add(PandP3);
		PlayerControl3.add(Skip3);
	    PlayerControl3.add(Reset3);
	    
		AlbumLabel3 = new JLabel();
		AlbumLabel3.setIcon(Album3.getIcon());
        AlbumLabel3.setBorder(null);

	    AlbumPanel3 = new JPanel();
	    AlbumPanel3.setBounds(10,10, 130,110);
		AlbumPanel3.setLayout(new BorderLayout());

		AlbumPanel3.add(AlbumLabel3, BorderLayout.CENTER);

		SongName3 = new JLabel();
		SongName3.setText("♪ " + Musics.Album3.getText());
		SongName3.setFont(new Font("Arial ", Font.BOLD, 13));
		SongName3.setForeground(Color.LIGHT_GRAY);
        SongName3.setVerticalAlignment(JLabel.CENTER);
        SongName3.setHorizontalAlignment(JLabel.CENTER);
		SongName3.setVerticalTextPosition(JLabel.BOTTOM);
		SongName3.setHorizontalTextPosition(JLabel.CENTER);
		SongName3.setBounds(165, 20, 153, 19);
		
	    PlayerUI3 = new JPanel();
	    PlayerUI3.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
	    PlayerUI3.setPreferredSize(new Dimension(360,0));
	    PlayerUI3.setLayout(null);
	    
	    PlayerUI3.add(Musics.AlbumPanel3);
	    PlayerUI3.add(SongName3);
		PlayerUI3.add(ProgressPosition3);
		PlayerUI3.add(ProgressLength3);
		PlayerUI3.add(MusicProgressSlider3);
	    PlayerUI3.add(Musics.PlayerControl3);
	    
	    PlayerUI3.setVisible(false);
	    
	}
	
	protected static void NavigationSettings4() {
		
		ProgressPosition4 = new JLabel();
		ProgressPosition4.setText((int)(c4.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c4.getMicrosecondPosition() / 1000000) % 60));
		ProgressPosition4.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressPosition4.setForeground(Color.white);
		ProgressPosition4.setPreferredSize(new Dimension(100, 100));
		ProgressPosition4.setBounds(160, 20, 100, 100);

		ProgressLength4 = new JLabel();
		ProgressLength4.setText((int)(c4.getMicrosecondLength()/(60000000))+":" + String.format("%02d", (int) (c4.getMicrosecondLength() / 1000000) % 60));
		ProgressLength4.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressLength4.setForeground(Color.white);
		ProgressLength4.setPreferredSize(new Dimension(100, 100));
		ProgressLength4.setBounds(320, 20, 100, 100);
		
		MusicProgressSlider4 = new JSlider();
		MusicProgressSlider4.setUI(new ProgressUI(MusicProgressSlider4));
		MusicProgressSlider4.setMinimum(0);
		MusicProgressSlider4.setMaximum((int) c4.getMicrosecondLength() / 1000000);
		MusicProgressSlider4.setValue(0);
		MusicProgressSlider4.setOrientation(JSlider.HORIZONTAL);
		MusicProgressSlider4.setEnabled(false);
		MusicProgressSlider4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		MusicProgressSlider4.setPreferredSize(new Dimension(200, 20));
		MusicProgressSlider4.setBounds(150, 70, 200, 20);

		unLoop4 = new JButton();
		Loop4 = new JButton();
		
		LandL4 = new JPanel();
		LandL4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		LandL4.setPreferredSize(new Dimension(30,25));
		LandL4.setLayout(new BorderLayout());
		
		Play4 = new JButton();
		Pause4 = new JButton();
		
		PandP4 = new JPanel();
		PandP4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		PandP4.setPreferredSize(new Dimension(30,25));
		PandP4.setLayout(new BorderLayout());
		
		Reset4 = new JButton();
		
		Back4 = new JButton();
		Back4.setText("|◀");
		Back4.setFont(new Font("null", Font.BOLD, 12));
		Back4.setForeground(Color.black);
		Back4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Back4.setFocusable(false);
		Back4.setBorder(null);
		Back4.setPreferredSize(new Dimension(30, 25));
		Back4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Back4) {

					c4.setMicrosecondPosition((long) c4.getMicrosecondPosition() - 10 * 1000000);
					c4.start();

				}
			}

		});

		Play4.setText("▶");
		Play4.setVisible(false);
		Play4.setForeground(Color.black);
		Play4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Play4.setFocusable(false);
		Play4.setBorder(null);
		Play4.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Play4) {
				   
	       		    PandP4.add(Pause4);
					Pause4.setVisible(true);
					Play4.setVisible(false);
					PandP4.remove(Play4);
					
					c4.start();
				}
				
			}
			
		});
		
		Skip4 = new JButton();
		Skip4.setText("▶|");
		Skip4.setFont(new Font("null", Font.BOLD, 12));
		Skip4.setForeground(Color.black);
		Skip4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Skip4.setFocusable(false);
		Skip4.setBorder(null);
		Skip4.setPreferredSize(new Dimension(30, 25));
		Skip4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Skip4) {

					c4.setMicrosecondPosition((long) c4.getMicrosecondPosition() + 10 * 1000000);
					c4.start();

				}
			}
			
		});

		Pause4.setText("∥∥");
		Pause4.setVisible(true);
		Pause4.setForeground(Color.black);
		Pause4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Pause4.setFocusable(false);
		Pause4.setBorder(null);
		Pause4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Pause4) {
				   
					PandP4.add(Play4);
					Play4.setVisible(true);
					Pause4.setVisible(false);
					PandP4.remove(Pause4);
					
					c4.stop();
					
				}
				
			}
			
		});
		
		Reset4.setText("↻");
		Reset4.setForeground(Color.black);
		Reset4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Reset4.setFont(new Font("null", Font.BOLD, 18));
		Reset4.setFocusable(false);
		Reset4.setBorder(null);
		Reset4.setPreferredSize(new Dimension(30, 25));
		Reset4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == Reset4) {
				
					PandP4.add(Pause4);
					Pause4.setVisible(true);
					Play4.setVisible(false);
					PandP4.remove(Play4);
					
					c4.setMicrosecondPosition(0);
					c4.start();
				}
			}
			
		});
		
		
		unLoop4.setText("⇌");
		unLoop4.setVisible(true);
		unLoop4.setForeground(Color.black);
		unLoop4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		unLoop4.setFocusable(false);
		unLoop4.setFont(new Font("null", Font.BOLD, 18));
		unLoop4.setBorder(null);
		unLoop4.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == unLoop4) {
					
				   LandL4.add(Loop4);
				   LandL4.remove(unLoop4);
				   Loop4.setVisible(true);
				   unLoop4.setVisible(false);
				   
				   PandP4.add(Pause4);
				   Pause4.setVisible(true);
				   Play4.setVisible(false);
				   PandP4.remove(Play4);
					
				   c4.loop(Clip.LOOP_CONTINUOUSLY);
				   
				}
			}
			
		});
		
		Loop4.setText("⇌¹");
		Loop4.setVisible(false);
	    Loop4.setForeground(Color.black);
		Loop4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Loop4.setFocusable(false);
		Loop4.setFont(new Font("null", Font.BOLD, 18));
		Loop4.setBorder(null);
		Loop4.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Loop4) {
					
				   LandL4.add(unLoop4);
				   LandL4.remove(Loop4);
				   unLoop4.setVisible(true);  
				   Loop4.setVisible(false);
				   
				   PandP4.add(Pause4);
				   Pause4.setVisible(true);
				   Play4.setVisible(false);
				   PandP4.remove(Play4);
				   
				   c4.loop(0);
				   
				}
				
			}
			
		});
	
		LandL4.add(unLoop4);
		
	    PandP4.add(Pause4);
	    
	    PlayerControl4 = new JPanel();
	    PlayerControl4.setBackground(new Color(0,0,0,0));
	    PlayerControl4.setLayout(new FlowLayout(FlowLayout.CENTER,7,0));
	    PlayerControl4.setBounds(135,90,220,30);
	    
	    PlayerControl4.add(LandL4);
		PlayerControl4.add(Back4);
	    PlayerControl4.add(PandP4);
		PlayerControl4.add(Skip4);
	    PlayerControl4.add(Reset4);
	    
		AlbumLabel4 = new JLabel();
		AlbumLabel4.setIcon(Album4.getIcon());
        AlbumLabel4.setBorder(null);

	    AlbumPanel4 = new JPanel();
	    AlbumPanel4.setBounds(10,10, 130,110);
		AlbumPanel4.setLayout(new BorderLayout());

		AlbumPanel4.add(AlbumLabel4, BorderLayout.CENTER);

		SongName4 = new JLabel();
		SongName4.setText("♪ " + Musics.Album4.getText());
		SongName4.setFont(new Font("Arial", Font.BOLD, 13));
		SongName4.setForeground(Color.LIGHT_GRAY);
        SongName4.setVerticalAlignment(JLabel.CENTER);
        SongName4.setHorizontalAlignment(JLabel.CENTER);
		SongName4.setVerticalTextPosition(JLabel.BOTTOM);
		SongName4.setHorizontalTextPosition(JLabel.CENTER);
		SongName4.setBounds(165, 20, 163, 19);

	    PlayerUI4 = new JPanel();
		PlayerUI4.setPreferredSize(new Dimension(360,0));
	    PlayerUI4.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
	    PlayerUI4.setLayout(null);
	    
	    PlayerUI4.add(Musics.AlbumPanel4);
	    PlayerUI4.add(SongName4);
		PlayerUI4.add(ProgressPosition4);
		PlayerUI4.add(ProgressLength4);
		PlayerUI4.add(MusicProgressSlider4);
	    PlayerUI4.add(Musics.PlayerControl4);
	    
	    PlayerUI4.setVisible(true);
	    
	}

    protected static void NavigationSettings5() {
		
		ProgressPosition5 = new JLabel();
		ProgressPosition5.setText((int)(c5.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c5.getMicrosecondPosition() / 1000000) % 60));
		ProgressPosition5.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressPosition5.setForeground(Color.white);
		ProgressPosition5.setPreferredSize(new Dimension(100, 100));
		ProgressPosition5.setBounds(160, 20, 100, 100);

		ProgressLength5 = new JLabel();
		ProgressLength5.setText((int)(c5.getMicrosecondLength()/(60000000))+":" + String.format("%02d", (int) (c5.getMicrosecondLength() / 1000000) % 60));
		ProgressLength5.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressLength5.setForeground(Color.white);
		ProgressLength5.setPreferredSize(new Dimension(100, 100));
		ProgressLength5.setBounds(320, 20, 100, 100);
		
		MusicProgressSlider5 = new JSlider();
		MusicProgressSlider5.setUI(new ProgressUI(MusicProgressSlider5));
		MusicProgressSlider5.setMinimum(0);
		MusicProgressSlider5.setMaximum((int) c5.getMicrosecondLength() / 1000000);
		MusicProgressSlider5.setValue(0);
		MusicProgressSlider5.setOrientation(JSlider.HORIZONTAL);
		MusicProgressSlider5.setEnabled(false);
		MusicProgressSlider5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		MusicProgressSlider5.setPreferredSize(new Dimension(200, 20));
		MusicProgressSlider5.setBounds(150, 70, 200, 20);

		unLoop5 = new JButton();
		Loop5 = new JButton();
		
		LandL5 = new JPanel();
		LandL5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		LandL5.setPreferredSize(new Dimension(30,25));
		LandL5.setLayout(new BorderLayout());
		
		Play5 = new JButton();
		Pause5 = new JButton();
		
		PandP5 = new JPanel();
		PandP5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		PandP5.setPreferredSize(new Dimension(30,25));
		PandP5.setLayout(new BorderLayout());
		
		Reset5 = new JButton();
		
		Back5 = new JButton();
		Back5.setText("|◀");
		Back5.setFont(new Font("null", Font.BOLD, 12));
		Back5.setForeground(Color.black);
		Back5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Back5.setFocusable(false);
		Back5.setBorder(null);
		Back5.setPreferredSize(new Dimension(30, 25));
		Back5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Back5) {

					c5.setMicrosecondPosition((long) c5.getMicrosecondPosition() - 10 * 1000000);
					c5.start();

				}
			}

		});

		Play5.setText("▶");
		Play5.setVisible(false);
		Play5.setForeground(Color.black);
		Play5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Play5.setFocusable(false);
		Play5.setBorder(null);
		Play5.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Play5) {
				   
	       		    PandP5.add(Pause5);
					Pause5.setVisible(true);
					Play5.setVisible(false);
					PandP5.remove(Play5);
					
					c5.start();
				}
				
			}
			
		});
		
		Skip5 = new JButton();
		Skip5.setText("▶|");
		Skip5.setFont(new Font("null", Font.BOLD, 12));
		Skip5.setForeground(Color.black);
		Skip5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Skip5.setFocusable(false);
		Skip5.setBorder(null);
		Skip5.setPreferredSize(new Dimension(30, 25));
		Skip5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Skip5) {

					c5.setMicrosecondPosition((long) c5.getMicrosecondPosition() + 10 * 1000000);
					c5.start();

				}
			}
			
		});

		Pause5.setText("∥∥");
		Pause5.setVisible(true);
		Pause5.setForeground(Color.black);
		Pause5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Pause5.setFocusable(false);
		Pause5.setBorder(null);
		Pause5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Pause5) {
				   
					PandP5.add(Play5);
					Play5.setVisible(true);
					Pause5.setVisible(false);
					PandP5.remove(Pause5);
					
					c5.stop();
					
				}
				
			}
			
		});
		
		Reset5.setText("↻");
		Reset5.setForeground(Color.black);
		Reset5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Reset5.setFont(new Font("null", Font.BOLD, 18));
		Reset5.setFocusable(false);
		Reset5.setBorder(null);
		Reset5.setPreferredSize(new Dimension(30, 25));
		Reset5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == Reset5) {
				
					PandP5.add(Pause5);
					Pause5.setVisible(true);
					Play5.setVisible(false);
					PandP5.remove(Play5);
					
					c5.setMicrosecondPosition(0);
					c5.start();
				}
			}
			
		});
		
		
		unLoop5.setText("⇌");
		unLoop5.setVisible(true);
		unLoop5.setFocusable(false);
		unLoop5.setFont(new Font("null", Font.BOLD, 18));
		unLoop5.setBorder(null);
		unLoop5.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == unLoop5) {
					
				   LandL5.add(Loop5);
				   LandL5.remove(unLoop5);
				   Loop5.setVisible(true);
				   unLoop5.setVisible(false);
				   
				   c5.loop(Clip.LOOP_CONTINUOUSLY);
				   
				}
			}
			
		});
		
		Loop5.setText("⇌¹");
		Loop5.setVisible(false);
		Loop5.setForeground(Color.black);
		Loop5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Loop5.setFocusable(false);
		Loop5.setFont(new Font("null", Font.BOLD, 18));
		Loop5.setBorder(null);
		Loop5.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Loop5) {
					
				   LandL5.add(unLoop5);
				   LandL5.remove(Loop5);
				   unLoop5.setVisible(true);  
				   Loop5.setVisible(false);
				   
				   c5.loop(0);
				   
				}
				
			}
			
		});
	
		LandL5.add(unLoop5);
		
	    PandP5.add(Pause5);
	    
	    PlayerControl5 = new JPanel();
	    PlayerControl5.setBackground(new Color(0,0,0,0));
	    PlayerControl5.setLayout(new FlowLayout(FlowLayout.CENTER,7,0));
	    PlayerControl5.setBounds(135,90,220,30);
	    
	    PlayerControl5.add(LandL5);
		PlayerControl5.add(Back5);
	    PlayerControl5.add(PandP5);
		PlayerControl5.add(Skip5);
	    PlayerControl5.add(Reset5);
	    
		AlbumLabel5 = new JLabel();
		AlbumLabel5.setIcon(Album5.getIcon());
        AlbumLabel5.setBorder(null);

	    AlbumPanel5 = new JPanel();
	    AlbumPanel5.setBounds(10,10, 130,110);
		AlbumPanel5.setLayout(new BorderLayout());

		AlbumPanel5.add(AlbumLabel5, BorderLayout.CENTER);

		SongName5 = new JLabel();
		SongName5.setText("♪ " + Musics.Album5.getText());
		SongName5.setFont(new Font("Arial", Font.BOLD, 13));
		SongName5.setForeground(Color.LIGHT_GRAY);
        SongName5.setVerticalAlignment(JLabel.CENTER);
        SongName5.setHorizontalAlignment(JLabel.CENTER);
		SongName5.setVerticalTextPosition(JLabel.BOTTOM);
		SongName5.setHorizontalTextPosition(JLabel.CENTER);
		SongName5.setBounds(165, 20, 153, 19);

	    PlayerUI5 = new JPanel();
		PlayerUI5.setPreferredSize(new Dimension(360,0));
	    PlayerUI5.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
	    PlayerUI5.setLayout(null);
	    
	    PlayerUI5.add(Musics.AlbumPanel5);
	    PlayerUI5.add(SongName5);
		PlayerUI5.add(ProgressPosition5);
		PlayerUI5.add(ProgressLength5);
		PlayerUI5.add(MusicProgressSlider5);
		PlayerUI5.add(Musics.PlayerControl5);
	    
	    PlayerUI5.setVisible(true);
	    
	}

	protected static void NavigationSettings6() {
		
		ProgressPosition6 = new JLabel();
		ProgressPosition6.setText((int)(c6.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c6.getMicrosecondPosition() / 1000000) % 60));
		ProgressPosition6.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressPosition6.setForeground(Color.white);
		ProgressPosition6.setPreferredSize(new Dimension(100, 100));
		ProgressPosition6.setBounds(160, 20, 100, 100);

		ProgressLength6 = new JLabel();
		ProgressLength6.setText((int)(c6.getMicrosecondLength()/(60000000))+":" + String.format("%02d", (int) (c6.getMicrosecondLength() / 1000000) % 60));
		ProgressLength6.setFont(new Font("Calibri", Font.BOLD, 12));
		ProgressLength6.setForeground(Color.white);
		ProgressLength6.setPreferredSize(new Dimension(100, 100));
		ProgressLength6.setBounds(320, 20, 100, 100);
		
		MusicProgressSlider6 = new JSlider();
		MusicProgressSlider6.setUI(new ProgressUI(MusicProgressSlider6));
		MusicProgressSlider6.setMinimum(0);
		MusicProgressSlider6.setMaximum((int) c6.getMicrosecondLength() / 1000000);
		MusicProgressSlider6.setValue(0);
		MusicProgressSlider6.setOrientation(JSlider.HORIZONTAL);
		MusicProgressSlider6.setEnabled(false);
		MusicProgressSlider6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		MusicProgressSlider6.setPreferredSize(new Dimension(200, 20));
		MusicProgressSlider6.setBounds(150, 70, 200, 20);

		unLoop6 = new JButton();
		Loop6 = new JButton();
		
		LandL6 = new JPanel();
		LandL6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		LandL6.setPreferredSize(new Dimension(30,25));
		LandL6.setLayout(new BorderLayout());

		Play6 = new JButton();
		Pause6 = new JButton();
		
		PandP6 = new JPanel();
		PandP6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		PandP6.setPreferredSize(new Dimension(30,25));
		PandP6.setLayout(new BorderLayout());
		
		Reset6 = new JButton();
		
		Back6 = new JButton();
		Back6.setText("|◀");
		Back6.setFont(new Font("null", Font.BOLD, 12));
		Back6.setForeground(Color.black);
		Back6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Back6.setFocusable(false);
		Back6.setBorder(null);
		Back6.setPreferredSize(new Dimension(30, 25));
		Back6.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
				Back6.setBackground(FocusableColor);

			}

			public void mouseExited(MouseEvent e) {
				
				Back6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));

			}

		});

		Back6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Back6) {

					c6.setMicrosecondPosition((long) c6.getMicrosecondPosition() - 10 * 1000000);
					c6.start();

				}
			}

		});

		Play6.setText("▶");
		Play6.setVisible(false);
		Play6.setForeground(Color.black);
		Play6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Play6.setFocusable(false);
		Play6.setBorder(null);
		Play6.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
				Play6.setBackground(FocusableColor);

			}

			public void mouseExited(MouseEvent e) {
				
				Play6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));

			}

		});

		Play6.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Play6) {
				   
	       		    PandP6.add(Pause6);
					Pause6.setVisible(true);
					Play6.setVisible(false);
					PandP6.remove(Play6);
					
					c6.start();
				}
				
			}
			
		});
		
		Pause6.setText("∥∥");
		Pause6.setVisible(true);
		Pause6.setForeground(Color.black);
		Pause6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Pause6.setFocusable(false);
		Pause6.setBorder(null);
		Pause6.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
				Pause6.setBackground(FocusableColor);

			}

			public void mouseExited(MouseEvent e) {
				
				Pause6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));

			}

		});

		Pause6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Pause6) {
				   
					PandP6.add(Play6);
					Play6.setVisible(true);
					Pause6.setVisible(false);
					PandP6.remove(Pause6);
					
					c6.stop();
					
				}
				
			}
			
		});
		
		Skip6 = new JButton();
		Skip6.setText("▶|");
		Skip6.setFont(new Font("null", Font.BOLD, 12));
		Skip6.setForeground(Color.black);
		Skip6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Skip6.setFocusable(false);
		Skip6.setBorder(null);
		Skip6.setPreferredSize(new Dimension(30, 25));
		Skip6.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
				Skip6.setBackground(FocusableColor);

			}

			public void mouseExited(MouseEvent e) {
				
				Skip6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));

			}

		});

		Skip6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(e.getSource() == Skip6) {

					c6.setMicrosecondPosition((long) c6.getMicrosecondPosition() + 10 * 1000000);
					c6.start();

				}
			}
			
		});
	
		Reset6.setText("↻");
		Reset6.setForeground(Color.black);
		Reset6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		Reset6.setFont(new Font("null", Font.BOLD, 18));
		Reset6.setFocusable(false);
		Reset6.setBorder(null);
		Reset6.setPreferredSize(new Dimension(30, 25));
		Reset6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource() == Reset6) {
				
					PandP6.add(Pause6);
					Pause6.setVisible(true);
					Play6.setVisible(false);
					PandP6.remove(Play6);
					
					c6.setMicrosecondPosition(0);
					c6.start();
				}
			}
			
		});
		
		
		unLoop6.setText("⇌");
		unLoop6.setVisible(true);
		unLoop6.setForeground(Color.black);
		unLoop6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
		unLoop6.setFocusable(false);
		unLoop6.setFont(new Font("null", Font.BOLD, 18));
		unLoop6.setBorder(null);
		unLoop6.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == unLoop6) {
					
				   LandL6.add(Loop6);
				   LandL6.remove(unLoop6);
				   Loop6.setVisible(true);
				   unLoop6.setVisible(false);
				   
				   c6.loop(Clip.LOOP_CONTINUOUSLY);
				   
				}
			}
			
		});
		
		Loop6.setText("⇌¹");
		Loop6.setVisible(false);
		Loop6.setForeground(Color.black);
		Loop6.setBackground(new Color(AppColor[0],AppColor[1],AppColor[2]));
		Loop6.setFocusable(false);
		Loop6.setFont(new Font("null", Font.BOLD, 18));
		Loop6.setBorder(null);
		Loop6.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Loop6) {
					
				   LandL6.add(unLoop6);
				   LandL6.remove(Loop6);
				   unLoop6.setVisible(true);  
				   Loop6.setVisible(false);
				   
				   c6.loop(0);
				   
				}
				
			}
			
		});
	
		LandL6.add(unLoop6);
		
	    PandP6.add(Pause6);
	    
	    PlayerControl6 = new JPanel();
	    PlayerControl6.setBackground(new Color(0,0,0,0));
	    PlayerControl6.setLayout(new FlowLayout(FlowLayout.CENTER,7,0));
	    PlayerControl6.setBounds(135,90,220,30);
	
	    PlayerControl6.add(LandL6);
		PlayerControl6.add(Back6);
	    PlayerControl6.add(PandP6);
		PlayerControl6.add(Skip6);
	    PlayerControl6.add(Reset6);
	    
		AlbumLabel6 = new JLabel();
		AlbumLabel6.setIcon(Album6.getIcon());
        AlbumLabel6.setBorder(null);

	    AlbumPanel6 = new JPanel();
	    AlbumPanel6.setBounds(10,10, 130,110);
		AlbumPanel6.setLayout(new BorderLayout());

		AlbumPanel6.add(AlbumLabel6, BorderLayout.CENTER);

		SongName6 = new JLabel();
		SongName6.setText("♪ " + Musics.Album6.getText());
		SongName6.setFont(new Font("Arial", Font.BOLD, 13));
		SongName6.setForeground(Color.LIGHT_GRAY);
        SongName6.setVerticalAlignment(JLabel.CENTER);
        SongName6.setHorizontalAlignment(JLabel.CENTER);
		SongName6.setVerticalTextPosition(JLabel.BOTTOM);
		SongName6.setHorizontalTextPosition(JLabel.CENTER);
		SongName6.setBounds(165, 20, 153, 19);

	    PlayerUI6 = new JPanel();
		PlayerUI6.setPreferredSize(new Dimension(360,0));
	    PlayerUI6.setBackground(new Color(AppColor[0], AppColor[1], AppColor[2]));
	    PlayerUI6.setLayout(null);
	    
	    PlayerUI6.add(Musics.AlbumPanel6);
	    PlayerUI6.add(SongName6);
		PlayerUI6.add(ProgressPosition6);
		PlayerUI6.add(ProgressLength6);
		PlayerUI6.add(MusicProgressSlider6);
	    PlayerUI6.add(Musics.PlayerControl6);

	    PlayerUI6.setVisible(true);
	    
	}

	protected static AbstractAction action = new AbstractAction() {
	private static final long serialVersionUID = 1L;

	public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == Musics.M1Button) {

					StopMusicButton.setVisible(true);

					float volume =  VolumeSlider.getValue() / Maximum;
				    VolumeControl = (FloatControl) c1.getControl(FloatControl.Type.MASTER_GAIN);
				    VolumeControl.setValue(20f * (float) Math.log(volume));

					TrackPanel.setVisible(false);
					try{
						Thread.sleep(100);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					TrackPanel.setVisible(true);

					PandP1.add(Pause1);
					Pause1.setVisible(true);
					Play1.setVisible(false);
					PandP1.remove(Play1);

					MusicTrackPanel.remove(PlayerUI2);
					PlayerUI2.setVisible(false);

					MusicTrackPanel.remove(PlayerUI3);
					PlayerUI3.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI4);
					PlayerUI4.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI5);
					PlayerUI5.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI6);
					PlayerUI6.setVisible(false);

					PlayerUI1.setVisible(true);
					MusicTrackPanel.add(PlayerUI1);

					Musics.c1.setMicrosecondPosition(0);
					Musics.c1.start();

					Musics.c2.stop();
					Musics.c3.stop();
					Musics.c4.stop();
					Musics.c5.stop();
					Musics.c6.stop();
					
				}
			
				if(e.getSource() == Musics.M2Button) {

					StopMusicButton.setVisible(true);

					float volume =  VolumeSlider.getValue() / Maximum;
				    VolumeControl = (FloatControl) c2.getControl(FloatControl.Type.MASTER_GAIN);
				    VolumeControl.setValue(20f * (float) Math.log(volume));

					TrackPanel.setVisible(false);
					try{
						Thread.sleep(100);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					TrackPanel.setVisible(true);

					PandP2.add(Pause2);
					Pause2.setVisible(true);
					Play2.setVisible(false);
					PandP2.remove(Play2);

					MusicTrackPanel.remove(PlayerUI1);
					PlayerUI1.setVisible(false);

					MusicTrackPanel.remove(PlayerUI3);
					PlayerUI3.setVisible(false);

					MusicTrackPanel.remove(PlayerUI4);
					PlayerUI4.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI5);
					PlayerUI5.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI6);
					PlayerUI6.setVisible(false);

					PlayerUI2.setVisible(true);
					MusicTrackPanel.add(PlayerUI2);
					
					Musics.c2.setMicrosecondPosition(0);
					Musics.c2.start();
					
					Musics.c1.stop();					
					Musics.c3.stop();
					Musics.c4.stop();
					Musics.c5.stop();
					Musics.c6.stop();
					
				}

				if(e.getSource() == Musics.M3Button) {

					StopMusicButton.setVisible(true);

					float volume =  VolumeSlider.getValue() / Maximum;
				    VolumeControl = (FloatControl) c3.getControl(FloatControl.Type.MASTER_GAIN);
				    VolumeControl.setValue(20f * (float) Math.log(volume));

					TrackPanel.setVisible(false);
					try{
						Thread.sleep(100);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					TrackPanel.setVisible(true);

					PandP3.add(Pause3);
					Pause3.setVisible(true);
					Play3.setVisible(false);
					PandP3.remove(Play3);

					MusicTrackPanel.remove(PlayerUI1);
					PlayerUI1.setVisible(false);

					MusicTrackPanel.remove(PlayerUI2);
					PlayerUI2.setVisible(false);

					MusicTrackPanel.remove(PlayerUI4);
					PlayerUI4.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI5);
					PlayerUI5.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI6);
					PlayerUI6.setVisible(false);

					PlayerUI3.setVisible(true);
					MusicTrackPanel.add(PlayerUI3);
					
					Musics.c3.setMicrosecondPosition(0);
					Musics.c3.start();
					
					Musics.c1.stop();					
					Musics.c2.stop();
					Musics.c4.stop();
					Musics.c5.stop();
					Musics.c6.stop();

				}

				if(e.getSource() == Musics.M4Button) {

					StopMusicButton.setVisible(true);

					float volume =  VolumeSlider.getValue() / Maximum;
				    VolumeControl = (FloatControl) c4.getControl(FloatControl.Type.MASTER_GAIN);
				    VolumeControl.setValue(20f * (float) Math.log(volume));

					TrackPanel.setVisible(false);
					try{
						Thread.sleep(100);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					TrackPanel.setVisible(true);

					PandP4.add(Pause4);
					Pause4.setVisible(true);
					Play4.setVisible(false);
					PandP4.remove(Play4);

					MusicTrackPanel.remove(PlayerUI1);
					PlayerUI1.setVisible(false);

					MusicTrackPanel.remove(PlayerUI2);
					PlayerUI2.setVisible(false);

					MusicTrackPanel.remove(PlayerUI3);
					PlayerUI3.setVisible(false);

					MusicTrackPanel.remove(PlayerUI5);
					PlayerUI5.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI6);
					PlayerUI6.setVisible(false);

					PlayerUI4.setVisible(true);
					MusicTrackPanel.add(PlayerUI4);
					
					Musics.c4.setMicrosecondPosition(0);
					Musics.c4.start();
					
					Musics.c1.stop();					
					Musics.c2.stop();
					Musics.c3.stop();
					Musics.c5.stop();
					Musics.c6.stop();
	
				}
				
				
				if(e.getSource() == Musics.M5Button) {

					StopMusicButton.setVisible(true);

					float volume =  VolumeSlider.getValue() / Maximum;
				    VolumeControl = (FloatControl) c5.getControl(FloatControl.Type.MASTER_GAIN);
				    VolumeControl.setValue(20f * (float) Math.log(volume));

					TrackPanel.setVisible(false);
					try{
						Thread.sleep(100);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					TrackPanel.setVisible(true);

					PandP5.add(Pause5);
					Pause5.setVisible(true);
					Play5.setVisible(false);
					PandP5.remove(Play5);

					MusicTrackPanel.remove(PlayerUI1);
					PlayerUI1.setVisible(false);

					MusicTrackPanel.remove(PlayerUI2);
					PlayerUI2.setVisible(false);

					MusicTrackPanel.remove(PlayerUI3);
					PlayerUI3.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI4);
					PlayerUI4.setVisible(false);

					MusicTrackPanel.remove(PlayerUI6);
					PlayerUI6.setVisible(false);

					PlayerUI5.setVisible(true);
					MusicTrackPanel.add(PlayerUI5);

					Musics.c5.setMicrosecondPosition(0);
					Musics.c5.start();
					
					Musics.c1.stop();					
					Musics.c2.stop();
					Musics.c3.stop();
					Musics.c4.stop();
					Musics.c6.stop();

				}

				if(e.getSource() == Musics.M6Button) {

					StopMusicButton.setVisible(true);

					float volume =  VolumeSlider.getValue() / Maximum;
				    VolumeControl = (FloatControl) c6.getControl(FloatControl.Type.MASTER_GAIN);
				    VolumeControl.setValue(20f * (float) Math.log(volume));

					TrackPanel.setVisible(false);
					try{
						Thread.sleep(100);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					TrackPanel.setVisible(true);

					PandP6.add(Pause6);
					Pause6.setVisible(true);
					Play6.setVisible(false);
					PandP6.remove(Play6);

					MusicTrackPanel.remove(PlayerUI1);
					PlayerUI1.setVisible(false);

					MusicTrackPanel.remove(PlayerUI2);
					PlayerUI2.setVisible(false);

					MusicTrackPanel.remove(PlayerUI3);
					PlayerUI3.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI4);
					PlayerUI4.setVisible(false);
					
					MusicTrackPanel.remove(PlayerUI5);
					PlayerUI5.setVisible(false);
					
					PlayerUI6.setVisible(true);
					MusicTrackPanel.add(PlayerUI6);

					Musics.c6.setMicrosecondPosition(0);
					Musics.c6.start();

					Musics.c1.stop();
					Musics.c2.stop();
					Musics.c3.stop();
					Musics.c4.stop();
					Musics.c5.stop();
					
				}

				if(e.getSource() == StopMusicButton) {

					StopMusicButton.setVisible(false);

					TrackPanel.setVisible(false);
					PlayerFrame.repaint();

					Musics.c1.stop();
					Musics.c2.stop();
					Musics.c3.stop();
					Musics.c4.stop();
					Musics.c5.stop();
					Musics.c6.stop();

				}
			}
			
		};

	protected static ChangeListener change1 = new ChangeListener() {

		public void stateChanged(ChangeEvent e) {

            if(e.getSource() == VolumeSlider) {
				
				float volume = (float) VolumeSlider.getValue() / Maximum;
				VolumeControl = (FloatControl) c1.getControl(FloatControl.Type.MASTER_GAIN);
				VolumeControl.setValue(20f * (float) Math.log(volume));
			}

            if(e.getSource() == VolumeSlider) {
				
				float volume = (float) VolumeSlider.getValue() / Maximum;
				VolumeControl = (FloatControl) c2.getControl(FloatControl.Type.MASTER_GAIN);
				VolumeControl.setValue(20f * (float) Math.log(volume));
			}

            if(e.getSource() == VolumeSlider) {
				
				float volume = (float) VolumeSlider.getValue() / Maximum;
				VolumeControl = (FloatControl) c3.getControl(FloatControl.Type.MASTER_GAIN);
				VolumeControl.setValue(20f * (float) Math.log(volume));
			}

			if(e.getSource() == VolumeSlider) {
				
				float volume = (float) VolumeSlider.getValue() / Maximum;
				VolumeControl = (FloatControl) c4.getControl(FloatControl.Type.MASTER_GAIN);
				VolumeControl.setValue(20f * (float) Math.log(volume));
			}

			if(e.getSource() == VolumeSlider) {
			
				float volume = (float) VolumeSlider.getValue() / Maximum;
				VolumeControl = (FloatControl) c5.getControl(FloatControl.Type.MASTER_GAIN);
				VolumeControl.setValue(20f * (float) Math.log(volume));
				
			}
			
			if(e.getSource() == VolumeSlider) {
				
				float volume = (float) VolumeSlider.getValue() / Maximum;
				VolumeControl = (FloatControl) c6.getControl(FloatControl.Type.MASTER_GAIN);
				VolumeControl.setValue(20f * (float) Math.log(volume));
			}

			if(e.getSource() == VolumeSlider) {

				int value = VolumeSlider.getValue();
				VolumeLabel.setText("" + value);
			}

		}
	};

   private void MusicEngines() {

	Thread thread1 = new Thread() {
        @Override
        public void run() {
            try {

				if(!Musics.c1.isRunning()) {

					for(long i = c1.getMicrosecondLength(); i >= c1.getMicrosecondPosition(); i++) {
		
						ProgressPosition1.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressLength1.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressPosition1.setText((int)(c1.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c1.getMicrosecondPosition() / 1000000) % 60));
						MusicProgressSlider1.setValue((int)(c1.getMicrosecondPosition()/1000000));
						
						if(!PlayerFrame.isVisible()) {
		
							break;
						}
		
						if(c1.getMicrosecondPosition() >= c1.getMicrosecondLength()) {
		
						if(!Loop1.isVisible()) {
		
							ProgressPosition1.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressLength1.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressPosition1.setText((int)(c1.getMicrosecondLength()/(60000000)) + ":" + String.format("%02d", (int) (c1.getMicrosecondLength() / 1000000) % 60));
							MusicProgressSlider1.setValue((int)(c1.getMicrosecondPosition()/1000000));
		
							} else {
								c1.setMicrosecondPosition(0);
								sleep(1000);
							}
		
						}
		
					}
			
				}

                    sleep(0);

            } catch (InterruptedException e) {
				
                e.printStackTrace();

            }
        }
    };

    thread1.start();

    Thread thread2 = new Thread() {
        @Override
        public void run() {
            try {

				if(!Musics.c2.isRunning()) {

					for(long i = c2.getMicrosecondLength(); i >= c2.getMicrosecondPosition(); i++) {
			
						ProgressPosition2.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressLength2.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressPosition2.setText((int)(c2.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c2.getMicrosecondPosition() / 1000000) % 60));
						MusicProgressSlider2.setValue((int)(c2.getMicrosecondPosition()/1000000));
						
						if(!PlayerFrame.isVisible()) {
			
							break;
						}
			
						if(c2.getMicrosecondPosition() >= c2.getMicrosecondLength()) {
			
						if(!Loop2.isVisible()) {
			
							ProgressPosition2.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressLength2.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressPosition2.setText((int)(c2.getMicrosecondLength()/(60000000)) + ":" + String.format("%02d", (int) (c2.getMicrosecondLength() / 1000000) % 60));
							MusicProgressSlider2.setValue((int)(c2.getMicrosecondPosition()/1000000));
			
							} else {
								c2.setMicrosecondPosition(0);
								sleep(1000);
							}
			
						}
			
					}
				}

                    sleep(0);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }
    };

    thread2.start();

	Thread thread3 = new Thread() {
        @Override
        public void run() {
            try {

				if(!Musics.c3.isRunning()) {

					for(long i = c3.getMicrosecondLength(); i >= c3.getMicrosecondPosition(); i++) {
			
						ProgressPosition3.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressLength3.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressPosition3.setText((int)(c3.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c3.getMicrosecondPosition() / 1000000) % 60));
						MusicProgressSlider3.setValue((int)(c3.getMicrosecondPosition()/1000000));
						
						if(!PlayerFrame.isVisible()) {
			
							break;
						}
			
						if(c3.getMicrosecondPosition() >= c3.getMicrosecondLength()) {
			
						if(!Loop3.isVisible()) {
			
							ProgressPosition3.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressLength3.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressPosition3.setText((int)(c3.getMicrosecondLength()/(60000000)) + ":" + String.format("%02d", (int) (c3.getMicrosecondLength() / 1000000) % 60));
							MusicProgressSlider3.setValue((int)(c3.getMicrosecondPosition()/1000000));
			
							} else {
								c3.setMicrosecondPosition(0);
								sleep(1000);
							}
			
						}
			
					}
				}

                    sleep(0);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }
    };

    thread3.start();

	Thread thread4 = new Thread() {
        @Override
        public void run() {
            try {

				if(!Musics.c4.isRunning()) {

					for(long i = c4.getMicrosecondLength(); i >= c4.getMicrosecondPosition(); i++) {
			
						ProgressPosition4.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressLength4.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressPosition4.setText((int)(c4.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c4.getMicrosecondPosition() / 1000000) % 60));
						MusicProgressSlider4.setValue((int)(c4.getMicrosecondPosition()/1000000));
						
						if(!PlayerFrame.isVisible()) {
			
							break;
						}
			
						if(c4.getMicrosecondPosition() >= c4.getMicrosecondLength()) {
			
						if(!Loop4.isVisible()) {
			
							ProgressPosition4.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressLength4.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressPosition4.setText((int)(c4.getMicrosecondLength()/(60000000)) + ":" + String.format("%02d", (int) (c4.getMicrosecondLength() / 1000000) % 60));
							MusicProgressSlider4.setValue((int)(c4.getMicrosecondPosition()/1000000));
			
							} else {
								c4.setMicrosecondPosition(0);
								sleep(1000);
							}
			
						}
			
					}
				}

                    sleep(0);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }
    };

    thread4.start();

	Thread thread5 = new Thread() {
        @Override
        public void run() {
            try {

				if(!Musics.c5.isRunning()) {

					for(long i = c5.getMicrosecondLength(); i >= c5.getMicrosecondPosition(); i++) {
		
						ProgressPosition5.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressLength5.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressPosition5.setText((int)(c5.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c5.getMicrosecondPosition() / 1000000) % 60));
						MusicProgressSlider5.setValue((int)(c5.getMicrosecondPosition()/1000000));
						
						if(!PlayerFrame.isVisible()) {
		
							break;
						}
		
						if(c5.getMicrosecondPosition() >= c5.getMicrosecondLength()) {
		
						if(!Loop5.isVisible()) {
		
							ProgressPosition5.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressLength5.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressPosition5.setText((int)(c5.getMicrosecondLength()/(60000000)) + ":" + String.format("%02d", (int) (c5.getMicrosecondLength() / 1000000) % 60));
							MusicProgressSlider5.setValue((int)(c5.getMicrosecondPosition()/1000000));
		
							} else {
								c5.setMicrosecondPosition(0);
								sleep(1000);
							}
		
						}
		
					}
			
				}

                    sleep(0);

            } catch (InterruptedException e) {
				
                e.printStackTrace();

            }
        }
    };

    thread5.start();

	Thread thread6 = new Thread() {
        @Override
        public void run() {
            try {

				if(!Musics.c6.isRunning()) {

					for(long i = c6.getMicrosecondLength(); i >= c6.getMicrosecondPosition(); i++) {
		
						ProgressPosition6.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressLength6.setFont(new Font("Calibri", Font.BOLD, 12));
						ProgressPosition6.setText((int)(c6.getMicrosecondPosition()/(60000000)) + ":" + String.format("%02d", (int) (c6.getMicrosecondPosition() / 1000000) % 60));
						MusicProgressSlider6.setValue((int)(c6.getMicrosecondPosition()/1000000));
						
						if(!PlayerFrame.isVisible()) {
		
							break;
						}
		
						if(c6.getMicrosecondPosition() >= c6.getMicrosecondLength()) {
		
						if(!Loop6.isVisible()) {
		
							ProgressPosition6.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressLength6.setFont(new Font("Calibri", Font.BOLD, 12));
							ProgressPosition6.setText((int)(c6.getMicrosecondLength()/(60000000)) + ":" + String.format("%02d", (int) (c6.getMicrosecondLength() / 1000000) % 60));
							MusicProgressSlider6.setValue((int)(c6.getMicrosecondPosition()/1000000));
		
							} else {
								c6.setMicrosecondPosition(0);
								sleep(1000);
							}
		
						}
		
					}
			
				}

                    sleep(0);

            } catch (InterruptedException e) {
				
                e.printStackTrace();

            }
        }
    };

    thread6.start();

    }
}
