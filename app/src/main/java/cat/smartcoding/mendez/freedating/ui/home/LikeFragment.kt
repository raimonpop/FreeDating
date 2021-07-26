package cat.smartcoding.mendez.freedating.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cat.smartcoding.mendez.freedating.R
import cat.smartcoding.mendez.freedating.databinding.FragmentHomeBinding
import cat.smartcoding.mendez.freedating.databinding.LikeFragmentBinding

class LikeFragment : Fragment() {

    private lateinit var viewModel: LikeViewModel
    private var _binding: LikeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(LikeViewModel::class.java)
        _binding = LikeFragmentBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.like_fragment, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}