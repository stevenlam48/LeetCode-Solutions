package numberofdifferentintegersinastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfDifferentIntegersInAStringTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().numDifferentIntegers("a123bc34d8ef34"))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().numDifferentIntegers("leet1234code234"))
    }

    @Test
    fun leadingZerosDoNotCreateDifferentIntegers() {
        assertEquals(1, Solution().numDifferentIntegers("a1b01c001"))
    }

    @Test
    fun allZeroRepresentationsAreEqual() {
        assertEquals(1, Solution().numDifferentIntegers("0a00b000"))
    }

    @Test
    fun noIntegers() {
        assertEquals(0, Solution().numDifferentIntegers("leetcode"))
    }
}
