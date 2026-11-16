package countkthrootsinarange

// Time:  O(logr * logk)
// Space: O(1)

// binary search, fast exponentiation
class Solution {
    fun countKthRoots(l: Int, r: Int, k: Int): Int {
        fun binarySearchRight(left0: Int, right0: Int, check: (Int) -> Boolean): Int {
            var left = left0
            var right = right0
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (!check(mid)) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            return right
        }

        fun count(right: Int): Int {
            return binarySearchRight(0, right) { x ->
                Math.pow(x.toDouble(), k.toDouble()) <= right.toDouble()
            } - 0 + 1
        }

        return count(r) - count(l - 1)
    }
}
