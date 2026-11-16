package makingfilenamesunique

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakingFileNamesUniqueTest {
    @Test
    fun testExample1() {
        assertEquals(
            listOf("pes", "fifa", "gta", "pes(2019)"),
            Solution().getFolderNames(arrayOf("pes", "fifa", "gta", "pes(2019)"))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf("gta", "gta(1)", "gta(2)", "avalon"),
            Solution().getFolderNames(arrayOf("gta", "gta(1)", "gta", "avalon"))
        )
    }

    @Test
    fun testExample3() {
        assertEquals(
            listOf("onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"),
            Solution().getFolderNames(
                arrayOf("onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece")
            )
        )
    }

    @Test
    fun testExample4() {
        assertEquals(
            listOf("wano", "wano(1)", "wano(2)", "wano(3)"),
            Solution().getFolderNames(arrayOf("wano", "wano", "wano", "wano"))
        )
    }

    @Test
    fun testSuffixLikeNames() {
        assertEquals(
            listOf("kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"),
            Solution().getFolderNames(arrayOf("kaido", "kaido(1)", "kaido", "kaido(1)"))
        )
    }

    @Test
    fun testSingleName() {
        assertEquals(listOf("abc"), Solution().getFolderNames(arrayOf("abc")))
    }
}
