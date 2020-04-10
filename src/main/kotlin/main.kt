import com.techprd.material.Icons
import com.techprd.material.MaterialApp
import com.techprd.material.components.*
import com.techprd.material.components.data.Link
import com.techprd.material.components.layouts.Drawer
import com.techprd.material.router.*
import pages.Badges
import pages.Cards

fun main(args: Array<String>) {
    console.log(KotlinVersion.CURRENT)

    val routes = listOf(
            Route("home", HomePage(), "This is home page"),
            Route("badges", Badges(), "passing some data"),
            Route("cards", Cards(), "passing some data"),
            Route("tabs", TestPage(), "This is test page")
    )

    MaterialApp()
            .configRouter(RouteOption(RouteMode.HASH, "myapp"))
            .addRoutes(routes)
            .addAppBar(AppBar("Kotlin Material App",
                    listOf(
                            Link("HOME", "#/home/")
                    )),
                    true)
            .addDrawer(Drawer("Kotlin Material App",
                    listOf(
                            Link("HOME", "#/home/", Icons.person),
                            Link("BADGES", "#/badges/", Icons.add_alert),
                            Link("CARDS", "#/cards/", Icons.card_giftcard),
                            Link("TABS", "#/tabs/", Icons.tab)
                    )),
                    false)
            .start("home")
}
