package uglynumberiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UglyNumberIiiTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().nthUglyNumber(3, 2, 3, 5))
    }

    @Test
    fun example2() {
        assertEquals(6, Solution().nthUglyNumber(4, 2, 3, 4))
    }

    @Test
    fun example3() {
        assertEquals(10, Solution().nthUglyNumber(5, 2, 11, 13))
    }

    @Test
    fun large() {
        assertEquals(1999999984, Solution().nthUglyNumber(1000000000, 2, 217983653, 336916467))
    }
}
