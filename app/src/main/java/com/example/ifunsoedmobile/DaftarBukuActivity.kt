package com.example.ifunsoedmobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ifunsoedmobile.data.model.BookDoc
import com.unsoed.informatikamobile.ui.adapter.OnBookClickListener

class DaftarBukuActivity : AppCompatActivity(), OnBookClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_daftar_buku)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onBookClick(book: BookDoc) {
        book.let { b->
            BookDetailFragment(
                title = b.title ?: "-",
                author = b.authorName?.joinToString(", ") ?: "Unknown Author",
                year = "${b.firstPublishYear}",
                coverId = b.coverId ?: 0
            ).show(supportFragmentManager, BookDetailFragment::class.java.simpleName)
        }
    }
}