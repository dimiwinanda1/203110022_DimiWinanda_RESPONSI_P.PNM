//File MovieDetail ini berfungsi untuk mengimplementasikan tampilan detail untuk item media saat dipilih oleh pengguna
//class ini juga berfungsi untuk menampilkan informasi tambahan tentang item media, seperti deskripsi atau ulasan, dan untuk mengambil 
//tindakan pada item tersebut.


package com.dimiwinanda.dimitugasakhir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_list_item.*

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val name =  intent.getStringExtra("name")
        tv_name.text = name
    }
}
