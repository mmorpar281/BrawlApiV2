package com.example.brawlapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.brawlapi.databinding.FragmentUserInfoBinding

// Suponiendo que tienes un modelo User para representar al usuario
data class User(
    val name: String,
    val email: String,
    val bio: String,
    val profilePictureUrl: String // URL de la foto de perfil
)

class UserInfoFragment : Fragment(R.layout.fragment_user_info) {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout con ViewBinding
        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aquí debes obtener la información del usuario (puede venir de una base de datos o desde un API)
        val user = User(
            name = "Juan Pérez",
            email = "juan.perez@ejemplo.com",
            bio = "Soy un desarrollador apasionado por el software y los videojuegos.",
            profilePictureUrl = "https://example.com/profile_picture.jpg"
        )

        // Mostrar la información del usuario en la UI
        binding.tvUserName.text = user.name
        binding.tvUserEmail.text = user.email
        binding.tvUserBio.text = user.bio

        // Usar Glide para cargar la imagen de perfil desde una URL
        Glide.with(requireContext())
            .load(user.profilePictureUrl)
            .placeholder(R.drawable.ic_user) // Imagen por defecto mientras carga
            .into(binding.ivUserProfile)
    }
}
