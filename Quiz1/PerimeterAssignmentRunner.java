import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numPoints = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            
            // Update prevPt to be currPt
            prevPt = currPt;
            numPoints += 1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double points = getNumPoints(s);
        double perimeter = getPerimeter(s);
        return (perimeter/points);
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if(currDist > largestSide){
                largestSide = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
            
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        for (Point p : s.getPoints()){
            if(p.getX() > largestX){
                largestX = p.getX();
            
        }
    }
    return largestX;
}

    public double getLargestPerimeterMultipleFiles() {
        double largestPerimeter = 0.0;
        
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape tempS = new Shape(fr);
            if(getPerimeter(tempS) > largestPerimeter){
                largestPerimeter = getPerimeter(tempS);
            }
        }
        System.out.println(largestPerimeter);
        return 0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        
        
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points = getNumPoints(s);
        System.out.println("points = " + points);
        double largestSide = getLargestSide(s);
        System.out.println("largestSide = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("largestX = " + largestX);
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p.getX());
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
