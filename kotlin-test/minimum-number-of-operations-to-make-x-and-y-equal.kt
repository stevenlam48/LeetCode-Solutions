package minimumnumberofoperationstomakexandyequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeXAndYEqualTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(3, solution.minimumOperationsToMakeEqual(26, 1))
    }

    @Test
    fun secondExample() {
        assertEquals(4, solution.minimumOperationsToMakeEqual(54, 2))
    }

    @Test
    fun incrementsWhenYIsGreater() {
        assertEquals(5, solution.minimumOperationsToMakeEqual(25, 30))
    }

    @Test
    fun alreadyEqual() {
        assertEquals(0, solution.minimumOperationsToMakeEqual(7, 7))
    }

    @Test
    fun dividesByFiveThenEleven() {
        assertEquals(2, solution.minimumOperationsToMakeEqual(55, 1))
    }
}
