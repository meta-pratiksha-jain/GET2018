import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class ScreenTest {
    Screen screen=new Screen();
    List<Double> listOfParameters;
   
    //test case for addShape()
    @Test
    public void testAddShapeShouldReturnTrueWhenShapeAdded() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        Point point=new Point(1,2);
        boolean isAdded=screen.addShape(ShapeEnum.SQUARE, point, listOfParameters);
        assertEquals(true, isAdded);
    }
    
    @Test
    public void testAddShapeShouldReturnFalseWhenCoordinatesAreNotInRange() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        Point point=new Point(-1,2010);
        boolean isAdded=screen.addShape(ShapeEnum.CIRCLE, point, listOfParameters);
        assertEquals(false, isAdded);
    }
    
    //test cases for deleteShape()
    @Test
    public void testDeleteShapeShouldReturnTrueWhenShapeDeleted() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        Point point=new Point(1,2);
        screen.addShape(ShapeEnum.SQUARE, point, listOfParameters);
        boolean isDeleted=screen.deleteShape(ShapeEnum.SQUARE, point);
        assertEquals(true, isDeleted);
    }
    
    @Test
    public void testDeleteShapeShouldReturnFalseWhenTypeAndOriginNotMatches() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        Point origin=new Point(1,2);
        screen.addShape(ShapeEnum.CIRCLE, origin, listOfParameters);
        Point point=new Point(2,3);
        boolean isDeleted=screen.deleteShape(ShapeEnum.RECTANGLE, point);
        assertEquals(false, isDeleted);
    }
    
    @Test
    public void testDeleteShapeShouldReturnFalseWhenScreenIsEmpty() {
        Point point=new Point(1,2);
        boolean isDeleted=screen.deleteShape(ShapeEnum.RECTANGLE, point);
        assertEquals(false, isDeleted);
    }
    
    //Test cases for deleteAllShapeOfSpecifiedType()
    @Test
    public void testDeleteAllShapeShouldReturnTrueWhenShapeTypeMatches() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        Point point=new Point(1,2);
        screen.addShape(ShapeEnum.CIRCLE, point, listOfParameters);
        
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(4.0);
        point=new Point(3,6);
        screen.addShape(ShapeEnum.CIRCLE, point, listOfParameters);
        
        boolean isRemoved=screen.deleteAllShapesOfSpecifiedType(ShapeEnum.CIRCLE);;
        assertEquals(true,isRemoved);    
    }
    
    @Test
    public void testDeleteAllShapeShouldReturnFalseWhenShapeTypeNotMatches() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        listOfParameters.add(3.3);
        Point point=new Point(1,2);
        screen.addShape(ShapeEnum.RECTANGLE, point, listOfParameters);
        
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(4.0);
        point=new Point(3,6);
        screen.addShape(ShapeEnum.CIRCLE, point, listOfParameters);
        
        boolean isRemoved=screen.deleteAllShapesOfSpecifiedType(ShapeEnum.SQUARE);
        assertEquals(false,isRemoved);    
    }
    
    //Test cases for sortListOfShape()
    @Test
    public void testSortListOfShapeShouldReturnSortedListBasedOnArea() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        listOfParameters.add(3.3);
        Point point=new Point(1,2);
        screen.addShape(ShapeEnum.RECTANGLE, point, listOfParameters);
        
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(4.0);
        point=new Point(3,6);
        screen.addShape(ShapeEnum.CIRCLE, point, listOfParameters);
        
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        point=new Point(1,2);
        screen.addShape(ShapeEnum.SQUARE, point, listOfParameters);
        
        List<IShape> sortedList=screen.sortListOfShape("area");
        double[] actualOutput=new double[sortedList.size()];
        for(int i=0;i<sortedList.size();i++)
        {
            actualOutput[i]=sortedList.get(i).getArea();
        }
        double[] expectedOutput={4.0,6.6,50.24};
        assertArrayEquals(expectedOutput, actualOutput,0.01);
    }
    
    @Test
    public void testSortListOfShapeShouldReturnSortedListBasedOnPerimeter() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        listOfParameters.add(3.3);
        Point point=new Point(1,2);
        screen.addShape(ShapeEnum.RECTANGLE, point, listOfParameters);
        
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(4.0);
        point=new Point(3,6);
        screen.addShape(ShapeEnum.CIRCLE, point, listOfParameters);
        
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        point=new Point(1,2);
        screen.addShape(ShapeEnum.SQUARE, point, listOfParameters);
        
        List<IShape> sortedList=screen.sortListOfShape("perimeter");
        double[] actualOutput=new double[sortedList.size()];
        for(int i=0;i<sortedList.size();i++)
        {
            actualOutput[i]=sortedList.get(i).getPerimeter();
        }
        double[] expectedOutput={8.0,10.6,25.12};
        assertArrayEquals(expectedOutput, actualOutput,0.01);
    }
    
    @Test
    public void testSortListOfShapeShouldReturnSortedListBasedOnOriginDistance() {
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        listOfParameters.add(3.3);
        Point point=new Point(1.0,1.0);
        screen.addShape(ShapeEnum.RECTANGLE, point, listOfParameters);
        
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(4.0);
        point=new Point(3.0,2.1);
        screen.addShape(ShapeEnum.CIRCLE, point, listOfParameters);
        
        listOfParameters=new ArrayList<Double>();
        listOfParameters.add(2.0);
        point=new Point(1.0,0.5);
        screen.addShape(ShapeEnum.SQUARE, point, listOfParameters);
        
        List<IShape> sortedList=screen.sortListOfShape("originDistance");
        double[] actualOutput=new double[sortedList.size()];
        for(int i=0;i<sortedList.size();i++)
        {
            actualOutput[i]=sortedList.get(i).getOriginDistance();
        }
        double[] expectedOutput={1.11,1.41,3.26};
        assertArrayEquals(expectedOutput, actualOutput,0.5);
    }

}
