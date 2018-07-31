import java.util.*;
public class Circle implements IShape {
    public Point origin;
    public int radius;
    
    public Circle(Point origin,List<Integer> parameters)
    {
        this.origin=origin;
        radius=parameters.get(0);
    }

    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getPerimeter() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Point getOrigin() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isPointEnclosed() {
        // TODO Auto-generated method stub
        return false;
    }

}
