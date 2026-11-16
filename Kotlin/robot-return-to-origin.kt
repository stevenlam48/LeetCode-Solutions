package robotreturntoorigin

// Time:  O(n)
// Space: O(1)

class Solution {
    fun judgeCircle(moves: String): Boolean {
        val count = HashMap<Char, Int>()
        for (m in moves) {
            count[m] = count.getOrDefault(m, 0) + 1
        }
        return count.getOrDefault('L', 0) == count.getOrDefault('R', 0) &&
            count.getOrDefault('U', 0) == count.getOrDefault('D', 0)
    }
}
