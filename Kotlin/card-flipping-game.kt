package cardflippinggame

// Time:  O(n)
// Space: O(n)

class Solution {
    fun flipgame(fronts: IntArray, backs: IntArray): Int {
        val same = HashSet<Int>()
        for (i in fronts.indices) {
            if (fronts[i] == backs[i]) {
                same.add(fronts[i])
            }
        }
        var result = Int.MAX_VALUE
        for (n in fronts) {
            if (!same.contains(n)) {
                result = minOf(result, n)
            }
        }
        for (n in backs) {
            if (!same.contains(n)) {
                result = minOf(result, n)
            }
        }
        return if (result != Int.MAX_VALUE) result else 0
    }
}
