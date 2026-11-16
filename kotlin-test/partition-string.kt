package partitionstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PartitionStringTest {
    private val solution = Solution()

    @Test
    fun createsNewSubstringsUsingTrie() {
        assertEquals(listOf("a", "b", "ab"), solution.partitionString("abab"))
    }

    @Test
    fun separatesEveryPreviouslyUnseenCharacter() {
        assertEquals(listOf("a", "b", "c"), solution.partitionString("abc"))
    }

    @Test
    fun combinesRepeatedCharacterWithFollowingNewBranch() {
        assertEquals(listOf("a", "ab"), solution.partitionString("aab"))
    }

    @Test
    fun handlesEmptyString() {
        assertEquals(emptyList<String>(), solution.partitionString(""))
    }
}
