package maximumequalfrequency

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxEqualFreq(nums: IntArray): Int {
        var result = 0
        val count = HashMap<Int, Int>()
        val freq = IntArray(nums.size + 1)
        for (i in nums.indices) {
            val old = count.getOrDefault(nums[i], 0)
            --freq[old]
            ++freq[old + 1]
            val c = old + 1
            count[nums[i]] = c
            if (freq[c] * c == i + 1 && i + 1 < nums.size) {
                result = i + 2
            }
            val remain = (i + 1) - freq[c] * c
            if (freq[remain] == 1 && (remain == 1 || remain == c + 1)) {
                result = i + 1
            }
        }
        return result
    }
}
