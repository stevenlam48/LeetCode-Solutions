package maximumenemyfortsthatcanbecaptured

// Time:  O(n)
// Space: O(1)

// array, two pointers
class Solution {
    fun captureForts(forts: IntArray): Int {
        var result = 0
        var left = 0
        for (right in forts.indices) {
            if (forts[right] == 0) {
                continue
            }
            if (forts[right] == -forts[left]) {
                result = maxOf(result, right - left - 1)
            }
            left = right
        }
        return result
    }
}
