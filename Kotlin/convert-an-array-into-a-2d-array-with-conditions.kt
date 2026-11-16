package convertanarrayintoa2darraywithconditions
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val cnt = HashMap<Int, Int>()
        for (x in nums) {
            if (cnt.getOrDefault(x, 0) == result.size) {
                result.add(mutableListOf())
            }
            val count = cnt.getOrDefault(x, 0)
            result[count].add(x)
            cnt[x] = count + 1
        }
        return result
    }
}
