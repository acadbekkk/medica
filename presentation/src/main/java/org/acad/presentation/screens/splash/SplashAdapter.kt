package org.acad.presentation.screens.splash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.acad.presentation.screens.splash.SplashAdapter.SplashViewHolder

/**
 * Created by Acad Bek on 12/28/2024
 */
class SplashAdapter(
    private val layouts: List<Int>,
) : RecyclerView.Adapter<SplashViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SplashViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(viewType, parent, false)
        return SplashViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int = layouts[position]

    override fun getItemCount(): Int = layouts.size

    override fun onBindViewHolder(holder: SplashViewHolder, position: Int) {}

    class SplashViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
