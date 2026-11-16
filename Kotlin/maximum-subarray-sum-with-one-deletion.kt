package maximumsubarraysumwithonedeletion
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumSum(arr: IntArray): Int {
        var result = Int.MIN_VALUE
        var prev = Int.MIN_VALUE
        var curr = Int.MIN_VALUE
        for (x in arr) {
            curr = maxOf(prev, if (curr == Int.MIN_VALUE) x else maxOf(curr + x, x))
            result = maxOf(result, curr)
            prev = if (prev == Int.MIN_VALUE) x else maxOf(prev + x, x)
        }
        return result
    }
}
