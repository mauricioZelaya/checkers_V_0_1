package org.checkers.app;

import org.checkers.controller.DrawingPanel;
import org.checkers.controller.FileController;
import org.checkers.controller.MovementGestor;
import org.checkers.model.InterfaceMatrix;
import org.checkers.model.Matrix;
import org.checkers.view.PlayerView;
import org.checkers.view.MenuBar;
import org.checkers.controller.PlayerController;
import org.checkers.model.Player;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * Updated by Kenneth on 7/11/2017.
 * Added the proper container to display the view of the player along with the view of the drawing
 */
public class DrawingWindow extends JFrame {

    private final MovementGestor movementGestor;
    private final InterfaceMatrix matrix;

    /**
     * Creation of the Drawing Panel (The board)
     */
    private DrawingPanel panel = new DrawingPanel();
    private MenuBar menuBar;

    /**
     * Creation of the controller
     */
    private PlayerController miPlayerController;

    /**
     * Drawing window construction.
     *
     * @param title title value.
     */
    public DrawingWindow(final String title) {
        super(title);
        setLayout(new BorderLayout());
        matrix = new Matrix();

        movementGestor = new MovementGestor(panel, matrix);

        Player miPlayerOne = new Player(1);
        Player miPlayerTwo = new Player(2);
        PlayerView newView = new PlayerView();
        miPlayerController = new PlayerController(miPlayerOne, miPlayerTwo, newView);

        menuBar = new MenuBar();
        setJMenuBar(menuBar.getMenuBar());
        add(panel, BorderLayout.CENTER);
        add(newView, BorderLayout.EAST);

        FileController controller = new FileController(menuBar);
    }
}
