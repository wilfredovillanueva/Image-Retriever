package com.android.imageretriever;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.imageretriever.R;
import com.android.imageretriever.modelo.AdapterIndividuo;
import com.android.imageretriever.modelo.Individuo;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity);
		
		ListView lista = (ListView) findViewById(R.id.listaPersonas);
		ArrayList<Individuo> arrayper = new ArrayList<Individuo>();
		Individuo individuo;
		
		// Introduzco los datos
//		individuo = new Individuo(Long.parseLong("65646363"), getResources().getDrawable(R.drawable.persona001_min), 
//				"Jorge Luis", "Rodriguez", "Cabrera", "03-05-1984", "Masculino", "Jr Los Manzanos 1234, La Victoria");
//		arrayper.add(individuo);
//		individuo = new Individuo(Long.parseLong("65646363"), getResources().getDrawable(R.drawable.persona003_min), 
//				"Sebastian Jose", "Castro", "Gutierrez", "10-02-1980", "Masculino", "Av Tomas Valle 1234, San Martin de Porres");
//		arrayper.add(individuo);
//		individuo = new Individuo(Long.parseLong("65646363"), getResources().getDrawable(R.drawable.persona004_min), 
//				"Peter Javier", "Suarez", "Caceres", "02-11-1983", "Masculino", "Jr Las Gaviotas 134, Callao");
//		arrayper.add(individuo);
//		individuo = new Individuo(Long.parseLong("65646363"), getResources().getDrawable(R.drawable.persona005_min), 
//				"Jorge Luis", "Rodriguez", "Cabrera", "03-05-1984", "Masculino", "Jr Los Manzanos 1234, La Victoria");
//		arrayper.add(individuo);
//		individuo = new Individuo(Long.parseLong("65646363"), getResources().getDrawable(R.drawable.persona006_min), 
//				"Jorge Luis", "Rodriguez", "Cabrera", "03-05-1984", "Masculino", "Jr Los Manzanos 1234, La Victoria");
//		arrayper.add(individuo);
		
		// Creo el adapter personalizado
		AdapterIndividuo adapter = new AdapterIndividuo(this, arrayper);
		
		// Lo aplico
		lista.setAdapter(adapter);

	}
	
	

}
