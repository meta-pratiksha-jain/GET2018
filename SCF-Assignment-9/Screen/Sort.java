import java.util.*;
public class Sort {
    
    /**
     * static method for sorting of list of shapes on the basis of area
     * @param listOfShape contains list of shapes which is to be sorted
     * @return returns sorted list
     */
    public static List<IShape> sortBasedOnArea(List<IShape> listOfShape)
    {
        for(int i=0;i<listOfShape.size()-1;i++)
        {
            for(int j=0;j<listOfShape.size()-i-1;j++)
            {
                IShape shapeAtPositionJ=listOfShape.get(j);
                IShape shapeAtNextPositionOfJ=listOfShape.get(j+1);
                if(shapeAtPositionJ.getArea()>shapeAtNextPositionOfJ.getArea())
                {
                    listOfShape.set(j, shapeAtNextPositionOfJ);
                    listOfShape.set(j+1, shapeAtPositionJ);
                }
            }
        }
        return listOfShape;
    }
    
    /**
     * static method for sorting of list of shapes on the basis of perimeter
     * @param listOfShape contains list of shapes which is to be sorted
     * @return returns sorted list
     */
    public static List<IShape> sortBasedOnPerimeter(List<IShape> listOfShape)
    {
        for(int i=0;i<listOfShape.size()-1;i++)
        {
            for(int j=0;j<listOfShape.size()-i-1;j++)
            {
                IShape shapeAtPositionJ=listOfShape.get(j);
                IShape shapeAtNextPositionOfJ=listOfShape.get(j+1);
                if(shapeAtPositionJ.getPerimeter()>shapeAtNextPositionOfJ.getPerimeter())
                {
                    listOfShape.set(j, shapeAtNextPositionOfJ);
                    listOfShape.set(j+1, shapeAtPositionJ);
                }
            }
        }
        return listOfShape;
    }
    
    /**
     * static method for sorting of list of shapes on the basis of timestamp
     * @param listOfShape contains list of shapes which is to be sorted
     * @return returns sorted list
     */
    public static List<IShape> sortBasedOnTimeStamp(List<IShape> listOfShape)
    {
        for(int i=0;i<listOfShape.size()-1;i++)
        {
            for(int j=0;j<listOfShape.size()-i-1;j++)
            {
                IShape shapeAtPositionJ=listOfShape.get(j);
                IShape shapeAtNextPositionOfJ=listOfShape.get(j+1);
                if(shapeAtPositionJ.getTimeStamp()>shapeAtNextPositionOfJ.getTimeStamp())
                {
                    listOfShape.set(j, shapeAtNextPositionOfJ);
                    listOfShape.set(j+1, shapeAtPositionJ);
                }
            }
        }
        return listOfShape;
    }
    
    /**
     * static method for sorting of list of shapes on the basis of origin distance
     * @param listOfShape contains list of shapes which is to be sorted
     * @return returns sorted list
     */
    public static List<IShape> sortBasedOnOriginDistance(List<IShape> listOfShape)
    {
        for(int i=0;i<listOfShape.size()-1;i++)
        {
            for(int j=0;j<listOfShape.size()-i-1;j++)
            {
                IShape shapeAtPositionJ=listOfShape.get(j);
                IShape shapeAtNextPositionOfJ=listOfShape.get(j+1);
                if(shapeAtPositionJ.getOriginDistance()>shapeAtNextPositionOfJ.getOriginDistance())
                {
                    listOfShape.set(j, shapeAtNextPositionOfJ);
                    listOfShape.set(j+1, shapeAtPositionJ);
                }
            }
        }
        return listOfShape;
    }

}
