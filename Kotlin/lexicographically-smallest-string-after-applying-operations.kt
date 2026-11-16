package lexicographicallysmalleststringafterapplyingoperations

// Time:  O(100 * n^2) = O(n^2)
// Space: O(1)
class Solution {
    fun findLexSmallestString(s: String, a: Int, b: Int): String {
        val chars = s.toCharArray()
        var result = s
        val even = BooleanArray(10)
        while (!even[chars[0] - '0']) {
            even[chars[0] - '0'] = true
            val odd = BooleanArray(10)
            while (!odd[chars[1] - '0']) {
                odd[chars[1] - '0'] = true
                var bestRotate = 0
                val lookup = BooleanArray(chars.size)
                var i = b
                while (!lookup[i]) {
                    lookup[i] = true
                    if (less(chars, i, bestRotate)) {
                        bestRotate = i
                    }
                    i = (i + b) % chars.size
                }
                val rotation = String(chars, bestRotate, chars.size - bestRotate) +
                    String(chars, 0, bestRotate)
                result = minOf(result, rotation)
                for (k in 1 until chars.size step 2) {
                    chars[k] = '0' + (chars[k] - '0' + a) % 10
                }
            }
            if (b % 2 != 0) {
                for (k in chars.indices step 2) {
                    chars[k] = '0' + (chars[k] - '0' + a) % 10
                }
            }
        }
        return result
    }

    private fun less(s: CharArray, i: Int, j: Int): Boolean {
        for (k in s.indices) {
            if (s[(k + i) % s.size] != s[(k + j) % s.size]) {
                return s[(k + i) % s.size] < s[(k + j) % s.size]
            }
        }
        return false
    }
}
