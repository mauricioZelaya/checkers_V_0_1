package org.checkers.view.component;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics;
import java.io.IOException;

/**
 * [ VIEW ]
 * Concrete CrownShape shape, draws an JPG graphic and allows working with it.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class CrownShape extends AbstractShape {

    private BufferedImage crownImage = null;
    private int imageW;
    private int imageH;

    /**
     * General format to handle the image file was found online.
     */
    public CrownShape(int x, int y) {
        super(x, y);

        try {
            crownImage = ImageIO.read(new File("crown.png"));
        } catch (IOException e) {
        }

        imageW = crownImage.getWidth();
        imageH = crownImage.getHeight();
    }

    @Override
    public boolean isInsideShape(int x, int y){
        return false;
    }

    @Override
    public void drawShape(Graphics g){
        g.drawImage(crownImage, x-imageW/2, y-imageH/2, null);
    }

    @Override
    public int getValue(){
        return 0;
    }

    @Override
    public void setValue(int value) {
    }

    @Override
    public void toggleState() {
    }

    @Override
    public void crownShape() {
    }
}