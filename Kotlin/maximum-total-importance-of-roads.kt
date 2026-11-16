package maximumtotalimportanceofroads
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
        val degree = IntArray(n)
        for (r in roads) {
            ++degree[r[0]]
            ++degree[r[1]]
        }
        inplaceCountingSort(degree, false)
        var result = 0L
        for (i in 0 until n) {
            result += (i + 1L) * degree[i]
        }
        return result
    }

    private fun inplaceCountingSort(nums: IntArray, isReverse: Boolean) {
        val maxNum = nums.max()
        val count = IntArray(maxNum + 1)
        for (num in nums) {
            ++count[num]
        }
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }
        for (i in nums.size - 1 downTo 0) {
            while (nums[i] >= 0) {
                --count[nums[i]]
                val j = count[nums[i]]
                val oldI = nums[i]
                nums[i] = nums[j]
                nums[j] = oldI.inv()
            }
        }
        for (i in nums.indices) {
            nums[i] = nums[i].inv()
        }
        if (isReverse) {
            nums.reverse()
        }
    }
}
