package com.example.informationexchangeserviceplatform.ui.dashboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.informationexchangeserviceplatform.R;
import com.example.informationexchangeserviceplatform.ui.tasks.PostTaskActivity;

public class PostResourceActivity extends AppCompatActivity {

    private Button buttonSelectCollege;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_resource);

        textView=this.findViewById(R.id.textView14);
        buttonSelectCollege=this.findViewById(R.id.button_select_college);
        buttonSelectCollege.setOnClickListener(new View.OnClickListener() {
            String str;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PostResourceActivity.this);
                builder.setTitle("选择学院");

                final String items[] = { "人文学院","翻译学院","国际商学院","包装工程学院","智能科学与工程学院","国际能源学院"};
                final boolean[] checkedItems = { false, false, false, false,false, false, true };
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
                        textView.setText(str);
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
