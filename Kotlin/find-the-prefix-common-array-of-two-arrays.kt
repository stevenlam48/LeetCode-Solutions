package findtheprefixcommonarrayoftwoarrays

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val result = IntArray(A.size)
        val cnt = HashMap<Int, Int>()
        var curr = 0
        for (i in result.indices) {
            cnt[A[i]] = cnt.getOrDefault(A[i], 0) + 1
            if (cnt[A[i]] == 2) {
                ++curr
            }
            cnt[B[i]] = cnt.getOrDefault(B[i], 0) + 1
            if (cnt[B[i]] == 2) {
                ++curr
            }
            result[i] = curr
        }
        return result
    }
}
