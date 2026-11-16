package encryptanddecryptstrings
// Time:  ctor:    O(m + d), m is len(keys), d is sum(len(x) for x in dictionary)
//        encrypt: O(n)
//        decrypt: O(n)
// Space: O(m + d)

class Encrypter(keys: CharArray, values: List<String>, dictionary: List<String>) {
    private val lookup = HashMap<Char, String>()
    private val cnt = HashMap<String, Int>()

    init {
        for (i in keys.indices) {
            lookup[keys[i]] = values[i]
        }
        for (word in dictionary) {
            val encrypted = encrypt(word)
            cnt[encrypted] = (cnt[encrypted] ?: 0) + 1
        }
    }

    fun encrypt(word1: String): String {
        val result = StringBuilder()
        for (c in word1) {
            val value = lookup[c] ?: return ""
            result.append(value)
        }
        return result.toString()
    }

    fun decrypt(word2: String): Int {
        return cnt[word2] ?: 0
    }
}
