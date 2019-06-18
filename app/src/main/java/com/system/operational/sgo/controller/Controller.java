package com.system.operational.sgo.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.system.operational.sgo.DAO.DatabaseList;
import com.system.operational.sgo.controller.list.listaDeEstacao.ListaDeEstacaoListAdapter;
import com.system.operational.sgo.controller.list.listaDeEstacao.OnListClickInteractionListenerListaDeEstacao;
import com.system.operational.sgo.model.Estacao;
import com.system.operational.sgo.model.Usuario;
import com.system.operational.sgo.view.forms.FormularioAtualizarEstacaoActivity;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static ViewHolder mViewHolderListaDeEstacao = new ViewHolder();
    public static List<Estacao> listaDeEstacao = new ArrayList<>();
    public static Usuario USUARIO = new Usuario();
    public static List ESTACAO = new ArrayList();
    public static String message;

    public static void listaDeEstacao(final Context context, RecyclerView recyclerView, final int op) {

        DatabaseList.lerEstacoes();

        try {
            OnListClickInteractionListenerListaDeEstacao listener = new OnListClickInteractionListenerListaDeEstacao() {
                @Override
                public void onClick(int id) {
                    switch (op) {
                        case 0:
                            context.startActivity(new Intent(context, FormularioAtualizarEstacaoActivity.class));
                            break;
                        case 1:

                            break;
                        case 2:

                            break;
                    }
                }
            };
            mViewHolderListaDeEstacao.recyclerViewListaDeEstacao = recyclerView;

            ListaDeEstacaoListAdapter listaDeEstacaoListAdapter = new ListaDeEstacaoListAdapter(listaDeEstacao, listener);
            mViewHolderListaDeEstacao.recyclerViewListaDeEstacao.setAdapter(listaDeEstacaoListAdapter);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            mViewHolderListaDeEstacao.recyclerViewListaDeEstacao.setLayoutManager(linearLayoutManager);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ViewHolder {
        RecyclerView recyclerViewListaDeEstacao;
    }
}
