package com.system.operational.sgo.controller.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.system.operational.sgo.R;
import com.system.operational.sgo.model.InformationStation;

import java.util.List;

public class ListaDeEstacaoListAdapter extends RecyclerView.Adapter<ListaDeEstacaoViewHolder> {

    private List<InformationStation> mListInformationStation;
    private OnListClickInteractionListenerListaDeEstacao mOnListClickInteractionListener;

    public ListaDeEstacaoListAdapter(List<InformationStation> informationStationList, OnListClickInteractionListenerListaDeEstacao listener) {
        this.mListInformationStation = informationStationList;
        this.mOnListClickInteractionListener = listener;
    }

    @NonNull
    @Override
    public ListaDeEstacaoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.row_list_station, viewGroup, false);
        return new ListaDeEstacaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaDeEstacaoViewHolder clientViewHolder, int i) {
        InformationStation informationStation = this.mListInformationStation.get(i);
        clientViewHolder.bindData(informationStation, this.mOnListClickInteractionListener);
    }

    @Override
    public int getItemCount() {
        return this.mListInformationStation.size();
    }
}