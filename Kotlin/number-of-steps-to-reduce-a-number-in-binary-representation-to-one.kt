package numberofstepstoreduceanumberinbinaryrepresentationtoone

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numSteps(s: String): Int {
        var result = 0
        var carry = 0
        for (i in s.length - 1 downTo 1) {
            if (s[i] - '0' + carry == 1) {
                carry = 1  // once it was set, it would keep carrying forever
                result += 2
            } else {
                ++result
            }
        }
        return result + carry
    }
}
