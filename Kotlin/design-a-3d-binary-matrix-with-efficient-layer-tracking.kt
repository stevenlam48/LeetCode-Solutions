package designa3dbinarymatrixwithefficientlayertracking

import java.util.TreeMap
import java.util.TreeSet

// Time:  ctor:          O(1)
//        setCell:       O(logn)
//        unsetCell:     O(logn)
//        largestMatrix: O(logn)
// Space: O(n^3)

class Matrix3D(private val n: Int) {
    private val matrix = HashMap<Int, HashMap<Int, HashSet<Int>>>()
    private val cnt = HashMap<Int, Int>()
    private val bst = TreeMap<Int, TreeSet<Int>>()

    init {
        bst[0] = TreeSet<Int>().apply { add(n - 1) }
    }

    fun setCell(x: Int, y: Int, z: Int) {
        val row = matrix.getOrPut(x) { HashMap() }
        val cells = row.getOrPut(y) { HashSet() }
        if (cells.contains(z)) {
            return
        }
        cells.add(z)
        val c = cnt[x] ?: 0
        if (c != 0 || x == n - 1) {
            bst[c]?.let { set ->
                set.remove(x)
                if (set.isEmpty()) {
                    bst.remove(c)
                }
            }
        }
        cnt[x] = c + 1
        bst.getOrPut(c + 1) { TreeSet() }.add(x)
    }

    fun unsetCell(x: Int, y: Int, z: Int) {
        val row = matrix[x] ?: return
        val cells = row[y] ?: return
        if (!cells.contains(z)) {
            return
        }
        cells.remove(z)
        if (cells.isEmpty()) {
            row.remove(y)
            if (row.isEmpty()) {
                matrix.remove(x)
            }
        }
        val c = cnt[x] ?: 0
        bst[c]?.let { set ->
            set.remove(x)
            if (set.isEmpty()) {
                bst.remove(c)
            }
        }
        cnt[x] = c - 1
        if (c - 1 != 0 || x == n - 1) {
            bst.getOrPut(c - 1) { TreeSet() }.add(x)
        }
    }

    fun largestMatrix(): Int {
        return bst.lastEntry().value.last()
    }
}
