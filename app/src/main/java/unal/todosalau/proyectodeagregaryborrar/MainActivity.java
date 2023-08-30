package unal.todosalau.proyectodeagregaryborrar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList telefonos;
    private ArrayAdapter adaptador1;
    private ListView lv1;
    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telefonos=new ArrayList();
        telefonos.add("Freddy: 1010101010");
        telefonos.add("Luis : 20220202020");
        telefonos.add("Ana : 3030303030");
        adaptador1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,telefonos);
        lv1=findViewById(R.id.list1);
        lv1.setAdapter(adaptador1);

        et1=findViewById(R.id.editText);

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Eliminar este teléfono ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        telefonos.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
    }

    public void agregar(View v) {
        telefonos.add(et1.getText().toString());
        adaptador1.notifyDataSetChanged();
        et1.setText("");
    }
}