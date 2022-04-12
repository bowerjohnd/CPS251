package edu.wccnet.jbower26.recycleviewintentsapp.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.wccnet.jbower26.recycleviewintentsapp.R
import edu.wccnet.jbower26.recycleviewintentsapp.SecondActivity

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return MainViewModel.titles.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = MainViewModel.titles[i]
        viewHolder.itemDetail.text = MainViewModel.details[i]
        viewHolder.itemImage.setImageResource(MainViewModel.images[i])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTitle: TextView
        var itemDetail: TextView
        var itemImage: ImageView

        init {

            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)
            itemImage = itemView.findViewById(R.id.itemImage)

            itemView.setOnClickListener {

                val i = Intent(context, SecondActivity::class.java)

                i.putExtra("title", itemTitle.text.toString())
                i.putExtra("detail", itemDetail.text.toString())
                i.putExtra("image", 6)   // Hard coded for demonstration
                //i.putExtra("image", itemImage.id) // Can't figure out how to get image Int

                context.startActivity(i)
            }
        }
    }
}