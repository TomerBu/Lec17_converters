package edu.tomerbu.lec17.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.tomerbu.lec17.R
import edu.tomerbu.lec17.databinding.FragmentHomeBinding
import edu.tomerbu.lec17.ui.adapter.MoviesAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.movies.observe(viewLifecycleOwner) {
            with(binding.recyclerMovies) {
                layoutManager = LinearLayoutManager(context)
                adapter = MoviesAdapter(it) { movie ->
//                    val args = Bundle()
//                    args.putParcelable("movie", movie)

                    findNavController().navigate(
                        R.id.action_navigation_home_to_movie_details,
                        Bundle().apply { putParcelable("movie", movie) }
                    )
                }
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}