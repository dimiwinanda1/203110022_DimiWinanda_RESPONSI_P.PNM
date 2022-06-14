//File MovieDetail ini berfungsi untuk mengimplementasikan tampilan detail untuk item media saat dipilih oleh pengguna
//class ini juga berfungsi untuk menampilkan informasi tambahan tentang item media, seperti deskripsi atau ulasan, dan untuk mengambil 
//tindakan pada item tersebut.

//untuk mendeklarasikan package com.dimiwinanda.dimitugasakhir kita dapat menggunakan kata kunci package.
package com.dimiwinanda.dimitugasakhir

//kita dapat menggunakan deklarasi import untuk mengaktifkan compiler untuk menemukan class, function, interface atau object yang akan diimpor.
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.layout_list_item.*

//Dalam metode onCreate(), kita dapat menjalankan logika startup aplikasi dasar yang hanya boleh terjadi sekali selama siklus aktivitas. 
//Metode ini menerima parameter savedInstanceState, yang merupakan objek Bundle yang berisi status aktivitas yang sebelumnya disimpan. 
//Jika aktivitas belum pernah ada sebelumnya, nilai objek Bundle adalah nol. 
class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        //Intent adalah sebuah jembatan yang menghubungkan interaksi antar Activity di aplikasi Android. 
        //dan terdapat method getStringExtra() yang berfungsi untuk mengambil nilai. 
        val name =  intent.getStringExtra("name")
        tv_name.text = name
    }
}
