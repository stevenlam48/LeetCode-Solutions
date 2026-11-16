package findanagrammappings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAnagramMappingsTest {
    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(1, 4, 3, 2, 0),
            Solution().anagramMappings(intArrayOf(12, 28, 46, 32, 50), intArrayOf(50, 12, 32, 46, 28))
        )
    }

    @Test
    fun duplicateValuesFollowReferenceQueueOrder() {
        assertArrayEquals(intArrayOf(1, 1), Solution().anagramMappings(intArrayOf(1, 1), intArrayOf(1, 1)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(0), Solution().anagramMappings(intArrayOf(7), intArrayOf(7)))
    }
}
