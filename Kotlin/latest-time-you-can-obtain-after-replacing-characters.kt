package latesttimeyoucanobtainafterreplacingcharacters
// Time:  O(1)
// Space: O(1)

class Solution {
    fun findLatestTime(s: String): String {
        val time = s.toCharArray()
        if (time[0] == '?') {
            time[0] = if (time[1] == '?' || time[1] <= '1') '1' else '0'
        }
        if (time[1] == '?') {
            time[1] = if (time[0] == '1') '1' else '9'
        }
        if (time[3] == '?') {
            time[3] = '5'
        }
        if (time[4] == '?') {
            time[4] = '9'
        }
        return String(time)
    }
}
