package vowelconsonantscore
// Time:  O(n)
// Space: O(1)

class Solution {
    fun vowelConsonantScore(s: String): Int {
        val vowels = "aeiou"
        var v = 0
        var c = 0
        for (x in s) {
            if (x in vowels) {
                ++v
            } else if (x in 'a'..'z' || x in 'A'..'Z') {
                ++c
            }
        }
        return if (c != 0) v / c else 0
    }
}
