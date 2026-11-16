package bitwiseorsofsubarrays

// Time:  O(32 * n)
// Space: O(1)

class Solution {
    fun subarrayBitwiseORs(A: IntArray): Int {
        val result = HashSet<Int>()
        var curr = HashSet<Int>()
        for (i in A) {
            val next = HashSet<Int>()
            next.add(i)
            for (j in curr) {
                next.add(i or j)
            }
            curr = next
            result.addAll(curr)
        }
        return result.size
    }
}
