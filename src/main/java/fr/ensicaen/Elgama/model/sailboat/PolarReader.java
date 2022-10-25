package fr.ensicaen.Elgama.model.sailboat;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class PolarReader {
    private String _file; // FIXME est-ce une constante ? -> final

    public PolarReader(){
        _file = "data/polaire-figaro.pol";
    }

    public double[][] loadData(){
        // FIXME déclaration d'une matrice de style C et pas Java !
        double data[][] = new double[19][14];
        int j=0;
        try {
            File myObj = new File(_file);
            Scanner myReader = new Scanner(myObj);

            myReader.nextLine(); //on saute la première ligne
            while (myReader.hasNextLine()) {
                String str[] = myReader.nextLine().split("\t");

                for(int i=0; i<14; i++){
                    data[j][i] = Double.parseDouble(str[i+1]);
                }
                j++;
            }
            myReader.close();
            return data;

        } catch (FileNotFoundException e) {
            System.out.println("Can't open the json data file");
            e.printStackTrace();
        }
        return data;
    }
}
