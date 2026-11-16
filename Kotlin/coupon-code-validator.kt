package couponcodevalidator

// Time:  O(l * nlogn)
// Space: O(n * l)

class Solution {
    fun validateCoupons(code: List<String>, businessLine: List<String>, isActive: BooleanArray): List<String> {
        val sortedCodes = mutableListOf<Pair<Int, String>>()
        for (i in code.indices) {
            if (isActive[i] && code[i].isNotEmpty() && LOOKUP.containsKey(businessLine[i]) &&
                code[i].all {
                    it in 'a'..'z' || it in 'A'..'Z' || it in '0'..'9' || it == '_'
                }
            ) {
                sortedCodes.add(LOOKUP.getValue(businessLine[i]) to code[i])
            }
        }
        sortedCodes.sortWith(compareBy<Pair<Int, String>> { it.first }.thenBy { it.second })
        return sortedCodes.map { it.second }
    }

    private companion object {
        val LOOKUP = mapOf("electronics" to 0, "grocery" to 1, "pharmacy" to 2, "restaurant" to 3)
    }
}
