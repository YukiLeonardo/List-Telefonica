package br.unigran.BancoDados;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.listatelefonica.Contatos;

public class ContatoDB {
    private DBHelper dbHelper;
    private SQLiteDatabase conexao;
    public ContatoDB(DBHelper dbHelper){
        this.dbHelper=dbHelper;
    }
        public void inserir(Contatos contatos){
            conexao = dbHelper.getWritableDatabase();//abre o bd
            ContentValues  valores = new ContentValues();
            valores.put("nome",contatos.getNome());
            valores.put("telefone",contatos.getTelefone());
            valores.put("datanasc", contatos.getDatanasc());
            conexao.insertOrThrow("Lista", null, valores);
            conexao.close();
        }


        public void atualizar(){}
        public void remover(int id){
            conexao=dbHelper.getWritableDatabase();
            conexao.delete("listatelefonica","id=?",
                    new String[]{id+""});
        }
        public void lista(List dados){
            dados.clear();
            conexao=dbHelper.getReadableDatabase();
            String names[]={"id","nome","telefone","datanasc"};
            Cursor query = conexao.query("listatelefonica", names,
                    null, null, null,
                    null, "nome");
            while (query.moveToNext()){
                Contatos contatos = new Contatos();
                contatos.setId(Integer.parseInt(
                        query.getString(0)));
                contatos.setNome(
                        query.getString(1));
                contatos.setTelefone(
                        query.getString(2));
                contatos.setDatanasc(
                        query.getString(3));
                dados.add(contatos);

            }
            conexao.close();
    }
}
