import com.techprd.material.Icons
import com.techprd.material.MaterialApp
import com.techprd.material.components.AppBar
import com.techprd.material.components.data.Link
import com.techprd.material.components.layouts.Drawer
import com.techprd.material.router.Route
import com.techprd.material.router.RouteMode
import com.techprd.material.router.RouteOption
import pages.Badges
import pages.Cards
import pages.HomePage

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
