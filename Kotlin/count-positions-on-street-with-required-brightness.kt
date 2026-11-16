package countpositionsonstreetwithrequiredbrightness

// Time:  O(n + l)
// Space: O(min(n, l))

class Solution {
    fun meetRequirement(n: Int, lights: Array<IntArray>, requirement: IntArray): Int {
        val counts = HashMap<Int, Int>()
        for (light in lights) {
            val start = maxOf(light[0] - light[1], 0)
            val end = minOf(light[0] + light[1], n - 1) + 1
            counts[start] = (counts[start] ?: 0) + 1
            counts[end] = (counts[end] ?: 0) - 1
        }
        var result = 0
        var current = 0
        for (i in requirement.indices) {
            current += counts[i] ?: 0
            if (current >= requirement[i]) {
                ++result
            }
        }
        return result
    }
}
