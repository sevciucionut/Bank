import contracts.BancaHelper;
import helper.Helper;
import models.BancaImplements;
import models.Client;
import models.Credit;
import models.Rata;
import service.MainService;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /** Scenariu:
         * O banca detine mai multi clienti si isi doreste sa-i managerieze mai usor. Astfel are nevoie de urmatoarele comenzi:
         * 1. Adaugare clienti noi
         * 2. Stergerea clientilor
         * 3. Adaugarea de credite noi
         * 4. Modificarea numarului de rate platite si stergerea creditelor in cazul in care clientul a platit tot
         * 5. Sortare alfabetica
         * 6. Afisarea tuturor clientilor
         * 7. Afisarea unui client
         **/

        BancaImplements bcr = new Helper().construiesteDouaCredite();
        MainService mainService = new MainService();
        //bcr.afsareClienti();


        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Banca " + bcr.getNumeBanca() + " va sta la dispozitie!");
        System.out.println("\n");


        while (true) {
            System.out.println("\n\nSelectati una din optiunile de mai jos pentru a afla mai multe informatii.");

            System.out.println("1.Adaugare clienti noi");
            System.out.println("2.Stergerea clientilor");
            System.out.println("3.Adaugarea de credite noi");
            System.out.println("4.Modificarea numarului de rate platite si stergerea creditelor in cazul in care clientul a platit tot");
            System.out.println("5.Sortare alfabetica");
            System.out.println("6.Afisarea tuturor clientilor");
            System.out.println("7.Afisarea unui client");
            System.out.println("8.exit");

            String optiune = scanner.next();
            switch (optiune) {
                case "1":
                    System.out.println("Introduceti numele clientului ");
                    String numeClient = scanner.next();
                    System.out.println("Introduceti prenumele clientului ");
                    String prenumeClient = scanner.next();
                    Client client = new Client(numeClient, prenumeClient);
                    bcr.adaugaClient(client);
                    System.out.println("Clientul " + numeClient + " " + prenumeClient + " doreste un credit?(d/n)");
                    String dn = scanner.next();
                    if ("d".equals(dn)) {
                        System.out.println("Introduceti suma creditului ");
                        String suma = scanner.next();
                        System.out.println("Introduceti dobanda ");
                        String dobanda = scanner.next();
                        System.out.println("Introduceti numarul de rate ");
                        String nrRate = scanner.next();
                        Credit credit = new Credit(Double.parseDouble(suma), Double.parseDouble(dobanda));
                        bcr.getClienti().get(bcr.getClienti().size() - 1).adaugaCredit(credit, Integer.parseInt(nrRate));
                        bcr.afisareaUnuiClient(bcr.getClienti().size() - 1);
                    }
                    break;

                case "2":
                    System.out.println("In momentul de fata exista " + bcr.getClienti().size() + " clienti");
                    if (bcr.getClienti().size() != 0) {
                        System.out.println("Introduceti indicele clientului (incepand cu 0)");
                        String indice = scanner.next();
                        bcr.stergeClient(Integer.parseInt(indice));
                    }
                    break;

                case "3":
                    System.out.println("In momentul de fata exista " + bcr.getClienti().size() + " clienti");
                    if (bcr.getClienti().size() != 0) {
                        System.out.println("Introduceti indicele clientului (incepand cu 0)");
                        String indice = scanner.next();
                        System.out.println("Introduceti suma creditului ");
                        String suma = scanner.next();
                        System.out.println("Introduceti dobanda ");
                        String dobanda = scanner.next();
                        System.out.println("Introduceti numarul de rate ");
                        String nrRate = scanner.next();
                        Credit credit = new Credit(Double.parseDouble(suma), Double.parseDouble(dobanda));
                        bcr.getClienti().get(Integer.parseInt(indice)).adaugaCredit(credit, Integer.parseInt(nrRate));
                        bcr.afisareaUnuiClient(Integer.parseInt(indice));
                    }
                    break;

                case"4":
                    System.out.println("In momentul de fata exista " + bcr.getClienti().size() + " clienti");
                    if (bcr.getClienti().size() != 0) {
                        System.out.println("Introduceti indicele clientului (incepand cu 0)");
                        String indice = scanner.next();
                        bcr.afisareaUnuiClient(Integer.parseInt(indice));
                        System.out.println("Introduceti numarul creditului (incepand cu 0)");
                        String nrCredit = scanner.next();
                        System.out.println("Introduceti numarul ratelor platite");
                        String nr = scanner.next();
                        bcr.editareNumarRatePlatite(Integer.parseInt(indice), Integer.parseInt(nr), Integer.parseInt(nrCredit));
                    }

                case"5":
                    Collections.sort(bcr.getClienti(), Client.alfabetic);
                    break;

                case"6":
                    bcr.afsareClienti();

                    mainService.initReportHeader();
                    mainService.writeDataToReport(bcr);

                    break;

                case"7":
                    System.out.println("In momentul de fata exista " + bcr.getClienti().size() + " clienti");
                    if (bcr.getClienti().size() != 0) {
                        System.out.println("Introduceti indicele clientului (incepand cu 0)");
                        String indice = scanner.next();
                        bcr.afisareaUnuiClient(Integer.parseInt(indice));
                        mainService.initReportHeader();
                        mainService.writeDataToReportUnClient(bcr, Integer.parseInt(indice));
                    }
                    break;

                case "8" :
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n");
                    System.out.println("Ai ales o optiune incorecta, selectati una din cele de mai sus.");

            }

        }
    }
}
