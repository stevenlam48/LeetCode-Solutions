package applydiscounttoprices

// Time:  O(n)
// Space: O(1)

class Solution {
    fun discountPrices(sentence: String, discount: Int): String {
        fun format(x: String): String {
            val value = x.toLong()
            val integers = value * (100 - discount) / 100
            val decimals = value * (100 - discount) % 100
            return "$" + integers + "." + decimals.toString().padStart(2, '0')
        }

        val result = StringBuilder()
        var i = 0
        while (i < sentence.length) {
            var j = sentence.indexOf(' ', i)
            if (j == -1) {
                j = sentence.length
            }
            val word = sentence.substring(i, j)
            if (word.length > 1 && word[0] == '$' && word.substring(1).all { it.isDigit() }) {
                result.append(format(word.substring(1)))
            } else {
                result.append(word)
            }
            if (j != sentence.length) {
                result.append(' ')
            }
            i = j + 1
        }
        return result.toString()
    }
}
