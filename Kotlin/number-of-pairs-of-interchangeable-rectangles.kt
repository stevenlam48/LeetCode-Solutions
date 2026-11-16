package numberofpairsofinterchangeablerectangles

// Time:  O(n)
// Space: O(n)

class Solution {
    fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
        val lookup = HashMap<Int, HashMap<Int, Int>>()
        for (rectangle in rectangles) {
            val divisor = gcd(rectangle[0], rectangle[1])
            val widths = lookup.getOrPut(rectangle[0] / divisor) { HashMap() }
            val height = rectangle[1] / divisor
            widths[height] = widths.getOrDefault(height, 0) + 1
        }

        var result = 0L
        for (widths in lookup.values) {
            for (count in widths.values) {
                result += count.toLong() * (count - 1) / 2
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}
