package zigzagconversion

// Time:  O(n)
// Space: O(1)

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        val step = 2 * numRows - 2
        val zigzag = StringBuilder()
        for (i in 0 until numRows) {
            var j = i
            while (j < s.length) {
                zigzag.append(s[j])
                if (0 < i && i < numRows - 1 && j + step - 2 * i < s.length) {
                    zigzag.append(s[j + step - 2 * i])
                }
                j += step
            }
        }
        return zigzag.toString()
    }
}
