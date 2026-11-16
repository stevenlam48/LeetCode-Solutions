package stringcompression
// Time:  O(n)
// Space: O(1)

class Solution {
    fun compress(chars: CharArray): Int {
        var write = 0
        var anchor = 0
        for (read in chars.indices) {
            if (read + 1 == chars.size || chars[read + 1] != chars[read]) {
                chars[write++] = chars[read]
                if (read - anchor > 0) {
                    var n = read - anchor + 1
                    var count = 0
                    while (n > 0) {
                        chars[write++] = ('0'.code + n % 10).toChar()
                        n /= 10
                        ++count
                    }
                    var left = write - count
                    var right = write - 1
                    while (left < right) {
                        val temporary = chars[left]
                        chars[left] = chars[right]
                        chars[right] = temporary
                        ++left
                        --right
                    }
                }
                anchor = read + 1
            }
        }
        return write
    }
}
