package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.IOException;
import java.io.InputStream;

public class MQTT_ACT extends AppCompatActivity {
    // Declarar variables de conexion.
    static String MQTTHOST ="tcp://tailor.cloudmqtt.com:13821";
    static String USERNAME ="axulyidb";
    static String PASSWORD ="CP-RoMoe__LT";
    String topicStr = "LIBROS";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt__act);

        String clientId = MqttClient.generateClientId();

        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Toast.makeText(getBaseContext(), "Se a conectado a mqtt", Toast.LENGTH_LONG).show();
                }
                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Toast.makeText(getBaseContext(), "No se a conectado a mqtt", Toast.LENGTH_LONG).show();
                }
            });


        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void farenheith_btn(View view){
        String topic = topicStr;
        String mgs = "FARENHEITH";

        try{
            client.publish(topic, mgs.getBytes(), 0, false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void revival_btn(View view){
        String topic = topicStr;
        String mgs = "REVIVAL";

        try{
            client.publish(topic, mgs.getBytes(), 0, false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void alquimista_btn(View view){
        String topic = topicStr;
        String mgs = "EL ALQUIMISTA";

        try{
            client.publish(topic, mgs.getBytes(), 0, false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void poder_btn(View view){
        String topic = topicStr;
        String mgs = "EL PODER";

        try{
            client.publish(topic, mgs.getBytes(), 0, false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void despertar_btn(View view){
        String topic = topicStr;
        String mgs = "EL DESPERTAR";

        try{
            client.publish(topic, mgs.getBytes(), 0, false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
