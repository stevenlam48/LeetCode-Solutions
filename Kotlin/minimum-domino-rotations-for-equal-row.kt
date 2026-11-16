package minimumdominorotationsforequalrow
// Time:  O(n)
// Space: O(1)

import java.util.TreeSet

class Solution {
    fun minDominoRotations(A: IntArray, B: IntArray): Int {
        val intersect = TreeSet<Int>()
        intersect.add(A[0])
        intersect.add(B[0])
        var i = 1
        while (i < A.size && intersect.isNotEmpty()) {
            intersect.retainAll(setOf(A[i], B[i]))
            ++i
        }
        if (intersect.isEmpty()) {
            return -1
        }
        val x = intersect.first()
        return minOf(A.size - A.count { it == x }, B.size - B.count { it == x })
    }
}
