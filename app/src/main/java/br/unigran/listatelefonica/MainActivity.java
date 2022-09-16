package br.unigran.listatelefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.unigran.BancoDados.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText telefone;
    EditText datanasc;
    ListView listagem;
    List<Contatos> dados;
    DBHelper dbHelper;

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
    }
    public void salvar (View view){
        Contatos contatos = new Contatos();
        contatos.setNome (nome.getText().toString());
        contatos.setTelefone(telefone.getText().toString());
        contatos.setDatanasc(datanasc.getText().toString());
        dados.add(contatos);
        dbHelper.inserir(contatos,dbHelper);
        Toast.makeText(this,"Salvo com Sucesso!", Toast.LENGTH_LONG)
                .show();
    }

}

