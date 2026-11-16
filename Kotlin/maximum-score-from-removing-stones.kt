package maximumscorefromremovingstones

// Time:  O(1)
// Space: O(1)

class Solution {
    fun maximumScore(a: Int, b: Int, c: Int): Int {
        return minOf((a + b + c) / 2, a + b + c - maxOf(a, b, c))
    }
}
