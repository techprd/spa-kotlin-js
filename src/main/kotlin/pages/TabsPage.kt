import com.techprd.material.components.Page
import com.techprd.material.components.data.Tab
import com.techprd.material.components.layouts.Grid
import com.techprd.material.components.layouts.Tabs
import kotlinx.html.button
import kotlinx.html.classes
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.js.onClickFunction
import kotlinx.html.p
import org.w3c.dom.HTMLElement
import kotlin.browser.document
import kotlin.browser.window

class TabsPage : Page() {
    override fun build(): HTMLElement {

        val content1 = Grid(4, arrayListOf(
            document.create.div {
                p {
                    +data[0].toString()
                }
                button {
                    classes = setOf(
                        "mdl-button", "mdl-js-button",
                        "mdl-button--raised", "mdl-js-ripple-effect"
                    )
                    +"go to home"
                    onClickFunction = {
                        window.location.hash = "/home/"
                    }
                }
            }
        )).build()

        val content2 = document.create.p { +" Tab Content 2" }
        val content3 = document.create.p { +" Tab Content 3" }

        val tabs = Tabs(
            listOf(
                Tab("Tab01", content1, true),
                Tab("Tab02", content2, false),
                Tab("Tab03", content3, false)
            )
        )

        return tabs.build()
    }

}
