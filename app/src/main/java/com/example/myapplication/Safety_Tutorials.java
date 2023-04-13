package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Safety_Tutorials extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Versions> versionsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_tutorials);

        recyclerView = findViewById(R.id.recycle_safety);

        initData();
        setRecyclerView();
    }

    private void setRecyclerView(){
        VersionsAdapter versionsAdapter = new VersionsAdapter(versionsList);
        recyclerView.setAdapter(versionsAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData(){
        versionsList = new ArrayList<>();

        versionsList.add(new Versions("Self Defence for Women","Training","Watch Video","Focus on your attacker’s vulnerable places: eyes, nose, throat, and groin. Aim all of the moves below at one or several of these areas to have maximum impact.\nUse all of your force and aggression during execution. Make it known that you’re a powerful lady. Use your voice, too. Be loud to intimidate the attacker and create attention in case somebody is nearby." ));
        versionsList.add(new Versions(" preventing sexual harassment","Training","Watch Video","According to various studies and reports, sexual harassment and assault are significant problems in the military, with a high number of incidents going unreported. These experiences can have a devastating impact on the lives and well-being of survivors, as well as erode trust and undermine unit cohesion.\n" +
                "\n" +
                "Therefore, there is a need to address this issue through various measures such as prevention programs, clear reporting and accountability systems, and support services for survivors. The military has implemented various measures over the years, such as training for leaders, enhanced victim advocacy and support, and disciplinary actions against perpetrators. However, there is still much work to be done to ensure that the military is a safe and inclusive environment for all service members." ));
        versionsList.add(new Versions(" impact of the COVID-19 pandemic on women's safety","Training","Watch Video","The COVID-19 pandemic has had a significant impact on women's safety. Lockdowns, social distancing measures, and economic instability have led to an increase in gender-based violence and other safety concerns for women around the world. Here are some specific ways that the pandemic has affected women's safety: \n" + "\n"+ "1) Increased domestic violence \n"+"2) Challenges accessing support services\n"+"3) Economic insecurity \n"+"4) Cyber harassment\n"+"5) Healthcare access" ));
        versionsList.add(new Versions("impact of public transportation","Training","Watch Video","Women may experience various forms of harassment, violence, and insecurity while traveling on public transport, which can restrict their mobility and access to economic opportunities. For example, if a woman feels unsafe using public transportation, she may avoid traveling alone, which can limit her ability to attend job interviews or work-related events. Additionally, if women have to take longer routes or use expensive modes of transportation to avoid unsafe areas, it can result in financial burden and restrict their economic opportunities. The topic also explores potential solutions and interventions to make public transportation safer and more accessible for women, such as increased lighting, the presence of security personnel, and gender-sensitive policies and programs." ));
        versionsList.add(new Versions(" impact of social media on women's safety","Training","Watch Video","One aspect of this topic is the spread of harmful stereotypes and misinformation through social media. For example, some platforms can perpetuate harmful and unrealistic beauty standards, which can negatively impact women's self-esteem and mental health. Social media can also perpetuate harmful stereotypes about women's roles and capabilities, which can limit their opportunities and undermine their safety.\n" +
                "\n" +
                "Another aspect of this topic is online harassment, which can include cyberbullying, stalking, and threats of violence. Women are often disproportionately targeted by online harassment, and the harassment can have serious consequences for their mental health, personal safety, and professional opportunities. Strategies for addressing online harassment include developing more effective reporting and enforcement mechanisms, promoting digital literacy and online safety skills, and building supportive online communities." ));
        versionsList.add(new Versions("online harassment and cyberstalking","Training","Watch Video","Focus on your attacker’s vulnerable places: eyes, nose, throat, and groin. Aim all of the moves below at one or several of these areas to have maximum impact.\nUse all of your force and aggression during execution. Make it known that you’re a powerful lady. Use your voice, too. Be loud to intimidate the attacker and create attention in case somebody is nearby." ));
        versionsList.add(new Versions("Addressing gender-based violence","Training","Watch Video","Focus on your attacker’s vulnerable places: eyes, nose, throat, and groin. Aim all of the moves below at one or several of these areas to have maximum impact.\nUse all of your force and aggression during execution. Make it known that you’re a powerful lady. Use your voice, too. Be loud to intimidate the attacker and create attention in case somebody is nearby." ));
    }
}