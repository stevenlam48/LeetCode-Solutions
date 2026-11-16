package buildingh2o

// Time:  O(n)
// Space: O(1)

class H2O {
    private var nH = 0
    private var nO = 0
    private var releaseHydrogenCallback: (() -> Unit)? = null
    private var releaseOxygenCallback: (() -> Unit)? = null

    @Synchronized
    fun hydrogen(releaseHydrogen: () -> Unit) {
        releaseHydrogenCallback = releaseHydrogen
        ++nH
        output()
    }

    @Synchronized
    fun oxygen(releaseOxygen: () -> Unit) {
        releaseOxygenCallback = releaseOxygen
        ++nO
        output()
    }

    private fun output() {
        while (nH >= 2 && nO >= 1) {
            nH -= 2
            nO -= 1
            releaseHydrogenCallback!!()
            releaseHydrogenCallback!!()
            releaseOxygenCallback!!()
        }
    }
}
