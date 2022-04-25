package com.muchori.joseph.distancetracker.ui.permission


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.muchori.joseph.distancetracker.R
import com.muchori.joseph.distancetracker.databinding.FragmentPermissionBinding
import com.muchori.joseph.distancetracker.util.Permissions.hasLocationPermission
import com.muchori.joseph.distancetracker.util.Permissions.requestLocationPermission
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog


class PermissionFragment : Fragment(), EasyPermissions.PermissionCallbacks {
  
  private var _binding: FragmentPermissionBinding? = null
  private val binding get() =  _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentPermissionBinding.inflate(inflater, container, false)
    
    binding.continueButton.setOnClickListener { 
      if (hasLocationPermission(requireContext())) {
        findNavController().navigate(R.id.action_permissionFragment_to_mapsFragment)
      } else {
        requestLocationPermission(this)
      }
    }
    
    return binding.root
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
  }

  override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
    if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
      SettingsDialog.Builder(requireActivity()).build().show()
    } else {
      requestLocationPermission(this)
    }
  }

  override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
    findNavController().navigate(R.id.action_permissionFragment_to_mapsFragment)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

}