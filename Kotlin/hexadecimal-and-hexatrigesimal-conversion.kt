package hexadecimalandhexatrigesimalconversion
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun concatHex36(n: Int): String {
        val lookup = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        fun convert(value: Int, radix: Int): String {
            var current = value
            val result = StringBuilder()
            while (current != 0) {
                result.append(lookup[current % radix])
                current /= radix
            }
            return result.reverse().toString()
        }

        return convert(n * n, 16) + convert(n * n * n, 36)
    }
}
