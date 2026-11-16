package dividechocolate

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximizeSweetness(sweetness: IntArray, K: Int): Int {
        var left = sweetness.min()
        var right = sweetness.sum() / (K + 1)
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(sweetness, K, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }

    private fun check(sweetness: IntArray, K: Int, x: Int): Boolean {
        var curr = 0
        var cuts = 0
        for (s in sweetness) {
            curr += s
            if (curr >= x) {
                ++cuts
                curr = 0
            }
        }
        return cuts >= K + 1
    }
}
