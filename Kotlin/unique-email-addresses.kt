package uniqueemailaddresses

// Time:  O(n * l)
// Space: O(n * l)

class Solution {
    fun numUniqueEmails(emails: List<String>): Int {
        val result = HashSet<String>()
        for (email in emails) {
            result.add(convert(email))
        }
        return result.size
    }

    private fun convert(email: String): String {
        val at = email.indexOf('@')
        val domain = email.substring(at)
        var name = email.substring(0, at)
        val plus = name.indexOf('+')
        if (plus != -1) {
            name = name.substring(0, plus)
        }
        name = name.replace(".", "")
        return name + domain
    }
}
