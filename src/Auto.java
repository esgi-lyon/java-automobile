import javax.swing.*;
import View.MainFrame;

public class Auto {
    public static void main(String[] args) {
        // Async Swing initialization
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
