package bitwiseorofadjacentelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BitwiseOrOfAdjacentElementsTest {
    @Test
    fun standardExample() {
        assertArrayEquals(intArrayOf(3, 3), Solution().orArray(intArrayOf(1, 2, 3)))
    }

    @Test
    fun adjacentDisjointBits() {
        assertArrayEquals(intArrayOf(3, 6, 12), Solution().orArray(intArrayOf(1, 2, 4, 8)))
    }

    @Test
    fun singleElementProducesEmptyArray() {
        assertArrayEquals(intArrayOf(), Solution().orArray(intArrayOf(7)))
    }
}
