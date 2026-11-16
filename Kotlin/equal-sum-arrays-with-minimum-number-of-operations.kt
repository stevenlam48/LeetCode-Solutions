package equalsumarrayswithminimumnumberofoperations

// Time:  O(m + n)
// Space: O(1)
class Solution {
    fun minOperations(nums1: IntArray, nums2: IntArray): Int {
        if (6 * nums1.size < 1 * nums2.size || 6 * nums2.size < 1 * nums1.size) {
            return -1
        }
        val count = IntArray(6)
        var diff = nums2.sum().toLong() - nums1.sum().toLong()
        var a = nums1
        var b = nums2
        if (diff < 0) {
            a = nums2
            b = nums1
            diff = -diff
        }
        for (num in a) {
            ++count[6 - num]
        }
        for (num in b) {
            ++count[num - 1]
        }
        var result = 0
        for (i in 5 downTo 1) {
            if (count[i] == 0) {
                continue
            }
            val cnt = minOf(count[i].toLong(), (diff + i - 1) / i)
            result += cnt.toInt()
            diff -= i * cnt
            if (diff <= 0) {
                break
            }
        }
        return result
    }
}
