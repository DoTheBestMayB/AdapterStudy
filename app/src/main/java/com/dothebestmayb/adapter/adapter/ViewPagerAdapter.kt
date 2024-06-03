package com.dothebestmayb.adapter.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dothebestmayb.adapter.model.TabType
import com.dothebestmayb.adapter.ui.FirstFragment
import com.dothebestmayb.adapter.ui.SecondFragment

class ViewPagerAdapter(m: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(m, lifecycle) {
//class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = TabType.entries.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            TabType.First.position -> FirstFragment()
            TabType.MY_PAGE.position -> SecondFragment()
            else -> throw IllegalArgumentException()
        }
    }

    val TAG = MyListAdapter::class.java.simpleName
    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)

        Log.i(TAG, "onDetachedFromRecyclerView is called")
    }
}