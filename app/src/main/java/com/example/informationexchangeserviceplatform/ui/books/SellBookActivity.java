package com.example.informationexchangeserviceplatform.ui.books;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.informationexchangeserviceplatform.R;
import com.example.informationexchangeserviceplatform.ui.tasks.PostTaskActivity;

public class SellBookActivity extends AppCompatActivity {

    private Button buttonSelectSellOrBorrow,buttonNo,buttonYes;
    private TextView textViewSelectSellOrBorrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_book);

        buttonNo=this.findViewById(R.id.button_no);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                SellBookActivity.this.finish();
            }
        });

        buttonYes=this.findViewById(R.id.button_yes);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                SellBookActivity.this.finish();
            }
        });

        textViewSelectSellOrBorrow=this.findViewById(R.id.text_view_sellorborrow);
        buttonSelectSellOrBorrow=this.findViewById(R.id.button_select_sellorborrow);
        buttonSelectSellOrBorrow.setOnClickListener(new View.OnClickListener() {
            String str;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SellBookActivity.this);
                builder.setTitle("选择卖出/借出");

                final String items[] = { "卖出","借出"};
                final boolean[] checkedItems = { false, false,true };
                builder.setMultiChoiceItems(items, checkedItems,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {

                            }
                        });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < items.length; i++) {
                            // 判断一下 选中的
                            if (checkedItems[i]) {
                                String choice = items[i];
                                sb.append(choice + " ");
                                str=sb.toString();
                            }
                        }
                        textViewSelectSellOrBorrow.setText(str);
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    }
}
