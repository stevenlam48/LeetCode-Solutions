package slowestkey

// Time:  O(n)
// Space: O(1)

class Solution {
    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        var result = 'a'
        val lookup = IntArray(26)
        for (i in keysPressed.indices) {
            val c = keysPressed[i]
            lookup[c - 'a'] = maxOf(
                lookup[c - 'a'],
                releaseTimes[i] - (if (i > 0) releaseTimes[i - 1] else 0)
            )
            if (lookup[c - 'a'] > lookup[result - 'a'] ||
                (lookup[c - 'a'] == lookup[result - 'a'] && c > result)
            ) {
                result = c
            }
        }
        return result
    }
}
