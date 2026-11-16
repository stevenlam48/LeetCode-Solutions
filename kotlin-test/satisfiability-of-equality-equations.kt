package satisfiabilityofequalityequations

// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SatisfiabilityOfEqualityEquationsTest {
    @Test
    fun contradictoryEquality() {
        assertFalse(Solution().equationsPossible(listOf("a==b", "b!=a")))
    }

    @Test
    fun consistentEqualities() {
        assertTrue(Solution().equationsPossible(listOf("b==a", "a==b")))
    }

    @Test
    fun transitiveContradiction() {
        assertFalse(Solution().equationsPossible(listOf("a==b", "b==c", "a!=c")))
    }

    @Test
    fun selfInequality() {
        assertFalse(Solution().equationsPossible(listOf("a!=a")))
    }

    @Test
    fun emptyInput() {
        assertTrue(Solution().equationsPossible(emptyList()))
    }
}
