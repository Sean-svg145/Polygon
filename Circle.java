import processing.core.*;

public class Circle extends Canvas.Shape
{
    private int diameter;
    private int xPosition;
    private int yPosition;
    private int fillColor;
    private boolean isVisible;

    private int xMovement = 3;
    private int yMovement = 2;

    public Circle()
    {
        super();
        diameter = 68;
        xPosition = 230;
        yPosition = 90;
        fillColor = sketch.color(0, 0, 255);
    }

    public void makeVisible()
    {
        isVisible = true;
    }

    public void makeInvisible()
    {
        isVisible = false;
    }

    public void slowMoveHorizontal(int distance)
    {
        xMovement = distance;
    }

    public void slowMoveVertical(int distance)
    {
        yMovement = distance;
    }

    public void changeSize(int newDiameter)
    {
        diameter = newDiameter;
    }

    public void changeColor(String newColor)
    {
        fillColor = getColor(newColor);
    }

    public void draw()
    {
        move();

        if(isVisible)
        {
            sketch.fill(fillColor);
            sketch.ellipse(
                xPosition,
                yPosition,
                diameter,
                diameter
            );
        }
    }

    private void move()
    {
        xPosition += xMovement;
        yPosition += yMovement;

        if(xPosition + diameter / 2 >= sketch.width ||
           xPosition - diameter / 2 <= 0)
        {
            xMovement = -xMovement;
        }

        if(yPosition + diameter / 2 >= sketch.height ||
           yPosition - diameter / 2 <= 0)
        {
            yMovement = -yMovement;
        }
    }
}
/*
private void move() {
    xPosition += xMovement;
    yPosition += yMovement;

    if (xPosition + diameter / 2 >= sketch.width ||
        xPosition - diameter / 2 <= 0) {
        xMovement = -xMovement;
    }

    if (yPosition + diameter / 2 >= sketch.height ||
        yPosition - diameter / 2 <= 0) {
        yMovement = -yMovement;
    }
}

private void erase() {
    sketch.erase(this);
}
}*/