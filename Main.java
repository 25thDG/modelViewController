import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PuzzleModel puzzle = new PuzzleModel();
            PuzzleView view = new PuzzleView();
        
            PuzzleController controller = new PuzzleController(puzzle, view);
            controller.handleEvents();
            view.setVisible(true);
        });
    }
}
