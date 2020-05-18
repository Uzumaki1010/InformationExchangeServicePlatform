package com.example.informationexchangeserviceplatform.ui.tasks;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.informationexchangeserviceplatform.R;

public class PostTaskActivity extends AppCompatActivity {

    private TextView textViewTaskSort,textViewTaskDifficulty;
    private Button buttonTaskSort,buttonTaskDifficulty,buttonCancel,buttonOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_task);

        textViewTaskSort=this.findViewById(R.id.text_view_sort);
        buttonTaskSort=this.findViewById(R.id.button_select_sort);
        textViewTaskDifficulty=this.findViewById(R.id.text_view_difficulty);
        buttonTaskDifficulty=this.findViewById(R.id.button_select_difficulty);
        buttonCancel=this.findViewById(R.id.button_cancel);
        buttonOk=this.findViewById(R.id.button_ok);

        buttonTaskSort.setOnClickListener(new View.OnClickListener() {
            String str;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PostTaskActivity.this);
                builder.setTitle("选择任务类别");

                final String items[] = { "技术类","学习类","竞赛类","生活服务类","爱好类","活动类","兼职实习类","其他"};
                final boolean[] checkedItems = { false, false, false, false,false, false, false, false, true };
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
                        textViewTaskSort.setText(str);
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

        buttonTaskDifficulty.setOnClickListener(new View.OnClickListener() {
            String str;
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PostTaskActivity.this);
                builder.setTitle("选择任务难度");

                final String items[] = { "难","中等","简单"};
                final boolean[] checkedItems = { false, false,false, true };
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
                        textViewTaskDifficulty.setText(str);
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

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                PostTaskActivity.this.finish();
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                PostTaskActivity.this.finish();
            }
        });
    }
}
