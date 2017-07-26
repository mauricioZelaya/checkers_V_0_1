package org.checkers.app;

import org.checkers.view.DrawingPanel;
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
import java.io.File;

/**
 * Updated by Kenneth on 7/11/2017.
 * Updated by Susana on 7/20/2017.
 * Added the proper container to display the view of the player along with the view of the drawing
 */
public class DrawingWindow extends JFrame {

    private final MovementGestor movementGestor;
    private final InterfaceMatrix matrix;

    /**
     * Creation of the Drawing Panel (The board)
     */
    private DrawingPanel drawingPanel;
    private MenuBar menuBar;

    /**
     * Creation of the controller
     */
    private FileController fileController;

    private PlayerController playerController;

    /**
     * Drawing window construction.
     *
     * @param title title value.
     */
    public DrawingWindow(final String title) {
        super(title);
        setLayout(new BorderLayout());

        matrix = new Matrix();

        menuBar = new MenuBar();
        drawingPanel = new DrawingPanel(matrix);

        fileController = new FileController(drawingPanel, menuBar, matrix);
        movementGestor = new MovementGestor(drawingPanel, matrix);

        Player playerOne = new Player(1);
        Player playerTwo = new Player(2);
        PlayerView playerView = new PlayerView();

        playerController = new PlayerController(playerOne, playerTwo, playerView);

        setJMenuBar(menuBar.getMenuBar());

        add(drawingPanel, BorderLayout.CENTER);
        add(playerView, BorderLayout.EAST);
    }
}
