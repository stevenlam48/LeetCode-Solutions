package countgoodtriplets

// Time:  O(n^3)
// Space: O(1)

class Solution {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var result = 0
        for (i in 0 until arr.size - 2) {
            for (j in i + 1 until arr.size - 1) {
                for (k in j + 1 until arr.size) {
                    if (kotlin.math.abs(arr[i] - arr[j]) <= a &&
                        kotlin.math.abs(arr[j] - arr[k]) <= b &&
                        kotlin.math.abs(arr[k] - arr[i]) <= c
                    ) {
                        ++result
                    }
                }
            }
        }
        return result
    }
}
