package minimumoperationstosortastring

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun minOperations(s: String): Int {
        if (s.length <= 1) {
            return 0
        }
        var sorted = true
        for (i in 1 until s.length) {
            if (s[i - 1] > s[i]) {
                sorted = false
                break
            }
        }
        if (sorted) {
            return 0
        }
        if (s.length == 2) {
            return -1
        }
        var mn = s[1]
        var mx = s[1]
        for (i in 1 until s.length - 1) {
            if (s[i] < mn) {
                mn = s[i]
            }
            if (s[i] > mx) {
                mx = s[i]
            }
        }
        var globalMin = s[0]
        var globalMax = s[0]
        for (c in s) {
            if (c < globalMin) {
                globalMin = c
            }
            if (c > globalMax) {
                globalMax = c
            }
        }
        return if (s[0] == globalMin || s.last() == globalMax) {
            1
        } else if (s[0] <= mx || s.last() >= mn) {
            2
        } else {
            3
        }
    }
}
