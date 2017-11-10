package com.caramelup.controlerpoint.BDAdapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.caramelup.controlerpoint.Dados.EntradaDados;
import com.caramelup.controlerpoint.DatabaseHelper;

import java.text.SimpleDateFormat;

/**
 * Created by fbuenod on 10/11/17.
 */

public class EntradaBDAdapters {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private Context ctx;

    private final String NOME_TABELA = "TB_Entrada";
    private final String DATAENTRADA = "DataEntrada";
    private final String HORAENTRADA = "HoraEntrada";

    SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm:ss");


    private static EntradaBDAdapters INSTANCE;
    public static EntradaBDAdapters getInstance() {
        if (INSTANCE == null)
            INSTANCE = new EntradaBDAdapters(null);
        return INSTANCE;
    }


    public EntradaBDAdapters(Context ctx) {
        this.ctx = ctx;
        INSTANCE = this;
    }

    public EntradaBDAdapters open() throws SQLiteException {
        dbHelper = new DatabaseHelper(ctx);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        database.close();
    }

    public Cursor selecionarEntrada() {
        String[] colunas = new String[] {"_id" , DATAENTRADA, HORAENTRADA };
        return database.query(NOME_TABELA, colunas,
                null, null, null, null, null);
    }

    public long inserirEntrada(EntradaDados p) {

        ContentValues valores = new ContentValues();

        valores.put(DATAENTRADA, formataData.format(p.getDataEntrada().getTimeInMillis()));
        valores.put(HORAENTRADA, formataHora.format(p.getHoraEntrada().getTime()));

        long idGerado = database.insert(NOME_TABELA, null, valores);
        return idGerado;

    }

    public boolean excluirEntrada(EntradaDados t) {
        /**
         * delete from turma where _id = ?
         */
        String[] argumentosWhere = new String[] { Long.toString(t.getId()) };
        int quantidadeRegistrosExcluidos =
                database.delete(NOME_TABELA, "_id = ?", argumentosWhere);

        return quantidadeRegistrosExcluidos == 1;
    }
}

