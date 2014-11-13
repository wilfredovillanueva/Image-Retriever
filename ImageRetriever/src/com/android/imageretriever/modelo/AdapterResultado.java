package com.android.imageretriever.modelo;

import java.util.ArrayList;

import com.android.imageretriever.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterResultado extends BaseAdapter{

	protected Activity activity;
	protected ArrayList<Resultado> items;

	public AdapterResultado(Activity activity, ArrayList<Resultado> items) {
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
		
		ViewHolder holder;
		
		//Asociamos el layout de la lista que hemos creado
		if(convertView == null){
			LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inf.inflate(R.layout.list_personas, null);
			holder = new ViewHolder();
			holder.dni = (TextView) convertView.findViewById(R.id.id);
			holder.nombres = (TextView) convertView.findViewById(R.id.nombre);
			holder.similaridad = (TextView) convertView.findViewById(R.id.similaridad);
			holder.foto = (ImageView) convertView.findViewById(R.id.foto);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		// Creamos un objeto resultado
		Resultado r = items.get(position);
		//r.crearImagen(r.getImagen());
		//Rellenamos el dni
		holder.dni.setText(r.getID());
		//Rellenamos el nombre
		holder.nombres.setText(r.getIndividuo());
		//Rellenamos la similaridad
		holder.similaridad.setText(String.valueOf(r.getSimilaridad()));
		//Rellenamos la fotografía
		
		if (holder.foto != null){
			r.descargarImagen(holder.foto, r.getUrl());
		}
		

		// Retornamos la vista
		return convertView;
	}
	
	static class ViewHolder {
		ImageView foto;
		TextView dni;
		TextView nombres;
		TextView similaridad;
	}
}