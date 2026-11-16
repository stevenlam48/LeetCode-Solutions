package countrotationswithexactlykequaladjacentpairs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countRotations(s: String, k: Int): Int {
        var total = 0
        for (i in s.indices) {
            if (s[i] == s[(i + 1) % s.length]) {
                ++total
            }
        }
        return when {
            total - 1 == k -> total
            total == k -> s.length - total
            else -> 0
        }
    }
}
