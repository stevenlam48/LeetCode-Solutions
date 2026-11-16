package mostvisitedsectorinacirculartrack

// Time:  O(n)
// Space: O(1)

class Solution {
    fun mostVisited(n: Int, rounds: IntArray): IntArray {
        val result = mutableListOf<Int>()
        if (rounds.first() <= rounds.last()) {
            for (i in rounds.first()..rounds.last()) {
                result.add(i)
            }
        } else {
            for (i in 1..rounds.last()) {
                result.add(i)
            }
            for (i in rounds.first()..n) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
