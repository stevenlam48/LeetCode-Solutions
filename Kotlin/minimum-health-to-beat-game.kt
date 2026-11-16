package minimumhealthtobeatgame

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun minimumHealth(damage: IntArray, armor: Int): Long {
        return damage.fold(0L) { accu, x -> accu + x } -
                minOf(damage.maxOrNull()!!, armor) +
                1
    }
}
