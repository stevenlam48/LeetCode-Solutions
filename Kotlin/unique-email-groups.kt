package uniqueemailgroups

// Time:  O(n * l)
// Space: O(n * l)

class Solution {
    fun uniqueEmailGroups(emails: List<String>): Int {
        val result = HashSet<String>()
        for (raw in emails) {
            val email = raw.lowercase()
            val end = email.indexOfFirst { it == '+' || it == '@' }
            var local = email.substring(0, end)
            local = local.replace(".", "")
            val domain = email.substring(email.indexOf('@') + 1)
            result.add(local + '@' + domain)
        }
        return result.size
    }
}
