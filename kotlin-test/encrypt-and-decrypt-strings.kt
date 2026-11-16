package encryptanddecryptstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EncryptAndDecryptStringsTest {
    @Test
    fun leetCodeOperationSequence() {
        val encrypter = Encrypter(
            charArrayOf('a', 'b', 'c', 'd'),
            listOf("ei", "zf", "ei", "am"),
            listOf("abcd", "acbd", "adbc", "badc", "dabc")
        )

        assertEquals("eizfeiam", encrypter.encrypt("abcd"))
        assertEquals(1, encrypter.decrypt("eizfeiam"))
        assertEquals("eieizfam", encrypter.encrypt("acbd"))
        assertEquals(1, encrypter.decrypt("eieizfam"))
        assertEquals(0, encrypter.decrypt("unknown"))
    }

    @Test
    fun decryptCountsAllDictionaryCollisions() {
        val encrypter = Encrypter(
            charArrayOf('a', 'b'),
            listOf("ei", "ei"),
            listOf("aa", "ab", "ba", "bb", "aaa")
        )

        assertEquals("eiei", encrypter.encrypt("ab"))
        assertEquals(4, encrypter.decrypt("eiei"))
        assertEquals(1, encrypter.decrypt("eieiei"))
    }

    @Test
    fun invalidCharacterAndEmptyWord() {
        val encrypter = Encrypter(
            charArrayOf('a'),
            listOf("xy"),
            listOf("a", "b")
        )

        assertEquals("xyxy", encrypter.encrypt("aa"))
        assertEquals("", encrypter.encrypt("ab"))
        assertEquals("", encrypter.encrypt(""))
        assertEquals(1, encrypter.decrypt(""))
    }
}
