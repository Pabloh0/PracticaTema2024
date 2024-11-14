import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int IVA = 10, DESCCRI = 5, DESCCONO = 7, DESCCONJA = 3, PRECIOPLACRI = 17, PRECIOBUCRI = 20, PRECIOANFCRI = 13, PRECIOPLACONO = 12, PRECIOBUCONO = 15,
                PRECIOANFCONO = 8, PRECIOPLACONJA = 20, PRECIOBUCONJA = 25, PRECIOANFCONJA = 15;
        boolean apagar = false, hayDescuento = false, daEspacios = false;
        String obraSelec = "", nombreSitioElegido = "", usuario = "usu", password = "123", lineaDescuento = "", codEntrada = "";
        int cantEntraCompradas = 0, entraTotaCri = 600, entraTotaConO = 600, entraTotaConJa = 600, entraPlaCri = 200,
                entraBuCri = 200, entraAnfCri = 200, entraPlaConO = 200, entraBuConO = 200, entraAnfConO = 200,
                entraPlaConJa = 200, entraBuConJa = 200, entraAnfConJa = 200, billete50res = 100000, billete20res = 1000000,
                billete10res = 10000, billete5res = 100000, moneda2res = 100000, moneda1res = 1000000, moneda05res = 100000,
                moneda02res = 10000, moneda01res = 100000, moneda005res = 100000, moneda002res = 100000, moneda001res = 10000;
        LocalDate fechaActu = LocalDate.now(), fecha = null, fechaCri = LocalDate.of(2024, 11, 20),
                fechaConO = LocalDate.of(2024, 11, 28), fechaConJa = LocalDate.of(2024, 12, 6), fechaElegida = null;
        long diferenciaEnDias = 0;
        float dineroIntro = 0f, cambio = 0f, ingresosTotalesCri = 0f, ingresosTotalesConO = 0f, ingresosTotalesConJa = 0f;


        System.out.println("\n" +
                " ___________ __    ______  __   ___ _______ ___________ ___      ___      __       ________ ___________ _______  _______         _______    __     ___      _______ ___  ___  \n" +
                "(\"     _   \"|\" \\  /\" _  \"\\|/\"| /  \"/\"     \"(\"     _   \"|\"  \\    /\"  |    /\"\"\\     /\"       (\"     _   \"/\"     \"|/\"      \\       |   __ \"\\  /\"\"\\   |\"  |    /\"     \"|\"  \\/\"  | \n" +
                " )__/  \\\\__/||  |(: ( \\___(: |/   (: ______))__/  \\\\__/ \\   \\  //   |   /    \\   (:   \\___/ )__/  \\\\__(: ______|:        |      (. |__) :)/    \\  ||  |   (: ______)\\   \\  /  \n" +
                "    \\\\_ /   |:  | \\/ \\    |    __/ \\/    |     \\\\_ /    /\\\\  \\/.    |  /' /\\  \\   \\___  \\      \\\\_ /   \\/    | |_____/   )      |:  ____//' /\\  \\ |:  |    \\/    |   \\\\  \\/   \n" +
                "    |.  |   |.  | //  \\ _ (// _  \\ // ___)_    |.  |   |: \\.        | //  __'  \\   __/  \\\\     |.  |   // ___)_ //      /       (|  /   //  __'  \\ \\  |___ // ___)_  /\\.  \\   \n" +
                "    \\:  |   /\\  |(:   _) \\|: | \\  (:      \"|   \\:  |   |.  \\    /:  |/   /  \\\\  \\ /\" \\   :)    \\:  |  (:      \"|:  __   \\      /|__/ \\ /   /  \\\\  ( \\_|:  (:      \"|/  \\   \\  \n" +
                "     \\__|  (__\\_|_\\_______(__|  \\__\\_______)    \\__|   |___|\\__/|___(___/    \\___(_______/      \\__|   \\_______|__|  \\___)    (_______(___/    \\___\\_______\\_______|___/\\___| \n" +
                "                                                                                                                                                                                           \n" +
                "────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────                                                                                                                                                                            \n");

        do { //Bucle para que el programa no se cierre a no ser que le de el admin.
            int op = 0, opIngresos = 0, opMenuAdmin = 0, sitioElegido = 0, opInfoElegida = 0, billete50 = 0, billete10 = 0, billete5 = 0, billete20 = 0, moneda2 = 0,
                    moneda1 = 0, moneda05 = 0, moneda02 = 0, moneda01 = 0, moneda005s = 0, moneda005 = 0,
                    moneda002 = 0, moneda001 = 0;
            String passIntro = "", usuIntro = "";
            boolean preguntarFecha = false, preguntarDinero = false, sePinta = false;
            float precioSinIva = 0f, precioConIva = 0f, cantidadDescuento = 0f, cantidadIva = 0f, precioTotal = 0f;

            if (daEspacios) {
                System.out.println("Pulse cualquier tecla para continuar");
                s.nextLine();
                for (int i = 0; i < 100; i++) {
                    System.out.println();
                }
            }

            System.out.print("""
                    ┌──────────────────┐
                    │  MENU PRINCIPAL  │
                    └──────────────────┘
                    ╔════════════════════════════════════════════╗
                    ║   1.  Vender entradas para un evento       ║
                    ║   2.  Consultar el estado de un evento     ║
                    ║   3.  Menú de administrador                ║
                    ╚════════════════════════════════════════════╝
                    Introduce una opción:\s""");
            op = Integer.parseInt(s.nextLine());

            //SWITCH DEL MENU PRICINPAL
            switch (op) {
                case 1: //VENDE ENTRADAS
                    System.out.println("""
                            ╔════════════════════╦═════════════╦═════════════════╦═════════════════╦═════════════╦══════════════╗
                            ║       Evento       ║    Fecha    ║  Precio platea  ║  Precio butacas ║   Precio    ║  Descuento   ║
                            ║                    ║             ║                 ║                 ║ anfiteatro  ║  anticipado  ║
                            ╠════════════════════╬═════════════╬═════════════════╬═════════════════╬═════════════╬══════════════╣
                            ║ Las criadas        ║  20/11/2024 ║       17€       ║       20€       ║     13€     ║      5%      ║
                            ╠--------------------╬-------------╬-----------------╬-----------------╬-------------╬--------------╣
                            ║ II Concierto de    ║  28/11/2024 ║       12€       ║       15€       ║     8€      ║      7%      ║
                            ║ Otoño              ║             ║                 ║                 ║             ║              ║
                            ╠--------------------╬-------------╬-----------------╬-----------------╬-------------╬--------------╣
                            ║ Concierto de Jazz  ║  06/12/2024 ║       20€       ║       25€       ║     15€     ║      3%      ║
                            ╚════════════════════╩═════════════╩═════════════════╩═════════════════╩═════════════╩══════════════╝
                            """);

                    System.out.println("Pulse cualquier tecla para continuar");
                    s.nextLine();

                    System.out.println("""
                            ┌───────────────────────────────────────────┐
                            │  Elige la obra a la que quieres asistir:  │
                            └───────────────────────────────────────────┘
                            ╔════════════════════════════════════════════╗
                            ║   1. Las criadas                           ║
                            ║   2. II Concierto de Otoño                 ║
                            ║   3. Concierto de Jazz                     ║
                            ║   4. Salir                                 ║
                            ╚════════════════════════════════════════════╝
                            """);
                    op = Integer.parseInt(s.nextLine());

                    if (op >= 1 && op <= 3) {//Si el usuario no le da a salir se mostrara el menu para elegir asiento
                        System.out.println("""
                                ┌────────────────────┐
                                │    Elige sitio:    │
                                └────────────────────┘
                                ╔═════════════════════════════════╗
                                ║   1. Platea                     ║
                                ║   2. Butacas                    ║
                                ║   3. Anfiteatro                 ║
                                ║   4. Salir                      ║
                                ╚═════════════════════════════════╝
                                """);
                        sitioElegido = Integer.parseInt(s.nextLine());
                        if (sitioElegido == 1) nombreSitioElegido = "Platea";
                        if (sitioElegido == 2) nombreSitioElegido = "Butacas";
                        if (sitioElegido == 3) nombreSitioElegido = "Anfiteatro";

                        //SWITCH PARA ELEGIR OBRA
                        if (sitioElegido >= 1 && sitioElegido <= 3) {//Si el usuario no le da a salir se preguntara la cantidad de entradas y fecha.
                            switch (op) {
                                case 1://Se hace la logica de comprar entradas para la opcion seleccionada.
                                    obraSelec = "Las criadas";

                                    if (entraTotaCri <= 0)//Comprobación para saber si quedan entradas de cualquier tipo
                                        System.out.println("Lo sentimos, no queda existencia de entradas para Las Criadas");
                                    else {
                                        System.out.print("Cuantas entradas van a ser: ");
                                        cantEntraCompradas = Integer.parseInt(s.nextLine());
                                        //Condicion para la cantidad minima y maxima de compra de entradas
                                        if (cantEntraCompradas <= 0 || cantEntraCompradas > entraTotaCri) {
                                            System.out.println("Canntidad de entradas erronea");
                                            cantEntraCompradas = 0;
                                        } else {
                                            switch (sitioElegido) {//switch para los asientos
                                                case 1://Se restan las entradas compradas a las entradas en stock de este tipo asiento
                                                    //Comprueba si la contidad de entradas
                                                    if (entraPlaCri == 0)
                                                        System.out.println("Entradas para platea agotadas");
                                                    else if ((entraPlaCri - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraPlaCri -= cantEntraCompradas;
                                                        entraTotaCri -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                case 2://Se restan las entradas compradas a las entradas en stock de este tipo asiento
                                                    if (entraBuCri == 0)
                                                        System.out.println("Entradas para butaca agotadas");
                                                    else if ((entraBuCri - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraBuCri -= cantEntraCompradas;
                                                        entraTotaCri -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                case 3://Se restan las entradas compradas a las entradas en stock de este tipo asiento
                                                    if (entraAnfCri == 0)
                                                        System.out.println("Entradas para anfiteatro agotadas");
                                                    else if ((entraAnfCri - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraAnfCri -= cantEntraCompradas;
                                                        entraTotaCri -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opción incorrecta");
                                            }
                                        }
                                    }
                                    break;
                                case 2://Se hace la logica de comprar entradas para la opcion seleccionada.
                                    obraSelec = "II Concierto de Otoño";
                                    if (entraTotaConO == 0)
                                        System.out.println("Lo sentimos, no queda existencia de entradas para II Concierto de Otoño");
                                    else {
                                        System.out.print("Cuantas entradas van a ser: ");
                                        cantEntraCompradas = Integer.parseInt(s.nextLine());
                                        if (cantEntraCompradas <= 0 || cantEntraCompradas > entraTotaConO) {
                                            System.out.println("Cantidad de entradas erronea");
                                            cantEntraCompradas = 0;
                                        } else {
                                            switch (sitioElegido) {
                                                case 1:
                                                    if (entraPlaConO == 0)
                                                        System.out.println("Entradas para platea agotadas");
                                                    else if ((entraPlaConO - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraPlaConO -= cantEntraCompradas;
                                                        entraTotaConO -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                case 2:
                                                    if (entraBuConO == 0)
                                                        System.out.println("Entradas para butaca agotadas");
                                                    else if ((entraBuConO - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraBuConO -= cantEntraCompradas;
                                                        entraTotaConO -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                case 3:
                                                    if (entraAnfConO == 0)
                                                        System.out.println("Entradas para anfiteatro agotadas");
                                                    else if ((entraAnfConO - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraAnfConO -= cantEntraCompradas;
                                                        entraTotaConO -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opción incorrecta");
                                            }
                                        }
                                    }

                                    break;
                                case 3://Se hace la logica de comprar entradas para la opcion seleccionada.
                                    obraSelec = "Concierto de Jazz";
                                    if (entraTotaConJa == 0)
                                        System.out.println("Lo sentimos, no queda existencia de entradas para Concierto de Jazz");
                                    else {
                                        System.out.print("Cuantas entradas van a ser: ");
                                        cantEntraCompradas = Integer.parseInt(s.nextLine());
                                        if (cantEntraCompradas <= 0 || cantEntraCompradas > entraTotaConJa) {
                                            System.out.println("Cantidad de entradas erronea");
                                            cantEntraCompradas = 0;
                                        } else {
                                            switch (sitioElegido) {
                                                case 1:
                                                    if (entraPlaConJa == 0)
                                                        System.out.println("Entradas para platea agotadas");
                                                    else if ((entraPlaConJa - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraPlaConJa -= cantEntraCompradas;
                                                        entraTotaConJa -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                case 2:
                                                    if (entraBuConJa == 0)
                                                        System.out.println("Entradas para butaca agotadas");
                                                    else if ((entraBuConJa - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraBuConJa -= cantEntraCompradas;
                                                        entraTotaConJa -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                case 3:
                                                    if (entraAnfConJa == 0)
                                                        System.out.println("Entradas para Anfiteatro agotadas");
                                                    else if ((entraAnfConJa - cantEntraCompradas) < 0)
                                                        System.out.println("No hay suficientes entradas para la cantidad seleccionada");
                                                    else {
                                                        entraAnfConJa -= cantEntraCompradas;
                                                        entraTotaConJa -= cantEntraCompradas;
                                                        preguntarFecha = true;
                                                        preguntarDinero = true;
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opción incorrecta");
                                            }
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Opción introducida errónea");
                            }


                            if (preguntarFecha) {
                                System.out.print("Introduce una fecha (yyyy-MM-dd): ");//Preguntamos la fecha de compra
                                String fechaIntro = s.nextLine().toLowerCase();
                                if (fechaIntro.equals("no"))
                                    fecha = fechaActu;//Si se introduce "no" se pone la fecha actual.
                                else {
                                    fecha = LocalDate.parse(fechaIntro);
                                }

                                if (op == 1) {
                                    diferenciaEnDias = ChronoUnit.DAYS.between(fecha, fechaCri);
                                }
                                if (op == 2) {
                                    diferenciaEnDias = ChronoUnit.DAYS.between(fecha, fechaConO);
                                }
                                if (op == 3) {
                                    diferenciaEnDias = ChronoUnit.DAYS.between(fecha, fechaConJa);
                                }
                                //Comprobamos si hay descuento.
                                if (diferenciaEnDias > 7) hayDescuento = true;
                            }

                            if (obraSelec.equals("Las criadas")) {
                                //Estos if miran que asiento es
                                if (sitioElegido == 1) precioSinIva = PRECIOPLACRI * cantEntraCompradas;
                                if (sitioElegido == 2) precioSinIva = PRECIOBUCRI * cantEntraCompradas;
                                if (sitioElegido == 3) precioSinIva = PRECIOANFCRI * cantEntraCompradas;
                            }
                            if (obraSelec.equals("II Concierto de Otoño")) {
                                //Estos if miran que asiento es
                                if (sitioElegido == 1) precioSinIva = PRECIOPLACONO * cantEntraCompradas;
                                if (sitioElegido == 2) precioSinIva = PRECIOBUCONO * cantEntraCompradas;
                                if (sitioElegido == 3) precioSinIva = PRECIOANFCONO * cantEntraCompradas;
                            }
                            if (obraSelec.equals("Concierto de Jazz")) {
                                //Estos if miran que asiento es
                                if (sitioElegido == 1) precioSinIva = PRECIOPLACONJA * cantEntraCompradas;
                                if (sitioElegido == 2) precioSinIva = PRECIOBUCONJA * cantEntraCompradas;
                                if (sitioElegido == 3) precioSinIva = PRECIOANFCONJA * cantEntraCompradas;
                            }
                            cantidadIva = (precioSinIva * IVA) / 100;
                            precioConIva = precioSinIva + cantidadIva;
                            if (hayDescuento) {
                                if (obraSelec.equals("Las criadas")) cantidadDescuento = (precioConIva * DESCCRI) / 100;
                                if (obraSelec.equals("II Concierto de Otoño"))
                                    cantidadDescuento = (precioConIva * DESCCONO) / 100;
                                if (obraSelec.equals("Concierto de Jazz"))
                                    cantidadDescuento = (precioConIva * DESCCONJA) / 100;
                                precioTotal = precioConIva - cantidadDescuento;
                            } else precioTotal = precioConIva;
                            if (cantEntraCompradas != 0) System.out.printf("precioTotal = %.2f \n", precioTotal);

                            if (obraSelec.equals("Las criadas")) ingresosTotalesCri += precioTotal;
                            if (obraSelec.equals("II Concierto de Otoño")) ingresosTotalesConO += precioTotal;
                            if (obraSelec.equals("Concierto de Jazz")) ingresosTotalesConJa += precioTotal;
                            //Esta parte es para sacar el menor cambio posible
                            if (preguntarDinero) {
                                do {//Este bucle comprueba la cantidad de dinero introducida
                                    System.out.print("Cuánto dinero va a Introducir: ");
                                    dineroIntro = Float.parseFloat(s.nextLine());
                                    if (precioTotal > dineroIntro) System.out.println("Cantidad insuficiente");
                                } while (dineroIntro < precioTotal);
                                cambio = dineroIntro - precioTotal;
                                System.out.printf("Su cambio es de: %.2f\n", cambio);
                                //Calculo de la menor cantidad
                                while (cambio >= 50) {
                                    billete50++;
                                    cambio -= 50;
                                }
                                while (cambio >= 20) {
                                    billete20++;
                                    cambio -= 20;
                                }
                                while (cambio >= 10) {
                                    billete10++;
                                    cambio -= 10;
                                }
                                while (cambio >= 5) {
                                    billete5++;
                                    cambio -= 5;
                                }
                                while (cambio >= 2) {
                                    moneda2++;
                                    cambio -= 2;
                                }
                                while (cambio >= 1) {
                                    moneda1++;
                                    cambio -= 1;
                                }
                                while (cambio >= 0.5) {
                                    moneda05++;
                                    cambio -= 0.5F;
                                    cambio = (float) Math.round(cambio * 100) / 100;
                                }
                                while (cambio >= 0.2) {
                                    moneda02++;
                                    cambio -= 0.2f;
                                    cambio = (float) Math.round(cambio * 100) / 100;
                                }
                                while (cambio >= 0.1) {
                                    moneda01++;
                                    cambio -= 0.1f;
                                    cambio = (float) Math.round(cambio * 100) / 100;
                                }
                                while (cambio >= 0.05) {
                                    moneda005++;
                                    cambio -= 0.05f;
                                    cambio = (float) Math.round(cambio * 100) / 100;
                                }
                                while (cambio >= 0.02) {
                                    moneda002++;
                                    cambio -= 0.01f;
                                    cambio = (float) Math.round(cambio * 100) / 100;
                                }
                                while (cambio > 0) {
                                    moneda001++;
                                    cambio -= 0.01f;
                                    cambio = (float) Math.round(cambio * 100) / 100;
                                }
                                //Para monstrar solo las monedas y billetes que se dan en el cambio
                                if (billete50 > 0) System.out.println("Hay: " + billete50 + " billetes de 50€");
                                if (billete20 > 0) System.out.println("Hay: " + billete20 + " billetes de 20€");
                                if (billete10 > 0) System.out.println("Hay: " + billete10 + " billetes de 10€");
                                if (billete5 > 0) System.out.println("Hay: " + billete5 + " billetes de 5€");
                                if (moneda2 > 0) System.out.println("Hay: " + moneda2 + " monedas de 2€");
                                if (moneda1 > 0) System.out.println("Hay: " + moneda1 + " monedas de 1€");
                                if (moneda05 > 0) System.out.println("Hay: " + moneda05 + " monedas de 0.5€");
                                if (moneda02 > 0) System.out.println("Hay: " + moneda02 + " monedas de 0.2€");
                                if (moneda01 > 0) System.out.println("Hay: " + moneda01 + " monedas de 0.1€");
                                if (moneda005 > 0) System.out.println("Hay: " + moneda005 + " monedas de 0.05€");
                                if (moneda002 > 0) System.out.println("Hay: " + moneda002 + " monedas de 0.02€");
                                if (moneda001 > 0) System.out.println("Hay: " + moneda001 + " monedas de 0.01€");
                                System.out.println("Pulse cualquier tecla para continuar");
                                s.nextLine();

                                //Actualizamos la cantidad de cambio que queda
                                billete50res -= billete50;
                                billete20res -= billete20;
                                billete10res -= billete10;
                                billete5res -= billete5;
                                moneda2res -= moneda2;
                                moneda1res -= moneda1;
                                moneda05res -= moneda05;
                                moneda02res -= moneda02;
                                moneda01res -= moneda01;
                                moneda005res -= moneda005;
                                moneda002res -= moneda002;
                                moneda001res -= moneda001;
                                sePinta = true;
                            }

                            lineaDescuento = (hayDescuento) ? String.valueOf(cantidadDescuento) : "No hay descuento";

                            if (op == 1) fechaElegida = fechaCri;
                            if (op == 2) fechaElegida = fechaConO;
                            if (op == 3) fechaElegida = fechaConJa;
                            codEntrada = codEntrada.concat(obraSelec.substring(0, 2).concat(String.valueOf(fechaElegida)
                                            .substring(0, 2)).concat(nombreSitioElegido.substring(0, 2))
                                    .concat(String.valueOf(cantEntraCompradas).substring(1)).concat(String.valueOf(fecha).substring(0, 2)));

                            if (sePinta) {
                                for (int i = 1; i <= cantEntraCompradas; i++) {

                                    codEntrada = codEntrada.concat(String.valueOf(i));

                                    if (op == 1) {
                                        System.out.printf("""
                                                ╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
                                                ║    Esta es tu entrada %d de %d.                                                                                                             ║
                                                ║    Presenta la pagina entera en el evento                                                                                                 ║
                                                ║───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╣
                                                ║ ┼┼┼┼┼┼┼▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                                                                                          ║
                                                ║ ┼┼┼┼┼┼┼▒▒▒███▒▒▒▒▒███▒▒▒▒▒███▒▒▒                                                                                                          ║
                                                ║ ┼┼┼┼┼░┼░▒█░█░█▒▒▒█░█░█▒▒▒█░█░█▒▒                    Miercoles, 20 de noviembre de 2024                                                    ║
                                                ║ ┼┼┼┼░░░░░█████▒▒▒█████▒▒▒█████▒▒                    Teatro Maestro Álvarez Alonso                                                         ║
                                                ║ ┼░░┼░░░░░█░█░█▒▒▒█░█░█▒▒▒█░█░█▒▒                    Martos, Parque Manuel Carrasco                                                        ║
                                                ║ ░░░░░░░░▒█░█░█▒▒░░░░░░░▒▒█░█░█▒▒                    Jaen                                                                                  ║
                                                ║ ░░░░░░░░▒░░███▒▒░█░█░█░▒▒█████▒▒                                                                                                          ║
                                                ║ ┼░░░░█░░░░░░▒▒▒▒░█░█░█░▒▒▒▒▒▒▒▒▒┼┼█                 Las criadas  19:00h                                                                   ║
                                                ║ ░█░░██░░░░░░▒▒▒▒░░░░░░░▒▒▒▒▒▒▒▒▒┼███                                                                                                      ║
                                                ║ ░██░██░█░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█████               Los menores de 12 años le damos chuches                                               ║
                                                ║ ░░░█████░░░▒▒▒▒▒▒▒░░░░░▒▒▒▒▒▒▒▒▒┼░░░┼                                                                                                     ║
                                                ║ ░░░████░░░███▒▒▒░░█░█░░▒▒▒███▒▒▒┼░░░┼               ─────────────────────────────────────────                                             ║
                                                ║ ░░░████░░░███▒▒▒░░█░█░░▒▒▒███▒▒▒┼░░░┼                                                                                                     ║
                                                ║ ┼░░███┼▒▒█░█░█▒░░██░██░░▒█░█░█▒▒┼░░░┼               Entrada General %-50s                    ║
                                                ║ ┼┼░███┼▒▒█████▒░███░███░▒█████▒▒┼███┼               %-70s                ║
                                                ║ ┼┼┼███┼▒▒█░█░█▒░███░███░▒█░█░█▒▒┼┼█┼┼                                                                                                     ║
                                                ║ ┼┼┼███┼▒▒█░█░█▒░███░███░▒█░█░█▒▒┼┼█┼                   TicketPalex                                                                        ║
                                                ║ ┼┼┼███┼▒▒█████▒░███░███░▒█████▒▒┼┼█┼┼                  -----------                                                                        ║
                                                ║ ┼┼┼███┼▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                  TicketPalex.es                                                                     ║
                                                ║ ┼┼┼███┼▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼                                                                                                      ║
                                                ║ ┼░████░▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                  COD: %-50s                            ║
                                                ║ ░░░┼░░░▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                                 Precio entrada: %.2f € + IVA %d : %.2f € = %-10.2f              ║
                                                ║ ░░░░░░░░┼░░░┼░░▒▒▒▒▒▒▒▒▒░░░░░░░░░███┼                                 Descuento: %-50s       ║
                                                ║                                                                       Precio Total: %-10.2f                                            ║
                                                ╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝
                                                """, i, cantEntraCompradas, nombreSitioElegido, nombreSitioElegido, codEntrada, precioSinIva, IVA, cantidadIva, precioConIva, lineaDescuento, precioTotal);
                                    }

                                    if (op == 2) {
                                        System.out.printf("""
                                                ╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
                                                ║    Esta es tu entrada %d de %d.                                                                                                             ║
                                                ║    Presenta la pagina entera en el evento                                                                                                 ║
                                                ║───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╣
                                                ║ ┼┼┼┼┼┼┼▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                                                                                          ║
                                                ║ ┼┼┼┼┼┼┼▒▒▒███▒▒▒▒▒███▒▒▒▒▒███▒▒▒                                                                                                          ║
                                                ║ ┼┼┼┼┼░┼░▒█░█░█▒▒▒█░█░█▒▒▒█░█░█▒▒                    Jueves, 28 de noviembre de 2024                                                       ║
                                                ║ ┼┼┼┼░░░░░█████▒▒▒█████▒▒▒█████▒▒                    Teatro Maestro Álvarez Alonso                                                         ║
                                                ║ ┼░░┼░░░░░█░█░█▒▒▒█░█░█▒▒▒█░█░█▒▒                    Martos, Parque Manuel Carrasco                                                        ║
                                                ║ ░░░░░░░░▒█░█░█▒▒░░░░░░░▒▒█░█░█▒▒                    Jaen                                                                                  ║
                                                ║ ░░░░░░░░▒░░███▒▒░█░█░█░▒▒█████▒▒                                                                                                          ║
                                                ║ ┼░░░░█░░░░░░▒▒▒▒░█░█░█░▒▒▒▒▒▒▒▒▒┼┼█                 II Concierto de Otoño  22:00h                                                         ║
                                                ║ ░█░░██░░░░░░▒▒▒▒░░░░░░░▒▒▒▒▒▒▒▒▒┼███                                                                                                      ║
                                                ║ ░██░██░█░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█████               Los menores de 12 años le damos chuches                                               ║
                                                ║ ░░░█████░░░▒▒▒▒▒▒▒░░░░░▒▒▒▒▒▒▒▒▒┼░░░┼                                                                                                     ║
                                                ║ ░░░████░░░███▒▒▒░░█░█░░▒▒▒███▒▒▒┼░░░┼               ─────────────────────────────────────────                                             ║
                                                ║ ░░░████░░░███▒▒▒░░█░█░░▒▒▒███▒▒▒┼░░░┼                                                                                                     ║
                                                ║ ┼░░███┼▒▒█░█░█▒░░██░██░░▒█░█░█▒▒┼░░░┼               Entrada General %-50s                    ║
                                                ║ ┼┼░███┼▒▒█████▒░███░███░▒█████▒▒┼███┼               %-70s                ║
                                                ║ ┼┼┼███┼▒▒█░█░█▒░███░███░▒█░█░█▒▒┼┼█┼┼                                                                                                     ║
                                                ║ ┼┼┼███┼▒▒█░█░█▒░███░███░▒█░█░█▒▒┼┼█┼                   TicketPalex                                                                        ║
                                                ║ ┼┼┼███┼▒▒█████▒░███░███░▒█████▒▒┼┼█┼┼                  -----------                                                                        ║
                                                ║ ┼┼┼███┼▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                  TicketPalex.es                                                                     ║
                                                ║ ┼┼┼███┼▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼                                                                                                      ║
                                                ║ ┼░████░▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                  COD: %-50s                            ║
                                                ║ ░░░┼░░░▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                                 Precio entrada: %.2f € + IVA %d : %.2f € = %-10.2f              ║
                                                ║ ░░░░░░░░┼░░░┼░░▒▒▒▒▒▒▒▒▒░░░░░░░░░███┼                                 Descuento: %-50s       ║
                                                ║                                                                       Precio Total: %-10.2f                                            ║
                                                ╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝
                                                """, i, cantEntraCompradas, nombreSitioElegido, nombreSitioElegido, codEntrada, precioSinIva, IVA, cantidadIva, precioConIva, lineaDescuento, precioTotal);
                                    }

                                    if (op == 3) {
                                        System.out.printf("""
                                                ╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
                                                ║    Esta es tu entrada %d de %d.                                                                                                             ║
                                                ║    Presenta la pagina entera en el evento                                                                                                 ║
                                                ║───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╣
                                                ║ ┼┼┼┼┼┼┼▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒                                                                                                          ║
                                                ║ ┼┼┼┼┼┼┼▒▒▒███▒▒▒▒▒███▒▒▒▒▒███▒▒▒                                                                                                          ║
                                                ║ ┼┼┼┼┼░┼░▒█░█░█▒▒▒█░█░█▒▒▒█░█░█▒▒                    Viernes, 12 de diciembre de 2024                                                      ║
                                                ║ ┼┼┼┼░░░░░█████▒▒▒█████▒▒▒█████▒▒                    Teatro Maestro Álvarez Alonso                                                         ║
                                                ║ ┼░░┼░░░░░█░█░█▒▒▒█░█░█▒▒▒█░█░█▒▒                    Martos, Parque Manuel Carrasco                                                        ║
                                                ║ ░░░░░░░░▒█░█░█▒▒░░░░░░░▒▒█░█░█▒▒                    Jaen                                                                                  ║
                                                ║ ░░░░░░░░▒░░███▒▒░█░█░█░▒▒█████▒▒                                                                                                          ║
                                                ║ ┼░░░░█░░░░░░▒▒▒▒░█░█░█░▒▒▒▒▒▒▒▒▒┼┼█                 Concierto de Jazz  21:00h                                                             ║
                                                ║ ░█░░██░░░░░░▒▒▒▒░░░░░░░▒▒▒▒▒▒▒▒▒┼███                                                                                                      ║
                                                ║ ░██░██░█░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█████               Los menores de 12 años le damos chuches                                               ║
                                                ║ ░░░█████░░░▒▒▒▒▒▒▒░░░░░▒▒▒▒▒▒▒▒▒┼░░░┼                                                                                                     ║
                                                ║ ░░░████░░░███▒▒▒░░█░█░░▒▒▒███▒▒▒┼░░░┼               ─────────────────────────────────────────                                             ║
                                                ║ ░░░████░░░███▒▒▒░░█░█░░▒▒▒███▒▒▒┼░░░┼                                                                                                     ║
                                                ║ ┼░░███┼▒▒█░█░█▒░░██░██░░▒█░█░█▒▒┼░░░┼               Entrada General %-50s                    ║
                                                ║ ┼┼░███┼▒▒█████▒░███░███░▒█████▒▒┼███┼               %-70s                ║
                                                ║ ┼┼┼███┼▒▒█░█░█▒░███░███░▒█░█░█▒▒┼┼█┼┼                                                                                                     ║
                                                ║ ┼┼┼███┼▒▒█░█░█▒░███░███░▒█░█░█▒▒┼┼█┼                   TicketPalex                                                                        ║
                                                ║ ┼┼┼███┼▒▒█████▒░███░███░▒█████▒▒┼┼█┼┼                  -----------                                                                        ║
                                                ║ ┼┼┼███┼▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                  TicketPalex.es                                                                     ║
                                                ║ ┼┼┼███┼▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼                                                                                                      ║
                                                ║ ┼░████░▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                  COD: %-50s                            ║
                                                ║ ░░░┼░░░▒▒▒▒▒▒▒▒░███░███░▒▒▒▒▒▒▒▒┼┼█┼┼                                 Precio entrada: %.2f € + IVA %d : %.2f € = %-10.2f              ║
                                                ║ ░░░░░░░░┼░░░┼░░▒▒▒▒▒▒▒▒▒░░░░░░░░░███┼                                 Descuento: %-50s       ║
                                                ║ ┼░░░░┼░░░░░┼░░▒▒▒▒▒▒▒▒▒▒▒░░┼░░░░░███┼                                 Precio Total: %-10.2f                                            ║
                                                ╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝
                                                """, i, cantEntraCompradas, nombreSitioElegido, nombreSitioElegido, codEntrada, precioSinIva, IVA, cantidadIva, precioConIva, lineaDescuento, precioTotal);
                                    }

                                }
                            }


                        } else if (sitioElegido != 4) System.out.println("Opcion erronea");
                        else {
                            System.out.println("Volviendo al menu...");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else if (op != 4) System.out.println("Opcion erronea");
                    break;
                case 2://Consultar estado de los eventos

                    System.out.println("""
                            ┌───────────────────────────────────────┐
                            │ Elige la obra de la que quieres info: │
                            └───────────────────────────────────────┘
                            ╔═════════════════════════════════╗
                            ║   1. Las criadas                ║
                            ║   2. II Concierto de Otoño      ║
                            ║   3. Concierto de Jazz          ║
                            ║   4. Salir                      ║
                            ╚═════════════════════════════════╝
                            """);
                    op = Integer.parseInt(s.nextLine());
                    if (op >= 1 && op <= 3) {
                        System.out.println("""
                                ┌───────────────────────────────────────────┐
                                │  Elige la opción de la que quieres info:  │
                                └───────────────────────────────────────────┘
                                ╔══════════════════════════════════════════╗
                                ║   1. Entradas vendidas de cada tipo      ║
                                ║   2. Entradas libres de cada tipo        ║
                                ║   3. Días que quedan hasta el evento     ║
                                ║   4. Salir                               ║
                                ╚══════════════════════════════════════════╝
                                    """);
                        opInfoElegida = Integer.parseInt(s.nextLine());

                        switch (op) {
                            case 1://Las criadas
                                switch (opInfoElegida) {
                                    case 1://Entradas vendidas de cada tipo
                                        System.out.printf("""
                                                Entradas totales vendidas: %d
                                                Entradas platea vendidas: %d
                                                Entradas butaca vendidas: %d
                                                Entradas anfiteatro vendidas: %d
                                                \n""", (600 - entraTotaCri), (200 - entraPlaCri), (200 - entraBuCri), (200 - entraAnfCri));
                                        break;
                                    case 2://Entradas libres de cada tipo
                                        System.out.printf("""
                                                Entradas totales restantes: %d
                                                Entradas platea restantes: %d
                                                Entradas butaca restantes: %d
                                                Entradas anfiteatro restantes: %d
                                                \n""", entraTotaCri, entraPlaCri, entraBuCri, entraAnfCri);
                                        break;
                                    case 3://Dias que quedan hasta el evento
                                        fecha = fechaActu;
                                        diferenciaEnDias = ChronoUnit.DAYS.between(fechaActu, fechaCri);
                                        if (diferenciaEnDias < 0) System.out.println("El evento ya ha tenido lugar");
                                        else System.out.println("Faltan " + diferenciaEnDias + " días");

                                        if (diferenciaEnDias > 7) System.out.println("Tienes descuento\n");
                                        else System.out.println("No tienes descuento\n");
                                        break;
                                    case 4://Salir
                                        System.out.println("Saliendo al menú");
                                        break;
                                    default:
                                        System.out.println("Opción erroena");
                                }
                                break;
                            case 2://II Concierto de Otoño
                                switch (opInfoElegida) {
                                    case 1://Entradas vendidas de cada tipo
                                        System.out.printf("""
                                                Entradas totales vendidas: %d
                                                Entradas platea vendidas: %d
                                                Entradas butaca vendidas: %d
                                                Entradas anfiteatro vendidas: %d
                                                \n""", (600 - entraTotaConO), (200 - entraPlaConO), (200 - entraBuConO), (200 - entraAnfConO));
                                        break;
                                    case 2://Entradas libres de cada tipo
                                        System.out.printf("""
                                                Entradas totales restantes: %d
                                                Entradas platea restantes: %d
                                                Entradas butaca restantes: %d
                                                Entradas anfiteatro restantes: %d
                                                \n""", entraTotaConO, entraPlaConO, entraBuConO, entraAnfConO);
                                        break;
                                    case 3://Dias que quedan hasta el evento
                                        fecha = fechaActu;
                                        diferenciaEnDias = ChronoUnit.DAYS.between(fechaActu, fechaConO);
                                        if (diferenciaEnDias < 0) System.out.println("El evento ya ha tenido lugar");
                                        else System.out.println("Faltan " + diferenciaEnDias + " días");
                                        if (diferenciaEnDias > 7) System.out.println("Tienes descuento\n");
                                        else System.out.println("No tienes descuento\n");
                                        break;
                                    case 4://Salir
                                        System.out.println("Saliendo al menú");
                                        break;
                                    default:
                                        System.out.println("Opción erroena");
                                        break;
                                }
                                break;
                            case 3://Concierto de Jazz

                                switch (opInfoElegida) {
                                    case 1://Entradas vendidas de cada tipo
                                        System.out.printf("""
                                                        Entradas totales vendidas: %d
                                                        Entradas platea vendidas: %d
                                                        Entradas butaca vendidas: %d
                                                        Entradas anfiteatro vendidas: %d
                                                        \n""", (600 - entraTotaConJa), (200 - entraPlaConJa), (200 - entraBuConJa),
                                                (200 - entraAnfConJa));
                                        System.out.println("Pulsa para continuar: ");
                                        s.nextLine();
                                        break;
                                    case 2://Entradas libres de cada tipo
                                        System.out.printf("""
                                                Entradas totales restantes: %d
                                                Entradas platea restantes: %d
                                                Entradas butaca restantes: %d
                                                Entradas anfiteatro restantes: %d
                                                \n""", entraTotaConJa, entraPlaConJa, entraBuConJa, entraAnfConJa);
                                        System.out.println("Pulsa para continuar: ");
                                        s.nextLine();
                                        break;
                                    case 3://Dias que quedan hasta el evento
                                        fecha = fechaActu;
                                        diferenciaEnDias = ChronoUnit.DAYS.between(fechaActu, fechaConJa);
                                        //Este if comprueba si el evento ya ha tenido lugar
                                        if (diferenciaEnDias < 0) System.out.println("El evento ya ha tenido lugar");
                                        else System.out.println("Faltan " + diferenciaEnDias + " días");
                                        //Este if comprueba si tienes descuento
                                        if (diferenciaEnDias > 7) System.out.println("Tienes descuento\n");
                                        else System.out.println("No tienes descuento\n");
                                        break;
                                    case 4://Salir
                                        System.out.println("Saliendo al menú");
                                        break;
                                    default:
                                        System.out.println("Opción erroena");
                                        break;
                                }
                                break;
                        }
                    } else if (op != 4) System.out.println("Opcion erronea");
                    else System.out.println("Saliendo al menú");
                    break;
                case 3://Menu de administrador
                    System.out.print("Introduce tu usuario: ");
                    usuIntro = s.nextLine();
                    System.out.print("Introduce tu contraseña: ");
                    passIntro = s.nextLine();

                    if (!usuario.equals(usuIntro) || !password.equals(passIntro))
                        System.out.println("Usuario o contraseña incorrecta");
                    else {
                        do {
                            System.out.println("""
                                ┌────────────────┐
                                │   MENU ADMIN   │
                                └────────────────┘
                                ╔═════════════════════════════════════════════════════════════╗
                                ║   1. Consultar los ingresos totales por el evento           ║
                                ║   2. Consultar las monedas restantes para el cambio         ║
                                ║   3. Apagar el software                                     ║
                                ║   4. Salir                                                  ║
                                ╚═════════════════════════════════════════════════════════════╝
                                Introduce una opción:\s""");
                            opMenuAdmin = Integer.parseInt(s.nextLine());

                            switch (opMenuAdmin) {
                                case 1://Consultar los ingresos totales por el evento
                                    System.out.println("""
                                        ┌──────────────────────────────────────────┐
                                        │ Elige la obra para ver los ingresos:     │
                                        └──────────────────────────────────────────┘
                                        ╔═════════════════════════════════╗
                                        ║   1. Las criadas                ║
                                        ║   2. II Concierto de Otoño      ║
                                        ║   3. Concierto de Jazz          ║
                                        ║   4. Salir                      ║
                                        ╚═════════════════════════════════╝
                                            """);
                                    opIngresos = Integer.parseInt(s.nextLine());

                                    switch (opIngresos) {
                                        case 1:
                                            System.out.printf("Los ingresos totales de 'Las criadas': %.2f\n", ingresosTotalesCri);
                                            break;
                                        case 2:
                                            System.out.printf("Los ingresos totales de 'II Concierto de Otoño': %.2f\n", ingresosTotalesConO);
                                            break;
                                        case 3:
                                            System.out.printf("Los ingresos totales de 'Concierto de Jazz': %.2f\n", ingresosTotalesConJa);
                                            break;
                                        default:
                                            System.out.println("Opcion erronea");
                                            break;
                                    }

                                    break;
                                case 2://Consultar las monedas restantes para el cambio
                                    System.out.printf("Quedan %d billetes de 50€\n", billete50res);
                                    System.out.printf("Quedan %d billetes de 20€\n", billete20res);
                                    System.out.printf("Quedan %d billetes de 10€\n", billete10res);
                                    System.out.printf("Quedan %d monedas de 2€\n", moneda2res);
                                    System.out.printf("Quedan %d monedas de 1€\n", moneda1res);
                                    System.out.printf("Quedan %d monedas de 0.5€\n", moneda05res);
                                    System.out.printf("Quedan %d monedas de 0.2€\n", moneda02res);
                                    System.out.printf("Quedan %d monedas de 0.1€\n", moneda01res);
                                    System.out.printf("Quedan %d monedas de 0.05€\n", moneda005res);
                                    System.out.printf("Quedan %d monedas de 0.02€\n", moneda002res);
                                    System.out.printf("Quedan %d monedas de 0.01€\n", moneda001res);
                                    System.out.println("Pulsa una tecla para continuar");
                                    s.nextLine();
                                    break;
                                case 3://Apagar el software
                                    apagar = true;
                                    break;
                                case 4://Salir al menu principal
                                    System.out.println("Volviendo al menu");
                                    break;
                                default:
                                    System.out.println("Opcion introducida errónea");
                            }
                        } while (opMenuAdmin != 4 && opMenuAdmin != 3);
                    }
                    break;
                default:
                    System.out.println("Opcion erronea");
            }
            daEspacios = true;
        } while (!apagar);
    }
}