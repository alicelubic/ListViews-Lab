package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mBookAdapter;
    ListView mListView;
    List<Book> mBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO: Define your ListView
        mListView = (ListView)findViewById(R.id.listview);
        //TODO: Define your Book List

        //Use helper method to add books to the list
        mBookList = generateBooks();

        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = convertView;

                if(convertView==null){

                    LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    view = inflater.inflate(android.R.layout.simple_list_item_2, null);
                }

                //TODO: Update the view

                final TextView textViewTitle = (TextView)view.findViewById(android.R.id.text1);
                final TextView textViewAuthor = (TextView)view.findViewById(android.R.id.text2);
                textViewTitle.setText("Title: " + mBookList.get(position).getTitle());
                textViewAuthor.setText("Author: " + mBookList.get(position).getAuthor());

                  View.OnClickListener listener = new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          textViewAuthor.setTextColor(Color.RED);
                          textViewTitle.setTextColor(Color.RED);
                          Toast.makeText(MainActivity.this, "Read!", Toast.LENGTH_SHORT).show();


                      }
                  };
                  view.setOnClickListener(listener);
                return view;
            }
        };
        //

        //TODO: Set the ListView's adapter
        mListView.setAdapter(mBookAdapter);
    }

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad"));
        books.add(new Book("Cats Book","Ryan"));
        books.add(new Book("Eagles Book","Kate"));
        books.add(new Book("Strawberries Cathy","Brad"));
        books.add(new Book("Dogs Book","Tom"));
        books.add(new Book("Ants Book","Zane"));

        return books;
    }
}
