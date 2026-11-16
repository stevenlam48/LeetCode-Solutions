package countbeautifulnumbers

// Time:  O(logr * 2 * 10 * s)
// Space: O(s) ~= O(2026), s = len(states)

class Solution {
    fun beautifulNumbers(l: Int, r: Int): Int {
        fun count(x: Int): Int {
            val s = x.toString()
            var dp = Array(2) { HashMap<Int, HashMap<Int, Int>>() }
            dp[1].getOrPut(1) { HashMap() }[0] = 1
            for (c in s) {
                val newDp = Array(2) { HashMap<Int, HashMap<Int, Int>>() }
                val digit = c - '0'
                for (b in 0..1) {
                    for ((mul, kvp) in dp[b]) {
                        for ((total, cnt) in kvp) {
                            for (x in 0..if (b == 0) 9 else digit) {
                                val newB = if (b == 1 && x == digit) 1 else 0
                                val newMul = if (total == 0 && x == 0) mul else mul * x
                                val sums = newDp[newB].getOrPut(newMul) { HashMap() }
                                sums[total + x] = (sums[total + x] ?: 0) + cnt
                            }
                        }
                    }
                }
                dp = newDp
            }
            var result = 0
            for (b in 0..1) {
                for ((mul, kvp) in dp[b]) {
                    for ((total, cnt) in kvp) {
                        if (total != 0 && mul % total == 0) {
                            result += cnt
                        }
                    }
                }
            }
            return result
        }

        return count(r) - count(l - 1)
    }
}
