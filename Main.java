import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Puzzle puzzle = new Puzzle();
            PuzzleView view = new PuzzleView();
            view.setVisible(true);
            PuzzleController controller = new PuzzleController(puzzle, view);
            controller.handleEvents();
        });
    }
}
