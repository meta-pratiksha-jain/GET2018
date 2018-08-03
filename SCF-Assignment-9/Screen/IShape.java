
public interface IShape {
    
    public double getArea();
    
    public double getPerimeter();
    
    public Point getOrigin();
    
    public boolean isPointEnclosed(Point P);
    
    public double getOriginDistance();
    
    public ShapeEnum getShapeType();
    
    public long getTimeStamp();

}
