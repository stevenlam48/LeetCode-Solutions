package decodedstringatindex

// Time:  O(n)
// Space: O(1)

class Solution {
    fun decodeAtIndex(S: String, K: Int): String {
        var k = K
        var n = 0L
        for (i in S.indices) {
            if (S[i].isDigit()) {
                n *= S[i] - '0'
            } else {
                ++n
            }
        }

        for (i in S.length - 1 downTo 0) {
            k = (k % n).toInt()
            if (k == 0 && S[i].isLetter()) {
                return "" + S[i]
            }

            if (S[i].isDigit()) {
                n /= S[i] - '0'
            } else {
                --n
            }
        }
        throw IllegalStateException()
    }
}
