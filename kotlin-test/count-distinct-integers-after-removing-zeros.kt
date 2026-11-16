package countdistinctintegersafterremovingzeros

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDistinctIntegersAfterRemovingZerosTest {
    @Test
    fun singleDigit() {
        assertEquals(1L, Solution().countDistinct(1L))
        assertEquals(9L, Solution().countDistinct(9L))
    }

    @Test
    fun ten() {
        assertEquals(9L, Solution().countDistinct(10L))
    }

    @Test
    fun twenty() {
        assertEquals(18L, Solution().countDistinct(20L))
    }

    @Test
    fun hundred() {
        assertEquals(90L, Solution().countDistinct(100L))
    }

    @Test
    fun largerValue() {
        assertEquals(819L, Solution().countDistinct(1000L))
    }
}
