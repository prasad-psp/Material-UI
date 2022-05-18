package com.psp.test_int;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textview.MaterialTextView;
import com.psp.test_int.databinding.FragmentHomeBinding;

public class Home extends Fragment {

    private FragmentHomeBinding binding;

    // Fragment / Screens object init
    private final YourInfo yourInfoFragment = new YourInfo();
    private final KnowYou knowYouFragment = new KnowYou();
    private final YourFamily yourFamilyFragment = new YourFamily();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // init
        init();

        // Your info
        binding.txtYourInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackground(binding.txtYourInfo);

                // Open **Your info** fragment
                openFragment(yourInfoFragment);
            }
        });

        // Know you
        binding.txtKnowYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackground(binding.txtKnowYou);

                // Open **Know you** fragment
                openFragment(knowYouFragment);
            }
        });

        // Your family
        binding.txtYourFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackground(binding.txtYourFamily);

                // Open **Your family** fragment
                openFragment(yourFamilyFragment);
            }
        });
    }

    private void init() {
        // initial stage Your info screen / Fragment is visible to user
        openFragment(yourInfoFragment);
    }

    private void changeBackground(MaterialTextView selectedView) {
        if(selectedView == binding.txtYourInfo) {
            // Your info is selected
            yourInfoIsActive(true);
            knowYouIsActive(false);
            yourFamilyIsActive(false);
            return;
        }

        if(selectedView == binding.txtKnowYou) {
            // Know you is selected
            yourInfoIsActive(false);
            knowYouIsActive(true);
            yourFamilyIsActive(false);
            return;
        }

        if(selectedView == binding.txtYourFamily) {
            // Your family is selected
            yourInfoIsActive(false);
            knowYouIsActive(false);
            yourFamilyIsActive(true);
        }
    }

    private void openFragment(Fragment fragment) {
        if(getActivity() != null) {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout,fragment)
                    .commit();
        }
    }

    private void yourInfoIsActive(boolean isActive) {
        if(isActive) {
            binding.conYourInfo.setBackground(ContextCompat.getDrawable(this.requireContext(),R.drawable.background_tab_selected));
        } else {
            binding.conYourInfo.setBackground(ContextCompat.getDrawable(this.requireContext(),R.drawable.background_tab_not_selected));
        }
    }

    private void knowYouIsActive(boolean isActive) {
        if(isActive) {
            binding.conKnowYou.setBackground(ContextCompat.getDrawable(this.requireContext(),R.drawable.background_tab_selected));
        } else {
            binding.conKnowYou.setBackground(ContextCompat.getDrawable(this.requireContext(),R.drawable.background_tab_not_selected));
        }
    }

    private void yourFamilyIsActive(boolean isActive) {
        if(isActive) {
            binding.conYourFamily.setBackground(ContextCompat.getDrawable(this.requireContext(),R.drawable.background_tab_selected));
        } else {
            binding.conYourFamily.setBackground(ContextCompat.getDrawable(this.requireContext(),R.drawable.background_tab_not_selected));
        }
    }
}