package generateschedule

// Time:  O(n^2)
// Space: O(1)

// constructive algorithms
class Solution {
    fun generateSchedule(n: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        if (n <= 4) {
            return result
        }
        val l = 1
        if (n % 2 == 0) {
            var i = 0
            while (i < n) {
                result.add(mutableListOf(i, i + l))
                i += 2
            }
            i = 0
            while (i < n) {
                result.add(mutableListOf(i + l, i))
                i += 2
            }
            i = 1
            while (i < n) {
                result.add(mutableListOf(i, (i + l) % n))
                i += 2
            }
            i = 1
            while (i < n) {
                result.add(mutableListOf((i + l) % n, i))
                i += 2
            }
        } else {
            var i = 0
            while (i < 2 * n) {
                result.add(mutableListOf(i % n, (i + l) % n))
                i += 2
            }
            i = 0
            while (i < 2 * n) {
                result.add(mutableListOf((i + l) % n, i % n))
                i += 2
            }
        }
        var l2 = 2
        while (l2 < (n + 1) / 2) {
            var j = result.last()[0] + 1
            var i = j
            while (i < j + n) {
                result.add(mutableListOf(i % n, (i + l2) % n))
                ++i
            }
            j = ((result.last()[1] - 1) % n + n) % n
            i = j
            while (i < j + n) {
                result.add(mutableListOf((i + l2) % n, i % n))
                ++i
            }
            ++l2
        }
        if (n % 2 == 0) {
            val ll = n / 2
            val j = ((result.last()[0] - 1) % n + n) % n
            var i = j
            while (i < j + n) {
                result.add(mutableListOf(i % n, (i + ll) % n))
                ++i
            }
        }
        return result
    }
}
