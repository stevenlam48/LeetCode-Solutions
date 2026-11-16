package findthemaximumnumberoffruitscollected

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun maxCollectedFruits(fruits: Array<IntArray>): Int {
        val n = fruits.size

        var result = 0
        for (i in 0 until n) {
            result += fruits[i][i]
        }

        for (i in 0 until n) {
            for (j in i + 1 until n - (i + 1)) {
                fruits[i][j] = 0
            }
        }
        for (i in 1 until n - 1) {
            for (j in i + 1 until n) {
                fruits[i][j] += maxOf(
                    fruits[i - 1][j - 1],
                    fruits[i - 1][j],
                    if (j + 1 < n) fruits[i - 1][j + 1] else 0
                )
            }
        }
        result += fruits[n - 2][n - 1]

        for (j in 0 until n) {
            for (i in j + 1 until n - (j + 1)) {
                fruits[i][j] = 0
            }
        }
        for (j in 1 until n - 1) {
            for (i in j + 1 until n) {
                fruits[i][j] += maxOf(
                    fruits[i - 1][j - 1],
                    fruits[i][j - 1],
                    if (i + 1 < n) fruits[i + 1][j - 1] else 0
                )
            }
        }
        result += fruits[n - 1][n - 2]

        return result
    }
}
