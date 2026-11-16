package numberoflaserbeamsinabank
// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun numberOfBeams(bank: List<String>): Int {
        var result = 0
        var prev = 0
        for (x in bank) {
            val cnt = x.count { it == '1' }
            if (cnt == 0) {
                continue
            }
            result += prev * cnt
            prev = cnt
        }
        return result
    }
}
