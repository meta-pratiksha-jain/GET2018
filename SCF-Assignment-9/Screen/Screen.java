import java.util.*;
public class Screen {
    public final int MAXIMUMXCOORDINATE=1600;
    public final int MAXIMUMYCOORDINATE=1200;
    public final int MINIMUMXCOORDINATE=0;
    public final int MINIMUMYCOORDINATE=0;
    List<IShape> listOfShape;
    
    /**
     * constructor
     */
    public Screen()
    {
        listOfShape=new ArrayList<IShape>();
    }
    
    /**
     * Add a shape on the screen
     * @param shapeType contains type of the shape should be added on the screen 
     * @param origin left corner point of the shape
     * @param listOfParameters contains parameter list for shape
     * @return returns true if shape to be added on screen
     */
    public boolean addShape(ShapeEnum shapeType,Point origin,List<Double> listOfParameters)
    {
        boolean isAdded=false;
        if(origin.getXCoordinate()<=MINIMUMXCOORDINATE || origin.getXCoordinate()>=MAXIMUMXCOORDINATE ||
                origin.getYCoordinate()>=MAXIMUMYCOORDINATE || origin.getYCoordinate()<=MINIMUMYCOORDINATE)
        {
            return isAdded;
        }
        IShape shapeInstance=ShapeFactory.createShape(shapeType, origin, listOfParameters);
        if(shapeInstance!=null)
        {
            listOfShape.add(shapeInstance);
            isAdded=true;
        }
        return isAdded;
    }
    
    /**
     * deletes first shape from listOfShape on screen whose shapeType and Origin matches with arguments.
     * @param shapeType contains type of shape to be deleted
     * @param origin contains origin of shape
     * @return returns true if shape is deleted otherwise false
     */
    public boolean deleteShape(ShapeEnum shapeType,Point origin)
    {
        boolean isDeleted=false;
        for(IShape shape:listOfShape)
        {
            if(shape.getShapeType().equals(shapeType) && shape.getOrigin().equals(origin))
            {
                listOfShape.remove(shape);
                isDeleted=true;
                return isDeleted;
            }
        }
        return isDeleted;
    }
    
    /**
     * delete all shapes of given type from screen
     * @param ShapeType
     * @return true if shapes are deleted
     */
    public boolean deleteAllShapesOfSpecifiedType(ShapeEnum shapeType)
    {
        boolean isDeleted=false;
        for(IShape shape:listOfShape)
        {
            if(shape.getShapeType().equals(shapeType))
            {
                listOfShape.remove(shape);
                isDeleted=true;
            }
        }
        return isDeleted;
    }
    
    /**
     * To get list of all shapes which encloses given point within it
     * @param point contains point that is enclosed by shapes
     * @return listOfShapeEnclosingAPoint
     */
    public List<IShape> getListOfShapeEnclosingAPOint(Point point)
    {
        List<IShape> listOFShapeEnclosingAPoint=new ArrayList<IShape>();
        for(IShape shape:listOfShape)
        {
            boolean isEnclosed=false;
            isEnclosed=shape.isPointEnclosed(point);
            if(isEnclosed)
            {
                listOFShapeEnclosingAPoint.add(shape);
            }
        }
        return listOFShapeEnclosingAPoint;
    }
    
    /**
     * Sort list of shapes in ascending order on various basis
     * @param basedOn contains various basis for sorting
     * @return returns list of shape in ascending order
     */
    public List<IShape> sortListOfShape(String basedOn)
    {
        List<IShape> sortedListOfShape=new ArrayList<IShape>();
        switch(basedOn)
        {
        case "area":
            sortedListOfShape=Sort.sortBasedOnArea(listOfShape);
            break;
        case "perimeter":
            sortedListOfShape=Sort.sortBasedOnPerimeter(listOfShape);
            break;
        case "timeStamp":
            sortedListOfShape=Sort.sortBasedOnTimeStamp(listOfShape);
            break;
        case "originDistance":
            sortedListOfShape=Sort.sortBasedOnOriginDistance(listOfShape);
            break;
        default:
            throw new AssertionError("list can't be sorted on the basis of "+basedOn);
        }
        return sortedListOfShape;
    }

}
