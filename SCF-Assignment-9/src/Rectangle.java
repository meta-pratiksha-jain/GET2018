import java.util.*;
public class Rectangle implements IShape{
    public Point origin;
    public int length;
    public int breadth;
    
    public Rectangle(Point origin,List<Integer> parameters)
    {
        this.origin=origin;
        length=parameters.get(0);
        breadth=parameters.get(1);
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
