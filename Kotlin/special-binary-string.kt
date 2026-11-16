package specialbinarystring

// Time:  f(n) = k * f(n/k) + n/k * klogk <= O(logn * nlogk) <= O(n^2)
//        n is the length of S, k is the max number of special strings in each depth
// Space: O(n)

class Solution {
    fun makeLargestSpecial(S: String): String {
        val result = mutableListOf<String>()
        var anchor = 0
        var count = 0
        for (i in S.indices) {
            if (S[i] == '1') {
                ++count
            } else {
                --count
            }
            if (count == 0) {
                result.add("1" + makeLargestSpecial(S.substring(anchor + 1, i)) + "0")
                anchor = i + 1
            }
        }
        result.sortDescending()
        return result.joinToString("")
    }
}
