package com.dothebestmayb.adapter.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dothebestmayb.adapter.model.TabType
import com.dothebestmayb.adapter.ui.FirstFragment
import com.dothebestmayb.adapter.ui.SecondFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = TabType.entries.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            TabType.First.position -> FirstFragment()
            TabType.MY_PAGE.position -> SecondFragment()
            else -> throw IllegalArgumentException()
        }
    }
}