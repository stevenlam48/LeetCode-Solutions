package numberofeffectivesubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfEffectiveSubsequencesTest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().countEffective(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, Solution().countEffective(intArrayOf(7, 4, 6)))
    }

    @Test
    fun testExample3() {
        assertEquals(1, Solution().countEffective(intArrayOf(8, 8)))
    }

    @Test
    fun testExample4() {
        assertEquals(5, Solution().countEffective(intArrayOf(2, 2, 1)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().countEffective(intArrayOf(1)))
    }
}
