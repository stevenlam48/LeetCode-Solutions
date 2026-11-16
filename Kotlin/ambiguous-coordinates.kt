package ambiguouscoordinates

// Time:  O(n^4)
// Space: O(n^2)

class Solution {
    fun ambiguousCoordinates(s: String): List<String> {
        val result = mutableListOf<String>()
        for (i in 1 until s.length - 2) {
            val lefts = make(s, 1, i)
            val rights = make(s, i + 1, s.length - 2 - i)
            for (left in lefts) {
                for (right in rights) {
                    result.add("($left, $right)")
                }
            }
        }
        return result
    }

    // Time:  O(n^2)
    // Space: O(n^2)
    private fun make(s: String, i: Int, n: Int): List<String> {
        val result = mutableListOf<String>()
        for (d in 1..n) {
            val left = s.substring(i, i + d)
            val right = s.substring(i + d, i + d + (n - d))
            if ((left.first() != '0' || left == "0") && (right.isEmpty() || right.last() != '0')) {
                result.add(left + (if (right.isNotEmpty()) "." else "") + right)
            }
        }
        return result
    }
}
