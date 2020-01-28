package com.example.wanandroidkotlin.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.wanandroidkotlin.R
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

    fun setName(name: String){
        text.text = name
    }
}
