package minimumfactorization

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFactorizationTest {
    @Test
    fun example1() {
        assertEquals(68, Solution().smallestFactorization(48))
    }

    @Test
    fun example2() {
        assertEquals(35, Solution().smallestFactorization(15))
    }

    @Test
    fun threeDigitResult() {
        assertEquals(455, Solution().smallestFactorization(100))
    }

    @Test
    fun inputBelowTwoIsReturned() {
        assertEquals(1, Solution().smallestFactorization(1))
        assertEquals(0, Solution().smallestFactorization(0))
    }

    @Test
    fun primeGreaterThanNineIsImpossible() {
        assertEquals(0, Solution().smallestFactorization(13))
    }
}
