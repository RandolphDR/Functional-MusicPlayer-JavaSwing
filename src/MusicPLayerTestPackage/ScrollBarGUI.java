package MusicPLayerTestPackage;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;  
import javax.swing.JScrollPane;  
import javax.swing.JTextArea; 
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class ScrollBarGUI {  
 
    public static void main(String[] args) {  
    
     JLabel label = new JLabel();
     label.setText("HEYYYYYY");
     label.setFont(new Font("MV Boli", Font.BOLD, 20));
     label.setForeground(Color.black);
     label.setBackground(Color.yellow);
     label.setOpaque(true);
     label.setBounds(0, 0, 200, 100);
     
     JLabel label2 = new JLabel();
     label2.setText("HIIIIIIIIII");
     label2.setFont(new Font("MV Boli", Font.BOLD, 20));
     label2.setForeground(Color.black);
     label2.setBackground(Color.yellow);
     label2.setOpaque(true);
     label2.setBounds(0, 600, 200, 100);
     
     JPanel panel1 = new JPanel();
     panel1.setBackground(Color.yellow);
     panel1.setPreferredSize(new Dimension(100,100));
     
     JPanel panel2 = new JPanel();
     panel2.setBackground(Color.blue);
     panel2.setPreferredSize(new Dimension(100,100));
     
     JPanel panel3 = new JPanel();
     panel3.setBackground(Color.black);
     panel3.setLayout(null);
     panel3.setPreferredSize(new Dimension(1500, 1500));
     
     panel3.add(label);
     panel3.add(label2);
     
     ScrollBarCustom SP = new ScrollBarCustom();
     SP.setOrientation(JScrollBar.HORIZONTAL);
     
     JScrollPane scroll = new JScrollPane();
     scroll.setHorizontalScrollBar(SP);
     scroll.setViewportView(panel3);
     
     JFrame frame = new JFrame();
   
     frame.setSize(700,700);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setLayout(new BorderLayout());
     
     frame.add(panel1,BorderLayout.SOUTH);
     frame.add(panel2,BorderLayout.WEST);
     frame.add(scroll,BorderLayout.CENTER);
     
     frame.setVisible(true);
    }  
}
