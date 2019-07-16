package com.system.operational.sgo.controller.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.system.operational.sgo.R;
import com.system.operational.sgo.controller.Controller;
import com.system.operational.sgo.model.InformationStation;

public class ListaDeEstacaoViewHolder extends RecyclerView.ViewHolder {

    private TextView title_1;
    private TextView title_2;
    private TextView title_3;
    private TextView title_4;
    private TextView title_5;

    public ListaDeEstacaoViewHolder(View itemView) {
        super(itemView);
        this.title_1 = itemView.findViewById(R.id.title1);
        this.title_2 = itemView.findViewById(R.id.title2);
        this.title_3 = itemView.findViewById(R.id.title3);
        this.title_4 = itemView.findViewById(R.id.title4);
        this.title_5 = itemView.findViewById(R.id.title5);
    }

    public void bindData(final InformationStation informationStation, final OnListClickInteractionListenerListaDeEstacao listener) {
        this.title_1.setText(informationStation.nome);
        this.title_2.setText(informationStation.regional);
        this.title_3.setText(informationStation.uf);
        this.title_4.setText(informationStation.cidade);
        this.title_5.setText(informationStation.endid);

        this.title_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Controller.ESTACAO.clear();
                listener.onClick(informationStation.id_estacao);
                Controller.ESTACAO.add(informationStation.id_estacao);
                Controller.ESTACAO.add(informationStation.nome);
                Controller.ESTACAO.add(informationStation.endid);
                return true;
            }
        });
    }
}
