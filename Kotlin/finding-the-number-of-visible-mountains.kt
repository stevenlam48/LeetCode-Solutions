package findingthenumberofvisiblemountains

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun visibleMountains(peaks: Array<IntArray>): Int {
        peaks.sortWith(Comparator { a, b ->
            val left1 = a[0] - a[1]
            val left2 = b[0] - b[1]
            if (left1 != left2) {
                left1.compareTo(left2)
            } else {
                val right1 = a[0] + a[1]
                val right2 = b[0] + b[1]
                right2.compareTo(right1)
            }
        })

        var result = 0
        var mx = 0
        for (i in peaks.indices) {
            if (peaks[i][0] + peaks[i][1] <= mx) {
                continue
            }
            mx = peaks[i][0] + peaks[i][1]
            if (i + 1 == peaks.size || !peaks[i + 1].contentEquals(peaks[i])) {
                ++result
            }
        }
        return result
    }
}
