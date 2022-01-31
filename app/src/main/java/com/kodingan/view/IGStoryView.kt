package com.kodingan.view

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.ConstraintSet.*
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.bumptech.glide.Glide
import com.kodingan.randomuislicing.R

class IGStoryView(context: Context, private val attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private var state: Int = stateNone
    private val defaultWidth = resources.getDimension(R.dimen.h_story).toInt()
    private val defaultHeight = resources.getDimension(R.dimen.h_story).toInt()
    private var layoutWidth = WRAP_CONTENT
    private var layoutHeight = WRAP_CONTENT

    init {

        setPadding(resources.getDimensionPixelSize(R.dimen.dp_5))

        getAttrs()
        buildImage()

        when (state) {
            stateNone -> {
                insertAddIcon()
            }
            stateUnread -> {
                background = ContextCompat.getDrawable(context, R.drawable.bg_story_ring_on)
            }
            stateRead -> {
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
            state = getInteger(R.styleable.IGStoryView_state, stateNone)
            layoutWidth = getLayoutDimension(R.styleable.IGStoryView_android_layout_height, 0)
            layoutHeight = getLayoutDimension(R.styleable.IGStoryView_android_layout_width, 0)

            recycle()
        }

    }

    private fun buildImage() {
        val imageView = AppCompatImageView(context)
        val params = LayoutParams(
            if (layoutWidth == WRAP_CONTENT) defaultWidth else MATCH_PARENT,
            if (layoutHeight == WRAP_CONTENT) defaultHeight else MATCH_PARENT
        )
        imageView.layoutParams = params

//        imageView.setImageResource(R.drawable.cat)
//        imageView.scaleType = ImageView.ScaleType.CENTER_CROP

        Glide.with(context)
            .load(R.drawable.cat)
            .circleCrop()
            .into(imageView)

        imageView.id = R.id.ig_story_image

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

    fun setState(state: Int) {
        if(this.state != state){
            if (this.state == stateNone) removeViewAt(1)

            this.state = state

            when (state) {
                stateNone -> {
                    insertAddIcon()
                    background = ContextCompat.getDrawable(context, R.drawable.bg_none)
                }
                stateUnread -> {
                    background = ContextCompat.getDrawable(context, R.drawable.bg_story_ring_on)
                }
                stateRead -> {
                    background = ContextCompat.getDrawable(context, R.drawable.bg_story_ring_off)
                }
            }
        }
    }

    companion object {
        const val stateNone = 0
        const val stateUnread = 1
        const val stateRead = 2

    }

}