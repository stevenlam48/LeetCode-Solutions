package findthecelebrity

// Time:  O(n)
// Space: O(1)
class Solution(private val knows: (Int, Int) -> Boolean) {
    fun findCelebrity(n: Int): Int {
        var candidate = 0
        for (i in 1 until n) {
            if (knows(candidate, i)) {
                candidate = i
            }
        }
        for (i in 0 until n) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1
            }
        }
        return candidate
    }
}
