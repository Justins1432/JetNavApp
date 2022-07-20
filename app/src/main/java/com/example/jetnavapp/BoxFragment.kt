package com.example.jetnavapp

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jetnavapp.databinding.FragmentBoxBinding

import kotlin.random.Random

class BoxFragment : Fragment(R.layout.fragment_box) {
    private lateinit var binding: FragmentBoxBinding

    private val args: BoxFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)
        val color = args.color
        binding.root.setBackgroundColor(color)

        binding.goBackBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.openSecretBtn.setOnClickListener {
            findNavController().navigate(BoxFragmentDirections.actionBoxFragmentToSecretFragment())
        }

        binding.generateBtn.setOnClickListener {
            val number = Random.nextInt(100)
            /*parentFragmentManager.setFragmentResult(RANDOM_CODE,
                bundleOf(EXTRA_RANDOM_NUMBER to number))*/
            findNavController().previousBackStackEntry?.savedStateHandle?.set(EXTRA_RANDOM_NUMBER, number)
            findNavController().popBackStack()
        }

    }

    companion object {
        //получаем результат
        //const val RANDOM_CODE = "random_code"
        //значение сгенерированного числа
        const val EXTRA_RANDOM_NUMBER = "extra_random_number"
    }

}