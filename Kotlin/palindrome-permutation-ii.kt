package palindromepermutationii
// Time:  O(n * n!)
// Space: O(n)

class Solution {
    fun generatePalindromes(s: String): List<String> {
        if (s.isEmpty()) {
            return emptyList()
        }
        val count = HashMap<Char, Int>()
        for (c in s) {
            count[c] = count.getOrDefault(c, 0) + 1
        }
        var mid = ""
        val chars = StringBuilder()
        for ((c, value) in count) {
            if (value % 2 != 0) {
                if (mid.isEmpty()) {
                    mid = c.toString()
                } else {
                    return emptyList()
                }
            }
            repeat(value / 2) { chars.append(c) }
        }
        return permuteUnique(mid, chars.toString())
    }

    fun permuteUnique(mid: String, chars: String): List<String> {
        val result = mutableListOf<String>()
        val sorted = chars.toCharArray()
        sorted.sort()
        do {
            result.add(String(sorted) + mid + String(sorted.reversedArray()))
        } while (nextPermutation(sorted))
        return result
    }

    private fun nextPermutation(values: CharArray): Boolean {
        var i = values.size - 2
        while (i >= 0 && values[i] >= values[i + 1]) {
            i--
        }
        if (i < 0) {
            return false
        }
        var j = values.size - 1
        while (values[j] <= values[i]) {
            j--
        }
        val temp = values[i]
        values[i] = values[j]
        values[j] = temp
        var left = i + 1
        var right = values.size - 1
        while (left < right) {
            val value = values[left]
            values[left] = values[right]
            values[right] = value
            left++
            right--
        }
        return true
    }
}
