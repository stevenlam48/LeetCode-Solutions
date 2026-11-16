package constructuniformparityarrayi

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConstructUniformParityArrayITest {
    @Test
    fun testExample1() {
        assertTrue(Solution().uniformArray(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testSingleElement() {
        assertTrue(Solution().uniformArray(intArrayOf(5)))
    }

    @Test
    fun testAllEven() {
        assertTrue(Solution().uniformArray(intArrayOf(2, 4, 6)))
    }
}
