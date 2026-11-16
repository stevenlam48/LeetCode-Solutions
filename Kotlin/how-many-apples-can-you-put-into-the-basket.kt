package howmanyapplescanyouputintothebasket
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxNumberOfApples(arr: IntArray): Int {
        arr.sort()
        var result = 0
        var total = 0
        for (x in arr) {
            if (total + x > LIMIT) {
                break
            }
            total += x
            ++result
        }
        return result
    }

    companion object {
        private const val LIMIT = 5000
    }
}
