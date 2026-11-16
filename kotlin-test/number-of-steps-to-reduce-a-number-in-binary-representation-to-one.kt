package numberofstepstoreduceanumberinbinaryrepresentationtoone

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfStepsToReduceANumberInBinaryRepresentationToOneTest {
    @Test
    fun testExample1() {
        assertEquals(6, Solution().numSteps("1101"))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().numSteps("10"))
    }

    @Test
    fun testExample3() {
        assertEquals(0, Solution().numSteps("1"))
    }

    @Test
    fun testAllOnes() {
        assertEquals(4, Solution().numSteps("111"))
    }

    @Test
    fun testPowerOfTwo() {
        assertEquals(3, Solution().numSteps("1000"))
    }
}
