package service;

import models.BancaImplements;

import java.awt.print.Book;
import java.io.*;

public class MainService {
    private String filePath = "C:\\Users\\Sevciuc\\OneDrive\\Desktop\\JavaProject\\src\\repository\\raport.csv";

    public void writeDataToReport(BancaImplements banca){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true))){
            for (int i = 0; i < banca.getClienti().size(); i++) {
                for (int j = 0; j < banca.getClienti().get(i).getCreditDePlata().length; j++) {
                    bufferedWriter.append(banca.getClienti().get(i).getNume());
                    bufferedWriter.append(",");
                    bufferedWriter.append(banca.getClienti().get(i).getPrenume());
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(j + 1));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(banca.getClienti().get(i).getCreditDePlata()[j].getSuma()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(banca.getClienti().get(i).getCreditDePlata()[j].getDobanda()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getTotalPlata()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getRata()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getNrRate()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getNrRatePlatite()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getRamasPlata()));
                    bufferedWriter.append(",");
                    bufferedWriter.append("\n");
                }
            }






        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeDataToReportUnClient(BancaImplements banca, int i){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true))){
                for (int j = 0; j < banca.getClienti().get(i).getCreditDePlata().length; j++) {
                    bufferedWriter.append(banca.getClienti().get(i).getNume());
                    bufferedWriter.append(",");
                    bufferedWriter.append(banca.getClienti().get(i).getPrenume());
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(j + 1));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(banca.getClienti().get(i).getCreditDePlata()[j].getSuma()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(banca.getClienti().get(i).getCreditDePlata()[j].getDobanda()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getTotalPlata()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getRata()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getNrRate()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getNrRatePlatite()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf( banca.getClienti().get(i).getRata()[j].getRamasPlata()));
                    bufferedWriter.append(",");
                    bufferedWriter.append("\n");
                }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void initReportHeader() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            bufferedWriter.append("NUME");
            bufferedWriter.append(",");
            bufferedWriter.append("PRENUME");
            bufferedWriter.append(",");
            bufferedWriter.append("CREDITUL");
            bufferedWriter.append(",");
            bufferedWriter.append("SUMA EXTRASA");
            bufferedWriter.append(",");
            bufferedWriter.append("DOBANDA");
            bufferedWriter.append(",");
            bufferedWriter.append("TOTAL DE PLATA");
            bufferedWriter.append(",");
            bufferedWriter.append("RATA LUNARA IN LEI");
            bufferedWriter.append(",");
            bufferedWriter.append("NUMARUL DE RATE");
            bufferedWriter.append(",");
            bufferedWriter.append("NUMARUL DE RATE PLATITE");
            bufferedWriter.append(",");
            bufferedWriter.append("REST DE PLATA");

            bufferedWriter.append("\n");
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readDataFromCsv() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String record;
            while((record = bufferedReader.readLine()) != null) {
                String [] recordData = record.split(",");
                System.out.println(recordData[0] + " " + recordData[1]);
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
