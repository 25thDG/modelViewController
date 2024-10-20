
import javax.swing.*;

public class PuzzleController {
    private PuzzleModel model;
    private PuzzleView view;
    final int BORDER;

    public PuzzleController(final int BORDER,PuzzleModel model, PuzzleView view) {
        this.BORDER = BORDER;
        this.model = model;
        this.view = view;
        handleEvents();
        view.updateView(model);
    }
    

    public void handleEvents() {
        JButton[][] buttons = view.buttons;
        for (int row = 0; row < BORDER; row++) {
            for (int column = 0; column < BORDER; column++) {
                final int frow = row;
                final int fcolumn = column;
                buttons[row][column].addActionListener(ev -> {
                    //After every click reload the view
                    model.swapTiles(frow, fcolumn);
                    view.updateView(model);
                    

                });
            }
        }
    }
}
