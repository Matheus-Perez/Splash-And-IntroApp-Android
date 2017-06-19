package devteam.com.appintro;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*============== LAYOUT CUSTOM*/
        addSlide(IntroFragment.newInstance(R.layout.activity_first_fragment));
        addSlide(IntroFragment.newInstance(R.layout.activity_second_fragment));
        /*============== LAYOUT DEFAULT*/
        //S3
        addSlide(AppIntroFragment.newInstance("Slide 3", "Text Here",
                R.mipmap.ic_launcher, getResources().getColor(R.color.color1)));
        //S4
        addSlide(AppIntroFragment.newInstance("Slide 4", "HELLO!",
                R.mipmap.ic_launcher, getResources().getColor(R.color.color2)));


        //CONFIG GENERAL
        setSkipText("SKIP");
        setDoneText("OK");
        setBackButtonVisibilityWithDone(true);

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        //EVENT DO SKIP
        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        //EVENT DONE
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        //EVENT SLIDE
    }
}
