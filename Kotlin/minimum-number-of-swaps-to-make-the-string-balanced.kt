package minimumnumberofswapstomakethestringbalanced

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minSwaps(s: String): Int {
        var result = 0
        var curr = 0
        for (c in s) {
            if (c == ']') {
                ++curr
                result = maxOf(result, curr)
            } else {
                --curr
            }
        }
        return (result + 1) / 2
    }
}
