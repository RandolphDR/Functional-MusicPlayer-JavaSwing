package MusicPlayerMain;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class ProjectConstants {

	//THEMES COLOR
    static int[] DefaultColor = {18, 52, 86};
    static int[] LightBlue = {0,50,139};
    static int[] Crimson = {220, 20, 60};

 // protected static int[] AppColor = { DefaultColor[0], DefaultColor[1], DefaultColor[2]};
    protected static int[] AppColor = { LightBlue[0], LightBlue[1], LightBlue[2]};
 //   protected static int[] AppColor = { Crimson[0], Crimson[1], Crimson[2] };

    //Clicked Color
    
    static int[] LightSkyBlue = {135,206,250};
    
    protected static boolean FrameUndecorated = true;

    protected static ImageIcon ApplicationLogo = new ImageIcon("AppLogo.png");
    
    protected static String AppName = "Music";
    protected static String MusicIcon = "♪";
    protected static String CloseIcon = "—";
    protected static String MaximizeIcon = "▢";
    protected static String MinimizeIcon = "▢▫";
    protected static String ExitIcon = "×";
    protected static boolean ButtonFocusable = false;

    protected static ImageIcon FrameBackground = new ImageIcon("Pixie1.png");
    protected static int[] FrameSize = {1000, 750};
    protected static boolean FrameVisible = true;
   
    final static Border AppBorder = BorderFactory.createLineBorder(new Color(40,0,255),1);
    final static Border WhiteBorder = BorderFactory.createLineBorder(new Color(0, 139, 139), 1);

    final static Color FocusableColor = new Color(0, 139, 139);

    protected static float DefaultVolume = 50f;
    protected static float Minimum = 0f;
    protected static float Maximum = 100f;

    protected static ImageIcon PlayIcon = new ImageIcon("PlayIcon.png");
    
    protected static ImageIcon M1Album = new ImageIcon("LeonoraAlbum.jpg");
    protected static ImageIcon M2Album = new ImageIcon("LigayaAlbum.jpg");
    protected static ImageIcon M3Album = new ImageIcon("UhawAlbum.jpg");
    protected static ImageIcon M4Album = new ImageIcon("FourseasonsAlbum.jpg");
    protected static ImageIcon M5Album = new ImageIcon("DemonyoAlbum.jpg");
    protected static ImageIcon M6Album = new ImageIcon("LDRAlbum.jpg");
    
}
