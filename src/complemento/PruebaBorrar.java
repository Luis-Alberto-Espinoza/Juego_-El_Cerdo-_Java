package complemento;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaBorrar {
    public static void main(String[] args) {
        mostrarArray(llenarVector(5), 5);
    }
    public static String [] vectorLleno (){

    String [] arrayString = new String[6];
    arrayString[0] = "123";
    arrayString[1] = "456";
    arrayString[2] = "789";
//    arrayString[3] = "987";
//    arrayString[4] = "654";
//    arrayString[5] = "321";
    return  arrayString;
    }
    public static String [] llenarVector(int cant){
        Scanner sc = new Scanner(System.in);
        String [] vector = new String[6];
        for (int i = 0; i < cant; i++) {
            vector[i] = sc.nextLine();

        }
        return vector;
    }
    public static void mostrarArray (String[] array, int cantidad){
        for (int i = 0; i < cantidad; i++) {
            System.out.println(" el jugador "+(i+1)+" se llama "+array[i] );
        }
    }

        /*
        //declaro e inicializo el array en este caso de string
        ArrayList<Integer> arrayValidarTurno = new ArrayList<Integer>();



        public ArrayList llenarArray(ArrayList arrayList){
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println("ingrese el nombre del " + i + 1 + " participante");
                arrayList.add(i + 40);

            }
            return arrayList;
        }


        public void mostrarArray (ArrayList arrayList){
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.toString());

            }


        }*/
    }

