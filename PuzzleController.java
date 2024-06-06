
import javax.swing.*;

public class PuzzleController {
    private PuzzleModel model;
    private PuzzleView view;

    public PuzzleController(PuzzleModel model, PuzzleView view) {
        this.model = model;
        this.view = view;
        view.updateView(model.getPlayground());
    }
    

    public void handleEvents() {
        JButton[][] buttons = view.buttons;
        for (int row = 0; row < view.BORDER; row++) {
            for (int column = 0; column < view.BORDER; column++) {
                final int frow = row;
                final int fcolumn = column;
                buttons[row][column].addActionListener(ev -> {
                    //After every click reload the view
                    model.swapTiles(frow, fcolumn);
                    view.updateView(model.getPlayground());
                    

                });
            }
        }
    }
}
