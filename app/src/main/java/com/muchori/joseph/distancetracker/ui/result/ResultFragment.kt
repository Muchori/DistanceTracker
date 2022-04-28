package com.muchori.joseph.distancetracker.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.muchori.joseph.distancetracker.R
import com.muchori.joseph.distancetracker.databinding.FragmentResultBinding

class ResultFragment : BottomSheetDialogFragment() {

  private var _binding: FragmentResultBinding? = null
  private val binding get() = _binding!!

  private val args by navArgs<ResultFragmentArgs>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // Inflate the layout for this fragment
    _binding = FragmentResultBinding.inflate(inflater, container, false)

    binding.distanceValueTextView.text = getString(R.string.result, args.result.distance)
    binding.timeValueTextView.text = args.result.distance

    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}