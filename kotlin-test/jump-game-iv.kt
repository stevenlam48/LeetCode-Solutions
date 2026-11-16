package jumpgameiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGameIvTest {
    @Test
    fun `uses equal values and adjacent jumps`() {
        assertEquals(3, Solution().minJumps(intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404)))
    }

    @Test
    fun `single element needs no jumps`() {
        assertEquals(0, Solution().minJumps(intArrayOf(7)))
    }

    @Test
    fun `jump directly between equal endpoints`() {
        assertEquals(1, Solution().minJumps(intArrayOf(7, 6, 9, 6, 9, 6, 9, 7)))
    }

    @Test
    fun `walks through distinct values`() {
        assertEquals(2, Solution().minJumps(intArrayOf(6, 1, 9)))
    }

    @Test
    fun `all equal values need one jump`() {
        assertEquals(1, Solution().minJumps(intArrayOf(4, 4, 4, 4)))
    }
}
