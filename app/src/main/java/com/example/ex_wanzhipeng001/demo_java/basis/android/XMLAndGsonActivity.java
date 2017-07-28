package com.example.ex_wanzhipeng001.demo_java.basis.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.ex_wanzhipeng001.demo_java.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class XMLAndGsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmland_gson);
        testXML();
        testGson();
    }

    private void testXML() {
        //PULL
        // TODO: 17/6/13
        //SAX
        // TODO: 17/6/13
    }

    private void testGson() {
        //JSONObject
        // TODO: 17/6/13
        //GSON
        Gson gson = new Gson();
        String string = "{\"name\":\"tom1\",\"age\":21}";
        String stringList = "[{\"name\":\"tom1\",\"age\":21},{\"name\":\"tom2\",\"age\":22},{\"name\":\"tom3\"," +
                "\"age\":23}]";
        Person person = gson.fromJson(string, Person.class);
        List<Person> personList = gson.fromJson(stringList, new TypeToken<List<Person>>(){}.getType());
        Log.d("XMLAndGsonActivity", person.getAge() +"===="+ person.getName());
        for (Person person1 : personList) {
            Log.d("XMLAndGsonActivity", person1.getAge() +"==list=="+ person1.getName());
        }
    }

    class Person{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        private  String name;
        private  int age;
    }
}
