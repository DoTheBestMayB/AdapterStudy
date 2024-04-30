package com.dothebestmayb.adapter.model

import androidx.annotation.StringRes
import com.dothebestmayb.adapter.R

enum class TabType(val position: Int, @StringRes val tabName: Int){
    First(0, R.string.first), MY_PAGE(1, R.string.second);

    companion object {
        fun from(position: Int) = entries.first { it.position == position }
    }
}