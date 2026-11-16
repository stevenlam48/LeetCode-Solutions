package p3sumwithmultiplicity

// Time:  O(n^2), n is the number of distinct A[i]
// Space: O(n)

class Solution {
    fun threeSumMulti(A: IntArray, target: Int): Int {
        val count = HashMap<Int, Long>()
        for (a in A) {
            count[a] = (count[a] ?: 0L) + 1
        }
        var result = 0L
        for (i in count.keys) {
            for (j in count.keys) {
                val k = target - i - j
                if (!count.containsKey(k)) {
                    continue
                }
                if (i == j && j == k) {
                    result += count[i]!! * (count[i]!! - 1) * (count[i]!! - 2) / 6
                } else if (i == j && j != k) {
                    result += count[i]!! * (count[i]!! - 1) / 2 * count[k]!!
                } else if (i < j && j < k) {
                    result += count[i]!! * count[j]!! * count[k]!!
                }
            }
        }
        return (result % (1e9 + 7).toInt()).toInt()
    }
}
