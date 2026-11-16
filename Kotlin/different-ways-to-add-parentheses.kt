package differentwaystoaddparentheses

// Time:  O(n * (C(2n, n) - C(2n, n - 1))), this is at most
// Space: O(n * (C(2n, n) - C(2n, n - 1)))

class Solution {
    fun diffWaysToCompute(input: String): List<Int> {
        val lookup = Array(input.length + 1) { arrayOfNulls<MutableList<Int>>(input.length + 1) }
        return diffWaysToComputeRecu(input, 0, input.length, lookup)
    }

    private fun diffWaysToComputeRecu(
        input: String,
        start: Int,
        end: Int,
        lookup: Array<Array<MutableList<Int>?>>
    ): MutableList<Int> {
        lookup[start][end]?.let { return it }
        val result = mutableListOf<Int>()
        for (i in start until end) {
            val cur = input[i]
            if (cur == '+' || cur == '-' || cur == '*') {
                val left = diffWaysToComputeRecu(input, start, i, lookup)
                val right = diffWaysToComputeRecu(input, i + 1, end, lookup)
                for (num1 in left) {
                    for (num2 in right) {
                        when (cur) {
                            '+' -> result.add(num1 + num2)
                            '-' -> result.add(num1 - num2)
                            else -> result.add(num1 * num2)
                        }
                    }
                }
            }
        }
        // If the input string contains only number.
        if (result.isEmpty()) {
            result.add(input.substring(start, end).toInt())
        }
        lookup[start][end] = result
        return result
    }
}
