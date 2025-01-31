package com.example.brawlapi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.brawlapi.databinding.FragmentCreditBinding

class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recuperar el argumento manualmente
        val nombre = arguments?.getString("nombre")

        // Configurar el texto en el TextView
        binding.tvCreditos.text = getString(R.string.creditostitulo, nombre)

        // Configurar el botón para enviar un correo electrónico
        binding.btnContact.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("tuemail@example.com"))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email))
            }
            startActivity(Intent.createChooser(emailIntent, "Enviar correo..."))
        }
    }

}