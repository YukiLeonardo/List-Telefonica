package br.unigran.BancoDados;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import br.unigran.listatelefonica.Contatos;

public class ContatoDB {
    private SQLiteDatabase conexao;
    public void inserir(Contatos contatos, DBHelper dbHelper){
        conexao = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome",contatos.getNome());
        valores.put("telefone",contatos.getTelefone());
        valores.put("datanasc",contatos.getDatanasc());
        conexao.insertOrThrow("BancoLista",null,valores);
        conexao.close();
    }
}
