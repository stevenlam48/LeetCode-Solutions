package findnumberswithevennumberofdigits

// Time:  O(nlog(logm)), n the length of nums, m is the max value of nums
// Space: O(logm)

class Solution {
    private val lookup = mutableListOf<Int>()

    init {
        val m = 100000
        lookup.add(0)
        var i = 10
        while (i < m) {
            lookup.add(i)
            i *= 10
        }
        lookup.add(i)
    }

    fun findNumbers(nums: IntArray): Int {
        return nums.fold(0) { x, y -> x + if (digitCount(y) % 2 == 0) 1 else 0 }
    }

    private fun digitCount(n: Int): Int {
        val index = lookup.binarySearch(n)
        return if (index >= 0) index + 1 else -index - 1
    }
}
