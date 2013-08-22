package com.yasya.table;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by dev on 22/08/13.
 */
public class MyTableRow extends TableRow {

    private static final int DIVIDER_SIZE = 1;
    LayoutParams params;
    int counter = 0;
    TextView id;
    TextView last;
    TextView first;
    TextView age;
    TextView street;
    Random rnd = new Random();
    int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    private boolean isSelected = false;

    public MyTableRow(Context context) {
        super(context);
        params = new TableRow.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1f);
        counter++;
        this.setId(counter);
        this.setLayoutParams(params);
        this.setBackgroundColor(color);

        id = new TextView(context);
        last = new TextView(context);
        first = new TextView(context);
        age = new TextView(context);
        street = new TextView(context);

        id.setLayoutParams(params);
        id.setBackgroundColor(color);
        id.setGravity(Gravity.CENTER);

        last.setLayoutParams(params);
        last.setBackgroundColor(color);
        last.setGravity(Gravity.CENTER);

        first.setLayoutParams(params);
        first.setBackgroundColor(color);
        first.setGravity(Gravity.CENTER);

        age.setLayoutParams(params);
        age.setBackgroundColor(color);
        age.setGravity(Gravity.CENTER);
        street.setLayoutParams(params);
        street.setBackgroundColor(color);
        street.setGravity(Gravity.CENTER);


        View dividerCell1 = new View(context);
        dividerCell1.setLayoutParams(new LayoutParams(DIVIDER_SIZE,
                LayoutParams.MATCH_PARENT));
        dividerCell1.setBackgroundColor(Color.BLACK);
        View dividerCell2 = new View(context);
        dividerCell2.setLayoutParams(new LayoutParams(DIVIDER_SIZE,
                LayoutParams.MATCH_PARENT));
        dividerCell2.setBackgroundColor(Color.BLACK);

        View dividerCell3 = new View(context);
        dividerCell3.setLayoutParams(new LayoutParams(DIVIDER_SIZE,
                LayoutParams.MATCH_PARENT));
        dividerCell3.setBackgroundColor(Color.BLACK);

        View dividerCell4 = new View(context);
        dividerCell4.setLayoutParams(new LayoutParams(DIVIDER_SIZE,
                LayoutParams.MATCH_PARENT));
        dividerCell4.setBackgroundColor(Color.BLACK);

        View dividerCell5 = new View(context);
        dividerCell5.setLayoutParams(new LayoutParams(DIVIDER_SIZE,
                LayoutParams.MATCH_PARENT));
        dividerCell5.setBackgroundColor(Color.BLACK);

        View dividerCell6 = new View(context);
        dividerCell6.setLayoutParams(new LayoutParams(DIVIDER_SIZE,
                LayoutParams.MATCH_PARENT));
        dividerCell6.setBackgroundColor(Color.BLACK);

        this.addView(dividerCell1);
        this.addView(id);
        this.addView(dividerCell2);
        this.addView(last);
        this.addView(dividerCell3);
        this.addView(first);
        this.addView(dividerCell4);
        this.addView(age);
        this.addView(dividerCell5);
        this.addView(street);
        this.addView(dividerCell6);

    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean what) {
        this.isSelected = what;
    }



    public int getId(){
        return Integer.parseInt(id.getText().toString());
    }

    public void setId(String id) {
        this.id.setText(id);
    }

    public String getName() {
        return first.getText().toString();
    }

    public void setName(String name) {
        this.first.setText(name);
    }

    public String getLastName() {
        return last.getText().toString();
    }

    public void setLastName(String lastName) {
        this.last.setText(lastName);
    }

    public String getAge() {
        return age.getText().toString();
    }

    public void setAge(String age) {
        this.age.setText(age);
    }
}
