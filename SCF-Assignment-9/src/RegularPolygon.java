import java.util.*;
public class RegularPolygon implements IShape {
    public Point origin;
    public int side;
    public int numberOfSides;
    
    public RegularPolygon(Point origin,List<Integer> parameters) {
        this.origin=origin;
        numberOfSides=parameters.get(0);
        side=parameters.get(1);
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
