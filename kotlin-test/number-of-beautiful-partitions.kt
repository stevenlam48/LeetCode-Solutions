package numberofbeautifulpartitions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfBeautifulPartitionsTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().beautifulPartitions("2354211341", 3, 3))
    }

    @Test
    fun singlePart() {
        assertEquals(1, Solution().beautifulPartitions("220", 1, 3))
    }

    @Test
    fun twoParts() {
        assertEquals(1, Solution().beautifulPartitions("2059", 2, 2))
    }

    @Test
    fun repeatedParts() {
        assertEquals(1, Solution().beautifulPartitions("2020", 2, 2))
    }

    @Test
    fun threeRepeatedParts() {
        assertEquals(1, Solution().beautifulPartitions("202020", 3, 2))
    }

    @Test
    fun impossiblePartition() {
        assertEquals(0, Solution().beautifulPartitions("2520", 2, 2))
    }
}
