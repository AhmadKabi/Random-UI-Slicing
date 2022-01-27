package com.kodingan.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.kodingan.randomuislicing.R

class IGStoryView(context: Context, val attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private var state: Int = 1

    init {

        setPadding(resources.getDimensionPixelSize(R.dimen.dp_5))

        getAttrs()
        buildImage()

        when (state) {
            0 -> {
                insertAddIcon()
            }
            1 -> {
                background = ContextCompat.getDrawable(context, R.drawable.bg_story_ring_on)
            }
            2 -> {
                background = ContextCompat.getDrawable(context, R.drawable.bg_story_ring_off)
            }
        }
    }

    private fun getAttrs() {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.IGStoryView,
            0,
            0
        ).apply {
            state = getInteger(R.styleable.IGStoryView_state, 0)
            recycle()
        }
    }

    private fun buildImage() {
        val imageView = CircleImageView(context)
        imageView.id = R.id.ig_story_image
        imageView.setImageResource(R.drawable.cat)
        val params = LayoutParams(
            resources.getDimension(R.dimen.h_story).toInt(),
            resources.getDimension(R.dimen.h_story).toInt()
        )
        imageView.layoutParams = params

        addView(imageView)

    }

    private fun insertAddIcon() {
        val imageView = AppCompatImageView(context)
        imageView.id = R.id.ig_story_icon_add
        imageView.setImageResource(R.drawable.ic_profile_add_no_margin)
        val params = LayoutParams(
            resources.getDimension(R.dimen.h_story_icon_add).toInt(),
            resources.getDimension(R.dimen.h_story_icon_add).toInt()
        )
        imageView.layoutParams = params

        addView(imageView)

        val set = ConstraintSet()
        set.clone(this)
        set.connect(imageView.id, RIGHT, PARENT_ID, RIGHT)
        set.connect(imageView.id, BOTTOM, PARENT_ID, BOTTOM)
        set.applyTo(this)

    }


}