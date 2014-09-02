package com.android.imageretriever.modelo;

import java.util.ArrayList;

import com.android.imageretriever.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterIndividuo extends BaseAdapter{

	protected Activity activity;
	protected ArrayList<Individuo> items;

	public AdapterIndividuo(Activity activity, ArrayList<Individuo> items) {
	    this.activity = activity;
	    this.items = items;
	  }

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int arg0) {
		return items.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		//return items.get(position).getDni();
		return 3;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// Generamos una convertView por motivos de eficiencia
		View v = convertView;
		
		//Asociamos el layout de la lista que hemos creado
		if(convertView == null){
			LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inf.inflate(R.layout.list_personas, null);
		}

		// Creamos un objeto persona
		Individuo i = items.get(position);
		//Rellenamos la fotografía
		ImageView foto = (ImageView) v.findViewById(R.id.foto);
		//foto.setImageDrawable(i.getImagen());
		//Rellenamos el nombre
		TextView nombres = (TextView) v.findViewById(R.id.nombres);
		nombres.setText(i.getNombres());
		//Rellenamos el apellido paterno
		TextView apellidoP = (TextView) v.findViewById(R.id.apellidoP);
		apellidoP.setText(i.getApellidoPaterno());
		//Rellenamos el apellido paterno
		TextView apellidoM = (TextView) v.findViewById(R.id.apellidoM);
		apellidoM.setText(i.getApellidoMaterno());
		//Rellenamos el dni
		TextView dni = (TextView) v.findViewById(R.id.dni);
		dni.setText(String.valueOf(i.getDni()));

		// Retornamos la vista
		return v;
	}
}