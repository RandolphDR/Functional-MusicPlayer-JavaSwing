package MusicPLayerTestPackage;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {
	
private static final long serialVersionUID = 1L;

	public ScrollBarCustom() {
        setUI(new ModernScrollBar());
        setPreferredSize(new Dimension(8, 8));
        setBackground(new Color(100, 150, 255));
    }
}
