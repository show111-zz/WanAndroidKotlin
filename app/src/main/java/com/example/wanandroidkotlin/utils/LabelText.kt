package com.example.wanandroidkotlin.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import com.example.wanandroidkotlin.R
import com.example.wanandroidkotlin.homes.model.Children
import kotlinx.android.synthetic.main.layout_text_view.view.*

/**
 *  Created by hannah on 2020-01-28
 */
class LabelText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_text_view, this)
    }

    fun setChild(child: Children) {
        text.text = child.name
        text.setOnClickListener { listener ->
            Toast.makeText(
                context,
                "${child.name} and ${child.id}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}
