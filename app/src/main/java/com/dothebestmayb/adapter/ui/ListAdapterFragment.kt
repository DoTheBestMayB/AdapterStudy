package com.dothebestmayb.adapter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dothebestmayb.adapter.R
import com.dothebestmayb.adapter.adapter.MyListAdapter
import com.dothebestmayb.adapter.databinding.FragmentListAdapterBinding
import com.dothebestmayb.adapter.model.SimpleData

class ListAdapterFragment : Fragment() {

    private var _binding: FragmentListAdapterBinding? = null
    private val binding: FragmentListAdapterBinding
        get() = _binding!!

    private val listAdapter = MyListAdapter()
    private val simpleData = List(100) { SimpleData(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listAdapter.submitList(simpleData)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListAdapterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setListener()
    }

    private fun setAdapter() {
        binding.rv.adapter = listAdapter
    }

    private fun setListener() {
        binding.btnStartOtherFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, SecondFragment())
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit()
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}