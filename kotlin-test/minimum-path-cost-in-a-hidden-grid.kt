package minimumpathcostinahiddengrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private typealias Position = Pair<Int, Int>
private typealias Edge = Set<Position>

class MinimumPathCostInAHiddenGridTest {
    private val solution = Solution()

    @Test
    fun startIsTarget() {
        val start = 0 to 0
        val neighbor = 0 to 1
        assertPath(0, setOf(start, neighbor), mapOf(setOf(start, neighbor) to 7), start, start)
    }

    @Test
    fun singlePathReturnsTotalMoveCost() {
        val start = 0 to 0
        val middle = 0 to 1
        val target = 1 to 1
        val costs = mapOf(
            setOf(start, middle) to 4,
            setOf(middle, target) to 5
        )
        assertPath(9, setOf(start, middle, target), costs, start, target)
    }

    @Test
    fun choosesCheapestRouteInsteadOfFewestMoves() {
        val start = 0 to 0
        val target = 0 to 1
        val bottomLeft = 1 to 0
        val bottomRight = 1 to 1
        val costs = mapOf(
            setOf(start, target) to 20,
            setOf(start, bottomLeft) to 1,
            setOf(bottomLeft, bottomRight) to 1,
            setOf(bottomRight, target) to 1
        )
        assertPath(3, setOf(start, target, bottomLeft, bottomRight), costs, start, target)
    }

    @Test
    fun unreachableTargetReturnsMinusOne() {
        val start = 0 to 0
        val neighbor = 0 to 1
        val target = 5 to 5
        val costs = mapOf(setOf(start, neighbor) to 7)
        assertPath(-1, setOf(start, neighbor, target), costs, start, target)
    }

    private fun assertPath(
        expected: Int,
        cells: Set<Position>,
        costs: Map<Edge, Int>,
        start: Position,
        target: Position
    ) {
        val master = FakeGridMaster(cells, costs, start, target)
        assertEquals(expected, solution.findShortestPath(master))
    }
}

private class FakeGridMaster(
    private val cells: Set<Position>,
    private val costs: Map<Edge, Int>,
    start: Position,
    private val target: Position
) : GridMaster {
    private var position = start

    override fun canMove(direction: Char): Boolean = next(direction) in cells

    override fun move(direction: Char): Int {
        val next = next(direction)
        val cost = costs.getValue(setOf(position, next))
        position = next
        return cost
    }

    override fun isTarget(): Boolean = position == target

    private fun next(direction: Char): Position {
        val delta = directions.getValue(direction)
        return (position.first + delta.first) to (position.second + delta.second)
    }

    private companion object {
        val directions = mapOf(
            'L' to (0 to -1),
            'R' to (0 to 1),
            'U' to (-1 to 0),
            'D' to (1 to 0)
        )
    }
}
