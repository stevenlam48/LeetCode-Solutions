package rleiterator

// Time:  O(n)
// Space: O(1)

class RLEIterator(a: IntArray) {
    private val a = a
    private var i = 0
    private var cnt = 0

    fun next(n: Int): Int {
        var remaining = n
        while (i < a.size) {
            if (remaining > a[i] - cnt) {
                remaining -= a[i] - cnt
                cnt = 0
                i += 2
            } else {
                cnt += remaining
                return a[i + 1]
            }
        }
        return -1
    }
}
