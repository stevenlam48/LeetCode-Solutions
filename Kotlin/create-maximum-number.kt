package createmaximumnumber

// Time:  O(k * (m + n + k)) ~ O(k * (m + n + k^2))
// Space: O(m + n + k^2)

class Solution {
    fun maxNumber(nums1: IntArray, nums2: IntArray, k: Int): IntArray {
        val m = nums1.size
        val n = nums2.size
        val maxNumbers1 = Array(k + 1) { intArrayOf() }
        val maxNumbers2 = Array(k + 1) { intArrayOf() }
        maxNumberDP(nums1, maxOf(0, k - n), minOf(k, m), maxNumbers1)
        maxNumberDP(nums2, maxOf(0, k - m), minOf(k, n), maxNumbers2)

        var result = IntArray(k)
        for (i in maxOf(0, k - n)..minOf(k, m)) {
            val tmp = IntArray(k)
            merge(maxNumbers1[i], maxNumbers2[k - i], tmp)
            if (lexicographicallyGreater(tmp, result)) {
                result = tmp
            }
        }
        return result
    }

    private fun maxNumberDP(nums: IntArray, start: Int, end: Int, maxNumbers: Array<IntArray>) {
        maxNumbers[end] = maxNumber(nums, end)
        for (i in end - 1 downTo start) {
            maxNumbers[i] = deleteNumber(maxNumbers[i + 1])
        }
    }

    private fun maxNumber(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        var drop = nums.size - k
        for (num in nums) {
            while (drop > 0 && result.isNotEmpty() && result.last() < num) {
                result.removeAt(result.lastIndex)
                --drop
            }
            result.add(num)
        }
        return result.take(k).toIntArray()
    }

    private fun deleteNumber(nums: IntArray): IntArray {
        val result = nums.toMutableList()
        for (i in result.indices) {
            if (i == result.lastIndex || result[i] < result[i + 1]) {
                result.removeAt(i)
                break
            }
        }
        return result.toIntArray()
    }

    private fun merge(vec1: IntArray, vec2: IntArray, result: IntArray) {
        var first1 = 0
        var first2 = 0
        var index = 0
        while (first1 < vec1.size || first2 < vec2.size) {
            if (greaterSuffix(vec1, first1, vec2, first2)) {
                result[index++] = vec1[first1++]
            } else {
                result[index++] = vec2[first2++]
            }
        }
    }

    private fun greaterSuffix(vec1: IntArray, first1: Int, vec2: IntArray, first2: Int): Boolean {
        var i = first1
        var j = first2
        while (i < vec1.size && j < vec2.size && vec1[i] == vec2[j]) {
            ++i
            ++j
        }
        return j == vec2.size || (i < vec1.size && vec1[i] > vec2[j])
    }

    private fun lexicographicallyGreater(first: IntArray, second: IntArray): Boolean {
        for (i in first.indices) {
            if (first[i] != second[i]) {
                return first[i] > second[i]
            }
        }
        return false
    }
}
