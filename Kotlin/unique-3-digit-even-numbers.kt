package unique3digitevennumbers

// Time:  O(n)
// Space: O(1)

class Solution {
    fun totalNumbers(digits: IntArray): Int {
        val cnt = IntArray(10)
        for (x in digits) {
            ++cnt[x]
        }
        var odd = 0
        var even = 0
        for (i in cnt.indices) {
            if (cnt[i] == 0) {
                continue
            }
            if (i % 2 == 1) {
                ++odd
            } else {
                ++even
            }
        }

        var result = 0
        for (i in 2 until cnt.size step 2) {
            if (cnt[i] >= 3) {
                ++result
            }
        }
        result += even * (odd + even - 1) * (odd + even - 2)
        if (cnt[0] > 0) {
            result -= 1 * (even - 1) * (odd + even - 2)
        }
        for (i in cnt.indices) {
            if (cnt[i] < 2) {
                continue
            }
            if (i == 0) {
                result += (odd + even) - 1
            } else if (i % 2 == 1) {
                result += even
            } else {
                result += 3 * (even - 1) - (if (cnt[0] != 0) 1 else 0)
                result += 2 * odd
            }
        }
        return result
    }
}
