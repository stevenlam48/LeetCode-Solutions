package abbreviatingtheproductofarange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PabbreviatingtheproductofarangeTest {
    @Test
    fun example1() {
        assertEquals("24e0", Solution().abbreviateProduct(1, 4))
    }

    @Test
    fun example2() {
        assertEquals("399168e2", Solution().abbreviateProduct(2, 11))
    }

    @Test
    fun example3() {
        assertEquals("72198...56259e3", Solution().abbreviateProduct(371, 375))
    }

    @Test
    fun singleValue() {
        assertEquals("1e0", Solution().abbreviateProduct(1, 1))
    }

    @Test
    fun trailingZeros() {
        assertEquals("1512e2", Solution().abbreviateProduct(5, 10))
    }
}
