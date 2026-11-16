package findthegridofregionaverage

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun resultGrid(image: Array<IntArray>, threshold: Int): Array<IntArray> {
        fun check(i: Int, j: Int): Boolean {
            for (ni in i - 1..i) {
                for (nj in j - 1..j + 1) {
                    if (kotlin.math.abs(image[ni][nj] - image[ni + 1][nj]) > threshold) {
                        return false
                    }
                }
            }
            for (ni in i - 1..i + 1) {
                for (nj in j - 1..j) {
                    if (kotlin.math.abs(image[ni][nj] - image[ni][nj + 1]) > threshold) {
                        return false
                    }
                }
            }
            return true
        }

        val result = Array(image.size) { IntArray(image[0].size) }
        val cnt = Array(image.size) { IntArray(image[0].size) }
        for (i in 1 until image.size - 1) {
            for (j in 1 until image[0].size - 1) {
                if (!check(i, j)) {
                    continue
                }
                var total = 0
                for (ni in i - 1..i + 1) {
                    for (nj in j - 1..j + 1) {
                        total += image[ni][nj]
                    }
                }
                total /= 9
                for (ni in i - 1..i + 1) {
                    for (nj in j - 1..j + 1) {
                        cnt[ni][nj] += 1
                        result[ni][nj] += total
                    }
                }
            }
        }
        for (i in image.indices) {
            for (j in image[0].indices) {
                if (cnt[i][j] != 0) {
                    result[i][j] /= cnt[i][j]
                } else {
                    result[i][j] = image[i][j]
                }
            }
        }
        return result
    }
}
