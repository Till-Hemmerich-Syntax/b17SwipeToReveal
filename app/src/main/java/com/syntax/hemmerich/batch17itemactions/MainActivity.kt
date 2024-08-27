package com.syntax.hemmerich.batch17itemactions

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.syntax.hemmerich.batch17itemactions.adapter.ItemAdapter
import com.syntax.hemmerich.batch17itemactions.data.model.ItemDataClass
import com.syntax.hemmerich.batch17itemactions.databinding.ActivityMainBinding
import java.util.Collections


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvItems.setHasFixedSize(true)
        var items = mutableListOf(
            ItemDataClass("position 01"),
            ItemDataClass("position 02"),
            ItemDataClass("position 03"),
            ItemDataClass("position 04"),
            ItemDataClass("position 05"),
            ItemDataClass("position 06"),
            ItemDataClass("position 07"),
            ItemDataClass("position 08"),
            ItemDataClass("position 09"),
            ItemDataClass("position 10"),
        )
        var myAdapter = ItemAdapter(items)

        binding.rvItems.adapter = myAdapter

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                source: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                Collections.swap(items,source.adapterPosition,target.adapterPosition)
                myAdapter.notifyItemMoved(source.adapterPosition,target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var pos = viewHolder.adapterPosition
                items.removeAt(pos)
                myAdapter.notifyItemRemoved(pos)
                if(direction == ItemTouchHelper.RIGHT){
                    Toast.makeText(this@MainActivity,"Rechts",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@MainActivity,"Links",Toast.LENGTH_LONG).show()
                }
            }

        })

        itemTouchHelper.attachToRecyclerView(binding.rvItems)

    }
}