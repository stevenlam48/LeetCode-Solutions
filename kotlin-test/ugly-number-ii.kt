package uglynumberii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UglyNumberIiTest {
    @Test
    fun first() {
        assertEquals(1, Solution().nthUglyNumber(1))
    }

    @Test
    fun tenth() {
        assertEquals(12, Solution().nthUglyNumber(10))
    }

    @Test
    fun eleventh() {
        assertEquals(15, Solution().nthUglyNumber(11))
    }

    @Test
    fun fifteenth() {
        assertEquals(24, Solution().nthUglyNumber(15))
    }
}
