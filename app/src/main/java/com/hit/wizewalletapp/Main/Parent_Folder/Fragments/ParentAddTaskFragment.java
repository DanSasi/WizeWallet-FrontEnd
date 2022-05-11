package com.hit.wizewalletapp.Main.Parent_Folder.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildModel;
import com.hit.wizewalletapp.Main.Child_Folder.Models.Models.ChildTaskModel;
import com.hit.wizewalletapp.Main.Parent_Folder.Models.ListModels.ChildListModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.api.responses.ServerResponse;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;

import java.util.HashMap;


public class ParentAddTaskFragment extends Fragment {
    EditText addTaskIdEt;
    EditText addTaskAmountEt;
    EditText addTaskMessage;
    Button addTaskBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_parent_add_task, container, false);
        addTaskIdEt = view.findViewById(R.id.parent_add_task_id_et);
        addTaskAmountEt = view.findViewById(R.id.parent_add_task_amount_et);
        addTaskMessage = view.findViewById(R.id.parent_add_task_message_et);
        addTaskBtn = view.findViewById(R.id.parent_add_task_add_btn);

        addTaskBtn.setOnClickListener(v-> save());

        return view;
    }

    private void save() {
        String id = addTaskIdEt.getText().toString();
        String amount = addTaskAmountEt.getText().toString();
        String message = addTaskMessage.getText().toString();
        if (Utilities.verifyAllTextNotEmpty(id, amount, message)) {
            String token = CacheUtilities.getAcssesToken(requireContext());
            HashMap<String, Object> userTaskMap = new HashMap<>();
            userTaskMap.put("kidid", Integer.parseInt(id));
            userTaskMap.put("amount", amount);
            userTaskMap.put("message", message);
            ApiCallsHelper.performAddTasks(token, userTaskMap, new CustomCallBack<Void>() {
                @Override
                public void onSuccesses(Void response) {
                ChildTaskModel childTaskModel = new ChildTaskModel(Integer.parseInt(id),message,Integer.parseInt(amount));
                ChildListModel.instance.addTran(childTaskModel);
                Navigation.findNavController(getActivity(), R.id.nav_host).navigateUp();

                }

                @Override
                public void onFailure(String msg) {
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();

                }
            });
        }



    }







}