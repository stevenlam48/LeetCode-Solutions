package longestarithmeticsubsequenceofgivendifference

// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        var result = 1
        val lookup = HashMap<Int, Int>()
        for (i in arr.indices) {
            lookup[arr[i]] = (lookup[arr[i] - difference] ?: 0) + 1
            result = maxOf(result, lookup[arr[i]]!!)
        }
        return result
    }
}
