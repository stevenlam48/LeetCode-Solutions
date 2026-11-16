package implementrand10usingrand7

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementRand10UsingRand7Test {
    @Test
    fun deterministicAllOnes() {
        val s = Solution { 1 }
        repeat(50) {
            assertEquals(1, s.rand10())
        }
    }

    @Test
    fun resultsInRange() {
        var seed = 123456789L
        val s = Solution {
            seed = (seed * 1103515245 + 12345) and 0x7fffffff
            (seed % 7).toInt() + 1
        }
        repeat(500) {
            val v = s.rand10()
            assertTrue(v in 1..10)
        }
    }

    @Test
    fun coversAllValues() {
        var seed = 987654321L
        val s = Solution {
            seed = (seed * 1103515245 + 12345) and 0x7fffffff
            (seed % 7).toInt() + 1
        }
        val seen = HashSet<Int>()
        repeat(2000) {
            seen.add(s.rand10())
        }
        assertEquals((1..10).toSet(), seen)
    }
}
