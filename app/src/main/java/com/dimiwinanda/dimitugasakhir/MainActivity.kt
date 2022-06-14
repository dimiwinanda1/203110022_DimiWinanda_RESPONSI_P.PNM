//untuk mendeklarasikan package com.dimiwinanda.dimitugasakhir kita dapat menggunakan kata kunci package.
package com.dimiwinanda.dimitugasakhir

//kita dapat menggunakan deklarasi import untuk mengaktifkan compiler untuk menemukan class, function, interface atau object yang akan diimpor.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

//Class MainActivity merupakan turunan dari Class AppCompatActivity dan mengimplementasikan Interface View.
class MainActivity : AppCompatActivity(), OnMovieClickListener {
    
    //var untuk mendeklarasikan variabel movies. Dimana dalam variabel movies ini terdapat array list.
    var movies = ArrayList<Movie>()

    //onCreate() adalah kondisi awal saat Activity baru diciptakan, disini dilakukan inisialisasi.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDummyMovieList()

        //pada script dibawah ini kita terapkan adapternya dimana kita menambahkan adapter ini 
        //melalui manajernya dalam bentuk linearlayoutmanager. 
        var movieAdapter = MovieAdapter(movies, this)
        rv_movie_list.layoutManager = LinearLayoutManager(this)
        rv_movie_list.adapter = movieAdapter
        movieAdapter.notifyDataSetChanged()

    }

    fun createDummyMovieList() {
        for (i in 1..25) {
            //pada bagian ini kita akan mengisi data yang disesuaikan
            movies.add(Movie("Movie " + i, "Genre " + i, "Year " + i))
        }
    }

    //Kita gunakan modifier override untuk menandai method dan properti yang ingin dibuat ulang yang bersumber pada Parent Class 
    //dari Child class yang berasal dari sebuah interface atau superclass
    override fun onMovieItemClicked(position: Int) {
        val intent = Intent(this, MovieDetail::class.java)
        intent.putExtra("name", movies[position].name)
        startActivity(intent)
    }
}
