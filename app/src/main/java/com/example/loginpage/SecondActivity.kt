package com.example.loginpage

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.Menu
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity()
{
    private lateinit var recyclerView : RecyclerView
    private lateinit var tourList : ArrayList<Tour>
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var tool_bar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val heading = findViewById<TextView>(R.id.headline)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val result = " Welcome $message "  //change heading text
        heading.text = result
       recyclerView.startLayoutAnimation()
        val back = findViewById<ImageView>(R.id.back_arrow1)
        back.setOnClickListener {
            Toast.makeText(this, "back ..", Toast.LENGTH_SHORT).show()
            //setContentView(R.layout.activity_main)
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val search = findViewById<ImageView>(R.id.search)
        search.setOnClickListener {
            Toast.makeText(this,"search..",Toast.LENGTH_SHORT).show()
        }
        init()
//        search()
    }

//    private fun search(){
//        tool_bar = findViewById(R.id.search)
//        setSupportActionBar(tool_bar)
//    }
//
//    private fun setSupportActionBar(toolBar: Toolbar?) {
//
//    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.tool_bar,menu)
//        val item = menu?.findItem(R.id.search)
//        val searchView = item ?.actionView as SearchView
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                return true
//            }
//        })
//        return true
//    }
    private fun init()
    {
        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true) //fixed size width & height --> recyclerviewItems
        //LayoutManger --> give the layout in items.
        recyclerView.layoutManager = GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false)
        tourList = ArrayList()
        addToList()
        //Go to the ItemAdapter Class
        itemAdapter = ItemAdapter(tourList)
        recyclerView.adapter = itemAdapter
        //Image click --> go to another activity
        itemAdapter.onItemClick = {
            Toast.makeText(this,"Item Clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("tour", it)
            startActivity(intent)
        }
    }

    private fun addToList()
    {
        tourList.add(Tour(R.drawable.eagle,"Jatayu Earth Center"))
        tourList.add(Tour(R.drawable.goa,"goa"))
        tourList.add(Tour(R.drawable.kerala,"Azhapula"))
        tourList.add(Tour(R.drawable.shimla,"shimla"))
        tourList.add(Tour(R.drawable.manali,"manali"))
        tourList.add(Tour(R.drawable.photo2,"IndiaGate"))
        tourList.add(Tour(R.drawable.mahal,"Taj mahal"))
        tourList.add(Tour(R.drawable.yercaudtour,"yercaud"))
        tourList.add(Tour(R.drawable.hawamahal,"hawa mahal"))
        tourList.add(Tour(R.drawable.lotustemple,"Louts temple"))
        tourList.add(Tour(R.drawable.kerala,"Azhapula"))
        tourList.add(Tour(R.drawable.shimla,"shimla"))
        tourList.add(Tour(R.drawable.manali,"manali"))
        tourList.add(Tour(R.drawable.photo2,"IndiaGate"))
        tourList.add(Tour(R.drawable.mahal,"Taj mahal"))
        tourList.add(Tour(R.drawable.yercaudtour,"yercaud"))
        tourList.add(Tour(R.drawable.yercaudtour,"yercaud"))
        tourList.add(Tour(R.drawable.hawamahal,"hawa mahal"))
        tourList.add(Tour(R.drawable.lotustemple,"Louts temple"))
        tourList.add(Tour(R.drawable.kerala,"Azhapula"))
        tourList.add(Tour(R.drawable.shimla,"shimla"))
        tourList.add(Tour(R.drawable.manali,"manali"))
        tourList.add(Tour(R.drawable.photo2,"IndiaGate"))
        tourList.add(Tour(R.drawable.mahal,"Taj mahal"))
        tourList.add(Tour(R.drawable.yercaudtour,"yercaud"))
    }
//    private fun search()
//    {
//        searchView = findViewById(R.id.searchView)
//        searchView.clearFocus() // cursor clear --> when click cursor is visible
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                if(tourList.contains(query))
//                {
//                    .filter.filter(query)
//                }
//                else
//                {
//                    Toast.makeText(this,"No Item Found",Toast.LENGTH_SHORT).show()
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                .filter.filter(newText)
//                 return true
//            }
//        })
}

