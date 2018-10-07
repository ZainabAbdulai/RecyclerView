package com.example.android.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;

    public class MainActivity extends AppCompatActivity {

        private RecyclerView mRecyclerView;
        private WordListAdapter mAdapter;
        private final LinkedList<String> mWordList = new LinkedList<>();

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Put initial data into the word list.
            for (int i = 0; i < 20; i++) {
                mWordList.addLast("Word " + i);
            }

            // Create recycler view.
            mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
            // Create an adapter and supply the data to be displayed.
            mAdapter = new WordListAdapter(this, mWordList);
            // Connect the adapter with the recycler view.
            mRecyclerView.setAdapter(mAdapter);
            // Give the recycler view a default layout manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Add a floating action click handler for creating new entries.
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int wordListSize = mWordList.size();
                    // Add a new word to the wordList.
                    mWordList.addLast("+ Word " + wordListSize);
                    // Notify the adapter, that the data has changed.
                    mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                    // Scroll to the bottom.
                    mRecyclerView.smoothScrollToPosition(wordListSize);
                }
            });
        }
}
