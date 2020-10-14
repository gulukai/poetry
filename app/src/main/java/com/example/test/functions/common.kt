package com.example.test.functions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.PoetryDetailsActivity
import com.example.test.PoetryListActivity
import com.example.test.adapter.MyRecyclerViewAdapter
import com.example.test.data.ItemData
import com.example.test.data.PoetryData
import com.example.weatherapp.adapter.MyLayoutManager
import kotlinx.android.synthetic.main.poetry_item_layout.view.*

fun getPoetry(
    view: RecyclerView,
    poetryList: ArrayList<PoetryData>,
    layout: Int,
    activity: Activity,
    context: Context
) {
    view.adapter =
        MyRecyclerViewAdapter.Builder().setDate(poetryList).setViewHolder { parent, _ ->
            return@setViewHolder MyRecyclerViewAdapter().ViewHolder(
                LayoutInflater.from(parent.context).inflate(layout, parent, false)
            )
        }.setBindViewHolder { holder, position ->
            holder.itemView.title_poetry_item.text = poetryList[position].title
            holder.itemView.dynasty_poetry_item.text = poetryList[position].dynasty
            holder.itemView.author_poetry_item.text = poetryList[position].author
            holder.itemView.setOnClickListener {
                val intent = Intent(activity, PoetryDetailsActivity::class.java)
                intent.putExtra("poetryId", poetryList[position].id)
                context.startActivity(intent)
            }
        }.create()
    view.layoutManager = MyLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
}

fun getItem(
    view: RecyclerView,
    itemList: ArrayList<ItemData>,
    layout: Int,
    activity: Activity,
    context: Context
) {
    view.adapter =
        MyRecyclerViewAdapter.Builder().setDate(itemList).setViewHolder { parent, _ ->
            return@setViewHolder MyRecyclerViewAdapter().ViewHolder(
                LayoutInflater.from(parent.context).inflate(layout, parent, false)
            )
        }.setBindViewHolder { holder, position ->
            holder.itemView.title_poetry_item.text = itemList[position].str
            holder.itemView.setOnClickListener {
                val intent = Intent(activity, PoetryListActivity::class.java)
                intent.putExtra("itemStr", itemList[position].str)
                context.startActivity(intent)
            }
        }.create()
    view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
}

fun goActivity(context: Context, cls: Class<*>) {
    val intent = Intent(context, cls)
    context.startActivity(intent)
}