package JavaOOP.WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    Rectangle(Point bottomLeft, Point topRight){
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
    public boolean contains(Point point) {
        boolean isIn = false;
        if (point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX()) {
            if (point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY()) {
                isIn = true;
            }
        }
        return isIn;
    }
}
