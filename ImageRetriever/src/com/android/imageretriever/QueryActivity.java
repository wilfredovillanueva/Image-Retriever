package com.android.imageretriever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;


import com.android.imageretriever.R.array;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class QueryActivity extends Activity {
	// Ojos
	private Spinner ojosTipo;
	private Spinner ojosColor;
	private Spinner ojosTamaño;
	private Spinner ojosLesion;
	
	// Rostro
	private Spinner rostroForma;
	private Spinner rostroTamaño;
	private Spinner rostroColor;
	private Spinner rostroRaza;
	
	// Cabello
	private Spinner cabelloTamaño;
	private Spinner cabelloColor;
	private Spinner cabelloForma;
	private Spinner cabelloTinte;
	
	// Otros
	private Spinner narizForma;
	private Spinner narizRinomegalia;
	private Spinner narizRaza;
	private Spinner labiosForma;
	private Spinner cejasForma;
	private Spinner orejasForma;
	private Spinner frenteForma;
	private Spinner cabezaTamaño;
	
	// Caracteristicas adicionales
	private Spinner pomulos;
	private Spinner pecas;
	private Spinner cicatrices;
	private Spinner bigotes;
	private Spinner barba;
	
	private String OJOS_TIPO;
	private String OJOS_COLOR;
	private String OJOS_TAMANIO;
	private String OJOS_LESION;
	private String ROSTRO_FORMA;
	private String ROSTRO_TAMANIO;
	private String ROSTRO_COLOR;
	private String ROSTRO_RAZA;
	private String CABELLO_TAMANIO;
	private String CABELLO_COLOR;
	private String CABELLO_FORMA;
	private String TIENE_TINTE;
	private String NARIZ_FORMA;
	private String NARIZ_RINOMEGALIA;
	private String NARIZ_RAZA;
	private String LABIOS;
	private String CEJAS;
	private String OREJAS;
	private String FRENTE;
	private String CABEZA;
	private String POMULOS;
	private String PECASGRANOS;
	private String CICATRICES;
	private String BIGOTES;
	private String BARBA;
	
	private int[] cantidadCaracteristicas = new int[25];
	private int[] caracteristicasFisicas = new int[25];
	private int[] caracteristicasConvertido;
	
	private static final String TAG = "QueryActivity";
	// Direccion URL  DEL servidor que aloja el servicio
	private static final String SERVICE_URL = "http://192.168.1.44:8080/SRImagenes/rest/individuos";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.query_activity);
		
		llenarPorDefecto();
	}
	
	protected void llenarPorDefecto(){
		
		int index = 0;
		
		// Ojos
		ojosTipo = (Spinner) findViewById(R.id.ojos_tipo_spinner);
		llenar(ojosTipo, R.array.ojos_tipo);
		ojosTipo.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				cantidadCaracteristicas[0] = parent.getCount() - 1;
				caracteristicasFisicas[0] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ojosColor = (Spinner) findViewById(R.id.ojos_color_spinner);
		llenar(ojosColor, R.array.ojo_color);
		ojosColor.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[1] = parent.getCount() - 1;
				caracteristicasFisicas[1] = position;
				System.out.println("caracteristica " + caracteristicasFisicas[1]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ojosTamaño = (Spinner) findViewById(R.id.ojos_tamanio_spinner);
		llenar(ojosTamaño, R.array.ojos_tamanio);
		ojosTamaño.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[2] = parent.getCount() - 1;
				caracteristicasFisicas[2] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ojosLesion = (Spinner) findViewById(R.id.ojos_lesion_spinner);
		llenar(ojosLesion, R.array.ojos_lesion);
		ojosLesion.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[3] = parent.getCount() - 1;
				caracteristicasFisicas[3] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Rostro
		rostroForma = (Spinner) findViewById(R.id.rostro_forma_spinner);
		llenar(rostroForma, R.array.rostro_forma);
		rostroForma.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[4] = parent.getCount() - 1;
				caracteristicasFisicas[4] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		rostroTamaño = (Spinner) findViewById(R.id.rostro_tamanio_spinner);
		llenar(rostroTamaño, R.array.rostro_tamanio);
		rostroTamaño.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[5] = parent.getCount() - 1;
				caracteristicasFisicas[5] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		rostroColor = (Spinner) findViewById(R.id.rostro_color_spinner);
		llenar(rostroColor, R.array.rostro_color);
		rostroColor.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[6] = parent.getCount() - 1;
				caracteristicasFisicas[6] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		rostroRaza = (Spinner) findViewById(R.id.rostro_raza_spinner);
		llenar(rostroRaza, R.array.rostro_raza);
		rostroRaza.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[7] = parent.getCount() - 1;
				caracteristicasFisicas[7] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Cabello
		cabelloTamaño = (Spinner) findViewById(R.id.cabello_tamanio_spinner);
		llenar(cabelloTamaño, R.array.cabello_tamanio);
		cabelloTamaño.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[8] = parent.getCount() - 1;
				caracteristicasFisicas[8] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		cabelloColor = (Spinner) findViewById(R.id.cabello_color_spinner);
		llenar(cabelloColor, R.array.cabello_color);
		cabelloColor.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[9] = parent.getCount() - 1;
				caracteristicasFisicas[9] = position;
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		       
		
		cabelloForma = (Spinner) findViewById(R.id.cabello_forma_spinner);
		llenar(cabelloForma, R.array.cabello_forma);
		cabelloForma.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[10] = parent.getCount() - 1;
				caracteristicasFisicas[10] = position;
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		
		});

		cabelloTinte = (Spinner) findViewById(R.id.cabello_tinte_spinner);
		llenar(cabelloTinte, R.array.cabello_tinte);
		cabelloTinte.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[11] = parent.getCount() - 1;
				caracteristicasFisicas[11] = position;
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		narizForma = (Spinner) findViewById(R.id.nariz_forma_spinner);
		llenar(narizForma, R.array.nariz_forma);
		narizForma.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[12] = parent.getCount() - 1;
				caracteristicasFisicas[12] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		narizRinomegalia = (Spinner) findViewById(R.id.nariz_rinomegalia_spinner);
		llenar(narizRinomegalia, R.array.nariz_rinomegalia);
		narizRinomegalia.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[13] = parent.getCount() - 1;
				caracteristicasFisicas[13] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		narizRaza = (Spinner) findViewById(R.id.nariz_raza_spinner);
		llenar(narizRaza, R.array.nariz_raza);
		narizRaza.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[14] = parent.getCount() - 1;
				caracteristicasFisicas[14] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		labiosForma = (Spinner) findViewById(R.id.otros_labios_spinner);
		llenar(labiosForma, R.array.otros_labios);
		labiosForma.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[15] = parent.getCount() - 1;
				caracteristicasFisicas[15] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		cejasForma = (Spinner) findViewById(R.id.otros_cejas_spinner);
		llenar(cejasForma, R.array.otros_cejas);
		cejasForma.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[16] = parent.getCount() - 1;
				caracteristicasFisicas[16] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		orejasForma = (Spinner) findViewById(R.id.otros_orejas_spinner);
		llenar(orejasForma, R.array.otros_orejas);
		orejasForma.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[17] = parent.getCount() - 1;
				caracteristicasFisicas[17] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		frenteForma = (Spinner) findViewById(R.id.otros_frente_spinner);
		llenar(frenteForma, R.array.otros_frente);
		frenteForma.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[18] = parent.getCount() - 1;
				caracteristicasFisicas[18] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		cabezaTamaño = (Spinner) findViewById(R.id.otros_cabeza_spinner);
		llenar(cabezaTamaño, R.array.otros_cabeza);
		cabezaTamaño.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[19] = parent.getCount() - 1;
				caracteristicasFisicas[19] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		pomulos = (Spinner) findViewById(R.id.otros_pomulos_spinner);
		llenar(pomulos, R.array.otros_pomulos);
		pomulos.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[20] = parent.getCount() - 1;
				caracteristicasFisicas[20] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		pecas = (Spinner) findViewById(R.id.otros_pecas_granos_spinner);
		llenar(pecas, R.array.otros_pecas_granos);
		pecas.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[21] = parent.getCount() - 1;
				caracteristicasFisicas[21] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		cicatrices = (Spinner) findViewById(R.id.otros_cicatrices_spinner);
		llenar(cicatrices, R.array.otros_cicatrices);
		cicatrices.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[22] = parent.getCount() - 1;
				caracteristicasFisicas[22] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bigotes = (Spinner) findViewById(R.id.otros_bigotes_spinner);
		llenar(bigotes, R.array.otros_bigotes);
		bigotes.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[23] = parent.getCount() - 1;
				caracteristicasFisicas[23] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		barba = (Spinner) findViewById(R.id.otros_barba_spinner);
		llenar(barba, R.array.otros_barba);
		barba.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				cantidadCaracteristicas[24] = parent.getCount() - 1;
				caracteristicasFisicas[24] = position;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	protected void llenar(Spinner spinner, int arrayValues){
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				arrayValues, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}
	
	public int totalCaracteristicas(){
		int suma = 0;
		for(int i = 0; i < cantidadCaracteristicas.length; i++){
			suma = suma + cantidadCaracteristicas[i];
		}
		return suma;
	}
	
	public void consultar(View view){
		//obtenerCaracteristicas();
		System.out.println("\nconsultando...");
		convertir();
		
		OJOS_TIPO = String.valueOf(caracteristicasConvertido[0]);
		OJOS_COLOR = String.valueOf(caracteristicasConvertido[1]);
		OJOS_TAMANIO = String.valueOf(caracteristicasConvertido[2]);
		OJOS_LESION = String.valueOf(caracteristicasConvertido[3]);
		ROSTRO_FORMA = String.valueOf(caracteristicasConvertido[4]);
		ROSTRO_TAMANIO = String.valueOf(caracteristicasConvertido[5]);
		ROSTRO_COLOR = String.valueOf(caracteristicasConvertido[6]);
		ROSTRO_RAZA = String.valueOf(caracteristicasConvertido[7]);
		CABELLO_TAMANIO = String.valueOf(caracteristicasConvertido[8]);
		CABELLO_COLOR = String.valueOf(caracteristicasConvertido[9]);
		CABELLO_FORMA = String.valueOf(caracteristicasConvertido[10]);
		TIENE_TINTE = String.valueOf(caracteristicasConvertido[11]);
		NARIZ_FORMA = String.valueOf(caracteristicasConvertido[12]);
		NARIZ_RINOMEGALIA = String.valueOf(caracteristicasConvertido[13]);
		NARIZ_RAZA = String.valueOf(caracteristicasConvertido[14]);
		LABIOS = String.valueOf(caracteristicasConvertido[15]);
		CEJAS = String.valueOf(caracteristicasConvertido[16]);
		OREJAS = String.valueOf(caracteristicasConvertido[17]);
		FRENTE = String.valueOf(caracteristicasConvertido[18]);
		CABEZA = String.valueOf(caracteristicasConvertido[19]);
		POMULOS = String.valueOf(caracteristicasConvertido[20]);
		PECASGRANOS = String.valueOf(caracteristicasConvertido[21]);
		CICATRICES = String.valueOf(caracteristicasConvertido[22]);
		BIGOTES = String.valueOf(caracteristicasConvertido[23]);
		BARBA = String.valueOf(caracteristicasConvertido[24]);
		
		getData(view);
	}
	
	public void getData(View v) {
		String sampleURL = SERVICE_URL + "/resultados?";

		WebServiceTask wst = new WebServiceTask(WebServiceTask.GET_TASK, this, "recibiendo datos...");
		
		String atributos = "ojosTipo=" + OJOS_TIPO + "&"
				+ "ojosColor=" + OJOS_COLOR + "&" 
				+ "ojosTamanio=" + OJOS_TAMANIO + "&"
				+ "ojosLesion=" + OJOS_LESION + "&"
				+ "rostroForma=" + ROSTRO_FORMA + "&"
				+ "rostroTamanio=" + ROSTRO_TAMANIO + "&"
				+ "rostroColor=" + ROSTRO_COLOR + "&"
				+ "rostroRaza=" + ROSTRO_RAZA + "&"
				+ "cabelloTamanio=" + ROSTRO_TAMANIO + "&"
				+ "cabelloColor=" + CABELLO_COLOR + "&"
				+ "cabelloForma=" + CABELLO_FORMA + "&"
				+ "tieneTinte=" + TIENE_TINTE + "&"
				+ "narizForma=" + NARIZ_FORMA + "&"
				+ "narizRinomegalia=" + NARIZ_RINOMEGALIA + "&"
				+ "narizRaza=" + NARIZ_RAZA + "&"
				+ "labios=" + LABIOS + "&"
				+ "cejas=" + CEJAS + "&"
				+ "orejas=" + OREJAS + "&"
				+ "frente=" + FRENTE + "&"
				+ "cabeza=" + CABEZA + "&"
				+ "pomulos=" + POMULOS + "&"
				+ "pecasgranos=" + PECASGRANOS + "&"
				+ "cicatrices=" + CICATRICES + "&"
				+ "bigotes=" + BIGOTES + "&"
				+ "barba=" + BARBA;
		
		sampleURL = sampleURL + atributos;
        
		wst.execute(new String[] { sampleURL });
	}
	
	public void convertir() {
		// TODO Auto-generated method stub
		caracteristicasConvertido = new int[25];
		for(int i = 0; i < caracteristicasFisicas.length; i++){
			if(caracteristicasFisicas[i] != 0)
				caracteristicasConvertido[i] = caracteristicasFisicas[i] + sumaAnteriores(cantidadCaracteristicas, i);
		}
	}

	public int sumaAnteriores(int[] X, int pos) {
		// TODO Auto-generated method stub
		int suma = 0;
		if(pos <= X.length){
			for(int i = 0; i < pos; i++){
				suma = suma + X[i];
			}
		}
		return suma;
	}

	public void postData(View vw){
        System.out.println("postData()");
//        if (firstName.equals("") || lastName.equals("") || email.equals("")) {
//            Toast.makeText(this, "Please enter in all required fields.",
//                    Toast.LENGTH_LONG).show();
//            return;
//        }
        
        WebServiceTask wst = new WebServiceTask(WebServiceTask.POST_TASK, this, "Posting data...");
        
        
        
        wst.addNameValuePair("ojosTipo", OJOS_TIPO);
        wst.addNameValuePair("ojosColor", OJOS_COLOR);
        wst.addNameValuePair("ojosTamanio", OJOS_TAMANIO);
        wst.addNameValuePair("ojosLesion", OJOS_LESION);
        wst.addNameValuePair("rostroForma", ROSTRO_FORMA);
        wst.addNameValuePair("rostroTamanio", ROSTRO_TAMANIO);
        wst.addNameValuePair("rostroColor", ROSTRO_COLOR);
        wst.addNameValuePair("rostroRaza", ROSTRO_RAZA);
        wst.addNameValuePair("cabelloTamanio", CABELLO_TAMANIO);
        wst.addNameValuePair("cabelloColor", CABELLO_COLOR);
        wst.addNameValuePair("cabelloForma", CABELLO_FORMA);
        wst.addNameValuePair("tieneTinte", TIENE_TINTE);
        wst.addNameValuePair("narizForma", NARIZ_FORMA);
        wst.addNameValuePair("narizRinomegalia", NARIZ_RINOMEGALIA);
        wst.addNameValuePair("narizRaza", NARIZ_RAZA);
        wst.addNameValuePair("labios", LABIOS);
        wst.addNameValuePair("cejas", CEJAS);
        wst.addNameValuePair("orejas", OREJAS);
        wst.addNameValuePair("frente", FRENTE);
        wst.addNameValuePair("cabeza", CABEZA);
        wst.addNameValuePair("pomulos", POMULOS);
        wst.addNameValuePair("pecasgranos", PECASGRANOS);
        wst.addNameValuePair("cicatrices", CICATRICES);
        wst.addNameValuePair("bigotes", BIGOTES);
        wst.addNameValuePair("barba", BARBA);
        
        // the passed String is the URL we will POST to
        wst.execute(new String[] { SERVICE_URL });
	}
	
//	public ArrayList<String> obtenerCaracteristicas(){
//		ArrayList<String> caracteristicas;
//		caracteristicas.add(cabelloTamaño.);
//		return caracteristicas;
//	}
	
	private class WebServiceTask extends AsyncTask<String, Integer, String> {
		
		public static final int POST_TASK = 1;
	    public static final int GET_TASK = 2;
	    
	    private int taskType = GET_TASK;
	    private static final String TAG = "WebServiceTask";
	    private Context mContext = null;
	    private String processMessage = "Processing...";
		
		// connection timeout, in milliseconds (waiting to connect)
	    private static final int CONN_TIMEOUT = 3000;
	     
	    // socket timeout, in milliseconds (waiting for data)
	    private static final int SOCKET_TIMEOUT = 7000;
	    
	    private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
	    
	    private ProgressDialog pDlg = null;
	    
	    public WebServiceTask(int taskType, Context mContext, String processMessage) {
	    	System.out.println("WebServiceTask(" + taskType + ")");
            this.taskType = taskType;
            this.mContext = mContext;
            this.processMessage = processMessage;
        }
	    
	    public void addNameValuePair(String name, String value) {
	    	params.add(new BasicNameValuePair(name, value));
			
		}

		protected void onPreExecute() {
			System.out.println("onPreExecute("+taskType+")");
	        //hideKeyboard();
	        showProgressDialog();
	    }

		private void showProgressDialog() {
			pDlg = new ProgressDialog(mContext);
	        pDlg.setMessage(processMessage);
	        //pDlg.setProgressDrawable(mContext.getWallpaper());
	        pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        pDlg.setCancelable(false);
	        pDlg.show();
		}

		protected String doInBackground(String... urls) {
			System.out.println("doInBackground("+taskType+")");
			// TODO Auto-generated method stub
			String url = urls[0];
			String result = "";
			
			HttpResponse response = doResponse(url);
			
			if (response == null) {
	            return result;
	        } else {
	        	try {

	                result = inputStreamToString(response.getEntity().getContent());

	            } catch (IllegalStateException e) {
	                Log.e(TAG, e.getLocalizedMessage(), e);

	            } catch (IOException e) {
	                Log.e(TAG, e.getLocalizedMessage(), e);
	            }
	        }
			return result;
		}
		
		protected void onPostExecute(String response) {
			System.out.println("onPostExecute()");
	        pDlg.dismiss();
	        System.out.println("response = " + response);
	        nuevoIntent(response);
	    }

		private String inputStreamToString(InputStream is) {
			String line = "";
	        StringBuilder total = new StringBuilder();
	        
	        // Wrap a BufferedReader around the InputStream
	        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	        try {
	            // Read response until the end
	            while ((line = rd.readLine()) != null) {
	                total.append(line);
	            }
	        } catch (IOException e) {
	            Log.e(TAG, e.getLocalizedMessage(), e);
	        }
	        
	        // Return full string
	        return total.toString();
		}

		private HttpResponse doResponse(String url) {
			// Use our connection and data timeouts as parameters for our
	        // DefaultHttpClient
			HttpClient httpclient = new DefaultHttpClient(getHttpParams());
			HttpResponse response = null;
			
			try {
	            switch (taskType) {

	            case POST_TASK:
	                HttpPost httppost = new HttpPost(url);
	                // Add parameters
	                httppost.setEntity(new UrlEncodedFormEntity(params));

	                response = httpclient.execute(httppost);
	                break;
	            case GET_TASK:
	                HttpGet httpget = new HttpGet(url);
	                response = httpclient.execute(httpget);
	                System.out.println("response: " + response);
	                break;
	            }
	        } catch(Exception e){
	        	Log.e(TAG, e.getLocalizedMessage(), e);
			}
			return response;
		}
		
		// Establish connection and socket (data retrieval) timeouts
		private HttpParams getHttpParams() {
			// TODO Auto-generated method stub
			HttpParams htpp = new BasicHttpParams();
			
			HttpConnectionParams.setConnectionTimeout(htpp, CONN_TIMEOUT);
	        HttpConnectionParams.setSoTimeout(htpp, SOCKET_TIMEOUT);
			
			return htpp;
		}
		
	}
	
	public void nuevoIntent(String response){
		Intent i = new Intent(this, ListActivity.class);
		i.putExtra("response", response);
		startActivity(i);
	}

}
