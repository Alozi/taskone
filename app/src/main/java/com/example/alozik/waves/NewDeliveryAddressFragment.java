package com.example.alozik.waves;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

public class NewDeliveryAddressFragment extends Fragment implements View.OnClickListener {
    private LinearLayout llMain;
    private LinearLayout llButtons;
    private Button btnFilterItems;
    private Button btnNavigation;
    private MaterialEditText etTitle;
    private MaterialEditText etCountry;
    private MaterialEditText etCity;
    private MaterialEditText etAddress;
    private MaterialEditText etZip;
    private MaterialEditText etPhone;
    private MaterialEditText etCompanyNumber;
    private MaterialEditText etRegion;
    private LinearLayout llCustomViewsContainer;
    private Button btnDeleteAddress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_delivery_address, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        setListeners();
        addObligatoryMarks();
        showRemoveAddressAlert();
    }

    private void findViews(View view) {
        llMain = (LinearLayout) view.findViewById(R.id.llMain);
        llButtons = (LinearLayout) view.findViewById(R.id.llButtons);
        btnFilterItems = (Button) view.findViewById(R.id.btnFilterItems);
        btnNavigation = (Button) view.findViewById(R.id.btnNavigation);
        etTitle = (MaterialEditText) view.findViewById(R.id.etTitle);
        etCountry = (MaterialEditText) view.findViewById(R.id.etCountry);
        etCity = (MaterialEditText) view.findViewById(R.id.etCity);
        etAddress = (MaterialEditText) view.findViewById(R.id.etAddress);
        etZip = (MaterialEditText) view.findViewById(R.id.etZip);
        etPhone = (MaterialEditText) view.findViewById(R.id.etPhone);
        etCompanyNumber = (MaterialEditText) view.findViewById(R.id.etCompanyNumber);
        etRegion = (MaterialEditText) view.findViewById(R.id.etRegion);
        llCustomViewsContainer = (LinearLayout) view.findViewById(R.id.llCustomViewsContainer);
        btnDeleteAddress = (Button) view.findViewById(R.id.btnDeleteAddress);
    }

    private void setListeners() {
        btnFilterItems.setOnClickListener(this);
        btnNavigation.setOnClickListener(this);
        btnDeleteAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFilterItems:
                break;
            case R.id.btnNavigation:
                break;
            case R.id.btnDeleteAddress:
                showRemoveAddressAlert();
                break;
        }
    }

    private void addObligatoryMarks() {
        addObligatoryMark(etTitle);
        addObligatoryMark(etCountry);
        addObligatoryMark(etPhone);
    }

    private void addObligatoryMark(MaterialEditText materialEditText) {
        String text = (String) materialEditText.getHint();
        materialEditText.setHint(text + " *");
    }

    private void showRemoveAddressAlert() {
        String message = "Delivery address will be removed.";

        new AlertDialog.Builder(getContext())
                .setMessage(message)
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Delivery remove.", Toast.LENGTH_LONG)
                                .show();
                    }
                })
                .show();
    }
}
