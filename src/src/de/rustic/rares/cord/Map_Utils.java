package de.rustic.rares.cord;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Map_Utils {

    public static HashMap<Coordinate, ColorCodes> content = new HashMap<Coordinate, ColorCodes>();

    public static void init(){

     for(ColorCodes c : ColorCodes.values()){
         Coordinate cord = new Coordinate(c.r,c.g,c.b);
         content.put(cord, c);
     }


    }

    public static String RoundColor(int r,int g,int b){
        Coordinate cord = new Coordinate(r,g,b);
        ArrayList<Double> dists = new ArrayList<>();
        HashMap <Double, Coordinate> cords = new HashMap<>();
        for(Coordinate c : content.keySet()){
            double dist = cord.getDistance(c);

            dists.add(dist);
            cords.put(dist, c);
        }

        dists.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });


        Coordinate c =cords.get(dists.get(0));
        return "" + content.get(c).getC();
    }




}
