package crawlerlogfolder

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(logs: List<String>): Int {
        var result = 0
        for (log in logs) {
            if (log == "../") {
                if (result > 0) {
                    --result
                }
            } else if (log != "./") {
                ++result
            }
        }
        return result
    }
}
