package com.example.brawlapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.brawlapi.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Acción cuando se presiona el botón
        binding.btn.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            if (nombre.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Error: Se necesita información en el EditText",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Crear el bundle y pasar el nombre
                val bundle = Bundle().apply {
                    putString("nombre", nombre)
                }

                // Navegar al MenuFragment con el bundle
                findNavController().navigate(R.id.action_loginFragment_to_viewPager2, bundle)
            }
        }
    }
}