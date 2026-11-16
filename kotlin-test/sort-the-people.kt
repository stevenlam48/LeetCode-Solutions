package sortthepeople

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortThePeopleTest {
    @Test
    fun standardExample() {
        assertArrayEquals(
            arrayOf("Mary", "Emma", "John"),
            Solution().sortPeople(
                arrayOf("Mary", "John", "Emma"),
                intArrayOf(180, 165, 170)
            )
        )
    }

    @Test
    fun descendingHeightsRemainUnchanged() {
        assertArrayEquals(
            arrayOf("tallest", "middle", "shortest"),
            Solution().sortPeople(
                arrayOf("tallest", "middle", "shortest"),
                intArrayOf(190, 175, 160)
            )
        )
    }

    @Test
    fun singlePersonAndEmptyInput() {
        assertArrayEquals(
            arrayOf("only"),
            Solution().sortPeople(arrayOf("only"), intArrayOf(150))
        )
        assertArrayEquals(arrayOf<String>(), Solution().sortPeople(arrayOf(), intArrayOf()))
    }
}
