package minimumoperationstomakearraymoduloalternatingi

// Time:  O(n + k)
// Space: O(k)

class Solution {
    fun minOperations(nums: IntArray, k: Int): Long {
        fun topk(values: LongArray, size: Int): Array<Pair<Long, Int>> {
            val result = Array(size) { Pair(Long.MAX_VALUE, Int.MAX_VALUE) }
            for (i in values.indices) {
                var x = Pair(values[i], i)
                for (index in result.indices) {
                    val y = result[index]
                    if (x.first < y.first || (x.first == y.first && x.second < y.second)) {
                        result[index] = x
                        x = y
                    }
                }
            }
            return result
        }

        fun distance(cnt: IntArray): LongArray {
            val total = cnt.sum()
            var c = 0
            for (i in 1..k / 2) {
                c += cnt[i]
            }
            val dist = LongArray(k)
            for (i in cnt.indices) {
                dist[0] += cnt[i] * minOf(i, k - i)
            }
            for (i in 1 until dist.size) {
                dist[i] = dist[i - 1] - c + (total - c) -
                    (if (k % 2 != 0) cnt[(i + k / 2) % k] else 0)
                c += cnt[(i + k / 2) % k] - cnt[i]
            }
            return dist
        }

        val cnt = Array(2) { IntArray(k) }
        for (i in nums.indices) {
            ++cnt[i % 2][nums[i] % k]
        }
        val dist = Array(2) { i -> distance(cnt[i]) }
        val top2 = Array(2) { i -> topk(dist[i], 2) }
        return if (top2[0][0].second == top2[1][0].second) {
            minOf(
                top2[0][0].first + top2[1][1].first,
                top2[0][1].first + top2[1][0].first
            )
        } else {
            top2[0][0].first + top2[1][0].first
        }
    }
}
