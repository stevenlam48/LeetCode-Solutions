package printinorder

import java.util.Collections
import kotlin.concurrent.thread
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class PrintInOrderTest {
    private fun run(): List<String> {
        val foo = Foo()
        val output = Collections.synchronizedList(mutableListOf<String>())
        val third = thread { foo.third { output.add("third") } }
        val second = thread { foo.second { output.add("second") } }
        val first = thread { foo.first { output.add("first") } }
        for (t in listOf(first, second, third)) {
            t.join(5000)
        }
        assertFalse(listOf(first, second, third).any { it.isAlive }, "threads did not finish")
        return output.toList()
    }

    @Test
    fun reverseStartOrder() {
        assertEquals(listOf("first", "second", "third"), run())
    }

    @Test
    fun repeatedRuns() {
        repeat(20) {
            assertEquals(listOf("first", "second", "third"), run())
        }
    }
}
