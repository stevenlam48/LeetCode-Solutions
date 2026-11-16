package findpositiveintegersolutionforagivenequation

// Time:  O(n)
// Space: O(1)

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 * public:
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     int f(int x, int y);
 * };
 */

fun interface CustomFunction {
    fun f(x: Int, y: Int): Int
}

class Solution {
    fun findSolution(customfunction: CustomFunction, z: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var x = 1
        var y = 1
        while (customfunction.f(x, y) < z) {
            ++y
        }
        while (y > 0) {
            while (y > 0 && customfunction.f(x, y) > z) {
                --y
            }
            if (y > 0 && customfunction.f(x, y) == z) {
                result.add(listOf(x, y))
            }
            ++x
        }
        return result
    }
}
