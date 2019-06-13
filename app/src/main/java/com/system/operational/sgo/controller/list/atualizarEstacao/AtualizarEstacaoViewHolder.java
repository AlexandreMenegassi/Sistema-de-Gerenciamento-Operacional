package com.system.operational.sgo.controller.list.atualizarEstacao;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.system.operational.sgo.R;
import com.system.operational.sgo.model.Estacao;

public class AtualizarEstacaoViewHolder extends RecyclerView.ViewHolder {

    private TextView title_1;
    private TextView title_2;
    private TextView title_3;
    private TextView title_4;

    public AtualizarEstacaoViewHolder(View itemView) {
        super(itemView);
        this.title_1 = itemView.findViewById(R.id.title1);
        this.title_2 = itemView.findViewById(R.id.title2);
        this.title_3 = itemView.findViewById(R.id.title3);
        this.title_4 = itemView.findViewById(R.id.title4);
    }

    public void bindData(final Estacao estacao, final OnListClickInteractionListenerAtualizarEstacao listener){

        this.title_1.setText(estacao.nome);
        this.title_2.setText(estacao.regional);
        this.title_3.setText(estacao.uf);
        this.title_4.setText(estacao.cidade);

        this.title_1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onClick(estacao.id_estacao);
                return true;
            }
        });
    }
}
