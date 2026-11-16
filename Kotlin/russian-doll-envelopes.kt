package russiandollenvelopes

// Time:  O(nlogn + nlogk) = O(nlogn), k is the length of the result.
// Space: O(1)

class Solution {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        val result = ArrayList<Int>()

        envelopes.sortWith(Comparator<IntArray> { a, b ->
            if (a[0] == b[0]) {
                b[1].compareTo(a[1])
            } else {
                a[0].compareTo(b[0])
            }
        })
        for (envelope in envelopes) {
            val target = envelope[1]
            var lo = 0
            var hi = result.size
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (result[mid] < target) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            if (lo == result.size) {
                result.add(target)
            } else {
                result[lo] = target
            }
        }

        return result.size
    }
}
