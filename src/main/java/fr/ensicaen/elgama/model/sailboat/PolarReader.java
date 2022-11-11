package fr.ensicaen.elgama.model.sailboat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PolarReader {
    private final String _file;

    public PolarReader(PolarType polarType) {
        _file = polarType._fileName;
    }

    public double[][] loadData() {
        double[][] data = new double[19][14];
        try {
            File myObj = new File(_file);
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            for (int j = 0; j < 19; j++) {
                String[] str = myReader.nextLine().split("\t");
                for (int i = 0; i < 14; i++) {
                    data[j][i] = Double.parseDouble(str[i + 1]);
                }
            }
            myReader.close();
            return data;

        } catch (FileNotFoundException e) {
            System.err.println("Can't found the polar file.");
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            System.err.println("The polar file is incomplete.");
            e.printStackTrace();
        }
        return data;
    }

    public enum PolarType {
        Figaro("data/polar-figaro.pol"), Oceanis("data/polar-oceanis.pol");
        final String _fileName;

        PolarType(String fileName) {
            _fileName = fileName;
        }
    }
}
