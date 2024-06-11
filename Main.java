import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Change this variable to set Field BORDERxBORDER
        final int BORDER = 5;
        SwingUtilities.invokeLater(() -> {
            PuzzleModel puzzle = new PuzzleModel(BORDER);
            PuzzleView view = new PuzzleView(BORDER);
        
            PuzzleController controller = new PuzzleController(BORDER,puzzle, view);
            //controller.handleEvents();
            view.setVisible(true);
        });
    }
}
