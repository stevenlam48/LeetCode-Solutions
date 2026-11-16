package designanumbercontainersystem

import java.util.TreeSet

// Time:  ctor:   O(1)
//        change: O(logn)
//        find:   O(1)
// Space: O(n)

class NumberContainers {
    private val idxToNum = HashMap<Int, Int>()
    private val numToIdxs = HashMap<Int, TreeSet<Int>>()

    fun change(index: Int, number: Int) {
        val old = idxToNum[index]
        if (old != null) {
            val set = numToIdxs[old]!!
            set.remove(index)
            if (set.isEmpty()) {
                numToIdxs.remove(old)
            }
        }
        idxToNum[index] = number
        numToIdxs.getOrPut(number) { TreeSet() }.add(index)
    }

    fun find(number: Int): Int {
        return numToIdxs[number]?.first() ?: -1
    }
}
