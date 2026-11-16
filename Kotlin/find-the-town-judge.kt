package findthetownjudge

// Time:  O(t + n)
// Space: O(n)

class Solution {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val degrees = IntArray(N)
        for (t in trust) {
            degrees[t[0] - 1] -= 1
            degrees[t[1] - 1] += 1
        }
        for (i in degrees.indices) {
            if (degrees[i] == N - 1) {
                return i + 1
            }
        }
        return -1
    }
}
