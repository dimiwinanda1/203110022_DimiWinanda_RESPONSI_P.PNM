//untuk mendeklarasikan package com.dimiwinanda.dimitugasakhir kita dapat menggunakan kata kunci package.
package com.dimiwinanda.dimitugasakhir

//kita dapat menggunakan deklarasi import untuk mengaktifkan compiler untuk menemukan class, function, interface atau object yang akan diimpor.
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_list_item.view.*

//kita perlu menerapkan Adapter dan ViewHolder, kedua class ini bekerja sama untuk menentukan cara data yang akan kita tampilkan. 
//ViewHolder merupakan wrapper di sekitar View yang berisi tata letak untuk setiap item dalam daftar. 
//sedangkan Adapter membuat objek ViewHolder seperlunya, serta menetapkan data untuk tampilan tersebut.
class MovieAdapter(private val movies : ArrayList<Movie>,private val onMovieClickListener: OnMovieClickListener) : RecyclerView.Adapter<MovieViewHolder>() {

    //onCreateViewHolder() berfungsi untuk memanggil method setiap kali kita perlu untuk membuat ViewHolder baru. 
    //Metode ini membuat serta menginisialisasi ViewHolder dan View-nya yang diatribusikan, 
    //tetapi tidak mengisi konten tampilan—ViewHolder belum terikat dengan data tertentu.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false))
    }

    //onBindViewHolder() berfungsi untuk memanggil metode ini untuk kemudian mengatribusikan ViewHolder dengan data. 
    //Metode ini mengambil data yang sesuai dan menggunakan data tersebut untuk mengisi tata letak pemegang tampilan. 
    //Misalnya, jika RecyclerView menampilkan daftar nama, metode tersebut mungkin menemukan nama yang sesuai di dalam daftar dan 
    //mengisi widget TextView pemegang tampilan.
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movies[position]

        holder.itemView.tv_name.text = movie.name
        holder.itemView.tv_genre.text = movie.genre
        holder.itemView.tv_year.text = movie.year

        holder.itemView.setOnClickListener {
            onMovieClickListener.onMovieItemClicked(position)
        }

    }

    //getItemCount(): RecyclerView berfungsi untuk memanggil metode ini untuk mendapatkan ukuran set data. 
    //RecyclerView menggunakan ukuran ini untuk menentukan bahwa tidak ada lagi item yang dapat ditampilkan.
    override fun getItemCount(): Int {
        return movies.size
    }

}
