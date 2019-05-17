package com.example.labo7_00198117

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labo7_00198117.database.adapter.ReposAdapter
import com.example.labo7_00198117.database.entities.GithubRepo
import com.example.labo7_00198117.database.viewmodels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ReposAdapter
    lateinit var viewModel: GithubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//dfd
    }

    fun bind(){
        adapter = ReposAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        rv_hola.apply {
            adapter=this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        viewModel.getAll().observe(this, Observer { adapter.updateList(it) })
        button.setOnClickListener{
            viewModel.insert(GithubRepo(Name.text.toString()))
        }
    }

}
