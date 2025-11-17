public class reloj_movimiento {
    public static final String CLEAN_SCREEN = "\033[H\033[2J";
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\033[0;35m";

    public static void limpiarPantalla() {
        try {
            String sistemaOperativo = System.getProperty("os.name");

            if (sistemaOperativo.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int altura = 21;
        int mitad = (int) Math.ceil(altura / 2);
        int asteriscos1 = altura - 2; //asteriscos primera linea
        int espacios1 = 0; // espacios primera linea
        int izq = 1; // 1 porque 0 es el exterior del reloj de arena
        int der = asteriscos1 - 3; // asteriscos-2 es el exterior del reloj de arena
        int fila = 2; // empieza por la fila siguiente del exterior del reloj de arena
        int contador = 0;
        int der2 = -5; // Empieza en -5 porque no lo quiero usar hasta que llegue el contador a 8
        int izq2 = -5; // "         "       "
        int fila2 = altura - 3; //ultima fila sin entrar en el exterior del reloj de arena.
        int resta = asteriscos1 - 1; //resta para el condicional der2

        while (true) {
            for (int i = 1; i < altura - 1; i++) {
                System.out.printf((espacios1 > 0) ? "%" + espacios1 + "s" : "", " "); //Espacios por delante de asteriscos
                for (int j = 0; j < asteriscos1; j++) {
                    if (j == 0 || i == 1 || j == asteriscos1 - 1 || i == altura - 2) { // Asteriscos del exterior
                        System.out.print("*");
                    } else if (i < fila && j != 0 && j != asteriscos1 - 1 && i != 1) {  // Espacios por encima de fila
                        System.out.print(" ");
                    } else if (i <= fila2 && i > mitad) { // Asteriscos y espacios de la pirámide de debajo
                        if ((j <= der2 && j >= izq2 && i == fila2) || (j == i - 10 && i - 10 <= contador)) {
                            System.out.print(GREEN + "*" + RESET);
                        } else {
                            System.out.print(" ");
                        }
                    }

                    else if (((i <= fila && i != 1) && ((j <= izq && j != 0) // Quitar asterisco por derecha e izquierda 
                    || (j >= der && j != asteriscos1 - 1 && i != 1)))) { 
                    System.out.print(" ");
                    }

                    else {
                        if (i > mitad) { //asteriscos restantes de colores
                            System.out.print(GREEN + "*" + RESET); 
                        } else {
                            System.out.print(PURPLE + "*" + RESET);
                        }
                        
                    }

                }

                //condicionales para cambios en estados de variables
                if (i == altura - 2) { //reiniciar asteriscos para limpar pantalla
                    asteriscos1 = altura - 2;
                } else if (i >= mitad) { // mitad reloj arriba
                    asteriscos1 += 2;
                    espacios1--;
                } else { // mitad reloj abajo
                    espacios1++;
                    asteriscos1 -= 2;
                }
                System.out.println("");
            }
            contador++;
            if (contador == 8) { // empezar a sumar asteriscos en piramide debajo
                der2 = mitad-1;
                izq2 = mitad-2;
            }

            if (der == izq) { //reiniciar centro de der e izq porque el centro de la siguiente fila cambia
                fila++;
                der = asteriscos1 - fila * 2;
                izq = 1;
            } else if (der2 >= resta - 5 && izq2 <= 1) { // lo mismo que el otro pero de la piramide de abajo
                resta = resta - 2;
                izq2 = (int) Math.ceil(resta / 2) - 1;
                der2 = (int) Math.ceil(resta / 2) - 2;
                fila2--;
            }

            else if (contador % 2 == 0) { //una vez suma por derecha, der = piramide arriba, der2 = piramide abajo
                der--;
                der2++;
            }

            else { // otra vez suma o resta por izquierda izq = piramide arriba, izq2 = piramide abajo
                izq++;
                izq2--;
            }
            Thread.sleep(400);
            limpiarPantalla();
        }

    }
}
