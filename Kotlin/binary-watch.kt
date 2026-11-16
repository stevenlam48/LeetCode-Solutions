package binarywatch

// Time:  O(1)
// Space: O(1)
class Solution {
    fun readBinaryWatch(num: Int): List<String> {
        val result = mutableListOf<String>()
        for (h in 0 until 12) {
            for (m in 0 until 60) {
                if (bitCount(h) + bitCount(m) == num) {
                    val hour = h.toString()
                    val minute = if (m < 10) "0$m" else m.toString()
                    result.add("$hour:$minute")
                }
            }
        }
        return result
    }

    private fun bitCount(bits: Int): Int {
        var value = bits
        var count = 0
        while (value != 0) {
            ++count
            value = value and (value - 1)
        }
        return count
    }
}
