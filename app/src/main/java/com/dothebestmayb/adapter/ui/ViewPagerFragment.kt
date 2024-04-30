package com.dothebestmayb.adapter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dothebestmayb.adapter.R
import com.dothebestmayb.adapter.adapter.ViewPagerAdapter
import com.dothebestmayb.adapter.databinding.FragmentViewPagerBinding
import com.dothebestmayb.adapter.model.TabType
import com.google.android.material.tabs.TabLayoutMediator


class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding: FragmentViewPagerBinding
        get() = _binding!!

    private var adapter: ViewPagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()
        setTabLayout()
    }

    private fun setViewPager() = with(binding) {
        if (adapter == null) {
            adapter = ViewPagerAdapter(this@ViewPagerFragment)
        }
        vp.adapter = adapter
    }

    private fun setTabLayout() = with(binding) {
        TabLayoutMediator(tabLayout, vp) { tab, position ->
            val tabType = TabType.from(position)
            tab.text = getString(tabType.tabName)
        }.attach()
    }

    override fun onDestroyView() {
        // 이 코드를 호출하지 않으면 FragmentStateAdapter의 onDetachedFromRecyclerView가 호출되지 않음
//        binding.vp.adapter = null
        _binding = null
        super.onDestroyView()
    }
}