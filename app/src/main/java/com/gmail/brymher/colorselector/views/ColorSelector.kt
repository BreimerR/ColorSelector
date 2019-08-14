package com.gmail.brymher.colorselector.views

import android.util.AttributeSet
import android.widget.LinearLayout
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import com.gmail.brymher.colorselector.activities.R
import kotlinx.android.synthetic.main.color_selector.view.*


class ColorSelector
@JvmOverloads
constructor(context: Context, attributeSet: AttributeSet? = null, defaultStyleAttr: Int = 0, defStyleRes: Int = 0) :
    LinearLayout(context, attributeSet, defaultStyleAttr, defStyleRes) {

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    val view = inflater.inflate(R.layout.color_selector, this)

    val colors = arrayListOf(Color.BLACK, Color.RED, Color.BLUE, Color.YELLOW)

    val cSize = colors.size

    val cColor get() = colors[cI]

    var cI: Int = 0

    init {

        orientation = HORIZONTAL

        setColor(cColor)
        nextColor.setOnClickListener {
            updateColor(1)
        }

        prevColor.setOnClickListener {
            updateColor(-1)
        }
    }


    fun updateColor(i: Int) {
        val nColor = cI + i

        cI = when {
            // return to start
            nColor >= cSize -> 0
            nColor < 0 -> cSize - 1
            else -> nColor
        }

        setColor(cColor)
    }

    fun setColor(color: Int) {
        selected_color.setBackgroundColor(color)
    }
}