package numberofpairsafterincrement

// Time:  O(n + m + q * sqrt(m * n)), n = len(nums1), m = len(nums2)
// Space: O(n + m)

import kotlin.math.sqrt

class Solution {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): IntArray {
        val nums = LongArray(nums2.size) { nums2[it].toLong() }
        val count1 = HashMap<Long, Int>()
        for (value in nums1) {
            val key = value.toLong()
            count1[key] = count1.getOrDefault(key, 0) + 1
        }

        val blockSize = sqrt(count1.size.toDouble() * nums2.size).toInt() + 1
        val blockCount = (nums.size + blockSize - 1) / blockSize
        val count2 = Array(blockCount) { HashMap<Long, Int>() }
        for (i in count2.indices) {
            var j = i * blockSize
            val bound = minOf((i + 1) * blockSize, nums.size)
            while (j < bound) {
                count2[i][nums[j]] = count2[i].getOrDefault(nums[j], 0) + 1
                j++
            }
        }

        val lazy = LongArray(blockCount)
        val result = ArrayList<Int>()
        for (query in queries) {
            if (query[0] == 2) {
                val totalTarget = query[1]
                var total = 0
                for ((value, count) in count1) {
                    for (i in count2.indices) {
                        val target = totalTarget.toLong() - value - lazy[i]
                        val matches = count2[i][target] ?: continue
                        total += matches * count
                    }
                }
                result.add(total)
                continue
            }

            val left = query[1]
            val right = query[2]
            val value = query[3]
            if (left / blockSize == right / blockSize) {
                update(nums, count2[left / blockSize], left, right, value)
                continue
            }
            update(nums, count2[left / blockSize], left, (left / blockSize + 1) * blockSize - 1, value)
            for (i in left / blockSize + 1 until right / blockSize) {
                lazy[i] += value
            }
            update(nums, count2[right / blockSize], (right / blockSize) * blockSize, right, value)
        }
        return result.toIntArray()
    }

    private fun update(
        nums: LongArray,
        counts: HashMap<Long, Int>,
        left: Int,
        right: Int,
        value: Int
    ) {
        for (i in left..right) {
            val oldCount = counts.getValue(nums[i]) - 1
            if (oldCount == 0) {
                counts.remove(nums[i])
            } else {
                counts[nums[i]] = oldCount
            }
            nums[i] += value
            counts[nums[i]] = counts.getOrDefault(nums[i], 0) + 1
        }
    }
}
