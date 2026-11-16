package studentattendancerecordii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkRecord(n: Int): Int {
        val M = 1000000007L
        var a0l0 = 1L
        var a0l1 = 0L
        var a0l2 = 0L
        var a1l0 = 0L
        var a1l1 = 0L
        var a1l2 = 0L
        for (i in 0..n) {
            val newA0l0 = (a0l0 + a0l1 + a0l2) % M
            a0l2 = a0l1
            a0l1 = a0l0
            a0l0 = newA0l0
            val newA1l0 = (a0l0 + a1l0 + a1l1 + a1l2) % M
            a1l2 = a1l1
            a1l1 = a1l0
            a1l0 = newA1l0
        }
        return a1l0.toInt()
    }
}
