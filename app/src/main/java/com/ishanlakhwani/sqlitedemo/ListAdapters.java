package com.ishanlakhwani.sqlitedemo;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListAdapters extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> Name;
    ArrayList<String> Ans1;
    ArrayList<String> Ans2;
    ArrayList<String> Time;


    public ListAdapters(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> name,
            ArrayList<String> ans1,
            ArrayList<String> ans2,
            ArrayList<String> time
    )
    {

        this.context = context2;
        this.ID = id;
        this.Name = name;
        this.Ans1 = ans1;
        this.Ans2 = ans2;
        this.Time = time;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return ID.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            child = layoutInflater.inflate(R.layout.items, null);

            holder = new Holder();

            holder.ID_TextView = (TextView) child.findViewById(R.id.textViewID);
            holder.Name_TextView = (TextView) child.findViewById(R.id.textViewNAME);
            holder.Ans1_TextView = (TextView) child.findViewById(R.id.textViewAns1);
            holder.Ans2_TextView = (TextView) child.findViewById(R.id.textViewAns2);
            holder.TimeTextView = (TextView) child.findViewById(R.id.textViewTime);

            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.ID_TextView.setText(ID.get(position));
        holder.Name_TextView.setText(Name.get(position));
        holder.Ans1_TextView.setText(Ans1.get(position));
        holder.Ans2_TextView.setText(Ans2.get(position));
        holder.TimeTextView.setText(Time.get(position));

        return child;
    }

    public class Holder {

        public TextView Ans1_TextView;
        public TextView Ans2_TextView;
        TextView ID_TextView;
        TextView Name_TextView;
        TextView TimeTextView;
    }

}