import java.util.*;
public class Circle implements IShape {
    public final double PIE=3.14;
    public Point origin;
    public double radius;
    public long timeStamp;
    
    /**
     * constructor
     * @param origin contains point on the circle that lies on the line connecting the center to the origin of screen.
     * @param parameters contains radius of circle
     */
    public Circle(Point origin,List<Double> parameters)
    {
        this.origin=origin;
        radius=parameters.get(0);
        Date currentDate=new Date();
        timeStamp=currentDate.getTime();
    }
    
    /**
     * calculates area of circle
     * @return area
     */
    @Override
    public double getArea() {
        double area=PIE*radius*radius;
        return area;
    }

    /**
     * calculates perimeter of circle
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        double perimeter=2*PIE*radius;
        return perimeter;
    }

    @Override
    public Point getOrigin() {
        return origin;
    }

    /**
     * Check whether given point is enclosed within circle or not
     * @return returns true if point is enclosed within circle otherwise false
     */
    @Override
    public boolean isPointEnclosed(Point point) {
        boolean isEnclosed=false;
        Point center=getCenter();
        double centerToPointDistance=Math.sqrt(
                Math.pow((center.getXCoordinate()-point.getXCoordinate()), 2)+
                        Math.pow((center.getXCoordinate()-point.getXCoordinate()), 2));
        if(centerToPointDistance<=radius)
        {
            isEnclosed=true;
        }
        return isEnclosed;
    }
    
    /**
     * Calculate distance between origin of circle to the origin of screen
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
        return ShapeEnum.CIRCLE;
    }
    
    @Override
    public long getTimeStamp()
    {
        return timeStamp;
    }
    
    /**
     * private helper method to get center of circle
     * @return center point
     */
    private Point getCenter()
    {
     Point center;
     double centerToOriginDistance;
     centerToOriginDistance=radius+Math.sqrt(
             Math.pow(origin.getXCoordinate(), 2)+Math.pow(origin.getYCoordinate(),2 ));
     double xCoordinate=(centerToOriginDistance*origin.getXCoordinate())/
             (centerToOriginDistance-radius);
     double yCoordinate=(centerToOriginDistance*origin.getYCoordinate())/
             (centerToOriginDistance-radius);
     center=new Point(xCoordinate, yCoordinate);
     return center;
    }
}
