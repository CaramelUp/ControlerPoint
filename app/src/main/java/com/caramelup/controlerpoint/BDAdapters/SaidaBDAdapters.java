package com.caramelup.controlerpoint.BDAdapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.caramelup.controlerpoint.Dados.SaidaDados;
import com.caramelup.controlerpoint.DatabaseHelper;

import java.text.SimpleDateFormat;

/**
 * Created by fbuenod on 10/11/17.
 */

public class SaidaBDAdapters {private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private Context ctx;

    private final String NOME_TABELA = "TB_Saida";
    private final String DATASAIDA = "DataSaida";
    private final String HORASAIDA = "HoraSaida";


    SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm:ss");


    private static SaidaBDAdapters INSTANCE;
    public static SaidaBDAdapters getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SaidaBDAdapters(null);
        return INSTANCE;
    }


    public SaidaBDAdapters(Context ctx) {
        this.ctx = ctx;
        INSTANCE = this;
    }

    public SaidaBDAdapters open() throws SQLiteException {
        dbHelper = new DatabaseHelper(ctx);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        database.close();
    }

    public Cursor selecionarSaida() {
        String[] colunas = new String[] {"_id" , DATASAIDA, HORASAIDA };
        return database.query(NOME_TABELA, colunas,
                null, null, null, null, null);
    }

    public long inserirSaida(SaidaDados p) {

        ContentValues valores = new ContentValues();

        valores.put(DATASAIDA, formataData.format(p.getDataSaida().getTimeInMillis()));
        valores.put(HORASAIDA, formataHora.format(p.getHoraSaida().getTime()));


        long idGerado = database.insert(NOME_TABELA, null, valores);
        return idGerado;

    }

    public boolean excluirSaida(SaidaDados t) {
        /**
         * delete from turma where _id = ?
         */
        String[] argumentosWhere = new String[] { Long.toString(t.getId()) };
        int quantidadeRegistrosExcluidos =
                database.delete(NOME_TABELA, "_id = ?", argumentosWhere);

        return quantidadeRegistrosExcluidos == 1;
    }
}