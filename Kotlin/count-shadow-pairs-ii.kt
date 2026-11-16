package countshadowpairsii

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    private data class StackEntry(val value: Int, var base: Int)

    fun shadowPairs(nums: IntArray): Int {
        val values = nums.distinct().sorted()
        val valueToIndex = HashMap<Int, Int>()
        for (i in values.indices) {
            valueToIndex[values[i]] = i
        }
        val groupedIndices = List(values.size) { mutableListOf<Int>() }
        for (i in nums.indices) {
            groupedIndices[valueToIndex.getValue(nums[i])].add(i)
        }
        var groups: List<List<Int>> = groupedIndices
        var result = 0
        while (groups.size != 1) {
            val newGroups = mutableListOf<List<Int>>()
            var i = 0
            while (i + 1 < groups.size) {
                val (merged, count) = mergeAndCount(groups[i], groups[i + 1], nums)
                result += count
                newGroups.add(merged)
                i += 2
            }
            if (groups.size % 2 != 0) {
                newGroups.add(groups.last())
            }
            groups = newGroups
        }
        return result
    }

    private fun mergeAndCount(left: List<Int>, right: List<Int>, nums: IntArray): Pair<List<Int>, Int> {
        val merged = ArrayList<Int>(left.size + right.size)
        var count = 0
        val firstStack = mutableListOf<Int>()
        val secondStack = mutableListOf<StackEntry>()
        var i = 0
        for (index in right) {
            while (i < left.size && left[i] < index) {
                while (firstStack.isNotEmpty() && firstStack.last() < nums[left[i]]) {
                    firstStack.removeAt(firstStack.lastIndex)
                }
                if (secondStack.isNotEmpty()) {
                    secondStack.last().base = minOf(secondStack.last().base, firstStack.size)
                }
                firstStack.add(nums[left[i]])
                merged.add(left[i])
                ++i
            }
            while (secondStack.isNotEmpty() && secondStack.last().value >= nums[index]) {
                val base = secondStack.last().base
                secondStack.removeAt(secondStack.lastIndex)
                if (secondStack.isNotEmpty()) {
                    secondStack.last().base = minOf(secondStack.last().base, base)
                }
            }
            count += firstStack.size - (if (secondStack.isNotEmpty()) secondStack.last().base else 0)
            secondStack.add(StackEntry(nums[index], firstStack.size))
            merged.add(index)
        }
        while (i < left.size) {
            merged.add(left[i])
            ++i
        }
        return merged to count
    }
}
