package decompressrunlengthencodedlist

// Time:  O(n)
// Space: O(1)

class Solution {
    fun decompressRLElist(nums: IntArray): IntArray {
        val result = ArrayList<Int>()
        var i = 0
        while (i < nums.size) {
            repeat(nums[i]) {
                result.add(nums[i + 1])
            }
            i += 2
        }
        return result.toIntArray()
    }
}
