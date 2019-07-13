package com.system.operational.sgo.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.system.operational.sgo.DAO.DatabaseDataStation;
import com.system.operational.sgo.DAO.DatabaseList;
import com.system.operational.sgo.controller.list.ListaDeEstacaoListAdapter;
import com.system.operational.sgo.controller.list.OnListClickInteractionListenerListaDeEstacao;
import com.system.operational.sgo.model.Estacao;
import com.system.operational.sgo.model.StationSituation;
import com.system.operational.sgo.model.Usuario;
import com.system.operational.sgo.view.form.FormularioAtualizarDadosEstacaoActivity;
import com.system.operational.sgo.view.list.VisualizarEstacaoActivity;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public static ViewHolder mViewHolderListaDeEstacao = new ViewHolder();
    public static List<Estacao> LISTADADOSESTACAO = new ArrayList<>();
    public static StationSituation dadosDaEstacao = new StationSituation();
    public static Usuario USUARIO = new Usuario();
    public static List ESTACAO = new ArrayList();
    public static String message;
    private static AlertDialog alerta;
    public static List<String> LISTANOMEESTACAO = new ArrayList<>();

    public static void listaDeEstacao(final Context context, RecyclerView recyclerView, final int op) {

        DatabaseList.lerEstacoes();

        try {
            OnListClickInteractionListenerListaDeEstacao listener = new OnListClickInteractionListenerListaDeEstacao() {
                @Override
                public void onClick(int id) {
                    switch (op) {
                        case 0:
                            context.startActivity(new Intent(context, FormularioAtualizarDadosEstacaoActivity.class));
                            break;
                        case 1:
                            DatabaseDataStation.dadosEstacao(id);
                            break;
                        case 2:
                            break;
                    }
                }
            };
            mViewHolderListaDeEstacao.recyclerViewListaDeEstacao = recyclerView;

            ListaDeEstacaoListAdapter listaDeEstacaoListAdapter = new ListaDeEstacaoListAdapter(LISTADADOSESTACAO, listener);
            mViewHolderListaDeEstacao.recyclerViewListaDeEstacao.setAdapter(listaDeEstacaoListAdapter);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            mViewHolderListaDeEstacao.recyclerViewListaDeEstacao.setLayoutManager(linearLayoutManager);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void filtarEstacao(final Context context, RecyclerView recyclerView, String filtro, final int op) {

        List<Estacao> dadosFiltrado = new ArrayList<>();

        for (int i = 0; i < LISTADADOSESTACAO.size(); i++) {
            if (LISTADADOSESTACAO.get(i).getNome().equals(filtro))
                dadosFiltrado.add(LISTADADOSESTACAO.get(i));
        }

        try {
            OnListClickInteractionListenerListaDeEstacao listener = new OnListClickInteractionListenerListaDeEstacao() {
                @Override
                public void onClick(int id) {
                    switch (op) {
                        case 0:
                            context.startActivity(new Intent(context, FormularioAtualizarDadosEstacaoActivity.class));
                            break;
                        case 1:
                            DatabaseDataStation.dadosEstacao(id);
                            break;
                    }
                }
            };
            mViewHolderListaDeEstacao.recyclerViewListaDeEstacao = recyclerView;

            ListaDeEstacaoListAdapter listaDeEstacaoListAdapter = new ListaDeEstacaoListAdapter(dadosFiltrado, listener);
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

    public static void alertDialogStationNotUpdate(String idOne, String idTwo) {

        AlertDialog.Builder builder = new AlertDialog.Builder(VisualizarEstacaoActivity.context);
        builder.setTitle("Estação Desatualizada!");
        builder.setMessage("Deseja atualizar esta estação?\n\n" + idOne + "\n" + idTwo);

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                VisualizarEstacaoActivity.activityForm(VisualizarEstacaoActivity.context);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alerta = builder.create();
        alerta.show();
    }
}
