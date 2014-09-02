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
	
	private String cabelloT;
	private String cabelloF;
	private String cabelloC;
	private String pielC;
	private String ojosC;
	
	private int[] cantidadCaracteristicas = new int[12];
	private int[] caracteristicasFisicas = new int[12];
	
	private static final String TAG = "MainActivity";
	// Direccion URL  DEL servidor que aloja el servicio
	private static final String SERVICE_URL = "http://192.168.1.38:8080/SRImagenes/rest/individuos";

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
	
	public void consultar(View view){
		//obtenerCaracteristicas();
		int n = cantidadCaracteristicas.length;
		System.out.print("\ncantidad = ");
		for(int i = 0; i < n; i++){
			System.out.print(cantidadCaracteristicas[i] + ", ");
		}
		n = caracteristicasFisicas.length;
		System.out.print("\n1 datos = ");
		for(int i = 0; i < n; i++){
			System.out.print(caracteristicasFisicas[i] + ", ");
		}
		System.out.print("\nconvirtiendo....");
		convertir();
		System.out.println("convertido....");
		System.out.print("\n2 datos = ");
		for(int i = 0; i < n; i++){
			System.out.print(caracteristicasFisicas[i] + ", ");
		}
		System.out.println("convertido....");
		System.out.println("convertido....");
		postData(view);
		Intent i = new Intent(this, ListActivity.class);
		startActivity(i);
	}
	
	public void convertir() {
		// TODO Auto-generated method stub
		for(int i = 0; i < caracteristicasFisicas.length; i++){
			if(caracteristicasFisicas[i] != 0)
				caracteristicasFisicas[i] = caracteristicasFisicas[i] + sumaAnteriores(cantidadCaracteristicas, i);
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
        
//        if (firstName.equals("") || lastName.equals("") || email.equals("")) {
//            Toast.makeText(this, "Please enter in all required fields.",
//                    Toast.LENGTH_LONG).show();
//            return;
//        }
        
        WebServiceTask wst = new WebServiceTask(WebServiceTask.POST_TASK, this, "Posting data...");
        
        wst.addNameValuePair("cabelloTamanio", cabelloT);
        wst.addNameValuePair("cabelloForma", cabelloF);
        wst.addNameValuePair("cabelloColor", cabelloC);
        wst.addNameValuePair("rostroColor", pielC);
        wst.addNameValuePair("ojosColor", ojosC);
        
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
	    private static final int SOCKET_TIMEOUT = 5000;
	    
	    private ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
	    
	    private ProgressDialog pDlg = null;
	    
	    public WebServiceTask(int taskType, Context mContext, String processMessage) {
            this.taskType = taskType;
            this.mContext = mContext;
            this.processMessage = processMessage;
        }
	    
	    public void addNameValuePair(String name, String value) {
	    	params.add(new BasicNameValuePair(name, value));
			
		}

		protected void onPreExecute() {
	        //hideKeyboard();
	        showProgressDialog();
	    }

		private void showProgressDialog() {
			pDlg = new ProgressDialog(mContext);
	        pDlg.setMessage(processMessage);
	        pDlg.setProgressDrawable(mContext.getWallpaper());
	        pDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	        pDlg.setCancelable(false);
	        pDlg.show();
		}

		protected String doInBackground(String... urls) {
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
	        //handleResponse(response);
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
	        } catch(Exception e){
	        	Log.e(TAG, e.getLocalizedMessage(), e);
			}
			return null;
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

	public void handleResponse(String response) {
		try {
			JSONObject jso = new JSONObject(response);
			
			
		} catch (Exception e) {
			Log.e(TAG, e.getLocalizedMessage(), e);
		}
		
	}

}
