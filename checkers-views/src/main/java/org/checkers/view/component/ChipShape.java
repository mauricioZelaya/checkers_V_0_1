package org.checkers.view.component;

import java.awt.Color;

/**
 * [ VIEW ] 
 *This composite shape gives visual form to a GamePiece. Its ability to hold any number of AbstractShapes allows for complex and adaptable visual representation.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class ChipShape extends CompositeShape {
    
    public ChipShape(int x, int y, int side, Color color) {
        super(x, y);
        setColor(color);
        Circle outer = new Circle(x, y); //lower circle, helps create the "selected" effect through "toggleState" method
        outer.setColor(color);
        outer.setValue((side-6)/2);
        Circle inner = new Circle(x, y); //top circle
        inner.setColor(color);
        inner.setValue((side-12)/2);        

        elements.add(outer);
        elements.add(inner);
    }
    
    /**
     * Executes a toggle state on the ChipShape by making the lower circle to change color and highlight the composed shape.
     */
    @Override
    public void toggleState() {
        AbstractShape element;
        element = elements.get(0);
        element.setColor((element.getColor()== color)? Color.green : color);
    }
    
    /**
     * When called this method will add a new Shape, to the composite list. In its current form a CrownShape.
     */
    @Override
    public void crownShape() {
        AbstractShape crown = new CrownShape(x, y);
        elements.add(crown);        
    }
}