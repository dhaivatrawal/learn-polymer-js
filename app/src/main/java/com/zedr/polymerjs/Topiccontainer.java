package com.zedr.polymerjs;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import com.zedr.polymerjs.R;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class Topiccontainer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Context ctx=this;
    RecyclerView rectopic;
    ArrayList<Topic> topiclist=new ArrayList<>();
    private DrawerLayout mydraw;
    private ActionBarDrawerToggle mytoggle;
    NavigationView navigatinView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_topiccontainer);
        allocatememory();
        navigatinView.setItemIconTintList(null);
        navigatinView.setNavigationItemSelectedListener(this);
        mydraw=(DrawerLayout)findViewById(R.id.drawer);
        mytoggle=new ActionBarDrawerToggle(this,mydraw,R.string.open,R.string.close);
        mydraw.addDrawerListener(mytoggle);
        mytoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GetTopics();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mytoggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void GetTopics() {

        String[] topics=ctx.getResources().getStringArray(R.array.topic);
        String[] url=ctx.getResources().getStringArray(R.array.url);
        int size=topics.length;

        for (int i=0; i<size; i++)
        {
            Topic current=new Topic(topics[i],url[i]);
            topiclist.add(current);
        }

        TopicAdapter topicAdapter=new TopicAdapter(ctx,topiclist);
        rectopic.setLayoutManager(new GridLayoutManager(ctx,1));
        rectopic.setItemAnimator(new DefaultItemAnimator());
        rectopic.setAdapter(topicAdapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        if(id == R.id.share)
        {
            item.setCheckable(true);
            Intent sharingIntent=new Intent(Intent.ACTION_SEND);
            final String apppackagename=getApplicationContext().getPackageName();
            String strApplink="";

            try
            {
                strApplink="https://play.google.com/store/apps/details?id="+apppackagename;
            }
            catch (android.content.ActivityNotFoundException e)
            {
                strApplink="https://play.google.com/store/apps/details?id="+apppackagename;
            }
            sharingIntent.setType("text/plain");
            String shareBody="Hello friends, I want to share this amaizing tutorial app with you. This app is nicely designed and it has good collection of easy PolymerJS tutorials.."+"\n"+"For download click here ... "+"\n"+""+strApplink;
            String shareSubject="APP NAME/TITLE";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
            sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
            startActivity(Intent.createChooser(sharingIntent,"Share Using"));
            mydraw.closeDrawers();
            return true;


        }
        if(id==R.id.rate)
        {
            item.setCheckable(true);
            try
            {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=" + getPackageName())));
            }
            catch (ActivityNotFoundException e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=" +getPackageName())));
            }
            mydraw.closeDrawers();
            return true;
        }

        if(id==R.id.moreapp)
        {
            item.setCheckable(true);
            try
            {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/collection/cluster?clp=igM4ChkKEzgwMjI3ODMwODE5MjM0NDY3NTcQCBgDEhkKEzgwMjI3ODMwODE5MjM0NDY3NTcQCBgDGAA%3D:S:ANO1ljKP1O8&gsr=CjuKAzgKGQoTODAyMjc4MzA4MTkyMzQ0Njc1NxAIGAMSGQoTODAyMjc4MzA4MTkyMzQ0Njc1NxAIGAMYAA%3D%3D:S:ANO1ljLhPUE&hl=en_IN")));
            }
            catch (ActivityNotFoundException e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/collection/cluster?clp=igM4ChkKEzgwMjI3ODMwODE5MjM0NDY3NTcQCBgDEhkKEzgwMjI3ODMwODE5MjM0NDY3NTcQCBgDGAA%3D:S:ANO1ljKP1O8&gsr=CjuKAzgKGQoTODAyMjc4MzA4MTkyMzQ0Njc1NxAIGAMSGQoTODAyMjc4MzA4MTkyMzQ0Njc1NxAIGAMYAA%3D%3D:S:ANO1ljLhPUE&hl=en_IN")));
            }
            mydraw.closeDrawers();
            return true;
        }
        return false;
    }

    private void allocatememory() {
        rectopic=findViewById(R.id.rectopic);
        navigatinView=findViewById(R.id.navigation_view);
    }


}
