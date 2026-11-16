package countoddlettersfromnumber

// Time:  O(logn)
// Space: O(26)
class Solution {
    fun countOddLetters(n: Int): Int {
        var number = n
        val lookup = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        val cnt = IntArray(26)
        while (number != 0) {
            val d = number % 10
            for (x in lookup[d]) {
                ++cnt[x - 'a']
            }
            number /= 10
        }
        var result = 0
        for (v in cnt) {
            result += v % 2
        }
        return result
    }
}
