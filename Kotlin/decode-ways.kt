package decodeways

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numDecodings(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        var prev = 0 // f[n - 2]
        var cur = 1 // f[n - 1]

        for (i in s.indices) {
            if (s[i] == '0') {
                cur = 0 // f[n - 1] = 0
            }
            if (i == 0 ||
                !(s[i - 1] == '1' || (s[i - 1] == '2' && s[i] <= '6'))
            ) {
                prev = 0 // f[n - 2] = 0
            }

            val tmp = cur
            cur += prev // f[n] = f[n - 1] + f[n - 2]
            prev = tmp
        }

        return cur
    }
}
