package distributeelementsintotwoarraysi
// Time:  O(n)
// Space: O(n)

class Solution {
    fun resultArray(nums: IntArray): IntArray {
        val a = mutableListOf(nums[0])
        val b = mutableListOf(nums[1])
        for (i in 2 until nums.size) {
            if (a.last() > b.last()) {
                a.add(nums[i])
            } else {
                b.add(nums[i])
            }
        }
        a.addAll(b)
        return a.toIntArray()
    }
}
