package sortintegersbythepowervalue

// Time:  O(n) on average
// Space: O(n)

class Solution {
    fun getKth(lo: Int, hi: Int, k: Int): Int {
        val arr = Array(hi - lo + 1) { i -> powerValue(lo + i) to (lo + i) }
        val target = k - 1
        var left = 0
        var right = arr.lastIndex
        while (left < right) {
            val pivot = arr[right]
            var store = left
            for (i in left until right) {
                if (less(arr[i], pivot)) {
                    val temp = arr[store]
                    arr[store] = arr[i]
                    arr[i] = temp
                    ++store
                }
            }
            val temp = arr[store]
            arr[store] = arr[right]
            arr[right] = temp
            when {
                target < store -> right = store - 1
                target > store -> left = store + 1
                else -> return arr[store].second
            }
        }
        return arr[left].second
    }

    private fun less(a: Pair<Int, Int>, b: Pair<Int, Int>): Boolean {
        return a.first < b.first || (a.first == b.first && a.second < b.second)
    }

    private fun powerValue(value: Int): Int {
        var x = value
        val y = x
        var result = 0
        while (x > 1 && !dp.containsKey(x)) {
            ++result
            x = if (x and 1 != 0) 3 * x + 1 else x shr 1
        }
        dp[y] = result + dp.getOrDefault(x, 0)
        return dp.getValue(y)
    }

    companion object {
        private val dp = HashMap<Int, Int>()
    }
}
