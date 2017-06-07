package com.example.admin.contactlist_simple;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listViewContact);
        List<Contact> contacts =getNameEmailDetails();
        setContactList(contacts);
    }
    public List<Contact> getNameEmailDetails(){
        List<Contact> contacts = new ArrayList<Contact>();
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                Cursor cur1 = cr.query(
                        ContactsContract.CommonDataKinds.Email.CONTENT_URI, null,
                        ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
                        new String[]{id}, null);
                while (cur1.moveToNext()) {
                    //to get the contact contacts
                    int phoneid = cur1.getInt(cur1.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                    String name=cur1.getString(cur1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String email = cur1.getString(cur1.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS));
                    contacts.add(new Contact(phoneid,name,email));
                }
                cur1.close();
            }
        }
        return contacts;
    }
    private void setContactList(List<Contact> contacts) {
        ContactListAdapter adapter = new ContactListAdapter(this, R.layout.single_item_list, contacts);
        list.setAdapter(adapter);
    }
}
