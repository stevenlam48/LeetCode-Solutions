package strobogrammaticnumberiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrobogrammaticNumberIiiTest {
    @Test
    fun `single value inclusive range`() {
        assertEquals(1, Solution().strobogrammaticInRange("0", "0"))
    }

    @Test
    fun `standard fifty to one hundred`() {
        assertEquals(3, Solution().strobogrammaticInRange("50", "100"))
    }

    @Test
    fun `different digit lengths`() {
        assertEquals(2, Solution().strobogrammaticInRange("1", "10"))
    }

    @Test
    fun `larger inclusive range`() {
        assertEquals(18, Solution().strobogrammaticInRange("1", "1000"))
    }
}
