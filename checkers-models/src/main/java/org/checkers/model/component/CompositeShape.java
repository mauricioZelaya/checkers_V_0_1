package org.checkers.model.component;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Extends AbstractShape to create a Composite container. It can contain any number of AbstractShapes to deliver
 * a complex image.
 *
 * @author (Done in class, extended some to adapt to Checkers game)
 * @version (July 2017)
 */
public class CompositeShape extends AbstractShape {

    protected List<AbstractShape> elements;

    public CompositeShape(int x, int y) {
      super(x, y);
      elements = new ArrayList<AbstractShape>();
    }

    public CompositeShape(int x, int y, Color color){
        super(x, y, color);
        elements = new ArrayList<AbstractShape>();
    }

  /**
   * Checks if a pair XY mouse coordinates belong to a shape in the Composite container.
   * @param x mouse coordinate, integer
   * @param y mouse coordinate, integer
   * @return true if the coordinates are inside one of the shapes belonging to the Composite container, false otherwise.
   */
    @Override
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

  /**
   * Draws all the objects that belong to the Composite container.
   * @param g Graphics context passed over.
   */
  @Override
    public void drawShape(Graphics g){
        for(AbstractShape element:elements) {
            element.draw(g);
        }
    }

  /**
   * Resets the XY coordinates of all shapes that belong to the Composite container.
   * @param x new X coordinate, integer
   * @param y new Y coordinate, integer
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
}
