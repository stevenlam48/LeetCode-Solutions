package maximumvalidsplitpositionsii

// Time:  O(n + (logr)^2)) = O(n)
// Space: O(n + logr) = O(n)

private data class Group(val value: Int, val left: Int, var right: Int)

class Solution {
    fun maxValidSplits(nums: IntArray): Int {
        val prefix = prefixGcd(nums)
        val suffix = suffixGcd(nums)
        val candidates = mutableListOf<Int>()
        for (i in nums.indices) {
            if (prefix[i + 1] != prefix[i]) {
                candidates.add(i)
            }
        }
        val reversedCandidates = candidates.asReversed()
            .map { nums.size - 1 - it }
            .toIntArray()
        val left = diff(nums.reversedArray(), reversedCandidates)
        val right = diff(nums, candidates.toIntArray())
        val valid = BooleanArray(nums.size - 1)
        for (i in valid.indices) {
            valid[i] = prefix[i + 1] == suffix[i + 1]
        }
        val base = valid.count { it }
        var result = base
        for (i in candidates.indices) {
            val x = candidates[i]
            var total = base
            total += left[left.lastIndex - i]
            if (x - 1 >= 0) {
                total += (if (prefix[x] == suffix[x + 1]) 1 else 0) - (if (valid[x - 1]) 1 else 0)
            }
            if (x < valid.size) {
                total -= if (valid[x]) 1 else 0
            }
            total += right[i]
            result = maxOf(result, total)
        }
        return result
    }

    private fun prefixGcd(nums: IntArray): IntArray {
        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = gcd(prefix[i], nums[i])
        }
        return prefix
    }

    private fun suffixGcd(nums: IntArray): IntArray {
        val suffix = IntArray(nums.size + 1)
        for (i in nums.lastIndex downTo 0) {
            suffix[i] = gcd(suffix[i + 1], nums[i])
        }
        return suffix
    }

    private fun diff(nums: IntArray, candidates: IntArray): IntArray {
        fun add(groups: MutableList<Group>, value: Int, left: Int, right: Int) {
            if (groups.isNotEmpty() && groups.last().value == value) {
                groups.last().right = right
            } else {
                groups.add(Group(value, left, right))
            }
        }
        fun count(lookup: Map<Int, Pair<Int, Int>>, value: Int, left: Int, right: Int): Int {
            val range = lookup[value] ?: return 0
            return maxOf(minOf(right, range.second) - maxOf(left, range.first) + 1, 0)
        }

        val prefix = prefixGcd(nums)
        val suffix = suffixGcd(nums)
        val lookup = hashMapOf<Int, Pair<Int, Int>>()
        var left = 0
        while (left < nums.size) {
            var right = left
            while (right + 1 < nums.size && suffix[right + 1] == suffix[left]) {
                ++right
            }
            lookup[suffix[left]] = (left - 1) to (right - 1)
            left = right + 1
        }
        val result = IntArray(candidates.size)
        var groups = mutableListOf<Group>()
        for (i in candidates.lastIndex downTo 0) {
            val newGroups = mutableListOf<Group>()
            var value = 0
            val last = if (i + 1 < candidates.size) candidates[i + 1] else nums.size - 1
            for (j in candidates[i] + 1..last) {
                value = gcd(value, nums[j])
                add(newGroups, value, j, j)
            }
            for (group in groups) {
                value = gcd(value, group.value)
                add(newGroups, value, group.left, group.right)
            }
            groups = newGroups
            var newValue = prefix[candidates[i]]
            var oldValue = nums[candidates[i]]
            for (group in groups) {
                newValue = gcd(newValue, group.value)
                oldValue = gcd(oldValue, newValue)
                val right = minOf(group.right, nums.size - 2)
                if (group.left > right) {
                    continue
                }
                result[i] += count(lookup, newValue, group.left, right) -
                    count(lookup, oldValue, group.left, right)
            }
        }
        return result
    }

    private tailrec fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
