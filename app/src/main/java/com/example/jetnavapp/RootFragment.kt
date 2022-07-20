package com.example.jetnavapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.jetnavapp.databinding.FragmentRootBinding

class RootFragment : Fragment(R.layout.fragment_root) {
    private lateinit var binding: FragmentRootBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)

        binding.openBtnGreen.setOnClickListener {
            openBox(Color.rgb(200, 255, 200), "Green")
        }

        binding.openBtnYellow.setOnClickListener {
            openBox(Color.rgb(255, 255, 200), "Yellow")
        }

        val liveData = findNavController().currentBackStackEntry?.savedStateHandle
            ?.getLiveData<Int>(BoxFragment.EXTRA_RANDOM_NUMBER)

        liveData?.observe(viewLifecycleOwner) { rNumber ->
            if (rNumber != null) {
                Toast.makeText(requireContext(), "Generate number: $rNumber", Toast.LENGTH_SHORT)
                    .show()
                liveData.value = null
            }

        }

        /*parentFragmentManager.setFragmentResultListener(
            BoxFragment.RANDOM_CODE,
            viewLifecycleOwner
        ) { _, data ->
            val number = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
            Toast.makeText(requireContext(), "Generate number: $number", Toast.LENGTH_SHORT).show()
        }*/
    }

    private fun openBox(color: Int, colorName: String) {
        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(color, colorName)

        findNavController().navigate(
            direction,
            navOptions {
                anim {

                }
            }
        )
    }

}