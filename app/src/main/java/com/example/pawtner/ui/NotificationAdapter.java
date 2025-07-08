package com.example.pawtner.ui;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pawtner.R;
import com.example.pawtner.ui.NotificationItem;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView; // ← INI PENTING
import androidx.recyclerview.widget.RecyclerView;

import com.example.pawtner.R;
import java.util.List;
import com.example.pawtner.ui.NotificationDetailActivity;



public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<NotificationItem> notificationList;

    public NotificationAdapter(List<NotificationItem> notificationList) {
        this.notificationList = notificationList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, message, date, time;
        CardView cardView;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.notification_title);
            message = view.findViewById(R.id.notification_message);
            date = view.findViewById(R.id.notification_date);
            time = view.findViewById(R.id.notification_time);
            cardView = view.findViewById(R.id.card_notification);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NotificationItem notif = notificationList.get(position);
        holder.title.setText(notif.getTitle());
        holder.message.setText(notif.getMessage());
        holder.date.setText(notif.getDate());
        holder.time.setText(notif.getTime());

        // Ganti warna background berdasarkan status
        int backgroundColor = notif.isRead() ? Color.parseColor("#FFF9ED") : Color.parseColor("#EEF3FE");
        holder.cardView.setCardBackgroundColor(backgroundColor);

        // Aksi klik ke detail
        holder.cardView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, NotificationDetailActivity.class);
            intent.putExtra("title", notif.getTitle());
            intent.putExtra("message", notif.getMessage());
            intent.putExtra("date", notif.getDate());
            intent.putExtra("time", notif.getTime());

            context.startActivity(intent);

            notif.setRead(true); // Tandai sebagai sudah dibaca
            notifyItemChanged(position); // refresh item ini saja
        });
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }
}


