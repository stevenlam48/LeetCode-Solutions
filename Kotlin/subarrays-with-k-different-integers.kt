package subarrayswithkdifferentintegers

// Time:  O(n)
// Space: O(k)

class Solution {
    fun subarraysWithKDistinct(A: IntArray, K: Int): Int {
        return atMostK(A, K) - atMostK(A, K - 1)
    }

    private fun atMostK(A: IntArray, K: Int): Int {
        var result = 0
        var left = 0
        val count = HashMap<Int, Int>()
        for (right in A.indices) {
            count[A[right]] = (count[A[right]] ?: 0) + 1
            while (count.size > K) {
                val c = (count[A[left]] ?: 0) - 1
                if (c == 0) {
                    count.remove(A[left])
                } else {
                    count[A[left]] = c
                }
                ++left
            }
            result += right - left + 1
        }
        return result
    }
}
