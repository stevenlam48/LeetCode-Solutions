package successfulpairsofspellsandpotions

// Time:  O(mlogm + nlogm)
// Space: O(1)
class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        potions.sort()
        val result = IntArray(spells.size)
        for (i in spells.indices) {
            val target = ceilDivide(success, spells[i].toLong())
            var left = 0
            var right = potions.size
            while (left < right) {
                val mid = left + (right - left) / 2
                if (potions[mid].toLong() < target) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            result[i] = potions.size - left
        }
        return result
    }

    private fun ceilDivide(a: Long, b: Long): Long {
        return (a + b - 1) / b
    }
}
