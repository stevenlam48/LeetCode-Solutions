package minimumvaluetogetpositivestepbystepsum

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minStartValue(nums: IntArray): Int {
        var minPrefix = 0
        var prefix = 0
        for (num in nums) {
            prefix += num
            minPrefix = minOf(minPrefix, prefix)
        }
        return 1 - minPrefix
    }
}
