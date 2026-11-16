package numbercomplement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberComplementTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().findComplement(5))
    }

    @Test
    fun one() {
        assertEquals(0, Solution().findComplement(1))
    }

    @Test
    fun allOnes() {
        assertEquals(0, Solution().findComplement(7))
    }

    @Test
    fun ten() {
        assertEquals(5, Solution().findComplement(10))
    }

    @Test
    fun two() {
        assertEquals(1, Solution().findComplement(2))
    }
}
