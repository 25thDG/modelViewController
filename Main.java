import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        final int BORDER = 4; //<-- Change this variable to set Field BORDERxBORDER
        SwingUtilities.invokeLater(() -> {
            PuzzleModel puzzle = new PuzzleModel(BORDER);
            PuzzleView view = new PuzzleView(BORDER);
        
            PuzzleController controller = new PuzzleController(BORDER,puzzle, view);
            //controller.handleEvents();
            view.setVisible(true);
        });
    }
}
