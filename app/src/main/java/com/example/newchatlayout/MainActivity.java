package com.example.newchatlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;
import com.hudomju.swipe.SwipeableItemClickListener;
import com.hudomju.swipe.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CustomAdapter customAdapter;
    List<ObjectoListView> objectoListViews = new ArrayList<>();
    //private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //mRecyclerView = findViewById(R.id.my_recycler_view);
        //coordinatorLayout = findViewById(R.id.constrainLayout);

        populateRecyclerView();
        enableSwipeToDeleteAndUndo();
    }

    private void populateRecyclerView()
    {


        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle("Swipeable");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        //List<ObjectoListView> objectoListViews = new ArrayList<>();
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //objectoListViews.add(new ObjectoListView("Tanu","Hii","Tanu",R.drawable.two));
        //objectoListViews.add(new ObjectoListView("Vaibhav","Hello","123",R.drawable.one));
        //objectoListViews.add(new ObjectoListView("Jahn","go","435",R.drawable.three));

        customAdapter = new CustomAdapter(this, objectoListViews);
        mRecyclerView.setAdapter(customAdapter);


     //for(int i = 0; i<16; i++)
         objectoListViews.add(new ObjectoListView("Item","SubItem","5-05-2021",R.drawable.two));
        objectoListViews.add(new ObjectoListView("Item2","SubItem2","5-05-2021",R.drawable.one));
        objectoListViews.add(new ObjectoListView("Item3","SubItem3","5-05-2021",R.drawable.three));
        objectoListViews.add(new ObjectoListView("Item4","SubItem4","5-05-2021",R.drawable.two));
        objectoListViews.add(new ObjectoListView("Item5","SubItem5","5-05-2021",R.drawable.one));
        objectoListViews.add(new ObjectoListView("Item6","SubItem6","5-05-2021",R.drawable.three));
        objectoListViews.add(new ObjectoListView("Item7","SubItem7","5-05-2021",R.drawable.one));
        objectoListViews.add(new ObjectoListView("Item8","SubItem8","5-05-2021",R.drawable.two));
        objectoListViews.add(new ObjectoListView("Item9","SubItem9","5-05-2021",R.drawable.three));
        objectoListViews.add(new ObjectoListView("Item10","SubItem10","5-05-2021",R.drawable.one));

        mRecyclerView.getAdapter().notifyDataSetChanged();

    }


    private void enableSwipeToDeleteAndUndo(){
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                //String name = objectoListView.get(viewHolder.getAdapterPosition()).getTextTitle();

                final int deleteIndex =  viewHolder.getAdapterPosition();

                final ObjectoListView item = objectoListViews.get(viewHolder.getAdapterPosition());
                customAdapter.removeItem(viewHolder.getAdapterPosition());

                Snackbar snackbar = Snackbar.make(findViewById(R.id.constrainLayout), "Item removed from list", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if(deleteIndex == 0)
                        {
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                           linearLayoutManager.scrollToPosition(0);
                        }

                        customAdapter.restoreItem(item, deleteIndex);
                        mRecyclerView.scrollToPosition(deleteIndex);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);


    }








}