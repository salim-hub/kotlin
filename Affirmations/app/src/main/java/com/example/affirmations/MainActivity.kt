package com.example.affirmations

import ItemAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize data.
        val myDataset = Datasource().loadAffirmations()

        // Create a variable called recyclerView and use findViewById()to find a reference to the RecyclerView within the layout.
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // To tell the recyclerView to use the ItemAdapter class you created, create a new ItemAdapter instance.
        // ItemAdapter expects two parameters: the context (this) of this activity, and the affirmations in myDataset.
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}