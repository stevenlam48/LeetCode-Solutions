package bullsandcows

// Time:  O(n)
// Space: O(10) = O(1)

class Solution {
    fun getHint(secret: String, guess: String): String {
        val lookup = HashMap<Char, Int>()
        var a = 0
        var b = 0
        for (i in secret.indices) {
            val s = secret[i]
            val g = guess[i]
            if (s == g) {
                ++a
            } else {
                val sCount = lookup[s] ?: 0
                if (sCount < 0) {
                    ++b
                }
                lookup[s] = sCount + 1
                val gCount = lookup[g] ?: 0
                if (gCount > 0) {
                    ++b
                }
                lookup[g] = gCount - 1
            }
        }
        return "${a}A${b}B"
    }
}
