package com.android.imageretriever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.android.imageretriever.R;
import com.android.imageretriever.modelo.AdapterResultado;
import com.android.imageretriever.modelo.Individuo;
import com.android.imageretriever.modelo.Resultado;

public class ListActivity extends Activity {
	
	private ListView lista;
	private ArrayList<Individuo> arrayper = new ArrayList<Individuo>();
	private ArrayList<Resultado> listaResultados = new ArrayList<Resultado>();
	private Individuo individuo;
	private String dni = "";
	
	private static final String SERVICE_URL = "http://192.168.1.44:8080/SRImagenes/rest/individuos";
	private static final String TAG = "ListActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity);
		
		Bundle bundle = getIntent().getExtras();
		listaResultados = (ArrayList<Resultado>) handleResponse(bundle.getString("response"));
		
		lista = (ListView) findViewById(R.id.listaPersonas);
		//getData();
		//Introduzco los datos
		
//		individuo = new Individuo(listaResultados.get(0).getID(),
//		getResources().getDrawable(R.drawable.persona001_min),
//		listaResultados.get(0).getIndividuo(), "Rodriguez", "Cabrera", "03-05-1984", "Masculino",
//		"Jr Los Manzanos 1234, La Victoria");
//		arrayper.add(individuo);
//		 individuo = new Individuo(Long.parseLong("65646363"),
//		 getResources().getDrawable(R.drawable.persona003_min),
//		 "Sebastian Jose", "Castro", "Gutierrez", "10-02-1980", "Masculino",
//		 "Av Tomas Valle 1234, San Martin de Porres");
//		 arrayper.add(individuo);
//		 individuo = new Individuo(Long.parseLong("65646363"),
//		 getResources().getDrawable(R.drawable.persona004_min),
//		 "Peter Javier", "Suarez", "Caceres", "02-11-1983", "Masculino",
//		 "Jr Las Gaviotas 134, Callao");
//		 arrayper.add(individuo);
//		 individuo = new Individuo(Long.parseLong("65646363"),
//		 getResources().getDrawable(R.drawable.persona005_min),
//		 "Jorge Luis", "Rodriguez", "Cabrera", "03-05-1984", "Masculino",
//		 "Jr Los Manzanos 1234, La Victoria");
//		 arrayper.add(individuo);
//		 individuo = new Individuo(Long.parseLong("65646363"),
//		 getResources().getDrawable(R.drawable.persona006_min),
//		 "Jorge Luis", "Rodriguez", "Cabrera", "03-05-1984", "Masculino",
//		 "Jr Los Manzanos 1234, La Victoria");
//		 arrayper.add(individuo);

		// Creo el adapter personalizado
		AdapterResultado adapter;
		if (listaResultados != null){
			 adapter = new AdapterResultado(this, listaResultados);
			// Lo aplico
			lista.setAdapter(adapter);
		}
		
		
	}

	public void getData() {
		String sampleURL = SERVICE_URL + "/sample";

		WebServiceTask wst = new WebServiceTask(WebServiceTask.GET_TASK, this, "recibiendo datos...");

		wst.execute(new String[] { sampleURL });
	}

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
		private static final int SOCKET_TIMEOUT = 5000;

		private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();

		private ProgressDialog pDlg = null;

		public WebServiceTask(int taskType, Context mContext,
				String processMessage) {
			System.out.println("WebServiceTask(" + taskType + ")");
			this.taskType = taskType;
			this.mContext = mContext;
			this.processMessage = processMessage;
		}

//		public void addNameValuePair(String name, String value) {
//			params.add(new BasicNameValuePair(name, value));
//
//		}

		protected void onPreExecute() {
			System.out.println("onPreExecute(" + taskType + ")");
			// hideKeyboard();
			showProgressDialog();
		}

		private void showProgressDialog() {
			pDlg = new ProgressDialog(mContext);
			pDlg.setMessage(processMessage);
			// pDlg.setProgressDrawable(mContext.getWallpaper());
			pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pDlg.setCancelable(false);
			pDlg.show();
		}

		protected String doInBackground(String... urls) {
			System.out.println("doInBackground(" + taskType + ")");
			// TODO Auto-generated method stub
			String url = urls[0];
			String result = "";

			HttpResponse response = doResponse(url);

			if (response == null) {
				return result;
			} else {
				try {

					result = inputStreamToString(response.getEntity()
							.getContent());

				} catch (IllegalStateException e) {
					Log.e(TAG, e.getLocalizedMessage(), e);

				} catch (IOException e) {
					Log.e(TAG, e.getLocalizedMessage(), e);
				}
			}
			return result;
		}

		protected void onPostExecute(String response) {
			if (taskType == 2) {
				System.out.println("onPostExecute(" + taskType + ")");
				handleResponse(response);
			}
			pDlg.dismiss();
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
					break;
				}
			} catch (Exception e) {
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
	
	public List<Resultado> handleResponse(String response) {
		System.out.println("manejando el response...");
		List<Resultado> arrRes = new ArrayList<Resultado>();
		
		if (response != null){
			if(!response.equals("null")){
				
				if (response.contains("\"resultado\":[")){
		
					try {
						JSONObject jso = new JSONObject(response);
						JSONArray jsa = jso.getJSONArray("resultado");
						
						for(int i = 0; i < jsa.length(); i++){
							JSONObject jsox = jsa.getJSONObject(i);
							Resultado resultado = new Resultado();
							resultado.setID(jsox.getString("ID"));
							resultado.setImagen(jsox.getString("imagen"));
							resultado.setIndividuo(jsox.getString("individuo"));
							resultado.setSimilaridad(jsox.getDouble("similaridad"));
							arrRes.add(resultado);
							System.out.println("resultado " + (i+1));
							System.out.println("dni: " + jsox.getString("ID"));
							System.out.println("imagen: " + jsox.getString("imagen"));
						}
						
						
					} catch (Exception e) {
						Log.e(TAG, e.getLocalizedMessage(), e);
					}
				
				} else {
					try {
						JSONObject jso = new JSONObject(response);
						
						Resultado resultado = new Resultado();
						resultado.setID(jso.getJSONObject("resultado").getString("ID"));
						resultado.setImagen(jso.getJSONObject("resultado").getString("imagen"));
						resultado.setIndividuo(jso.getJSONObject("resultado").getString("individuo"));
						resultado.setSimilaridad(jso.getJSONObject("resultado").getDouble("similaridad"));
						arrRes.add(resultado);
						
					} catch (Exception e) {
						Log.e(TAG, e.getLocalizedMessage(), e);
					}
				}
				
				return arrRes;
			}
		}
		
		return null;
	}


}
