import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PuzzleModel puzzle = new PuzzleModel(4);
            PuzzleView view = new PuzzleView(4);
        
            PuzzleController controller = new PuzzleController(puzzle, view);
            //controller.handleEvents();
            view.setVisible(true);
        });
    }
}
