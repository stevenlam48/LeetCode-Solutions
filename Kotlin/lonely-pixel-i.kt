package lonelypixeli

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun findLonelyPixel(picture: Array<CharArray>): Int {
        val rows = IntArray(picture.size)
        val cols = IntArray(picture[0].size)

        for (i in picture.indices) {
            for (j in picture[0].indices) {
                if (picture[i][j] == 'B') {
                    ++rows[i]
                    ++cols[j]
                }
            }
        }

        var result = 0
        for (i in picture.indices) {
            if (rows[i] == 1) {
                for (j in picture[0].indices) {
                    if (picture[i][j] == 'B' && cols[j] == 1) {
                        ++result
                    }
                }
            }
        }
        return result
    }
}
