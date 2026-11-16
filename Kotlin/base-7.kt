package base7

// Time:  O(1)
// Space: O(1)

class Solution {
    fun convertToBase7(num: Int): String {
        if (num < 0) {
            return "-" + convertToBase7(-num)
        }
        var value = num
        val result = StringBuilder()
        while (value != 0) {
            result.append(value % 7)
            value /= 7
        }
        return if (result.isEmpty()) "0" else result.reverse().toString()
    }
}
