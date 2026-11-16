package buildingh2o

import java.time.Duration
import kotlin.concurrent.thread
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTimeoutPreemptively
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BuildingH2oTest {
    @Test
    fun oxygenArrivingFirstWaitsForTwoHydrogen() {
        val h2o = H2O()
        val output = StringBuilder()
        h2o.oxygen { output.append('O') }
        h2o.hydrogen { output.append('H') }
        assertEquals("", output.toString())
        h2o.hydrogen { output.append('H') }
        assertEquals("HHO", output.toString())
    }

    @Test
    fun extraAtomsRemainBuffered() {
        val h2o = H2O()
        val output = StringBuilder()
        "OHHHOH".forEach { atom ->
            if (atom == 'H') h2o.hydrogen { output.append('H') } else h2o.oxygen { output.append('O') }
        }
        assertEquals("HHOHHO", output.toString())
    }

    @Test
    fun concurrentAtomsFormCompleteWaterMolecules() {
        assertTimeoutPreemptively(Duration.ofSeconds(5)) {
            val h2o = H2O()
            val output = StringBuilder()
            val threads = (0 until 12).map { i ->
                thread {
                    if (i < 4) h2o.oxygen { output.append('O') } else h2o.hydrogen { output.append('H') }
                }
            }
            threads.forEach { it.join() }
            assertEquals(12, output.length)
            output.chunked(3).forEach { molecule ->
                assertEquals(3, molecule.length)
                assertEquals(1, molecule.count { it == 'O' })
                assertTrue(molecule.all { it == 'H' || it == 'O' })
            }
        }
    }
}
