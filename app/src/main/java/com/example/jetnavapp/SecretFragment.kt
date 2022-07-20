package com.example.jetnavapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jetnavapp.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {
    private lateinit var binding: FragmentSecretBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecretBinding.bind(view)

        binding.closeSecretBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.closeTheBox.setOnClickListener {
            findNavController().popBackStack(R.id.rootFragment, false)
        }

    }

}