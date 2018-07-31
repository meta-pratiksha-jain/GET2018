import java.util.*;
public class Square implements IShape {
    public Point origin;
    public int width;
    
    public Square(Point origin,List<Integer> parameters)
    {
        this.origin=origin;
        width=parameters.get(0);
    }

    @Override
    public double getArea() {
        return 0.0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public Point getOrigin() {
        return null;
    }

    @Override
    public boolean isPointEnclosed() {
        // TODO Auto-generated method stub
        return false;
    }

}
