package com.dimiwinanda.dimitugasakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnMovieClickListener {

    var movies = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDummyMovieList()

        var movieAdapter = MovieAdapter(movies, this)
        rv_movie_list.layoutManager = LinearLayoutManager(this)
        rv_movie_list.adapter = movieAdapter
        movieAdapter.notifyDataSetChanged()

    }

    fun createDummyMovieList() {
        for (i in 1..25) {
            movies.add(Movie("Movie " + i, "Genre " + i, "Year " + i))
        }
    }

    override fun onMovieItemClicked(position: Int) {
        val intent = Intent(this, MovieDetail::class.java)
        intent.putExtra("name", movies[position].name)
        startActivity(intent)
    }
}