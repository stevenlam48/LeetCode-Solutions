package pourwaterbetweenbucketstomakewaterlevelsequal
// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun equalizeWater(buckets: IntArray, loss: Int): Double {
        val rate = (100.0 - loss) / 100.0
        fun check(x: Double): Boolean {
            var extra = 0.0
            var need = 0.0
            for (b in buckets) {
                if (b >= x) {
                    extra += b - x
                } else {
                    need += x - b
                }
            }
            return extra * rate >= need
        }
        var left = buckets.min().toDouble()
        var right = buckets.sumOf { it.toLong() }.toDouble() / buckets.size
        while (right - left > EPS) {
            val mid = left + (right - left) / 2
            if (!check(mid)) {
                right = mid
            } else {
                left = mid
            }
        }
        return right
    }

    companion object {
        private const val EPS = 1e-5
    }
}
