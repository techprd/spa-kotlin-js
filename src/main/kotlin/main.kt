import com.techprd.material.Icons
import com.techprd.material.MaterialApp
import com.techprd.material.components.*
import com.techprd.material.components.data.Link
import com.techprd.material.components.layouts.Drawer
import com.techprd.material.router.*

fun main(args: Array<String>) {

    val routes = listOf(
            Route("home", HomePage(), "This is home page"),
            Route("test", TestPage(), "This is test page")
    )

    MaterialApp()
            .configRouter(RouteOption(RouteMode.HASH, "myapp"))
            .addRoutes(routes)
            .addAppBar(AppBar("Kotlin Material App",
                    listOf(
                            Link("HOME", "#/home/"),
                            Link("TEST", "#/test/")
                    )),
                    true)
            .addDrawer(Drawer("Kotlin Material App",
                    listOf(
                            Link("HOME", "#/home/", Icons.person),
                            Link("TEST", "#/test/", Icons.favorite)
                    )),
                    false)
            .start("home")
}
