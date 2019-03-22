package com.teamtreehouse.oslist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpendableListAdapterFailedBills extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeaderFailedBills;
    private HashMap<String,List<String>> listHashMap;

    public ExpendableListAdapterFailedBills(Context context, List<String> listDataHeaderFailedBills, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeaderFailedBills = listDataHeaderFailedBills;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeaderFailedBills.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(listDataHeaderFailedBills.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeaderFailedBills.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listHashMap.get(listDataHeaderFailedBills.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String headerTitle= (String)getGroup(i);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group_failedbills,null);
        }
        TextView lbListHeaderFailed = (TextView)view.findViewById(R.id.lbListHeaderFailedBills);
        lbListHeaderFailed.setTypeface(null, Typeface.BOLD);
        lbListHeaderFailed.setText(headerTitle);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String)getChild(i,i1);
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_failedbills,null);
        }

        TextView txtListChild = (TextView)view.findViewById(R.id.lbListItemfailedbills);
        txtListChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
