package lettercombinationsofaphonenumber

// Time:  O(n * 4^n)
// Space: O(1)

class Solution {
    fun letterCombinations(digits: String): List<String> {
        val lookup = listOf(" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

        if (digits.isEmpty()) {
            return emptyList()
        }
        var total = 1
        for (digit in digits) {
            total *= lookup[digit - '0'].length
        }
        val result = ArrayList<String>()
        for (i in 0 until total) {
            var base = total
            val curr = StringBuilder()
            for (digit in digits) {
                val choices = lookup[digit - '0']
                base /= choices.length
                curr.append(choices[(i / base) % choices.length])
            }
            result.add(curr.toString())
        }
        return result
    }
}
