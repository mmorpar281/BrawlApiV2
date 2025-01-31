package com.example.brawlapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.brawlapi.BrawlerProvider
import com.example.brawlapi.adapter.BrawlerAdapter
import com.example.brawlapi.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView
        val recyclerView = binding.recyclerBrawlers
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Pasar la lista de Brawlers al Adapter
        val adapter = BrawlerAdapter(BrawlerProvider.listaBrawlers) { brawler ->
            // Acción cuando se hace clic en un Brawler (puedes navegar a otro fragmento o mostrar detalles)
        }
        recyclerView.adapter = adapter
    }

}