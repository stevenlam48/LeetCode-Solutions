package implementrand10usingrand7

import kotlin.random.Random

// Time:  O(1.199), counted by statistics, limit would be O(log10/log7) = O(1.183)
// Space: O(1)

// The rand7() API is already defined for you.
// int rand7();
// @return a random integer in the range 1 to 7

// Reference: https://leetcode.com/problems/implement-rand10-using-rand7/discuss/151567/C++JavaPython-Average-1.199-Call-rand7-Per-rand10
class Solution(private val rand7: () -> Int = { Random.nextInt(1, 8) }) {
    private val cache = ArrayList<Int>()

    fun rand10(): Int {
        while (cache.isEmpty()) {
            generate()
        }
        return cache.removeAt(cache.size - 1)
    }

    private fun generate() {
        val n = 19
        var curr = 0L
        var range = 1L
        repeat(n) { range *= 7 }
        var p = 1L
        for (i in 0 until n) {
            curr += p * (rand7() - 1)
            p *= 7
        }
        while (curr < range / 10 * 10) {
            cache.add((curr % 10 + 1).toInt())
            curr /= 10
            range /= 10
        }
    }
}
