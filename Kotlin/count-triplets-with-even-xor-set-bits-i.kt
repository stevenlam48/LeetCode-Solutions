package counttripletswithevenxorsetbitsi

// Time:  O(nlogr), r = max(max(a), max(b), max(c))
// Space: O(1)

class Solution {
    fun tripletCount(a: IntArray, b: IntArray, c: IntArray): Int {
        val count = { values: IntArray ->
            var odd = 0
            for (x in values) {
                odd += Integer.bitCount(x) and 1
            }
            intArrayOf(values.size - odd, odd)
        }
        val cnt = arrayOf(count(a), count(b), count(c))
        var result = 0
        for (i in 0 until 4) {
            result += cnt[0][if (i == 0 || i == 1) 0 else 1] *
                cnt[1][if (i == 0 || i == 2) 0 else 1] *
                cnt[2][if (i == 0 || i == 3) 0 else 1]
        }
        return result
    }
}
