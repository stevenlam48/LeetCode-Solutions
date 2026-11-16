package rangeaddition

// Time:  O(k + n)
// Space: O(1)

class Solution {
    fun getModifiedArray(length: Int, updates: Array<IntArray>): IntArray {
        val result = IntArray(length)

        for (update in updates) {
            result[update[0]] += update[2]
            if (update[1] + 1 < length) {
                result[update[1] + 1] -= update[2]
            }
        }

        for (i in 1 until length) {
            result[i] += result[i - 1]
        }

        return result
    }
}
