package ru.zettatech.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ru.zettatech.demo.category.Category
import ru.zettatech.demo.constant.Constant
import ru.zettatech.demo.databinding.ActivityMainBinding
import ru.zettatech.demo.db.DBHelper
import ru.zettatech.hrv.adapter.ChildAdapter
import ru.zettatech.hrv.adapter.ParentAdapter
import ru.zettatech.hrv.item.ChildItem
import ru.zettatech.hrv.item.ParentItem
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHrv.setOnClickListener {
            val intent = Intent(this, HorizontalActivity::class.java)
            startActivity(intent)
        }
    }
}