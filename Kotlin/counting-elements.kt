package countingelements

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countElements(arr: IntArray): Int {
        val lookup = arr.toHashSet()
        var result = 0
        for (x in arr) {
            if (lookup.contains(x + 1)) {
                ++result
            }
        }
        return result
    }
}
