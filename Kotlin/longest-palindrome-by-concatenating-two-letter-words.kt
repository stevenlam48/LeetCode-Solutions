package longestpalindromebyconcatenatingtwoletterwords

// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestPalindrome(words: Array<String>): Int {
        val cnt = HashMap<String, Int>()
        for (x in words) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        var result = 0
        var remain = 0
        for ((x, c) in cnt) {
            val mirror = x.reversed()
            if (x == mirror) {
                result += c / 2
                remain = remain or (c % 2)
            } else if (x < mirror && cnt.containsKey(mirror)) {
                result += minOf(c, cnt[mirror]!!)
            }
        }
        return result * 4 + remain * 2
    }
}
