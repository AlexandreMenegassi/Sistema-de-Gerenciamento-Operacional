package com.system.operational.sgo.controller.list.atualizarEstacao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.system.operational.sgo.R;
import com.system.operational.sgo.model.Estacao;

import java.util.List;

public class AtualizarEstacaoListAdapter extends RecyclerView.Adapter<AtualizarEstacaoViewHolder> {

    private List<Estacao> mListEstacao;
    private OnListClickInteractionListenerAtualizarEstacao mOnListClickInteractionListener;

    public AtualizarEstacaoListAdapter(List<Estacao> estacaoList, OnListClickInteractionListenerAtualizarEstacao listener){
        this.mListEstacao = estacaoList;
        this.mOnListClickInteractionListener = listener;
    }

    @NonNull
    @Override
    public AtualizarEstacaoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.row_atualizar_estacao_activity, viewGroup, false);
        return new AtualizarEstacaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AtualizarEstacaoViewHolder clientViewHolder, int i) {
        Estacao estacao = this.mListEstacao.get(i);
        clientViewHolder.bindData(estacao, this.mOnListClickInteractionListener);
    }

    @Override
    public int getItemCount() {
        return this.mListEstacao.size();
    }
}