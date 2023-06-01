package MusicPLayerTestPackage;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JProgressBar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        frame.add(progressBar);

        frame.setVisible(true);

        int counter = 0;
        while (counter <= 100) {
            counter++;
            String counterString = String.format("%02d", counter);
            progressBar.setString(counterString);
            progressBar.setValue(counter);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}