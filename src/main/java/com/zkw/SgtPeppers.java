package com.zkw;

import org.springframework.stereotype.Component;

@Component(value = "myBean")
public class SgtPeppers implements CompactDisc {
    private String title="Sgt. Pepper's Lonely Hearts Clud Band";
    private String artist = "The Beatles";

    public void play(){
        System.out.println("Playing "+title+" by "+artist);
    }
}
