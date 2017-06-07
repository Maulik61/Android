package com.example.admin.contactlist_simple;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 02/08/2016.
 */
public class ContactListAdapter extends ArrayAdapter<Contact> {

    Context mContext;
    int layoutResourceId;
    List<Contact> data = null;

    public ContactListAdapter(Context menuContext, int layoutResourceId,List<Contact> contactList) {
        super(menuContext,layoutResourceId,contactList);
        this.mContext = menuContext;
        this.data = contactList;
        this.layoutResourceId = layoutResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position


        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView  txtContactID = (TextView) convertView.findViewById(R.id.txt_id);
        TextView txtContactName= (TextView) convertView.findViewById(R.id.txt_name);
        TextView txtContactEmail = (TextView) convertView.findViewById(R.id.txt_email);

        txtContactName.setText(String.valueOf(data.get(position).getId()));
        txtContactID.setText(data.get(position).getName());
        txtContactEmail.setText(data.get(position).getEmail());
        return convertView;
    }

}