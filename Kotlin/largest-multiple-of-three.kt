package largestmultipleofthree

// Time:  O(n)
// Space: O(1)

class Solution {
    fun largestMultipleOfThree(digits: IntArray): String {
        val lookup = mapOf(
            0 to emptyList<List<Int>>(),
            1 to listOf(
                listOf(1), listOf(4), listOf(7), listOf(2, 2), listOf(5, 2),
                listOf(5, 5), listOf(8, 2), listOf(8, 5), listOf(8, 8)
            ),
            2 to listOf(
                listOf(2), listOf(5), listOf(8), listOf(1, 1), listOf(4, 1),
                listOf(4, 4), listOf(7, 1), listOf(7, 4), listOf(7, 7)
            )
        )
        val count = counter(digits)
        val r = digits.sum() % 3
        for (deletes in lookup[r]!!) {
            if (remove(deletes, count)) {
                break
            }
        }
        val result = StringBuilder()
        for (d in 9 downTo 0) {
            repeat(count[d]) { result.append('0' + d) }
        }
        return if (result.isNotEmpty() && result[0] == '0') "0" else result.toString()
    }

    private fun remove(deletes: List<Int>, count: IntArray): Boolean {
        val deleteCount = counter(deletes.toIntArray())
        for (d in 0..9) {
            if (count[d] < deleteCount[d]) {
                return false
            }
        }
        for (d in 0..9) {
            count[d] -= deleteCount[d]
        }
        return true
    }

    private fun counter(digits: IntArray): IntArray {
        val result = IntArray(10)
        for (i in digits) {
            ++result[i]
        }
        return result
    }
}
