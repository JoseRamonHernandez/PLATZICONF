package com.platzi.platziconf.view.adapter


import com.platzi.conf.model.Conference
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.platzi.platziconf.R
import  android.view.View
import android.widget.TextView
import com.platzi.conf.model.Speaker
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SpeakerAdapter(val scheduleListener: ScheduleListener): RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listConference = ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_speaker, parent, false
    ))
    override fun getItemCount() = listConference.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {


        val conference = listConference[position] as Speaker

        holder.tvConferenceName.text = conference.title
        holder.tvConferenceSpeaker.text = conference.speaker
        holder.tvConferenceTag.text = conference.tag

        val simpleDateformat = SimpleDateFormat("HH:mm")
        val simpleDateformatAMPM = SimpleDateFormat("a")

        val cal = Calendar.getInstance()
        cal.time = conference.datetime
        val hourFormat = simpleDateformat.format(conference.datetime)

        holder.tvConferenceHour.text = hourFormat
        holder.tvConferenceAMPM.text = simpleDateformatAMPM.format(conference.datetime).toUpperCase()

    }

    fun updateData(data:List<Conference>){
        listConference.clear()
        listConference.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceSpeaker)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheduleTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvConferenceAMPM = itemView.findViewById<TextView>(R.id.tvItemScheduleAMPM)
    }

}