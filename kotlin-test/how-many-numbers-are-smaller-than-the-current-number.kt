package howmanynumbersaresmallerthanthecurrentnumber

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class HowManyNumbersAreSmallerThanTheCurrentNumberTest {
    @Test
    fun firstStandardExample() {
        assertArrayEquals(
            intArrayOf(4, 0, 1, 1, 3),
            Solution().smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3))
        )
    }

    @Test
    fun secondStandardExample() {
        assertArrayEquals(
            intArrayOf(2, 1, 0, 3),
            Solution().smallerNumbersThanCurrent(intArrayOf(6, 5, 4, 8))
        )
    }

    @Test
    fun allValuesAreEqual() {
        assertArrayEquals(
            intArrayOf(0, 0, 0, 0),
            Solution().smallerNumbersThanCurrent(intArrayOf(7, 7, 7, 7))
        )
    }

    @Test
    fun zeroesAndDuplicates() {
        assertArrayEquals(
            intArrayOf(0, 2, 0, 2, 4),
            Solution().smallerNumbersThanCurrent(intArrayOf(0, 1, 0, 1, 2))
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(0), Solution().smallerNumbersThanCurrent(intArrayOf(5)))
    }
}
