package countnumberofpairswithabsolutedifferencek

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countKDifference(nums: IntArray, k: Int): Int {
        val lookup = HashMap<Int, Int>()
        var result = 0
        for (x in nums) {
            result += lookup.getOrDefault(x - k, 0)
            result += lookup.getOrDefault(x + k, 0)
            lookup[x] = lookup.getOrDefault(x, 0) + 1
        }
        return result
    }
}
