package usingarobottoprintthelexicographicallysmalleststring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UsingARobotToPrintTheLexicographicallySmallestStringTest {
    @Test
    fun reversedZAndA() {
        assertEquals("azz", Solution().robotWithString("zza"))
    }

    @Test
    fun alternatingCharacters() {
        assertEquals("abc", Solution().robotWithString("bac"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals("addb", Solution().robotWithString("bdda"))
    }

    @Test
    fun singleCharacter() {
        assertEquals("x", Solution().robotWithString("x"))
    }
}
