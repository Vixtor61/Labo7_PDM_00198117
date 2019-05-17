package com.example.labo7_00198117.database.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.labo7_00198117.R
import com.example.labo7_00198117.database.entities.GithubRepo
import kotlinx.android.synthetic.main.repo_cardview.view.*

class ReposAdapter(var repos: List<GithubRepo>) : RecyclerView.Adapter<ReposAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repo_cardview,parent,false)
        return ViewHolder(view)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return repos.size


    }
    fun updateList(newRepos: List<GithubRepo>){
        this.repos  = newRepos
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ReposAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        holder.bind(repos[position])
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(repo: GithubRepo) = with(itemView){
            this.textView2.text = repo.name
        }
    }

}