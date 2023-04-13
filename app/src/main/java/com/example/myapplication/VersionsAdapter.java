package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersionsAdapter extends RecyclerView.Adapter<VersionsAdapter.VersionVH> {

    List<Versions> versionsList;
    String link2;

    public VersionsAdapter(List<Versions> versionsList) {
        this.versionsList = versionsList;
    }

    @NonNull
    @Override
    public VersionsAdapter.VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.card,parent,false);
        return new VersionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionsAdapter.VersionVH holder, int position) {

        Versions versions = versionsList.get(position);
        holder.codeNameTxt.setText(versions.getCodeName());
        holder.VersionTxt.setText(versions.getVersion());
        holder.apiLevelTxt.setText(versions.getApiLevel());
        holder.descriptionTxt.setText(versions.getDescription());
        //link2 = versions.getLink();

//        holder.apiLevelTxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                gotoUrl(versions.getLink());
//            }
//        });

        boolean isExpandable = versionsList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return versionsList.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder{

        TextView codeNameTxt,VersionTxt,apiLevelTxt,descriptionTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;


        public VersionVH(@NonNull View itemView) {
            super(itemView);

            codeNameTxt = itemView.findViewById(R.id.code_name);
            VersionTxt = itemView.findViewById(R.id.version);
            apiLevelTxt = itemView.findViewById(R.id.api_level);
            descriptionTxt = itemView.findViewById(R.id.description);

            linearLayout = itemView.findViewById(R.id.linear_layout_safety);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);



            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Versions versions = versionsList.get(getAdapterPosition());
                    versions.setExpandable(!versions.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }


}
