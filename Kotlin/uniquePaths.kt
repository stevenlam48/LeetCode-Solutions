package uniquePaths

// Time Complexity: O(mn)
// Space Complexity: O(mn)

class Solution {
    private val hash = HashMap<Int, HashMap<Int, Int>>()

    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 0 || n == 0) {
            return 0
        }
        if (m == 1 || n == 1) {
            return 1
        }
        if (hash[m]?.containsKey(n) == true) {
            return hash[m]!![n]!!
        }
        val result = uniquePaths(m - 1, n) + uniquePaths(m, n - 1)
        hash.getOrPut(m) { HashMap() }[n] = result
        return result
    }
}
