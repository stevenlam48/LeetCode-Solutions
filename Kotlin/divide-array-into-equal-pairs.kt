package dividearrayintoequalpairs
// Time:  O(n)
// Space: O(n)

class Solution {
    fun divideArray(nums: IntArray): Boolean {
        val odd = HashMap<Int, Int>()
        for (x in nums) {
            odd[x] = ((odd[x] ?: 0) + 1) % 2
        }
        return odd.values.all { it == 0 }
    }
}
