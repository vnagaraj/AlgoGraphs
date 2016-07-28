package week5;

/**
 * Point class - represents the co-ordinate x, y
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 1.0 July 28th, 2016
 */
class Point implements Comparable<Point>{
    final int x;
    final int y;
    double key;

    Point(int x, int y){
        this.x = x;
        this.y = y;
        //property used in Prim's algorithm
        this.key = Double.MAX_VALUE;
    }

    public String toString(){
        return "X = " + this.x + " Y = " + this.y;

    }

    @Override
    public int compareTo(Point o) {
        if (this.key <  o.key){
            return -1;
        }
        if (this.key > o.key){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * x;
        result += result * y;
        return result;
    }

}