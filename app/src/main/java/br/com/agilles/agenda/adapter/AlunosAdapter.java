package br.com.agilles.agenda.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.agilles.agenda.ListaAlunosActivity;
import br.com.agilles.agenda.R;
import br.com.agilles.agenda.modelo.Aluno;

/**
 * Created by Jilles on 26/02/2017.
 */

public class AlunosAdapter extends BaseAdapter {


    private final List<Aluno> alunos;
    private final Context context;

    public AlunosAdapter(Context context, List<Aluno> listaAlunos) {
        this.context = context;
        this.alunos = listaAlunos;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = alunos.get(position);
        View view = convertView;
        LayoutInflater inflater = LayoutInflater.from(context);

        if (view == null) {
            view = inflater.inflate(R.layout.list_item, parent, false);

        }
        ImageView campoFoto = (ImageView) view.findViewById(R.id.item_foto);
        TextView nome = (TextView) view.findViewById(R.id.item_nomeAluno);
        TextView tel = (TextView) view.findViewById(R.id.item_telAluno);

        nome.setText(aluno.getNome());
        tel.setText(aluno.getTelefone());
        String caminhoFoto = aluno.getCaminhoFoto();
        if (caminhoFoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            campoFoto.setImageBitmap(bitmapReduzido);
            campoFoto.setScaleType(ImageView.ScaleType.FIT_XY);

        }
        return view;
    }
}
