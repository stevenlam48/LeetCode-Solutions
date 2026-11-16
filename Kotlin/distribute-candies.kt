package distributecandies
// Time:  O(n)
// Space: O(n)

class Solution {
    fun distributeCandies(candyType: IntArray): Int {
        return minOf(candyType.toSet().size, candyType.size / 2)
    }
}
