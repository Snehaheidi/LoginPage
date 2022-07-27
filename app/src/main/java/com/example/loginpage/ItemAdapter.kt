package com.example.loginpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//Adapter Class
class ItemAdapter(private var tourList:ArrayList<Tour>) : RecyclerView.Adapter<ItemAdapter.TourViewHolder>()
{
    var onItemClick :((Tour)->Unit)?=null

   //ViewHolder Class
   class TourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val cardView : CardView = itemView.findViewById(R.id.cardView)
       val imageView : ImageView = itemView.findViewById(R.id.imageview)
       val imageText : TextView = itemView.findViewById(R.id.imageText)
   }

   //Override the Adapter methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
       // Inflater --> create a new view ,  which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return TourViewHolder(view)
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val tour = tourList[position]
        holder.imageView.setImageResource(tour.image)
        holder.imageText.text = tour.name

        //animation --> each item store in cardView so anim res file will be called
        holder.cardView.animation = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.animone)

        //Detail each item when click the image
        holder.itemView.setOnClickListener {
           onItemClick?.invoke(tour)
        }
    }

    override fun getItemCount(): Int {
        return tourList.size
    }
   // val detail = tourList[position]

    fun updateList(tourlist1 : ArrayList<Tour>) {
        tourList = ArrayList()
        tourList.addAll(tourlist1)
    }
}