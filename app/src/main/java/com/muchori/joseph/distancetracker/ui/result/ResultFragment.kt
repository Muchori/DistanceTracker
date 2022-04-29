package com.muchori.joseph.distancetracker.ui.result

import android.content.Intent
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
    _binding = FragmentResultBinding.inflate(inflater, container, false)

    binding.distanceValueTextView.text = getString(R.string.result, args.result.distance)
    binding.timeValueTextView.text = args.result.distance

    binding.shareButton.setOnClickListener {
      shareResult()
    }

    return binding.root
  }

  private fun shareResult() {
    val shareResult = Intent().apply {
      action = Intent.ACTION_SEND
      type = "text/plain"
      putExtra(Intent.EXTRA_TEXT, "I went ${args.result.distance}km in ${args.result.time}")
    }
    startActivity(shareResult)

  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}