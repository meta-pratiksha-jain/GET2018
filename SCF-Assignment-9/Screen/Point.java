
public class Point {
    public double xCoordinate;
    public double yCoordinate;
    
    /**
     * constructor
     * @param xCoordinate
     * @param yCoordinate
     */
    public Point(double xCoordinate,double yCoordinate)
    {
        this.xCoordinate=xCoordinate;
        this.yCoordinate=yCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    

}
