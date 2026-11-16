package findingmkaverage

// Time:  ctor:           O(1)
//        add_element:    O(logn)
//        calc_mkaverage: O(1)
// Space: O(m)

import java.util.ArrayDeque
import java.util.TreeMap

private class MultiSet {
    private val counts = TreeMap<Int, Int>()
    var size = 0
        private set

    fun add(value: Int) {
        counts[value] = (counts[value] ?: 0) + 1
        ++size
    }

    fun remove(value: Int) {
        val count = counts[value]!!
        if (count == 1) {
            counts.remove(value)
        } else {
            counts[value] = count - 1
        }
        --size
    }

    fun first(): Int = counts.firstKey()

    fun last(): Int = counts.lastKey()

    fun find(value: Int): Int = value
}

class MKAverage(private val m: Int, private val k: Int) {
    private val queue = ArrayDeque<Int>()
    private val left = MultiSet()
    private val mid = MultiSet()
    private val right = MultiSet()
    private var total = 0L

    fun addElement(num: Int) {
        if (queue.size == m) {
            remove(queue.first())
            queue.removeFirst()
        }
        queue.addLast(num)
        add(num)
    }

    fun calculateMKAverage(): Int {
        if (queue.size < m) {
            return -1
        }
        return (total / (m - 2 * k)).toInt()
    }

    private fun add(num: Int) {
        left.add(num)
        if (left.size > k) {
            val value = left.last()
            mid.add(value)
            total += value
            left.remove(value)
        }
        if (mid.size > m - 2 * k) {
            val value = mid.last()
            total -= value
            right.add(value)
            mid.remove(value)
        }
    }

    private fun remove(num: Int) {
        if (num <= left.last()) {
            left.remove(left.find(num))
        } else if (num <= mid.last()) {
            val value = mid.find(num)
            total -= value
            mid.remove(value)
        } else {
            right.remove(right.find(num))
        }
        if (left.size < k) {
            val value = mid.first()
            left.add(value)
            total -= value
            mid.remove(value)
        }
        if (mid.size < m - 2 * k) {
            val value = right.first()
            mid.add(value)
            total += value
            right.remove(value)
        }
    }
}
