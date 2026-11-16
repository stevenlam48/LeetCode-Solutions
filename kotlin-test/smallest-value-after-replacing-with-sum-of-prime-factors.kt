package smallestvalueafterreplacingwithsumofprimefactors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestValueAfterReplacingWithSumOfPrimeFactorsTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().smallestValue(15))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().smallestValue(3))
    }

    @Test
    fun powerOfTwo() {
        assertEquals(4, Solution().smallestValue(4))
    }

    @Test
    fun primeInput() {
        assertEquals(2, Solution().smallestValue(2))
    }

    @Test
    fun compositeInput() {
        assertEquals(5, Solution().smallestValue(100))
    }
}
