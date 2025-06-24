package com.example.creatingtableusingroomdatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.creatingtableusingroomdatabase.databinding.ItemUserBinding

class UserAdapter (var lisener: UserclickLisener):ListAdapter<User,UserAdapter.UserViewholder>(compator) {



   class UserViewholder(var binding:ItemUserBinding):RecyclerView.ViewHolder(binding.root)

companion object{


    var compator= object : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.userid==newItem.userid
        }


    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewholder {
     return  UserViewholder(ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UserViewholder, position: Int) {
       getItem(position).let {
           var mainActivity:UserclickLisener=MainActivity()
           holder.binding.nametv.text=it.name
           holder.binding.agetv.text="${it.age}"
           holder.binding.mobiletv.text=it.mobile

holder.binding.editbtn.setOnClickListener{V ->
mainActivity.userUpdate(it)


}
holder.binding.deletbtn.setOnClickListener{V ->
    mainActivity.userDelete(it)

}

       }
    }
}