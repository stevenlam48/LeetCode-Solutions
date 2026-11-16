package numberofvalidclocktimes

// Time:  O(1)
// Space: O(1)

class Solution {
    fun countTime(time: String): Int {
        var result = 1
        if (time[4] == '?') {
            result *= 10
        }
        if (time[3] == '?') {
            result *= 6
        }
        if (time[1] == '?' && time[0] == '?') {
            result *= 24
        } else if (time[1] == '?') {
            result *= if (time[0] != '2') 10 else 4
        } else if (time[0] == '?') {
            result *= if (time[1] < '4') 3 else 2
        }
        return result
    }
}
