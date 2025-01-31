package com.example.brawlapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.brawlapi.databinding.FragmentTab2Binding

class Tab2Fragment : Fragment(R.layout.fragment_tab2) {
    private var _binding: FragmentTab2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Usamos el binding para inflar el layout
        _binding = FragmentTab2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el botón "Comenzar" con ViewBinding
        binding.buttonComenzar.setOnClickListener {
            findNavController().navigate(R.id.action_viewPager2_to_menuFragment)
        }
    }
}