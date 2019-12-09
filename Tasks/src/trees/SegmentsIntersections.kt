package trees

import trees.model.RangeTree
import java.util.*

// Given a set of horizontal and vertical line segments, find the number of squares formed by them?
class SegmentsIntersections {

    fun calc() {
        val segments = getSegments()
        val pq = getPriorityQueue(segments)

        //printPriorityQueue(pq)
        //val root = RangeTree.getExampleTree4()

        val rangeTree = RangeTree()
        //rangeTree.root = root

        var intersectionSum = 0

        while(pq.isNotEmpty()) {

            val pair = pq.remove()
            if (pair.second.isVertical()) {
                rangeTree.calcRanks()
                // Find intersections

                val vStartNode = rangeTree.search(pair.second.start.y, RangeTree.Comparison.Greater)
                val vEndNode = rangeTree.search(pair.second.end.y, RangeTree.Comparison.Less)
                var intersectionCount = vEndNode!!.rank - vStartNode!!.rank + 1
                intersectionSum += intersectionCount
                println("$intersectionCount intersections")

            } else {
                if (pair.first == pair.second.start) {
                    rangeTree.insert(pair.first.y)
                } else if (pair.first == pair.second.end) {
                    rangeTree.delete(pair.first.y)
                }
            }
        }

        println("Overall $intersectionSum intersections")

        //rangeTree.delete(58)

    }

    private fun printPriorityQueue(pq: PriorityQueue<Pair<Point, LineSegment>>) {
        while (pq.isNotEmpty()) {
            val pair = pq.remove()
            println("(${pair.first.x}, ${pair.first.y})")
        }
    }

    private fun getPriorityQueue(segments: Array<LineSegment>): PriorityQueue<Pair<Point, LineSegment>> {
        val pq = PriorityQueue<Pair<Point, LineSegment>> { p1, p2 ->
            if (p1.first.x > p2.first.x) 1 else if (p1.first.x == p2.first.x) 0 else -1
        }

        segments.forEach { s ->
            if (s.isVertical()) {
                pq.add(Pair(s.start, s))
            } else {
                pq.add(Pair(s.start, s))
                pq.add(Pair(s.end, s))
            }
        }
        return pq
    }

    private fun getSegments(): Array<LineSegment> {
        return arrayOf(
            LineSegment(Point(1, 1), Point(4, 1)),
            LineSegment(Point(2, 2), Point(5, 2)),
            LineSegment(Point(3, 0), Point(3, 5)),
            LineSegment(Point(1, 4), Point(6, 4)),
            LineSegment(Point(4, 2), Point(4, 6))
        )
    }
}

class LineSegment (val start: Point, val end: Point) {
    fun isVertical() = start.x == end.x
}

data class Point(val x: Int, val y: Int)