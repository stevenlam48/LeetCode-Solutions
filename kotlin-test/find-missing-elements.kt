package findmissingelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindMissingElementsTest {
    private val solution = Solution()

    @Test
    fun exampleWithGaps() {
        assertArrayEquals(intArrayOf(3), solution.findMissingElements(intArrayOf(1, 4, 2, 5)))
    }

    @Test
    fun multipleMissingElements() {
        assertArrayEquals(intArrayOf(3, 4, 6), solution.findMissingElements(intArrayOf(2, 5, 7)))
    }

    @Test
    fun noMissingElements() {
        assertArrayEquals(intArrayOf(), solution.findMissingElements(intArrayOf(4, 2, 3, 1)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(), solution.findMissingElements(intArrayOf(7)))
    }
}
