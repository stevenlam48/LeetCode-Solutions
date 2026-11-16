package numberofuniquexortripletsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfUniqueXorTripletsITest {
    @Test
    fun example1() {
        assertEquals(4, Solution().uniqueXorTriplets(intArrayOf(1, 2, 3)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().uniqueXorTriplets(intArrayOf(1, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().uniqueXorTriplets(intArrayOf(1)))
    }

    @Test
    fun fourElements() {
        assertEquals(8, Solution().uniqueXorTriplets(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun fiveElements() {
        assertEquals(8, Solution().uniqueXorTriplets(intArrayOf(1, 2, 3, 4, 5)))
    }
}
