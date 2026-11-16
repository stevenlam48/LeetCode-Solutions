package stringwithoutaaaorbbb
// Time:  O(a + b)
// Space: O(1)

class Solution {
    fun strWithout3a3b(a: Int, b: Int): String {
        var remainingA = a
        var remainingB = b
        val result = StringBuilder()
        var putA = false
        while (remainingA != 0 || remainingB != 0) {
            putA = if (result.length >= 2 && result[result.length - 1] == result[result.length - 2]) {
                result[result.length - 1] == 'b'
            } else {
                remainingA >= remainingB
            }
            if (putA) {
                --remainingA
                result.append('a')
            } else {
                --remainingB
                result.append('b')
            }
        }
        return result.toString()
    }
}
