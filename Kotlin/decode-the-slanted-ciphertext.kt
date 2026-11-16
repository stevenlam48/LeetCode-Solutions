package decodetheslantedciphertext

// Time:  O(n)
// Space: O(1)

class Solution {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        val n = encodedText.length
        val cols = n / rows
        var k = n
        var i = cols - 1
        while (i >= 0 && k == n) {
            var j = i + ((n - 1) - i) / (cols + 1) * (cols + 1)
            while (j >= i) {
                if (encodedText[j] != ' ') {
                    k = j
                    break
                }
                j -= cols + 1
            }
            --i
        }
        val result = StringBuilder()
        var col = 0
        while (col < cols && k != -1) {
            var j = col
            while (j < n) {
                result.append(encodedText[j])
                if (j == k) {
                    k = -1
                    break
                }
                j += cols + 1
            }
            ++col
        }
        return result.toString()
    }
}
