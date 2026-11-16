package createsortedarraythroughinstructions

// Time:  O(nlogm)
// Space: O(m)

class Solution {
    fun createSortedArray(instructions: IntArray): Int {
        val bit = BIT(instructions.maxOrNull()!!)
        var result = 0
        for (i in instructions.indices) {
            val inst = instructions[i] - 1
            var cost = minOf(bit.query(inst - 1), i - bit.query(inst))
            if (MOD - result <= cost) {
                cost -= MOD
            }
            result += cost
            bit.add(inst, 1)
        }
        return result
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + 1)

        fun add(i: Int, value: Int) {
            var index = i + 1
            while (index < bit.size) {
                bit[index] += value
                index += lowerBit(index)
            }
        }

        fun query(i: Int): Int {
            var index = i + 1
            var total = 0
            while (index > 0) {
                total += bit[index]
                index -= lowerBit(index)
            }
            return total
        }

        private fun lowerBit(i: Int): Int {
            return i and -i
        }
    }

    private companion object {
        const val MOD = 1_000_000_007
    }
}
