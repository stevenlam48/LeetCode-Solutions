package guesstheword

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GuessTheWordTest {
    private class FakeMaster(private val secret: String, private val maxGuesses: Int) : Master {
        var guesses = 0
            private set
        var found = false
            private set

        override fun guess(word: String): Int {
            ++guesses
            assertTrue(guesses <= maxGuesses, "too many guesses")
            var matches = 0
            for (i in secret.indices) {
                if (secret[i] == word[i]) {
                    ++matches
                }
            }
            if (matches == 6) {
                found = true
            }
            return matches
        }
    }

    @Test
    fun example1() {
        val wordlist = listOf("acckzz", "ccbazz", "eiowzz", "abcczz")
        val master = FakeMaster("acckzz", 10)
        Solution().findSecretWord(wordlist, master)
        assertTrue(master.found)
    }

    @Test
    fun example2() {
        val wordlist = listOf("hamada", "khaled")
        val master = FakeMaster("hamada", 10)
        Solution().findSecretWord(wordlist, master)
        assertTrue(master.found)
    }

    @Test
    fun allIdentical() {
        val wordlist = List(6) { "aaaaaa" }
        val master = FakeMaster("aaaaaa", 10)
        Solution().findSecretWord(wordlist, master)
        assertTrue(master.found)
        assertEquals(1, master.guesses)
    }

    @Test
    fun secretLast() {
        val wordlist = listOf("aaaaaa", "bbbbbb", "cccccc", "dddddd", "eeeeee", "ffffff")
        val master = FakeMaster("ffffff", 10)
        Solution().findSecretWord(wordlist, master)
        assertTrue(master.found)
    }

    @Test
    fun secretFirst() {
        val wordlist = listOf("zzzzzz", "aaaaaa", "bbbbbb", "cccccc", "dddddd", "eeeeee")
        val master = FakeMaster("zzzzzz", 10)
        Solution().findSecretWord(wordlist, master)
        assertTrue(master.found)
    }
}
