package kidswiththegreatestnumberofcandies

// Time:  O(n)
// Space: O(1)

class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maxNum = candies.maxOrNull()!!
        return candies.map { it + extraCandies >= maxNum }
    }
}
