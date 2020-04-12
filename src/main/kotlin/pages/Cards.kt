package pages

import com.techprd.material.components.Card
import com.techprd.material.components.Page
import com.techprd.material.components.layouts.Grid
import org.w3c.dom.HTMLElement

class Cards : Page() {

    override fun build(): HTMLElement {

        val card1 = Card("Card 1 ", "Supporting Text", 2)
        val card2 = Card("Card 2 ", "Supporting Text", 2)

        val grid = Grid(4,
                arrayListOf(card1.build(), card2.build())
        )
        return grid.build()
    }
}
