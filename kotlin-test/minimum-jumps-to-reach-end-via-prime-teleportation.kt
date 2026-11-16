package minimumjumpstoreachendviaprimeteleportation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumJumpsToReachEndViaPrimeTeleportationTest {
    private val solution = Solution()

    @Test
    fun singleElementNeedsNoJump() {
        assertEquals(0, solution.minJumps(intArrayOf(1)))
    }

    @Test
    fun combinesAdjacentJumpsAndPrimeTeleportation() {
        assertEquals(2, solution.minJumps(intArrayOf(1, 2, 4, 6)))
    }

    @Test
    fun primePositionCanTeleportDirectlyToEnd() {
        assertEquals(1, solution.minJumps(intArrayOf(2, 3, 5, 6)))
    }

    @Test
    fun compositePositionsUseAdjacentJumps() {
        assertEquals(3, solution.minJumps(intArrayOf(1, 4, 9, 25)))
    }
}
