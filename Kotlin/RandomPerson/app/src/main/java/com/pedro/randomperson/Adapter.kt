package com.pedro.randomperson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class Adapter (val candidatos:List<Person>):RecyclerView.Adapter<Adapter.PersonHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder
    {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonHolder(layoutInflater.inflate(R.layout.item_recyclerview, parent, false))
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int)
    {
        holder.render(candidatos[position])
    }

    override fun getItemCount(): Int
    {
        return candidatos.size
    }

    class PersonHolder(val view: View):RecyclerView.ViewHolder(view)
    {
        fun render(person:Person)
        {
            view.recordText.text =  person.name
        }
    }
}