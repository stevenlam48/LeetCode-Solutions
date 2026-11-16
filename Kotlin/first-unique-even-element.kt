package firstuniqueevenelement

// Time:  O(n)
// Space: O(n)

class Solution {
    fun firstUniqueEven(nums: IntArray): Int {
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        for (x in nums) {
            if (x % 2 == 0 && cnt[x] == 1) {
                return x
            }
        }
        return -1
    }
}
