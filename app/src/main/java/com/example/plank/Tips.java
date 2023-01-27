package com.example.plank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Tips extends AppCompatActivity {

    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);



        List<Item> items = new ArrayList<Item>();
        items.add(new Item(R.drawable.a, "Uscf health" , "Be physically active for 30 minutes most days of the week. Break this up into three 10-minute sessions when pressed for time. Healthy movement may include walking, sports, dancing, yoga, running or other activities you enjoy."));
        items.add(new Item(R.drawable.b, "Uscf health" , "Eat a well-balanced, low-fat diet with lots of fruits, vegetables and whole grains. Choose a diet that's low in saturated fat and cholesterol, and moderate in sugar, salt and total fat."));
        items.add(new Item(R.drawable.c, "Uscf health" , "Avoid injury by wearing seatbelts and bike helmets, using smoke and carbon monoxide detectors in the home, and using street smarts when walking alone. If you own a gun, recognize the dangers of having a gun in your home. Use safety precautions at all times."));
        items.add(new Item(R.drawable.e, "Uscf health" , "Don't smoke, or quit if you do. Ask your health care provider for help. UCSF's Tobacco Education Center offers smoking cessation and relapse prevention classes as well as doctor consultations for smokers trying to quit."));
        items.add(new Item(R.drawable.f, "Uscf health" , "Ask someone you trust for help if you think you might be addicted to drugs or alcohol."));
        items.add(new Item(R.drawable.g, "Uscf health" , "Brush your teeth after meals with a soft or medium bristled toothbrush. Also brush after drinking and before going to bed. Use dental floss daily."));
        items.add(new Item(R.drawable.h, "Uscf health" , "Stay out of the sun, especially between 10 a.m. and 3 p.m. when the sun's harmful rays are strongest. You are not protected if it is cloudy or if you are in the water — harmful rays pass through both. Use a broad spectrum sunscreen that guards against both UVA and UVB rays, with a sun protection factor (SPF) of 15 or higher. Select sunglasses that block 99 to 100 percent of the sun's rays."));
        items.add(new Item(R.drawable.i, "moh gov sa " , "Read nutritional labels on products. Make sure you know the amount of added sugars in a product before you buy it and encourage your children to do the same."));
        items.add(new Item(R.drawable.j, "moh gov sa " , "Replace sugar-sweetened juices with water and milk. Milk contains natural sugar (lactose) and provides calcium, protein, vitamin D, and other nutrients that children need"));
        items.add(new Item(R.drawable.k, "moh gov sa " , "Eat fresh foods and avoid canned foods and beverages as they usually contain added sugars (e.g. ketchup)"));
        items.add(new Item(R.drawable.m, "moh gov sa " , "Eat starchy foods (e.g. rice, sweet potatoes, macaroni, etc.) on a daily basis—they are a good source of energy, and are rich in many nutrients."));

        back = findViewById(R.id.button2);
        back.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext() , MainActivity.class);
            startActivity(intent);
            finish();
        });



        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));

    }
}