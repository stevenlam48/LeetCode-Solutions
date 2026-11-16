package designanarraystatisticstracker

import java.util.ArrayDeque
import java.util.TreeMap
import java.util.TreeSet

// Time:  ctor:                   O(1)
//        addNumber:              O(logn)
//        removeFirstAddedNumber: O(logn)
//        getMean:                O(1)
//        getMedian:              O(1)
//        getMode:                O(1)
// Space: O(n)

class StatisticsTracker {
    private var total = 0L
    private val dq = ArrayDeque<Int>()
    private val numToFreq = HashMap<Int, Int>()
    private val freqToNums = TreeMap<Int, TreeSet<Int>>()
    private val bst1 = TreeMap<Int, Int>()
    private val bst2 = TreeMap<Int, Int>()
    private var bst1Size = 0
    private var bst2Size = 0

    fun addNumber(number: Int) {
        total += number
        dq.addLast(number)
        update(number, 1)
        if (bst2.isEmpty() || bst2.firstKey() <= number) {
            addTo(bst2, number)
            ++bst2Size
        } else {
            addTo(bst1, number)
            ++bst1Size
        }
        rebalance()
    }

    fun removeFirstAddedNumber() {
        val number = dq.removeFirst()
        total -= number
        update(number, -1)
        if (bst2.containsKey(number)) {
            removeFrom(bst2, number)
            --bst2Size
        } else {
            removeFrom(bst1, number)
            --bst1Size
        }
        rebalance()
    }

    fun getMean(): Int {
        return (total / dq.size).toInt()
    }

    fun getMedian(): Int {
        return bst2.firstKey()
    }

    fun getMode(): Int {
        return freqToNums.lastEntry().value.first()
    }

    private fun update(number: Int, d: Int) {
        val old = numToFreq[number]
        if (old != null) {
            val set = freqToNums[old]!!
            set.remove(number)
            if (set.isEmpty()) {
                freqToNums.remove(old)
            }
        }
        val newFreq = (old ?: 0) + d
        if (newFreq == 0) {
            numToFreq.remove(number)
        } else {
            numToFreq[number] = newFreq
            freqToNums.getOrPut(newFreq) { TreeSet() }.add(number)
        }
    }

    private fun rebalance() {
        if (bst2Size == bst1Size + 2) {
            val x = bst2.firstKey()
            removeFrom(bst2, x)
            --bst2Size
            addTo(bst1, x)
            ++bst1Size
        } else if (bst2Size + 1 == bst1Size) {
            val x = bst1.lastKey()
            removeFrom(bst1, x)
            --bst1Size
            addTo(bst2, x)
            ++bst2Size
        }
    }

    private fun addTo(map: TreeMap<Int, Int>, x: Int) {
        map[x] = (map[x] ?: 0) + 1
    }

    private fun removeFrom(map: TreeMap<Int, Int>, x: Int) {
        val c = map[x]!!
        if (c == 1) {
            map.remove(x)
        } else {
            map[x] = c - 1
        }
    }
}
