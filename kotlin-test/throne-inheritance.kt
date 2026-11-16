package throneinheritance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThroneInheritanceTest {
    @Test
    fun fullInheritanceSequence() {
        val inheritance = ThroneInheritance("king")
        inheritance.birth("king", "andy")
        inheritance.birth("king", "bob")
        inheritance.birth("king", "catherine")
        inheritance.birth("andy", "matthew")
        inheritance.birth("bob", "alex")
        inheritance.birth("bob", "asha")
        assertEquals(listOf("king", "andy", "matthew", "bob", "alex", "asha", "catherine"), inheritance.getInheritanceOrder())
        inheritance.death("bob")
        assertEquals(listOf("king", "andy", "matthew", "alex", "asha", "catherine"), inheritance.getInheritanceOrder())
        inheritance.birth("bob", "claire")
        inheritance.death("king")
        assertEquals(listOf("andy", "matthew", "alex", "asha", "claire", "catherine"), inheritance.getInheritanceOrder())
    }

    @Test
    fun kingWithoutDescendants() {
        val inheritance = ThroneInheritance("king")
        assertEquals(listOf("king"), inheritance.getInheritanceOrder())
    }
}
