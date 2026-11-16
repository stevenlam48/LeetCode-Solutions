package maximumxorproduct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumXorProductTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(98, solution.maximumXorProduct(12L, 5L, 4))
    }

    @Test
    fun exampleTwo() {
        assertEquals(930, solution.maximumXorProduct(6L, 7L, 5))
    }

    @Test
    fun exampleThree() {
        assertEquals(12, solution.maximumXorProduct(1L, 6L, 3))
    }

    @Test
    fun zeroBitCount() {
        assertEquals(6, solution.maximumXorProduct(2L, 3L, 0))
    }

    @Test
    fun largeValuesUseModulo() {
        assertEquals(36, solution.maximumXorProduct(1000000000L, 1000000000L, 1))
    }
}
