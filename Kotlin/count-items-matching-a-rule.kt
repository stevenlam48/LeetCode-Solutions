package countitemsmatchingarule

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        val rule = mapOf("type" to 0, "color" to 1, "name" to 2)
        var result = 0
        for (item in items) {
            if (item[rule.getValue(ruleKey)] == ruleValue) {
                ++result
            }
        }
        return result
    }
}
