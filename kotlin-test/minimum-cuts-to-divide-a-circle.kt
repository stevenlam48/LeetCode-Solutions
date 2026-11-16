package minimumcutstodivideacircle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCutsToDivideACircleTest {
    @Test
    fun n1() {
        assertEquals(0, Solution().numberOfCuts(1))
    }

    @Test
    fun n2() {
        assertEquals(1, Solution().numberOfCuts(2))
    }

    @Test
    fun n3() {
        assertEquals(3, Solution().numberOfCuts(3))
    }

    @Test
    fun n4() {
        assertEquals(2, Solution().numberOfCuts(4))
    }

    @Test
    fun n5() {
        assertEquals(5, Solution().numberOfCuts(5))
    }

    @Test
    fun n6() {
        assertEquals(3, Solution().numberOfCuts(6))
    }
}
