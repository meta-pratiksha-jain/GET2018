import java.util.*;
public class ShapeFactory {
    
    /**
     * static method for creating various shapes
     * @param shapeType contains type of shape 
     * @param origin contains left corner point of shape
     * @param parameters contains list of parameters for shape
     * @return shape object
     */
    public static IShape createShape(ShapeEnum shapeType,Point origin,List<Double> parameters)
    {
        IShape shape=null;
        switch(shapeType){
        case CIRCLE:
            shape=new Circle(origin,parameters);
            break;
        case RECTANGLE:
            shape=new Rectangle(origin,parameters);
            break;
        case SQUARE:
            shape=new Square(origin,parameters);
            break;
        default:
            throw new AssertionError(shapeType+" type of shape doesn't exist");
        
        }
        return shape;
        
    }

}
