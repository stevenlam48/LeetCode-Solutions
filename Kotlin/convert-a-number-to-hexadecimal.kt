package convertanumbertohexadecimal
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun toHex(num: Int): String {
        if (num == 0) {
            return "0"
        }
        val result = StringBuilder()
        var value = num
        while (value != 0 && result.length != Int.SIZE_BITS / 4) {
            val hex = value and 15
            if (hex < 10) {
                result.append(('0'.code + hex).toChar())
            } else {
                result.append(('a'.code + hex - 10).toChar())
            }
            value = value shr 4
        }
        return result.reverse().toString()
    }
}
