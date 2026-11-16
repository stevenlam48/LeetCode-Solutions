package convertdatetobinary
// Time:  O(1)
// Space: O(1)

class Solution {
    fun convertDateToBinary(date: String): String {
        fun bin(value: Int): String {
            val result = StringBuilder()
            var x = value
            while (x != 0) {
                result.append(if (x and 1 == 1) '1' else '0')
                x = x shr 1
            }
            return result.reverse().toString()
        }
        return bin(date.substring(0, 4).toInt()) + "-" +
            bin(date.substring(5, 7).toInt()) + "-" +
            bin(date.substring(8, 10).toInt())
    }
}
