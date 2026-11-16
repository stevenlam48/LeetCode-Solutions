package shufflestring

// Time:  O(n)
// Space: O(1)
class Solution {
    fun restoreString(s: String, indices: IntArray): String {
        val chars = s.toCharArray()
        for (i in chars.indices) {
            if (indices[i] == i) continue
            var move = chars[i]
            var j = indices[i]
            while (j != i) {
                val next = indices[j]
                indices[j] = j
                val temp = chars[j]
                chars[j] = move
                move = temp
                j = next
            }
            chars[i] = move
        }
        return String(chars)
    }
}
