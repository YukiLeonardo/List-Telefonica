package br.unigran.listatelefonica;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.unigran.BancoDados.ContatoDB;
import br.unigran.BancoDados.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText telefone;
    EditText datanasc;
    ListView listagem;
    List<Contatos> dados;
    DBHelper dbHelper;
    ContatoDB contatoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DBHelper(this);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.id_nome);
        telefone = findViewById(R.id.id_telefone);
        datanasc = findViewById(R.id.id_datanasc);
        listagem = findViewById(R.id.id_list);

        dados = new ArrayList();

        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dados);
        listagem.setAdapter(adapter);

        contatoDB = new ContatoDB(dbHelper);
        contatoDB.lista(dados);
        acoes();
    }
        private void acoes(){
            listagem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long k) {
                    AlertDialog.Builder alert =
                            new AlertDialog.Builder(getApplicationContext());
                    alert.setMessage("Confirmar");
                    alert.setPositiveButton("remover",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int k) {
                                    contatoDB.remover(dados.get(i).getId());
                                    contatoDB.lista(dados);
                                }
                            });
                    alert.create().show();
                    return false;
                }
            });

}

    Contatos contatos;
    public void salvar(View view){
        if(contatos==null)
            contatos = new Contatos();
        contatos.setNome(nome.getText().toString());
        contatos.setTelefone(telefone.getText().toString());
        contatos.setDatanasc(datanasc.getText().toString());

        contatoDB.inserir(contatos);
        contatoDB.lista(dados);

        contatos=null;

        Toast.makeText(this,"Salvo com Sucesso!", Toast.LENGTH_LONG)
                .show();
    }

}

