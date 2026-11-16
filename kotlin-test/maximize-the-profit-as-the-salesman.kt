package maximizetheprofitasthesalesman

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheProfitAsTheSalesmanTest {
    @Test
    fun exampleOne() {
        val offers = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 2, 2),
            intArrayOf(1, 3, 2)
        )
        assertEquals(3, Solution().maximizeTheProfit(5, offers))
    }

    @Test
    fun exampleTwo() {
        val offers = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 2, 10),
            intArrayOf(1, 3, 2)
        )
        assertEquals(10, Solution().maximizeTheProfit(5, offers))
    }

    @Test
    fun noOffers() {
        assertEquals(0, Solution().maximizeTheProfit(3, arrayOf()))
    }

    @Test
    fun singleOffer() {
        assertEquals(5, Solution().maximizeTheProfit(3, arrayOf(intArrayOf(0, 2, 5))))
    }
}
