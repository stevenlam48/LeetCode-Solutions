package uniquemorsecodewords

// Time:  O(n), n is the sume of all word lengths
// Space: O(n)

class Solution {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val morse = arrayOf(
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."
        )
        val lookup = HashSet<String>()
        for (word in words) {
            val code = StringBuilder()
            for (c in word) {
                code.append(morse[c - 'a'])
            }
            lookup.add(code.toString())
        }
        return lookup.size
    }
}
