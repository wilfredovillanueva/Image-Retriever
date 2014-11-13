package com.android.imageretriever.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;

import com.android.imageretriever.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class Resultado {
	String ID;
	String individuo;
	String imagen;
	Bitmap foto;
	double similaridad;
	String IMAGE_URL = "http://192.168.1.44:8080/SRImagenes/resources/";

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getIndividuo() {
		return individuo;
	}

	public void setIndividuo(String individuo) {
		this.individuo = individuo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getSimilaridad() {
		return similaridad;
	}

	public void setSimilaridad(double similaridad) {
		this.similaridad = similaridad;
	}

	public Bitmap getFoto() {
		return foto;
	}

	public void setFoto(Bitmap foto) {
		this.foto = foto;
	}
	
	public String getUrl(){
		return IMAGE_URL + imagen;
	}
	
	public void descargarImagen(ImageView v, String url){
		new DescargarImagenTask(v).execute(url);
	}
	
	private class DescargarImagenTask extends AsyncTask<String, Integer, Bitmap> {
		
		private final WeakReference imageViewReference;
		
		public DescargarImagenTask(ImageView imagen){
			imageViewReference = new WeakReference(imagen);
		}
		
	    @Override
	    // Actual download method, run in the task thread
	    protected Bitmap doInBackground(String... params) {
	    	// params comes from the execute() call: params[0] is the url.
	    	return descargarImagen(params[0]);
	    }
	    
	    @Override
	    // Once the image is downloaded, associates it to the imageView
	    protected void onPostExecute(Bitmap bitmap){
	    	
	    	if (isCancelled())
	    		bitmap = null;
	    	
	    	if (imageViewReference != null){
	    		ImageView imagen = (ImageView) imageViewReference.get();
	    		
	    		if (imagen != null){
	    			if (bitmap != null) {
	    				Bitmap miniatura = ThumbnailUtils.extractThumbnail(bitmap, 100, 100);
	    				imagen.setImageBitmap(miniatura);
	    			} else {
	    				imagen.setImageDrawable(imagen.getContext().getResources().getDrawable(R.drawable.ic_launcher));
	    			}
	    		}
	    	}
	    }
	    
	    public Bitmap descargarImagen(String url){
	    	final AndroidHttpClient cliente = AndroidHttpClient.newInstance("Android");
	    	final HttpGet getRequest = new HttpGet(url);
	    	
	    	try {
	    		HttpResponse response = cliente.execute(getRequest);
	    		final int statusCode = response.getStatusLine().getStatusCode();
	    		
	    		if(statusCode != HttpStatus.SC_OK){
	    			Log.w("ImageDownloader", "Error " + statusCode
							+ " while retrieving bitmap from " + url);
	    			return null;
	    		}
	    		
	    		final HttpEntity entity = response.getEntity();
	    		if(entity != null){
	    			InputStream is = null;
	    			
	    			try {
	    				is = entity.getContent();
	    				final Bitmap bitmap = BitmapFactory.decodeStream(is);
	    				return bitmap;
	    			} finally {
	    				if (is != null){
	    					is.close();
	    				}
	    				entity.consumeContent();
	    			}
	    		}
	    	} catch (Exception e) {
	    		// Could provide a more explicit error message for IOException or
				// IllegalStateException
	    		getRequest.abort();
	    		Log.w("ImageDownloader", "Error while retrieving bitmap from " + url);
	    	} finally {
	    		if(cliente != null){
	    			cliente.close();
	    		}
	    	}
	    	
	    	return null;
	    }
	}
	
}
