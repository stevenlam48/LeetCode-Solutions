package findnumberofwaystoreachthekthstair

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindNumberOfWaysToReachTheKThStairTest {
    private val solution = Solution()

    @Test
    fun exampleZero() {
        assertEquals(2, solution.waysToReachStair(0))
    }

    @Test
    fun exampleOne() {
        assertEquals(4, solution.waysToReachStair(1))
    }

    @Test
    fun stairTwo() {
        assertEquals(4, solution.waysToReachStair(2))
    }

    @Test
    fun stairThree() {
        assertEquals(3, solution.waysToReachStair(3))
    }
}
