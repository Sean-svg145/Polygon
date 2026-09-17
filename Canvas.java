import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Canvas extends PApplet {
    private static Canvas canvasSingleton;
    private final int[] COLORS;
    private final String[] COLOR_NAMES;
    private List<Shape> shapes;    

    public static void main(String[] args){
        String[] processingArgs = {"Canvas"};
        PApplet.runSketch(processingArgs, Canvas.getCanvas());
    }    
    
    public static Canvas getCanvas() {
        if( canvasSingleton == null ) {
            canvasSingleton = new Canvas();
        }
        return canvasSingleton;
    }
    
    public Canvas() {
        super();
        COLORS = new int[]{color(255,0,0),color(255,255,0),color(0,0,255),color(0,255,0),color(255,0,255),color(0,0,0)};
        COLOR_NAMES = new String[]{"red", "yellow", "blue", "green","magenta","black"};        
        shapes = new ArrayList<Shape>();     
    }
    
    public void settings() {
        size(500,300);
    }
    

     public void setup() {
        Circle c = new Circle();
        c.makeVisible();
        c.slowMoveHorizontal(3);
        c.slowMoveVertical(2);
        
        Square s = new Square();
        
        Triangle t = new Triangle();
    }
        
    
    
    public void addShape(Shape newShape) {
        shapes.add(newShape);
    }
    
    public void erase(Shape shapeToDelete) {
        for( int i = 0; i < shapes.size(); i++ ) {
            if( shapes.get(i).id == shapeToDelete.id ) {
                shapes.remove(i);
                System.out.println("Removing shape: " + shapeToDelete.id);
                return;
            }
        }
    }
    
    public void draw() {
        background(128);
        for( Shape s : shapes ) {
            s.draw();
        }
    }

    public static abstract class Shape {
        private static int NEXT_ID = 0;
        protected final Canvas sketch;
        protected final int id;
        
    private int xPosition;
    private int yPosition;
    private int fillColor;
    private boolean isVisible;
    private int xMovement = 0;
    private int yMovement = 0;
        
        public Shape() {
            sketch = Canvas.getCanvas();
            sketch.addShape(this);
            id = NEXT_ID;
            NEXT_ID++;
        }
        
        /**
         * Change the color. Valid colors are "red", "yellow", "blue", "green",
         * "magenta" and "black".
         */
        public int getColor(String color)
        {
            for( int i = 0; i < sketch.COLOR_NAMES.length; i++ ) {
                if( sketch.COLOR_NAMES[i].equals(color) ) {
                    return sketch.COLORS[i];
                }
            }
            return sketch.COLORS[sketch.COLORS.length-1];
        }        
        
        public abstract void draw();
        
        public boolean equals(Object o) {
            if( this == o ) { return true; }
            
            if( o == null || getClass() != o.getClass() ) { return false; }
            
            Shape s = (Shape) o;
            return id == s.id;
        }
    }    
}