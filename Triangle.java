import processing.core.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes (original)
 * @author  Jason Oswald (adapted to PApplet)
 * @version 7.P.0
 */

public class Triangle extends Canvas.Shape
{
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private int fillColor;
    private boolean isVisible;
    private int xMovement = 0;
    private int yMovement = 0;
    
    /**
     * Create a new circle at default position with default color.
     */
    public Triangle()
    {
        super();
        height = 60;
        width = 70;
        xPosition = 310;
        yPosition = 120;
        fillColor = sketch.color(0,255,0);
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible() { isVisible = true; }
    
    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible() { isVisible = false; }
    
    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the circle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        xPosition += distance;
    }

    /**
     * Move the circle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        yPosition += distance;
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
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
    public void changeSize(int newHeight, int newWidth)
    {
        height = newHeight;
        width = newWidth;
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
        
        if(isVisible) {
            sketch.fill(fillColor);
            sketch.triangle(
                xPosition, yPosition,
                xPosition + (width/2), yPosition + height,
                xPosition - (width/2), yPosition + height                
            );            
        }
    }
    
    private void move() {
        if( xMovement > 0 ) {
            xPosition++;
            xMovement--;
        }
        if( xMovement < 0 ) {
            xPosition--;
            xMovement++;
        }        

        if( yMovement > 0 ) {
            yPosition++;
            yMovement--;
        }
        if( yMovement < 0 ) {
            yPosition--;
            yMovement++;
        }            
    }

    /**
     * Erase the circle on screen.
     */
    private void erase()
    {
        sketch.erase(this);
    }
}
