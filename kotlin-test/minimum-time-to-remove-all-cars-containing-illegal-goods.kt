package minimumtimetoremoveallcarscontainingillegalgoods

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToRemoveAllCarsContainingIllegalGoodsTest {
    @Test
    fun mixedCars() {
        assertEquals(5, Solution().minimumTime("1100101"))
    }

    @Test
    fun prefixRemovals() {
        assertEquals(2, Solution().minimumTime("0010"))
    }

    @Test
    fun allIllegal() {
        assertEquals(3, Solution().minimumTime("111"))
    }

    @Test
    fun allLegal() {
        assertEquals(0, Solution().minimumTime("0000"))
    }

    @Test
    fun singleIllegalCar() {
        assertEquals(1, Solution().minimumTime("1"))
    }
}
