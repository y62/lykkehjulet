package com.example.spintask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spintask.databinding.FragmentRulesBinding

class Rules : Fragment(R.layout.fragment_rules) {
    private var _binding : FragmentRulesBinding? = null
    private val binding get () = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRulesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding

    }
    // to prevent memory leaks
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}