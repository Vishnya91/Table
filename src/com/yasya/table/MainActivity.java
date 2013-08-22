package com.yasya.table;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.yasya.table.EditDialog.EditDialogListener;

import java.util.ArrayList;

public class MainActivity extends Activity implements EditDialogListener {


    private static final int DIVIDER_SIZE = 1;

    TableLayout table;
    View dividerRow2;
    MyTableRow row;
    protected Object mActionMode;
    private ArrayList<TableRow> rows = new ArrayList<TableRow>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup the layout
        setContentView(R.layout.activity_main);

    }

    private void addRow() {
        table = (TableLayout) findViewById(R.id.table);

        row = new MyTableRow(this);

        dividerRow2 = new View(this);
        dividerRow2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                DIVIDER_SIZE));
        dividerRow2.setBackgroundColor(Color.BLACK);

        // add the TableRow to the TableLayout
        // table.addView(deviderRow1);
        table.addView(row, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        table.addView(dividerRow2);

        Toast.makeText(this, "Table has " + table.getChildCount(),
                Toast.LENGTH_SHORT).show();

        row.setOnLongClickListener(new View.OnLongClickListener() {
            // Called when the user long-clicks on someView
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }

                // Start the CAB using the ActionMode.Callback defined above
                mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
                view.setSelected(true);
               // row.setSelected(true);
                return true;
            }
        });
        rows.add(row);
    }

    private void deleteRow() {
        for(TableRow c : rows){
            MyTableRow row = (MyTableRow) c;
        if(row.isSelected()){
        table.removeView(row);
           // table.removeView(dividerRow2);
       }
    }
    }
    private void editRow(){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                addRow();
               // showEditDialog();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showEditDialog() {
        FragmentManager fm = getFragmentManager();
        EditDialog editDialog = new EditDialog();
        editDialog.show(fm, "fragment_edit");
    }

    @Override
    public void onFinishEditDialog(String text1, String text2, String text3,
                                   String text4, String text5) {
      /*  id.setText(text1);
        last.setText(text2);
        first.setText(text3);
        age.setText(text4);
        street.setText(text5);*/
    }

    @Override
    public void onCallEditDialog(String text1, String text2, String text3, String text4, String text5) {
      /* text1 = id.getText().toString();
       text2 = last.getText().toString();
       text3 = first.getText().toString();
       text4 = age.getText().toString();
       text5 = street.getText().toString();*/

    }
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_menu, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.action_delete:
                    deleteRow();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                case R.id.action_edit:
                    editRow();
                    mode.finish(); // Action picked, so close the CAB
                    return true;
                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };
}
