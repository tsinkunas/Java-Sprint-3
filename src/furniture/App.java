package furniture;


import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = null;
        ArrayList<Furniture> furniturePrintList = new ArrayList<>();
        ArrayList<Furniture> furnitureRemoveList = new ArrayList<>();
        while (true) {
            System.out.println(" ----------------------------- \n " +
                    "new - add new furniture \n " +
                    "print - print furniture list \n " +
                    "remove - remove from furniture list \n " +
                    "exit - exit from the program \n " +
                    "----------------------------- \n " +
                    "please select a command:");
            input = in.nextLine();
            if (input.equals("exit")) {
                System.exit(0);
            } else if (input.equals("new")) {
                System.out.println(" ----------------------------- \n " +
                        "sofa - Sofa \n " +
                        "chair - Chair \n " +
                        "armchair - Armchair \n " +
                        "----------------------------- \n " +
                        "please select furniture type:");
                String inputNew = in.nextLine();
                if (inputNew.equals("sofa")||inputNew.equals("chair")||inputNew.equals("armchair")){
                try {
                    FileWriter fw = new FileWriter(new File("furniture.csv"),true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(String.valueOf(createFurniture(inputNew)));
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }}
            }else if (input.equals("print")) {
                furniturePrintList = printFurniture(furniturePrintList, in);

            }else if (input.equals("remove")) {
                furniturePrintList = printFurniture(furniturePrintList, in);
                furnitureRemoveList = removeFurniture(furnitureRemoveList, in);

            }
        }
    }
    private static ArrayList<Furniture> removeFurniture(ArrayList<Furniture> furnitureRemoveList, Scanner in){
        System.out.println("Please select furniture name for removal:");
        String inputRemove = in.nextLine();
        String[] splitString = null;
        try {
            FileReader fr = new FileReader("furniture.csv");
            BufferedReader br = new BufferedReader(fr);
            String fileLine = br.readLine();
            while (fileLine != null) {
                splitString = fileLine.split(": |, ");
                String check = splitString[3];
                System.out.println(Arrays.toString(splitString));

                if (!inputRemove.equals(check)){
                    System.out.println(splitString[3]);
                    try {
                        FileWriter fw = new FileWriter(new File("furniture.csv"),true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(String.valueOf(createFurniture(Arrays.toString(splitString))));
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                fileLine = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return furnitureRemoveList;
    }
    private static ArrayList<Furniture> printFurniture(ArrayList<Furniture> furniturePrintList, Scanner in) {
        System.out.println(" ----------------------------- \n " +
                "all - All furniture \n " +
                "sofas - Sofas \n " +
                "chairs - Chairs \n " +
                "armchairs - Armchairs \n " +
                "----------------------------- \n " +
                "please select furniture type:");
        String inputPrint = in.nextLine();
        String[] splitString = null;
        if (inputPrint.equals("all")) {
            try {
                FileReader fr = new FileReader("furniture.csv");
                BufferedReader br = new BufferedReader(fr);
                String fileLine = br.readLine();
                while (fileLine != null) {
                    System.out.println(fileLine);
                    fileLine = br.readLine();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (inputPrint.equals("sofas")){
            try {
                FileReader fr = new FileReader("furniture.csv");
                BufferedReader br = new BufferedReader(fr);
                String fileLine = br.readLine();
                while (fileLine != null) {
                    splitString = fileLine.split(": |, ");
                    String check = splitString[1];
                    if (check.equals("Sofa")) System.out.println(fileLine);
                    fileLine = br.readLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (inputPrint.equals("chairs")){
        try {
            FileReader fr = new FileReader("furniture.csv");
            BufferedReader br = new BufferedReader(fr);
            String fileLine = br.readLine();
            while (fileLine != null) {
                splitString = fileLine.split(": |, ");
                String check = splitString[1];
                if (check.equals("Chair")) System.out.println(fileLine);
                fileLine = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }else if (inputPrint.equals("armchairs")){
        try {
            FileReader fr = new FileReader("furniture.csv");
            BufferedReader br = new BufferedReader(fr);
            String fileLine = br.readLine();
            while (fileLine != null) {
                splitString = fileLine.split(": |, ");
                String check = splitString[1];
                if (check.equals("Armchair")) System.out.println(fileLine);
                fileLine = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        return furniturePrintList;
    }

    private static Furniture createFurniture(String inputNew) {
        Scanner in = new Scanner(System.in);
        Furniture furniture = new Furniture();

        if (inputNew.equals("sofa")){
            furniture.setType("Sofa");
            System.out.println("Sofa name: ");
            furniture.setName(in.nextLine());
            System.out.println("Sofa price in eur: ");
            furniture.setPrice(in.nextDouble());
            System.out.println("Sofa description: ");
            furniture.setDescription(in.next());
        }else if (inputNew.equals("chair")) {
            furniture.setType("Chair");
            System.out.println("Chair name: ");
            furniture.setName(in.nextLine());
            System.out.println("Chair price in eur: ");
            furniture.setPrice(in.nextDouble());
            System.out.println("Chair description: ");
            furniture.setDescription(in.next());
        }else if (inputNew.equals("armchair")) {
            furniture.setType("Armchair");
            System.out.println("Armchair name: ");
            furniture.setName(in.nextLine());
            System.out.println("Armchair price in eur: ");
            furniture.setPrice(in.nextDouble());
            System.out.println("Armchair description: ");
            furniture.setDescription(in.next());
        }else if (inputNew.equals("main")){
            return null;
        }
        return furniture;
    }
}
