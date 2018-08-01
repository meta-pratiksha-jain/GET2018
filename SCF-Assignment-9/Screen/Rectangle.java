import java.util.*;
public class Rectangle implements IShape{
    public Point origin;
    public double length;
    public double breadth;
    public long timeStamp;
    
    /**
     * constructor
     * @param origin left corner point of rectangle
     * @param parameters contains length and breadth of rectangle
     */
    public Rectangle(Point origin,List<Double> parameters)
    {
        this.origin=origin;
        length=parameters.get(0);
        breadth=parameters.get(1);
        Date currentDate=new Date();
        timeStamp=currentDate.getTime();
    }

    /**
     * calculates area of rectangle
     * @return area
     */
    @Override
    public double getArea() {
        double area=length*breadth;
        return area;
    }

    /**
     * calculates perimeter of rectangle
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        double perimeter=2*(length+breadth);
        return perimeter;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * Check whether given point is enclosed within rectangle or not
     * @return returns true if point is enclosed within rectangle otherwise false
     */
    @Override
    public boolean isPointEnclosed(Point P) {
        boolean isEnclosed=false;
        if(P.getXCoordinate()>=origin.getXCoordinate() && P.getXCoordinate()<=(origin.getXCoordinate()+length)
                && P.getYCoordinate()>=origin.getYCoordinate() && P.getYCoordinate()<=(origin.getYCoordinate()+breadth))
        {
            isEnclosed=true;
        }
        return isEnclosed;
    }
    
    /**
     * Calculate distance between origin of rectangle to the origin of screen
     * @return distance
     */
    @Override
    public double getOriginDistance()
    {
        double distance=Math.sqrt(
                Math.pow(origin.getYCoordinate(), 2)+Math.pow(origin.getYCoordinate(), 2));
        return distance;
    }
    
    @Override
    public ShapeEnum getShapeType()
    {
        return ShapeEnum.RECTANGLE;
    }
    
    @Override
    public long getTimeStamp()
    {
        return timeStamp;
    }
    

}
