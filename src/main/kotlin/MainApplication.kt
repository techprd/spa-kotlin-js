class MainApplication : ApplicationBase() {

    init {
        // init material app here
    }

    override val stateKeys = listOf("keys")

    override fun start(state: Map<String, Any>) {
        // init with given state
        println(state)
    }

    override fun dispose(): Map<String, Any> {
        // return saved state
        return mapOf()
    }
}
