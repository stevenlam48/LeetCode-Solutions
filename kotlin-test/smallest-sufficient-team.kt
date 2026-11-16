package smallestsufficientteam

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestSufficientTeamTest {
    @Test
    fun example1() {
        val reqSkills = listOf("java", "nodejs", "reactjs")
        val people = listOf(listOf("java"), listOf("nodejs"), listOf("nodejs", "reactjs"))
        assertEquals(listOf(0, 2), Solution().smallestSufficientTeam(reqSkills, people))
    }

    @Test
    fun example2UsesTwoPeople() {
        val reqSkills = listOf("algorithms", "math", "java", "reactjs", "csharp", "aws")
        val people = listOf(
            listOf("algorithms", "math", "java"),
            listOf("algorithms", "math", "reactjs"),
            listOf("java", "csharp", "aws"),
            listOf("reactjs", "csharp"),
            listOf("csharp", "math"),
            listOf("aws", "java")
        )
        val result = Solution().smallestSufficientTeam(reqSkills, people)
        assertEquals(2, result.size)
        assertEquals(reqSkills.toSet(), result.flatMap { people[it] }.toSet())
    }

    @Test
    fun singleSkill() {
        val reqSkills = listOf("algorithms")
        val people = listOf(listOf("math"), listOf("algorithms"), listOf("algorithms", "math"))
        assertEquals(listOf(1), Solution().smallestSufficientTeam(reqSkills, people))
    }

    @Test
    fun onePersonCoversEverything() {
        val reqSkills = listOf("a", "b", "c")
        val people = listOf(listOf("a"), listOf("a", "b", "c"), listOf("b", "c"))
        assertEquals(listOf(1), Solution().smallestSufficientTeam(reqSkills, people))
    }
}
