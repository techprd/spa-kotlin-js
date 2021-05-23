package pages

import com.techprd.material.components.Page
import com.techprd.material.components.layouts.Grid
import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.HTMLElement
import kotlinx.browser.document

class Badges : Page() {

    override fun build(): HTMLElement {

        val badge1 = document.create.div {
            classes = setOf("material-icons mdl-badge mdl-badge--overlap")
            attributes["data-badge"] = "1"
            +"account_box"
        }
        val badge2 = document.create.span {
            classes = setOf("mdl-badge")
            attributes["data-badge"] = "♥"
            +"Inbox"
        }

        val grid = Grid(2,
                arrayListOf(badge1, badge2)
        )
        return grid.build()
    }
}

