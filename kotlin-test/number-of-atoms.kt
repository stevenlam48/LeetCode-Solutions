package numberofatoms

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfAtomsTest {
    @Test
    fun example1() {
        assertEquals("H2O", Solution().countOfAtoms("H2O"))
    }

    @Test
    fun example2() {
        assertEquals("H2MgO2", Solution().countOfAtoms("Mg(OH)2"))
    }

    @Test
    fun example3() {
        assertEquals("K4N2O14S4", Solution().countOfAtoms("K4(ON(SO3)2)2"))
    }

    @Test
    fun sortedOutput() {
        assertEquals("ClNa", Solution().countOfAtoms("NaCl"))
    }

    @Test
    fun multiDigitCount() {
        assertEquals("Be32", Solution().countOfAtoms("Be32"))
    }
}
