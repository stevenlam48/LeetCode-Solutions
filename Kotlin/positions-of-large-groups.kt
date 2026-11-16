package positionsoflargegroups
// Time:  O(n)
// Space: O(1)

class Solution {
    fun largeGroupPositions(S: String): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        for (j in S.indices) {
            if (j == S.length - 1 || S[j] != S[j + 1]) {
                if (j - i + 1 >= 3) {
                    result.add(intArrayOf(i, j))
                }
                i = j + 1
            }
        }
        return result.toTypedArray()
    }
}
