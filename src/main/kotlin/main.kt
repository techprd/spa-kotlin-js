import com.techprd.material.Icons
import com.techprd.material.MaterialApp
import com.techprd.material.components.*
import com.techprd.material.components.data.Link
import com.techprd.material.components.layouts.Drawer
import com.techprd.material.router.*
import pages.*

fun main() {
    console.log(KotlinVersion.CURRENT)

    val routes = listOf(
        Route("home", HomePage(), "This is home page"),
        Route("badges", Badges(), "passing some data"),
        Route("buttons", ButtonsPage(), "This is buttons page"),
        Route("cards", Cards(), "passing some data"),
        Route("chips", ChipsPage(), "passing some data"),
        Route("dialogs", DialogPage(), "passing some data"),
        Route(
            "tabs", TabsPage(), "This content is passed in via Route data " +
                    "to page data which can be used anywhere in the page"
        )
    )

    MaterialApp()
        .configRouter(RouteOption(RouteMode.HASH, "myapp"))
        .addRoutes(routes)
        .addAppBar(
            AppBar(
                "Kotlin Material App",
                listOf(
                    Link("HOME", "#/home/")
                )
            ),
            true
        )
        .addDrawer(
            Drawer(
                "Kotlin Material App",
                listOf(
                    Link("Home", "#/home/", Icons.person),
                    Link("Buttons", "#/buttons/", Icons.radio_button_checked),
                    Link("Badges", "#/badges/", Icons.add_alert),
                    Link("Cards", "#/cards/", Icons.card_giftcard),
                    Link("Chips", "#/chips/", Icons.contacts),
                    Link("Dialogs", "#/dialogs/", Icons.desktop_windows),
                    Link("Tabs", "#/tabs/", Icons.tab)
                )
            ),
            true
        )
        .start("home")
}
