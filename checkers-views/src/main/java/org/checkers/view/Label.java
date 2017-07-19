package org.checkers.view;

import org.checkers.view.component.AbstractShape;
import java.awt.Graphics;
import java.awt.FontMetrics;

/**
 * [ VIEW ]
 *Concrete Label shape, draws a label and allows working with it.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class Label extends AbstractShape {
    private String label;

    public Label(int x, int y, String text){
        super(x, y);
        this.label = text;
    }

    @Override
    public boolean isInsideShape(int x, int y){
        return false;
    }

    @Override
    public void drawShape(Graphics g){
        FontMetrics fm = g.getFontMetrics();
        int xText;
        int yText;
        xText= x - fm.stringWidth(label)/2;
        yText= y + fm.getHeight()/3;
        g.drawString(label, xText, yText);
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