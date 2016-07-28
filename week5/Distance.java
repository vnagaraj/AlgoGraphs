package week5;
/**
 * Distance class - computes the distance between a pair of points
 *
 * @author Vivekanand Ganapathy Nagarajan
 * @version 1.0 July 28th, 2016
 */

final class Distance implements Comparable<Distance> {
    final Point startPoint;
    final Point endPoint;
    final double distance;

    Distance(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distTo(startPoint, endPoint);
    }

    /**
     * Computes eucledian distance between a pair of points
     * @param first point
     * @param second point
     * @return distance
     */
    private double distTo(Point first, Point second){
        double x_diff = first.x - second.x;
        double y_diff = first.y - second.y;
        //eucledian distance between a pair of points
        double pow = Math.pow(x_diff, 2) + Math.pow(y_diff, 2);
        return Math.sqrt(pow);
    }

    @Override
    public int compareTo(Distance o) {
        if (this.distance <  o.distance){
            return -1;
        }
        if (this.distance > o.distance){
            return 1;
        }
        return 0;
    }
}