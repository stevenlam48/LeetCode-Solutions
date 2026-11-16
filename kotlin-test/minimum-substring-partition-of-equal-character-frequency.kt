package minimumsubstringpartitionofequalcharacterfrequency

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSubstringPartitionOfEqualCharacterFrequencyTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minimumSubstringsInPartition("fabccddg"))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().minimumSubstringsInPartition("abababaccddb"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().minimumSubstringsInPartition("a"))
    }

    @Test
    fun repeatedCharacterNeedsOnePartition() {
        assertEquals(1, Solution().minimumSubstringsInPartition("aaaa"))
    }

    @Test
    fun allDistinctCharactersShareOnePartition() {
        assertEquals(1, Solution().minimumSubstringsInPartition("abcd"))
    }
}
