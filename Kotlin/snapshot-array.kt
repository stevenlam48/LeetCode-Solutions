package snapshotarray

import java.util.TreeMap

// Time:  set: O(1)
//        get: O(logn), n is the total number of set
// Space: O(n)

class SnapshotArray(length: Int) {
    private val a = HashMap<Int, TreeMap<Int, Int>>()
    private var snapId = 0

    fun set(index: Int, value: Int) {
        a.getOrPut(index) { TreeMap() }[snapId] = value
    }

    fun snap(): Int {
        return snapId++
    }

    fun get(index: Int, snapId: Int): Int {
        return a[index]?.floorEntry(snapId)?.value ?: 0
    }
}
