package maximumtastinessofcandybasket
// Time:  O(nlogr), r = max(price)-min(price)
// Space: O(1)

class Solution {
    fun maximumTastiness(price: IntArray, k: Int): Int {
        fun check(x: Int): Boolean {
            var cnt = 0
            var prev = 0
            for (i in price.indices) {
                if (prev != 0 && price[i] - prev < x) {
                    continue
                }
                if (++cnt == k) {
                    break
                }
                prev = price[i]
            }
            return cnt >= k
        }

        price.sort()
        var left = 1
        var right = price.last() - price.first()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }
}
