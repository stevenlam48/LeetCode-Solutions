package minimumoperationstomakethearraykincreasing

// Time:  O(k * (n/k)log(n/k)) = O(nlog(n/k))
// Space: O(n/k)

class Solution {
    fun kIncreasing(arr: IntArray, k: Int): Int {
        var result = arr.size
        for (i in 0 until k) {
            val buffer = IntArray((arr.size + k - 1) / k)
            var len = 0
            var j = i
            while (j < arr.size) {
                var lo = 0
                var hi = len
                while (lo < hi) {
                    val mid = (lo + hi) / 2
                    if (buffer[mid] <= arr[j]) {
                        lo = mid + 1
                    } else {
                        hi = mid
                    }
                }
                buffer[lo] = arr[j]
                if (lo == len) {
                    ++len
                }
                j += k
            }
            result -= len
        }
        return result
    }
}
