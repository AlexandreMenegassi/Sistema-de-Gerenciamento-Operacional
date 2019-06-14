package com.system.operational.sgo.controller;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.system.operational.sgo.DAO.Database;
import com.system.operational.sgo.controller.list.atualizarEstacao.AtualizarEstacaoListAdapter;
import com.system.operational.sgo.controller.list.atualizarEstacao.OnListClickInteractionListenerAtualizarEstacao;
import com.system.operational.sgo.model.Estacao;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static ViewHolder mViewHolderAtualizarEstacao = new ViewHolder();

    public static List<Estacao> listAtualizarEstacao = new ArrayList<>();

    public static void listarCliente(Context context, RecyclerView recyclerView) {

        Database.lerEstacoes();

        try {
            OnListClickInteractionListenerAtualizarEstacao listener = new OnListClickInteractionListenerAtualizarEstacao() {
                @Override
                public void onClick(int id) {

                }
            };
            mViewHolderAtualizarEstacao.recyclerViewAtualizarEstacao = recyclerView;

            AtualizarEstacaoListAdapter atualizarEstacaoListAdapter = new AtualizarEstacaoListAdapter(listAtualizarEstacao, listener);
            mViewHolderAtualizarEstacao.recyclerViewAtualizarEstacao.setAdapter(atualizarEstacaoListAdapter);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            mViewHolderAtualizarEstacao.recyclerViewAtualizarEstacao.setLayoutManager(linearLayoutManager);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static class ViewHolder {
        RecyclerView recyclerViewAtualizarEstacao;
    }
}
