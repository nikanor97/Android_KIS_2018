package com.example.nikan.task3;

import android.graphics.ColorSpace;

import java.util.ArrayList;
import java.util.List;

public class ModelItem {
    private String author;
    private int imgId;

    public ModelItem(String author, int imgId){
        this.author = author;
        this.imgId = imgId;
    }

    public int getImgId(){
        return imgId;
    }

    public String getAuthor(){
        return author;
    }

    public static List<ModelItem> getFakeItems(){
        ArrayList<ModelItem> itemsList = new ArrayList<>();
        itemsList.add(new ModelItem("picture 1", R.drawable.pic1));
        itemsList.add(new ModelItem("picture 2", R.drawable.pic2));
        itemsList.add(new ModelItem("picture 3", R.drawable.pic3));
        itemsList.add(new ModelItem("picture 4", R.drawable.pic4));
        itemsList.add(new ModelItem("picture 5", R.drawable.pic5));
        return itemsList;
    }
}
