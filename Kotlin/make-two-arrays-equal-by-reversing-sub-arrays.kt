package maketwoarraysequalbyreversingsubarrays

// Time:  O(n)
// Space: O(n)

class Solution {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        return counter(target) == counter(arr)
    }

    private fun counter(arr: IntArray): HashMap<Int, Int> {
        val count = HashMap<Int, Int>()
        for (x in arr) {
            count.merge(x, 1, Int::plus)
        }
        return count
    }
}
