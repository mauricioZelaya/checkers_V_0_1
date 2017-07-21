package org.checkers.view.component;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 * [ VIEW ]
 * This class was created in order to show and example of the Composite Pattern. It allows to extend the AbstractShape
 * into a class that can hold and manage a list of shapes.
 *
 * @author (Done in class)
 * @version (June 2017)
 */
public class CompositeShape extends AbstractShape {

    protected List<AbstractShape> elements;

    public CompositeShape(int x, int y){
        super(x, y);
        elements = new ArrayList<>();
    }

    @Override //recheck logic for container check
    public boolean isInsideShape(int x, int y){
        for(AbstractShape element:elements) {
            if(element.isInsideShape(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getValue(){
        return 0;
    }

    @Override
    public void setValue(int value) {
    }

    @Override
    public void drawShape(Graphics g){
        for(AbstractShape element:elements) {
            element.draw(g);
        }
    }

    /**
     * Goes over all the shapes of the composition in order to update their x, y coordinates.
     */
    @Override
    public void setAllShapeProperties(int x, int y) {
        for(AbstractShape element:elements) {
            element.setX(x);
            element.setY(y);
        }
    }

    @Override
    public void toggleState() {
    }

    @Override
    public void crownShape() {
    }
}