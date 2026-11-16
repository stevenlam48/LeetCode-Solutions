package senderwithlargestwordcount

// Time:  O(n * l)
// Space: O(n)

class Solution {
    fun largestWordCount(messages: List<String>, senders: List<String>): String {
        val cnt = HashMap<String, Int>()
        var result = ""
        var mx = 0
        for (i in messages.indices) {
            val words = messages[i].count { it == ' ' } + 1
            val total = (cnt[senders[i]] ?: 0) + words
            cnt[senders[i]] = total
            if (total > mx || (total == mx && senders[i] > result)) {
                mx = total
                result = senders[i]
            }
        }
        return result
    }
}
