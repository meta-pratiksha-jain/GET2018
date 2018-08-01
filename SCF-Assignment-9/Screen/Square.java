import java.util.*;
public class Square implements IShape {
    public Point origin;
    public double width;
    public long timeStamp;
    
    /**
     * constructor
     * @param origin contains left corner point of square
     * @param parameters contains width of square
     */
    public Square(Point origin,List<Double> parameters)
    {
        this.origin=origin;
        width=parameters.get(0);
        Date currentDate=new Date();
        timeStamp=currentDate.getTime();
    }

    /**
     * calculates area of square
     * @return area
     */
    @Override
    public double getArea() {
        double area=width*width;
        return area;
    }

    /**
     * calculates perimeter of square
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        double perimeter=4*width;
        return perimeter;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * Check whether given point is enclosed within square or not
     * @return returns true if point is enclosed within square otherwise false
     */
    @Override
    public boolean isPointEnclosed(Point P) {
        boolean isEnclosed=false;
        if(P.getXCoordinate()>=origin.getXCoordinate() && P.getXCoordinate()<=(origin.getXCoordinate()+width)
                && P.getYCoordinate()>=origin.getYCoordinate() && P.getYCoordinate()<=(origin.getYCoordinate()+width))
        {
            isEnclosed=true;
        }
        return isEnclosed;
    }
    
    /**
     * Calculate distance between origin of square to the origin of screen
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
        return ShapeEnum.SQUARE;
    }
    
    @Override
    public long getTimeStamp()
    {
        return timeStamp;
    }

}
