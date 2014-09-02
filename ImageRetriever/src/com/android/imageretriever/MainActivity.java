package com.android.imageretriever;

import com.android.imageretriever.R;
import com.android.imageretriever.modelo.Usuario;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText username;
	private EditText password;
	Usuario user1 = new Usuario(1, "user", "imgret");
	Usuario user2 = new Usuario(2, "user2", "pass2");
	Usuario user3 = new Usuario(3, "user3", "pass3");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
	}

	public void ingresar(View view){
		
		username = (EditText) findViewById(R.id.usuario);
		password = (EditText) findViewById(R.id.contrasena);
		
		if(username.getText().toString().equals(user1.getUsername()) && password.getText().toString().equals(user1.getPassword())){
			Intent i = new Intent(this, QueryActivity.class );
			startActivity(i);
		}
		else{
			Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta:\nusuario: " + username.getText().toString() + "\npass: " + password.getText().toString(), Toast.LENGTH_SHORT).show();
		}

	} 
	
}
