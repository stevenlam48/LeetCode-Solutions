package minimumincrementsfortargetmultiplesinanarray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumIncrementsForTargetMultiplesInAnArrayTest {
    @Test
    fun oneIncrementCoversBothTargets() {
        assertEquals(1, Solution().minimumIncrements(intArrayOf(1, 2, 3), intArrayOf(2, 4)))
    }

    @Test
    fun separateElementsCoverTargets() {
        assertEquals(1, Solution().minimumIncrements(intArrayOf(8, 4), intArrayOf(2, 3)))
    }

    @Test
    fun separateTargetsAreCheaperThanTheirLcm() {
        assertEquals(2, Solution().minimumIncrements(intArrayOf(3, 5), intArrayOf(4, 6)))
    }

    @Test
    fun duplicateTargetsShareOneElement() {
        assertEquals(1, Solution().minimumIncrements(intArrayOf(1), intArrayOf(2, 2)))
    }

    @Test
    fun noIncrementsNeeded() {
        assertEquals(0, Solution().minimumIncrements(intArrayOf(6, 10), intArrayOf(2, 3, 5)))
    }
}
