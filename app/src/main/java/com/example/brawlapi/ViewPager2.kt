package com.example.brawlapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.brawlapi.databinding.FragmentViewPager2Binding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator


class ViewPager2 : Fragment() {

    private var _binding : FragmentViewPager2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentViewPager2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuramos el adaptador para el ViewPager2
        binding.vpNotice.adapter = NoticeAdapter(this)

        // Configuración de TabLayout
        TabLayoutMediator(binding.TabNotice, binding.vpNotice) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Comenzar"
                    tab.setIcon(R.drawable.ic_comenzar)
                }
                1 -> {

                    tab.text = "Creditos"
                    tab.setIcon(R.drawable.ic_creditos)
                    val badge: BadgeDrawable = tab.orCreateBadge
                    badge.backgroundColor = ContextCompat.getColor(requireContext(), R.color.red)
                    badge.number = 666
                    badge.maxCharacterCount = 3
                    badge.badgeGravity = BadgeDrawable.TOP_START
                }
                2 -> {
                    tab.text = "Perfil"
                    tab.setIcon(R.drawable.ic_user)  // Usa un ícono adecuado para el perfil
                }
            }
        }.attach()
    }

}

class NoticeAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3  // Ahora tenemos 3 fragmentos en lugar de 2

    override fun createFragment(position: Int): Fragment {
        // Usamos un condicional para elegir qué fragmento cargar
        return when (position) {
            0 -> Tab2Fragment()
            1 -> CreditFragment()  // Aquí mantenemos el Tab2Fragment (Comenzar)
            else -> UserInfoFragment()  // Aquí añadimos el UserInfoFragment
        }
    }
}
