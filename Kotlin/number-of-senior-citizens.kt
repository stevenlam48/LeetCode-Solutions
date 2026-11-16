package numberofseniorcitizens

// Time:  O(n)
// Space: O(1)

// string
class Solution {
    fun countSeniors(details: List<String>): Int {
        return details.count { it.substring(11, 13) > "60" }
    }
}
