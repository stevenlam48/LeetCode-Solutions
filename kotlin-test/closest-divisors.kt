package closestdivisors

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ClosestDivisorsTest {
    @Test
    fun findsDivisorsInFirstLeetCodeExample() {
        assertArrayEquals(intArrayOf(3, 3), Solution().closestDivisors(8))
    }

    @Test
    fun findsDivisorsInSecondLeetCodeExample() {
        assertArrayEquals(intArrayOf(5, 25), Solution().closestDivisors(123))
    }

    @Test
    fun findsDivisorsInThirdLeetCodeExample() {
        assertArrayEquals(intArrayOf(25, 40), Solution().closestDivisors(999))
    }

    @Test
    fun handlesSmallestInput() {
        assertArrayEquals(intArrayOf(1, 2), Solution().closestDivisors(1))
    }

    @Test
    fun usesNumPlusTwoWhenItHasCloserFactors() {
        assertArrayEquals(intArrayOf(3, 4), Solution().closestDivisors(10))
    }
}
