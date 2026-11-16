package sortintegersbythenumberof1bits

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun sortByBits(arr: IntArray): IntArray {
        for (start in arr.size / 2 - 1 downTo 0) {
            siftDown(arr, start, arr.size)
        }
        for (end in arr.size - 1 downTo 1) {
            val temp = arr[0]
            arr[0] = arr[end]
            arr[end] = temp
            siftDown(arr, 0, end)
        }
        return arr
    }

    private fun siftDown(arr: IntArray, start: Int, end: Int) {
        var root = start
        while (2 * root + 1 < end) {
            var child = 2 * root + 1
            if (child + 1 < end && less(arr[child], arr[child + 1])) {
                ++child
            }
            if (!less(arr[root], arr[child])) {
                return
            }
            val temp = arr[root]
            arr[root] = arr[child]
            arr[child] = temp
            root = child
        }
    }

    private fun less(a: Int, b: Int): Boolean {
        val aBits = Integer.bitCount(a)
        val bBits = Integer.bitCount(b)
        return aBits < bBits || (aBits == bBits && a < b)
    }
}
