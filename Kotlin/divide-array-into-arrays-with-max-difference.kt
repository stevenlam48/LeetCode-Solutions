package dividearrayintoarrayswithmaxdifference
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        nums.sort()
        val result = mutableListOf<IntArray>()
        for (i in nums.indices step 3) {
            if (nums[i + 2] - nums[i] > k) {
                return emptyArray()
            }
            result.add(nums.copyOfRange(i, i + 3))
        }
        return result.toTypedArray()
    }
}
