package nthmagicalnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NthMagicalNumberTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().nthMagicalNumber(1, 2, 3))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().nthMagicalNumber(4, 2, 3))
    }

    @Test
    fun example3() {
        assertEquals(10, Solution().nthMagicalNumber(5, 2, 4))
    }

    @Test
    fun example4() {
        assertEquals(8, Solution().nthMagicalNumber(3, 6, 4))
    }
}
