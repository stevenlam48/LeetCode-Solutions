package recovertheoriginalarray

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun recoverArray(nums: IntArray): IntArray {
        nums.sort()
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            cnt[x] = (cnt[x] ?: 0) + 1
        }
        for (i in 1..nums.size / 2) {
            var k = nums[i] - nums[0]
            if (k == 0 || k % 2 != 0) {
                continue
            }
            k /= 2
            val result = ArrayList<Int>()
            if (check(nums, k, HashMap(cnt), result)) {
                return result.toIntArray()
            }
        }
        return intArrayOf()
    }

    private fun check(nums: IntArray, k: Int, cnt: HashMap<Int, Int>, result: ArrayList<Int>): Boolean {
        for (x in nums) {
            if ((cnt[x] ?: 0) == 0) {
                continue
            }
            if ((cnt[x + 2 * k] ?: 0) == 0) {
                return false
            }
            cnt[x] = cnt[x]!! - 1
            cnt[x + 2 * k] = cnt[x + 2 * k]!! - 1
            result.add(x + k)
        }
        return true
    }
}
