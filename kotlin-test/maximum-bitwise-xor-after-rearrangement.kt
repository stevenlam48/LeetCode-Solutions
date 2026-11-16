package maximumbitwisexorafterrearrangement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBitwiseXorAfterRearrangementTest {
    @Test
    fun example() {
        assertEquals("110", Solution().maximumXor("101", "011"))
    }

    @Test
    fun zerosOnly() {
        assertEquals("0", Solution().maximumXor("0", "0"))
    }

    @Test
    fun onesOnly() {
        assertEquals("0", Solution().maximumXor("1", "1"))
    }

    @Test
    fun complementaryStrings() {
        assertEquals("1111", Solution().maximumXor("1111", "0000"))
    }
}
