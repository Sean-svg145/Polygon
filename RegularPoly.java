import processing.core.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes (original)
 * @author  Jason Oswald (adapted to PApplet)
 * @version 7.P.0
 */

public class RegularPoly extends Canvas.Shape
{
    private int size;
    private int xPosition;
    private int yPosition;
    private int fillColor;
    private boolean isVisible;
    private int xMovement = 0;
    private int yMovement = 0;
    private int radius;
    private float offset = 0;
    private float doffset = 0.01f;
    private int sides = 5; 
    
    /**
     * Create a new circle at default position with default color.
     */
    public RegularPoly()
    {
        super();
        size = 30;
        xPosition = 230;
        yPosition = 90;
        fillColor = sketch.color(0,255,255);
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible() { isVisible = true; }
    
 /*Slowly move the circle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        xMovement = distance;
    }

    /**
     * Slowly move the circle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        yMovement = distance;
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newSize)
    {
        size = newSize;
    }
    public void changeSides(int newSides) {
        sides = newSides;
    }
    public void changeRotate(int newOffset) {
        doffset = newOffset;
    }
    
    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */    
    public void changeColor(String newColor) {
        fillColor = getColor(newColor);
    }

    /**
     * Draw the circle with current specifications on screen.
     */
    public void draw()
    {
        move();
bounce();
        sketch.translate(xPosition,yPosition);
        sketch.rotate(offset);
        if(isVisible) {
            sketch.fill(fillColor);  
            Polygon(0, 0, size, sides);
        }
        offset += doffset;
    }
    private void Polygon(int x, int y, int size, int sides) {
        sketch.beginShape();
        int sidesDrawn = 0;
        float theta = 0;
        float dTheta = sketch.TWO_PI/sides;
        while(sidesDrawn < sides) {
            float xd = x + size*sketch.cos(theta);
            float xy = y + size*sketch.sin(theta);
            sketch.vertex(xd, xy);
            sidesDrawn++;
            theta = sidesDrawn*dTheta;
        }
        sketch.endShape(sketch.CLOSE);
    }
    
    private void move() {
        if( xMovement > 0 ) {
            xPosition++;
            xMovement--;
        }
        if( xMovement < 0 ) {
            xPosition--;
            xMovement++;
        }if( yMovement > 0 ) {
            yPosition++;
            yMovement--;
            }            
    }

    /**
     * Erase the circle on screen.
     */
    private void erase()
    {
        sketch.erase(this);
    }
    private void bounce(){
        if (xPosition+size >= sketch.width) {
            if (xMovement>0) {
                xMovement *= -1;
            }
            else {
                xPosition = sketch.width-radius;
            }
        }
        if (xPosition - size <= 0) {
            if (xMovement <0) {
                xMovement *= -1;
            }
            else {
                xPosition = 0+size;
            }
        }
        if (yPosition+size >= sketch.height) {
            if (yMovement>0) {
                yMovement *= -1;
            }
                yPosition = sketch.height-size;
        }
        if (yPosition - size <= 0) {
            if (yMovement <0) {
                yMovement *= -1;
            }
            else {
                yPosition = 0+size;
            }
        }
    }
}
