package sumofsubarrayminimums

// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun sumSubarrayMins(A: IntArray): Int {
        val mod = 1_000_000_007
        val left = IntArray(A.size)
        val s1 = ArrayDeque<Pair<Int, Int>>()
        for (i in A.indices) {
            var count = 1
            while (s1.isNotEmpty() && s1.peek().first > A[i]) {
                count += s1.peek().second
                s1.pop()
            }
            s1.push(A[i] to count)
            left[i] = count
        }

        val right = IntArray(A.size)
        val s2 = ArrayDeque<Pair<Int, Int>>()
        for (i in A.indices.reversed()) {
            var count = 1
            while (s2.isNotEmpty() && s2.peek().first >= A[i]) {
                count += s2.peek().second
                s2.pop()
            }
            s2.push(A[i] to count)
            right[i] = count
        }

        var result = 0L
        for (i in A.indices) {
            result = (result + A[i].toLong() * left[i] * right[i]) % mod
        }
        return result.toInt()
    }
}
