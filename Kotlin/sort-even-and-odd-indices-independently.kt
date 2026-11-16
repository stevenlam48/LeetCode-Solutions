package sortevenandoddindicesindependently

// Time:  O(n)
// Space: O(c), c is the max of nums

class Solution {
    fun sortEvenOdd(nums: IntArray): IntArray {
        fun partition(index: (Int) -> Int) {
            for (i in nums.indices) {
                var j = i
                while (nums[i] >= 0) {
                    j = index(j)
                    val current = nums[i]
                    nums[i] = nums[j]
                    nums[j] = current.inv()
                }
            }
            for (i in nums.indices) {
                nums[i] = nums[i].inv()
            }
        }

        val evenCount = (nums.size + 1) / 2
        partition { i -> if (i % 2 == 0) i / 2 else evenCount + i / 2 }
        inplaceCountingSort(nums, 0, evenCount - 1, false)
        inplaceCountingSort(nums, evenCount, nums.size - 1, true)
        partition { i -> if (i < evenCount) 2 * i else 1 + 2 * (i - evenCount) }
        return nums
    }

    private fun inplaceCountingSort(nums: IntArray, left: Int, right: Int, isReverse: Boolean) {
        if (right - left + 1 == 0) {
            return
        }
        var maxNum = nums[left]
        for (i in left + 1..right) {
            maxNum = maxOf(maxNum, nums[i])
        }
        val count = IntArray(maxNum + 1)
        for (i in left..right) {
            ++count[nums[i]]
        }
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }
        for (i in right downTo left) {
            while (nums[i] >= 0) {
                --count[nums[i]]
                val j = left + count[nums[i]]
                val current = nums[i]
                nums[i] = nums[j]
                nums[j] = current.inv()
            }
        }
        for (i in left..right) {
            nums[i] = nums[i].inv()
        }
        if (isReverse) {
            var i = left
            var j = right
            while (i < j) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                ++i
                --j
            }
        }
    }
}
