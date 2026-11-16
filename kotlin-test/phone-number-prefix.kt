package phonenumberprefix

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PhoneNumberPrefixTest {
    @Test
    fun numberIsPrefixOfAnother() {
        assertFalse(Solution().phonePrefix(arrayOf("12", "123", "45")))
    }

    @Test
    fun noNumberIsPrefix() {
        assertTrue(Solution().phonePrefix(arrayOf("1", "24", "234")))
    }

    @Test
    fun duplicateNumbers() {
        assertFalse(Solution().phonePrefix(arrayOf("911", "911")))
    }

    @Test
    fun emptyInput() {
        assertTrue(Solution().phonePrefix(emptyArray()))
    }

    @Test
    fun singleNumber() {
        assertTrue(Solution().phonePrefix(arrayOf("00123")))
    }
}
