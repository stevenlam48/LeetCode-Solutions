package totaldistancetotypeastringusingonefinger

import kotlin.math.abs

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun totalDistance(s: String): Int {
        var result = 0
        var prev = LOOKUP[0]
        for (x in s) {
            val curr = LOOKUP[x - 'a']
            result += abs(curr.first - prev.first) + abs(curr.second - prev.second)
            prev = curr
        }
        return result
    }

    companion object {
        private val KEYBOARD = arrayOf("qwertyuiop", "asdfghjkl", "zxcvbnm")

        private val LOOKUP = Array(26) { 0 to 0 }.also { lookup ->
            for (i in KEYBOARD.indices) {
                for (j in KEYBOARD[i].indices) {
                    lookup[KEYBOARD[i][j] - 'a'] = i to j
                }
            }
        }
    }
}
