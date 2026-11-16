package singlerowkeyboard

// Time:  O(n)
// Space: O(1)
class Solution {
    fun calculateTime(keyboard: String, word: String): Int {
        val lookup = HashMap<Char, Int>()
        for (i in keyboard.indices) {
            lookup[keyboard[i]] = i
        }
        var result = 0
        var prev = 0
        for (c in word) {
            result += kotlin.math.abs(lookup.getValue(c) - prev)
            prev = lookup.getValue(c)
        }
        return result
    }
}
