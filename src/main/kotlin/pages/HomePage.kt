package pages

import com.techprd.material.components.*
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import org.w3c.dom.HTMLElement
import kotlin.browser.document

class HomePage : Page() {

    override fun build(): HTMLElement {
        return document.create.div {
            style = "margin:50px"
            h3 {
                +"Home Page - under development"
            }
            +"More material component will be added soon."
            hr { }
            +"Visit: "
            a {
                href = "https://github.com/techprd/spa-kotlin-js"
                +"https://github.com/techprd/spa-kotlin-js"
            }
            br { }
            +"Components are developed under separate package"
            br { }
            +"Visit: "
            a {
                href = "https://github.com/techprd/kotlin-material"
                +"https://github.com/techprd/kotlin-material"
            }
        }
    }
}
