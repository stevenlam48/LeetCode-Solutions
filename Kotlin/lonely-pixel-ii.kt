package lonelypixelii

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun findBlackPixel(picture: Array<CharArray>, N: Int): Int {
        val rows = IntArray(picture.size)
        val cols = IntArray(picture[0].size)

        val lookup = HashMap<String, Int>()
        val srows = ArrayList<String>()
        for (i in picture.indices) {
            val sb = StringBuilder()
            for (j in picture[0].indices) {
                if (picture[i][j] == 'B') {
                    ++rows[i]
                    ++cols[j]
                }
                sb.append(picture[i][j])
            }
            val s = sb.toString()
            lookup[s] = (lookup[s] ?: 0) + 1
            srows.add(s)
        }

        var result = 0
        for (i in picture.indices) {
            if (rows[i] == N && lookup[srows[i]] == N) {
                for (j in picture[0].indices) {
                    if (picture[i][j] == 'B' && cols[j] == N) {
                        ++result
                    }
                }
            }
        }
        return result
    }
}
