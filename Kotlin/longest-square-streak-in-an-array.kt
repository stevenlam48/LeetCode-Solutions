package longestsquarestreakinanarray
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun longestSquareStreak(nums: IntArray): Int {
        val sortedNums = nums.map { it.toLong() }.toSortedSet()
        val squares = HashSet<Long>()
        for (x in sortedNums) {
            if (x % 4 < 2) {
                squares.add(x)
            }
        }
        var result = 0
        for (x in sortedNums) {
            var count = 1
            var square = x * x
            while (squares.contains(square)) {
                ++count
                squares.remove(square)
                square *= square
            }
            result = maxOf(result, count)
        }
        return if (result != 1) result else -1
    }
}
