package com.hit.wizewalletapp.views.fragments.parent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.hit.wizewalletapp.model.child.ChildModel;
import com.hit.wizewalletapp.model.child.ChildTaskModel;
import com.hit.wizewalletapp.model.ChildListModel;
import com.hit.wizewalletapp.R;
import com.hit.wizewalletapp.adapters.child.ChildAdapterSpinner;
import com.hit.wizewalletapp.adapters.child.ChildTaskListAdapter;
import com.hit.wizewalletapp.api.ApiCallsHelper;
import com.hit.wizewalletapp.api.CustomCallBack;
import com.hit.wizewalletapp.utilities.CacheUtilities;
import com.hit.wizewalletapp.utilities.Utilities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class ParentAddTaskFragment extends Fragment {
    //EditText addTaskIdEt;
    EditText addTaskAmountEt;
    EditText addTaskMessage;
    Button addTaskBtn;
    Spinner spinner;
    private ChildAdapterSpinner childAdapter ;
    ChildTaskListAdapter listAdapter= new ChildTaskListAdapter();
    ImageView back_arrow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_parent_add_task, container, false);
       // addTaskIdEt = view.findViewById(R.id.parent_add_task_id_et);
        addTaskAmountEt = view.findViewById(R.id.parent_add_task_amount_et);
        addTaskMessage = view.findViewById(R.id.parent_add_task_message_et);
        addTaskBtn = view.findViewById(R.id.parent_add_task_add_btn);
        spinner=(Spinner)view.findViewById(R.id.add_task_Parent_spinner2);
        childAdapter = new ChildAdapterSpinner(getContext());
        back_arrow = view.findViewById(R.id.child_request_imgbtn_backarrow);
        back_arrow.setOnClickListener(v -> Navigation.findNavController(requireActivity(),R.id.nav_host).navigateUp());

        spinner.setAdapter(childAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectChildId = String.valueOf(childAdapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ApiCallsHelper.performGetAllChilds( CacheUtilities.getAcssesToken(requireContext()), new CustomCallBack<List<ChildModel>>() {
            @Override
            public void onSuccesses(List<ChildModel> response) {
                childAdapter.updateList(response);
            }
            @Override
            public void onFailure(String msg) {
            }
        });

        addTaskBtn.setOnClickListener(v-> save());

        return view;
    }



    private void save() {

        String id=spinner.getSelectedItem().toString();
        String amount = addTaskAmountEt.getText().toString();
        String message = addTaskMessage.getText().toString();
        Date date=new Date();
        String date1=date.toString();
        if (Utilities.verifyAllTextNotEmpty(id, amount, message)) {
            String token = CacheUtilities.getAcssesToken(requireContext());
            HashMap<String, Object> userTaskMap = new HashMap<>();
            userTaskMap.put("kidid", id);
            userTaskMap.put("amount", amount);
            userTaskMap.put("message", message);
            userTaskMap.put("createdat",date1);
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