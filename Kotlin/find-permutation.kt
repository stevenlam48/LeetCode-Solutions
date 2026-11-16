package findpermutation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findPermutation(s: String): IntArray {
        val result = mutableListOf<Int>()
        for (i in 0..s.length) {
            if (i == s.length || s[i] == 'I') {
                val k = result.size
                for (j in i + 1 downTo k + 1) {
                    result.add(j)
                }
            }
        }
        return result.toIntArray()
    }
}
