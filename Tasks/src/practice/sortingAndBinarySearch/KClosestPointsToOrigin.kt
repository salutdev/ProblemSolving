package practice.sortingAndBinarySearch

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

class KClosestPointsToOrigin {

    /*
     We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
    */
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {

        val pq = PriorityQueue<IntArray> { a, b ->
            val d1 = sqrt(a[0].toDouble().pow(2.toDouble()) + a[1].toDouble().pow(2.toDouble()))
            val d2 = sqrt(b[0].toDouble().pow(2.toDouble()) + b[1].toDouble().pow(2.toDouble()))
            if (d1 > d2) 1 else if (d1 == d2) 0 else -1
        }

        for (p in points) {
            pq.add(p)
        }

        val result = Array(K) { IntArray(2) }

        for (i in 0 until K) {
            if (pq.isNotEmpty()) {
                result[i] = pq.remove()
            }
        }

        return result
    }
}