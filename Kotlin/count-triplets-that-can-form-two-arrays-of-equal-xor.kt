package counttripletsthatcanformtwoarraysofequalxor

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countTriplets(arr: IntArray): Int {
        val countSum = hashMapOf(0 to intArrayOf(1, 0))
        var result = 0
        var prefix = 0
        for (i in arr.indices) {
            prefix = prefix xor arr[i]
            val counts = countSum.getOrPut(prefix) { intArrayOf(0, 0) }
            result += counts[0] * i - counts[1]
            ++counts[0]
            counts[1] += i + 1
        }
        return result
    }
}
