package com.example.pawtner.ui;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pawtner.R;

import java.util.ArrayList;
import java.util.List;


public class NotificationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NotificationAdapter adapter;
    List<NotificationItem> notificationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notificationList = new ArrayList<>();
        notificationList.add(new NotificationItem(
                "Welcome to Pawtner!",
                "You're officially part of the cutest dating community for pets and their humans. Explore our features to connect with responsible pet lovers, discover matches, and create paw-some moments together with your furry friends!",
                "25/5/2025", "10:30", false));

        notificationList.add(new NotificationItem(
                "It’s a match! 🎉",
                "You and Maritza both swiped right on each other's pets! This could be the beginning of a beautiful friendship (or more) between your companions. Start a chat to get to know each other and plan your first paw-date!",
                "15/2/2025", "09:15", false));

        notificationList.add(new NotificationItem(
                "New Match Found 🐶",
                "Bruno just matched with Daisy! They seem to share similar energy and temperament. It's the perfect time to connect with Daisy's owner and see if their bond has real potential. Let the tail-wagging begin!",
                "26/5/2025", "11:00", false));

        notificationList.add(new NotificationItem(
                "Vaccination Reminder 💉",
                "Hey there, responsible pet parent! It's time to update Coco's vaccination record to keep her profile verified and ensure safe meetups. Keeping medical info current helps all pets stay happy and healthy.",
                "27/5/2025", "14:20", false));

        notificationList.add(new NotificationItem(
                "Event Reminder 🎉",
                "The Cat Café Meet-Up is happening this afternoon! Don’t miss the chance to socialize with other feline fans, share care tips, and let your cats make new friends in a cozy and safe environment.",
                "28/5/2025", "08:00", false));

        notificationList.add(new NotificationItem(
                "Playdate Confirmed 🐾",
                "You have a confirmed playdate with Milo today at 4 PM at Green Paw Park. Bring your pet’s favorite toys, some treats, and let the fun begin. Don’t forget to capture the moments and share it in our community!",
                "28/5/2025", "09:45", false));

        notificationList.add(new NotificationItem(
                "Profile Viewed 👀",
                "Good news! Someone just viewed your pet’s profile. This could lead to a potential match. Consider updating photos or adding more personality details to attract the right Pawtner!",
                "29/5/2025", "12:10", false));

//
//        notificationList.add(new NotificationItem(
//                "Safety Tips ✅",
//                "Make sure to always meet new pet friends in a public space, carry vaccination proof, and supervise all interactions for a smooth experience.",
//                "30/5/2025", "07:30", false));
//
//        notificationList.add(new NotificationItem(
//                "Weekly Match Digest 💌",
//                "You've had 3 profile visits, 2 matches, and 1 message this week. Keep engaging to boost your chances of finding a great match!",
//                "30/5/2025", "19:45", false));
//
//        notificationList.add(new NotificationItem(
//                "New Pawtner Tip 🐕",
//                "Did you know? Including fun facts and photos in your pet's profile increases match rates by 65%! Try updating yours today.",
//                "31/5/2025", "15:10", false));

        adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);
    }
}

