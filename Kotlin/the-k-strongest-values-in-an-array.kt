package thekstrongestvaluesinanarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getStrongest(arr: IntArray, k: Int): IntArray {
        nthElement(arr, 0, arr.size - 1, (arr.size - 1) / 2) { a, b -> a.compareTo(b) }
        val m = arr[(arr.size - 1) / 2]
        if (k < arr.size) {
            nthElement(arr, 0, arr.size - 1, k) { a, b ->
                if (Math.abs(a - m) != Math.abs(b - m)) {
                    Math.abs(b - m).compareTo(Math.abs(a - m))
                } else {
                    b.compareTo(a)
                }
            }
        }
        return arr.copyOf(k)
    }

    private fun nthElement(a: IntArray, left: Int, right: Int, k: Int, cmp: Comparator<Int>) {
        var l = left
        var r = right
        while (l < r) {
            val pivot = a[(l + r) ushr 1]
            var i = l
            var j = r
            while (i <= j) {
                while (cmp.compare(a[i], pivot) < 0) {
                    ++i
                }
                while (cmp.compare(a[j], pivot) > 0) {
                    --j
                }
                if (i <= j) {
                    val tmp = a[i]
                    a[i] = a[j]
                    a[j] = tmp
                    ++i
                    --j
                }
            }
            if (k <= j) {
                r = j
            } else if (k >= i) {
                l = i
            } else {
                return
            }
        }
    }
}
