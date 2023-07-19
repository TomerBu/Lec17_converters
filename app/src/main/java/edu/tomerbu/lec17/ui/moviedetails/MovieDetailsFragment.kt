package edu.tomerbu.lec17.ui.moviedetails

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import edu.tomerbu.lec17.R
import edu.tomerbu.lec17.data.entity.Movie
import edu.tomerbu.lec17.databinding.FragmentMovieDetailsBinding
import java.time.LocalDate

class MovieDetailsFragment : Fragment() {

    private lateinit var viewModel: MovieDetailsViewModel
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding: FragmentMovieDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable("movie", Movie::class.java)
        } else {
            arguments?.getParcelable("movie") as Movie?
        }

        println(movie)
        //binding.textview.text = movie.title
        //binding.textview.text = movie.title
        //binding.textview.text = movie.title
        //binding.textview.text = movie.title
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
