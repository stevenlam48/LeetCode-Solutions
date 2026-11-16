package findthekeyofthenumbers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKeyOfTheNumbersTest {
    @Test
    fun example1() {
        assertEquals(0, Solution().generateKey(1, 10, 1000))
    }

    @Test
    fun example2() {
        assertEquals(777, Solution().generateKey(987, 879, 798))
    }

    @Test
    fun smallNumbers() {
        assertEquals(1, Solution().generateKey(1, 2, 3))
    }

    @Test
    fun allSame() {
        assertEquals(1234, Solution().generateKey(1234, 1234, 1234))
    }
}
