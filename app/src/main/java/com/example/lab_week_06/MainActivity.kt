package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatItemClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Instantiate ItemTouchHelper for the swipe to delete callback and attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                // Item tambahan 1
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Luna",
                    "Playful explorer",
                    "https://cdn2.thecatapi.com/images/1if.jpg"
                ),
                // Item tambahan 2
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Max",
                    "Lazy lounger",
                    "https://cdn2.thecatapi.com/images/3do.jpg"
                ),
                // Item tambahan 3
                CatModel(
                    Gender.Unknown,
                    CatBreed.BalineseJavanese,
                    "Bella",
                    "Mysterious wanderer",
                    "https://cdn2.thecatapi.com/images/5iY.jpg"
                ),
                // Item tambahan 4
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Oliver",
                    "Adventurous hunter",
                    "https://cdn2.thecatapi.com/images/a3h.jpg"
                ),
                // Item tambahan 5
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Sophie",
                    "Affectionate companion",
                    "https://cdn2.thecatapi.com/images/ai6.jpg"
                ),
                // Item tambahan 6
                CatModel(
                    Gender.Unknown,
                    CatBreed.BalineseJavanese,
                    "Charlie",
                    "Curious observer",
                    "https://cdn2.thecatapi.com/images/eh5.jpg"
                ),
                // Item tambahan 7
                CatModel(
                    Gender.Female,
                    CatBreed.AmericanCurl,
                    "Mia",
                    "Gentle soul",
                    "https://cdn2.thecatapi.com/images/RIyBElNT7.jpg"
                )
            )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}