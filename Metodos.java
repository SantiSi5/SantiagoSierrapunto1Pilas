import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;

public class Metodos {
    Scanner sc = new Scanner(System.in);

    public void Menu() {
        Queue<Integer> Cola = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        Stack<Integer> Pila = new Stack<>();
        boolean bandera = true;
        int opcion = 0;
/*         int opcionint = 0;
 */        int n = 0;
        System.out.println("Ingrese la dimension de la matriz");
        n = sc.nextInt();

        int[][] matriz = new int[n][n];
        matriz = llenarmatriz(matriz);
        mostrarmatriz(matriz);

        do {
            System.out.println("Escoja una de las siguientes opciones para continuar:");
            System.out.println(
                    "1. Sumar las filas de la matriz y almacenarlas en una pila\n2. Sumar las columnas de la matriz y almacenarla en una cola\n3. Mostrar el factorial de la dimension de la matriz\n4.Metodo que muestre los numeros ordenados de la cola del punto 2 ordenados de mayor a menor");
            opcion = sc.nextInt();
            while (opcion < 1 || opcion > 4) {
                System.out.println("Valor ingresado no es permitido, por favor revise sus respuestas:");
                System.out.println(
                    "1. Sumar las filas de la matriz y almacenarlas en una pila\n2. Sumar las columnas de la matriz y almacenarla en una cola\n3. Mostrar el factorial de la dimension de la matriz\n4.Metodo que muestre los numeros ordenados de la cola del punto 2 ordenados de mayor a menor");
            opcion = sc.nextInt();
            }
            switch (opcion) {
                case 1:
                    Pila = MatrizToPila(matriz);
                    System.out.print(Pila);
/*                     mensajeConfirmacion();
 */                    bandera=false;
                    break;
                case 2:
                    Cola = MatrizToCola(matriz);
                    System.out.print(Cola);
/*                     mensajeConfirmacion();
 */                    bandera=false;
                    break;
                case 3:
                    factorialDimension(n);
/*                     mensajeConfirmacion();
 */                    bandera=false;
                    break;
                case 4:
                    if (Cola.isEmpty()) {
                        Cola = MatrizToCola(matriz);
                        ordenarCola(Cola);
                        System.out.println(Cola);
/*                         mensajeConfirmacion();
 */                        bandera=false;
                    } else {
                        ordenarCola(Cola);
                        System.out.println(Cola);
/*                         mensajeConfirmacion();
 */                        bandera=false;
                    }
                    break;
                default:
                    System.out.println("Valor ingresado no es permitido, por favor revise sus respuestas");
                    break;
            }
        } while (bandera);

    }

    public int[][] llenarmatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (int) (Math.random() * 50 + 1);
            }
        }
        return matriz;
    }

    public void mostrarmatriz(int[][] matriz) {
        System.out.println("Valores de la matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public Stack<Integer> MatrizToPila(int[][] matriz) {
        Stack<Integer> Pila = new Stack<>();
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz.length; j++) {
                suma += matriz[i][j];
            }
            Pila.push(suma);
        }
        return Pila;
    }

    public Queue<Integer> MatrizToCola(int[][] matriz) {
        Queue<Integer> Cola = new LinkedList<>();
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz.length; j++) {
                suma += matriz[j][i];
            }
            Cola.offer(suma);
        }
        return Cola;
    }

    public int factorialDimension(int n) {
        int factorial = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Factorial de la dimensión de la matriz: " + factorial);

        return factorial;
    }

    public Queue<Integer> ordenarCola(Queue<Integer> Cola) {
        int n = Cola.size();
        int[] arreglo = new int[n];
        int temp = 0;

        //guardar los valores de la cola en un arreglo para una mejor manipulacion
        for (int i = 0; i < n; i++) {
            arreglo[i] = Cola.poll();
        }

        //Ordenar los valores del arreglo de manera descendiente
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        //Devolver los valores del arreglo a la cola
        for (int i = 0; i < arreglo.length; i++) {
            Cola.offer(arreglo[i]);
        }
        return Cola;
    }

    /* public void mensajeConfirmacion() {
        boolean bandera = true;
        int opcionint = 0;
        while (bandera) {
            System.out.println("\nDeseas volver al menu o salir del programa?\n1. Volver\n2.salir");
            opcionint = sc.nextInt();
            while (opcionint < 1 || opcionint > 4) {
                System.out.println("Valor ingresado por fuera del rango, por favor ingrese un valor correcto:\n1. Volver\n2.salir");
                opcionint = sc.nextInt();
            }
            switch (opcionint) {
                case 1:
                    Menu();
                    break;
                case 2:
                    bandera = false;
                    break;
            }
        }

    } */
}
