package examroom

import java.util.TreeSet

// Time:  seat:  O(logn),
//        leave: O(logn)
// Space: O(n)
class ExamRoom(private val num: Int) {
    private val maxBst = TreeSet<Pair<Int, Int>>(Comparator { a, b ->
        val distA = distance(a)
        val distB = distance(b)
        if (distA == distB) a.first.compareTo(b.first) else distB.compareTo(distA)
    })
    private val seats = TreeSet<Int>()

    init {
        seats.add(-1)
        seats.add(num)
        maxBst.add(Pair(-1, num))
    }

    fun seat(): Int {
        val top = maxBst.first()
        maxBst.remove(top)
        val mid = if (top.first == -1) {
            0
        } else if (top.second == num) {
            num - 1
        } else {
            (top.first + top.second) / 2
        }
        seats.add(mid)
        maxBst.add(Pair(top.first, mid))
        maxBst.add(Pair(mid, top.second))
        return mid
    }

    fun leave(p: Int) {
        val left = seats.lower(p)!!
        val right = seats.higher(p)!!
        maxBst.remove(Pair(left, p))
        maxBst.remove(Pair(p, right))
        seats.remove(p)
        maxBst.add(Pair(left, right))
    }

    private fun distance(segment: Pair<Int, Int>): Int {
        return if (segment.first == -1 || segment.second == num) {
            segment.second - segment.first - 1
        } else {
            (segment.second - segment.first) / 2
        }
    }
}
