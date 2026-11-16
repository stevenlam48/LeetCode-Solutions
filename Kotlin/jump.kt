package jump

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    fun jump(A: IntArray, n: Int): Int {
        var ans = 0
        var last = 0
        var cur = 0
        for (i in 0 until n) {
            if (i > last) {
                ++ans
                last = cur
            }
            cur = maxOf(cur, i + A[i])
        }
        return ans
    }
}
