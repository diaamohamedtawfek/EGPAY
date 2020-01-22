package com.example.egpay.adaptor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.egpay.DataRate;

import java.util.ArrayList;
import java.util.Collections;

public class adaptor_list extends ArrayAdapter<String> {
    Activity context;

    ArrayList<DataRate> dataRates=new ArrayList<>();
    public adaptor_list(Activity context, ArrayList<DataRate> sorts) {
        super(context, android.R.layout.list_content);
        this.context=context;
        this.dataRates=sorts;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        // return super.getCount();
//        if (MainActivity.debug) {
//            LOG.d(TAG, "getCount Called");
//        }
        return dataRates.size();
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout listLayout = new LinearLayout(context);
        listLayout.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.MATCH_PARENT));
        listLayout.setId(5000);
        listLayout.setOrientation(LinearLayout.VERTICAL);
        listLayout.setPadding(17,3,17,3);

        TextView id = new TextView(context);
        id.setId(5001);
        id.setGravity(Gravity.LEFT);

        TextView name = new TextView(context);
        name.setId(5002);
        name.setGravity(Gravity.LEFT);

        TextView required = new TextView(context);
        required.setId(5001);
        required.setGravity(Gravity.LEFT);

        TextView type = new TextView(context);
        type.setId(5001);
        type.setGravity(Gravity.LEFT);

        TextView default_value = new TextView(context);
        default_value.setId(5001);
        default_value.setGravity(Gravity.LEFT);

        TextView sort = new TextView(context);
        sort.setId(5001);
        sort.setGravity(Gravity.LEFT);

        Spinner spinner=new Spinner(context);
        spinner.setId(555);

        String[] arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, Collections.singletonList(dataRates.get(position).getMultiple()));
        spinner.setAdapter(adapter);



        listLayout.addView(id);
        listLayout.addView(required);
        listLayout.addView(name);
        listLayout.addView(type);
        listLayout.addView(default_value);
        listLayout.addView(sort);
        listLayout.addView(spinner);

        id.setText("id:-  "+dataRates.get(position).getId());
        required.setText("required:-  "+dataRates.get(position).getRequired());
        name.setText("name:-   "+dataRates.get(position).getName());
        type.setText("type:-  "+dataRates.get(position).getType());
        default_value.setText("default_value:-  "+dataRates.get(position).getDefaultValue());
        sort.setText("sort:-  "+dataRates.get(position).getSort());


        return listLayout;
    }

}