package howmanyapplescanyouputintothebasket

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HowManyApplesCanYouPutIntoTheBasketTest {
    @Test
    fun firstStandardExample() {
        assertEquals(4, Solution().maxNumberOfApples(intArrayOf(100, 200, 150, 1000)))
    }

    @Test
    fun secondStandardExample() {
        assertEquals(6, Solution().maxNumberOfApples(intArrayOf(900, 950, 800, 1000, 700, 400)))
    }

    @Test
    fun exactCapacityIsAllowed() {
        assertEquals(2, Solution().maxNumberOfApples(intArrayOf(2500, 2500)))
        assertEquals(1, Solution().maxNumberOfApples(intArrayOf(3000, 2001)))
    }

    @Test
    fun lightestApplesAreChosenFirst() {
        assertEquals(4, Solution().maxNumberOfApples(intArrayOf(5000, 1, 2, 3, 4)))
    }

    @Test
    fun emptyAndSingleOverweightInput() {
        assertEquals(0, Solution().maxNumberOfApples(intArrayOf()))
        assertEquals(0, Solution().maxNumberOfApples(intArrayOf(5001)))
    }
}
