package main;

import Csv.Csv;
import basedatos.BaseDatos;
import java.util.*;
import conexion.Conexion;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import modelo.Donaciones;
import modelo.Donadores;
import modelo.ImprimirCsv;

public class MainTransation {

    public static void main(String[] args) throws SQLException {
        Scanner teclado = new Scanner(System.in);
        Conexion c1 = new Conexion("jdbc:mysql://localhost:3306/fundacion?serverTimezone=UTC", "root", "root");
        Donaciones donaciones = new Donaciones();
        Donadores donadores = new Donadores();
        ImprimirCsv imprimir = new ImprimirCsv();
        BaseDatos DB = new BaseDatos("jdbc:mysql://localhost:3306/fundacion?serverTimezone=UTC", "root", "root");
        int b;
        String nombreF = "Novatec Fudation";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = new Date();
        String fechi =sdf.format(fecha);
        int valor;
        int descontado = 0;
        int gol = 0;
        int devolver;
        int valorConvertido = 0;
        int opcion1 = 0;
        int opcion2 = 0;
        int opcion,opcion4;
        int opcion3 = 0;

    
    
        do
        {
            System.out.println("*************************************");
            System.out.println(" Bienvenidos a la fundacion novatec   ");
            System.out.println("*************************************");
            System.out.println("");
            System.out.println("");

            System.out.println("Para ingresar a nuestro registro debe de tener disponibilidad de un millon de pesos a mas...");
            System.out.println("Solo se podran registrar 10 personas a la fundacion!");
            System.out.println("");
            System.out.println("Si su dinero esta en moneda extranjera, porfavor digite la aquivalencia que tiene en pesos colombianos?");
            System.out.print("Valor : ");
            b = teclado.nextInt();
            if (b >= 1000000)
            {
                opcion1 = 3;
                System.out.println("");
            }else{
                System.out.println("No esta permitido para realizar el registro");
                System.out.println("");
            }
        } while (opcion1 != 3);

        do
        {
            System.out.println("       -------- Perfecto ---------");
            System.out.println("");
            System.out.println("Comenezemos con el registro a la fundacion!");
            System.out.println("");
            System.out.print("Ingresa porfavor tu numero de documento : ");
            int dato1 = teclado.nextInt();
            int documento = 0;
            if (dato1 > 999999999)
            {
                 documento = dato1;
            }else{
                System.out.println("documento no valido");
            }
            System.out.println("");
            System.out.print("Ingresa porfavor tu primer nombre : ");
            String nom = teclado.next();
            String nombre = nom.trim();
            System.out.println("");
            System.out.print("Ingresa porfavor tu primer apellido : ");
            String ape = teclado.next();
            String apellido = ape.trim();
            System.out.println("");
            do
            {
                System.out.print("Ingresa porfavor una cantidad no mayor a 2 millones pero que sea mayor a lo acordado (1 millon)");
                System.out.println("En que moneda desea realizar la transferencia a la fundacion?");
                System.out.println("Debe ingresar el valor a lo equivalente a pesos colombianos en la moneda que elija!");
                System.out.println("El plazo para realizar la donacion es hasta "+LocalDate.now().plusDays(5));
                System.out.println("Porfavor digite la cantidad que desea donar a lo que ya tiene a su cargo");
                System.out.println("MENU MONEDA");
                System.out.println("1. Euro");
                System.out.println("2. Peso chileno");
                System.out.println("3. PesoArgentino");
                System.out.println("4. Dolar");
                System.out.println("5. Pesos Colombianos");
                System.out.print("Opcion : ");
                opcion = teclado.nextInt();
                switch (opcion)
                {
                    case 1:
                        System.out.print("Digite el valor en Euros a transferir : ");
                        valor = teclado.nextInt();
                        valorConvertido =donaciones.euroPesos(valor);
                        if (valorConvertido > 999999 && valorConvertido <= 2000000)
                        {
                            donadores = new Donadores(documento, nombre, apellido, valor, nombreF);
                            donaciones = new Donaciones(documento, "Euros", valor, fechi);
                            imprimir = new ImprimirCsv(documento, nombre, valorConvertido, nombreF, fechi);
                            
                            if (DB.insertarDonador(donadores) && DB.insertarDonaciones(donaciones) && DB.insertarCsv(imprimir))
                            {
                                if (valorConvertido >= 1800000 && valorConvertido <= 2000000)
                                {
                                descontado =  (valorConvertido * 20) / 100;//lo que quita la empresa
                                gol = (descontado * 25) / 100;//lo que se queda la empresa al devolver el dinero
                                System.out.println("Se ha descontado el 20% de lo donado, es decir, : "+descontado);
                                }else{
                                 descontado =  (valorConvertido *17) /100;
                                 gol = (descontado * 25) / 100;
                                System.out.println("Se ha descontado el 17% de lo donado, es decir, : "+descontado);
                                }
                                System.out.println("Registro exitoso!");
                                opcion3 = 2;
                            }else{
                                System.out.println("Huvo un error de registro");
                            }
                        } else
                        {
                            System.out.println("El valor a transferir no corresponde a lo acordado");
                        }
                        break;
                    case 2:
                        System.out.print("Digite el valor en Pesos Chilenos a transferir : ");
                        valor = teclado.nextInt();
                        valorConvertido = donaciones.chilenosPesos(valor);
                        if (valorConvertido > 999999 && valorConvertido <= 2000000)
                        {
                            donadores = new Donadores(documento, nombre, apellido, valor, nombreF);
                            donaciones = new Donaciones(documento, "Pesos Chilenos", valor, fechi);
                            imprimir = new ImprimirCsv(documento, nombre, valorConvertido, nombreF, fechi);
                            if (DB.insertarDonador(donadores) && DB.insertarDonaciones(donaciones) && DB.insertarCsv(imprimir))
                            {
                                if (valorConvertido >= 1800000 && valorConvertido <= 2000000)
                                {
                                descontado =  (valorConvertido * 20) / 100;//lo que quita la empresa
                                gol = (descontado * 25) / 100;//lo que se queda la empresa al devolver el dinero
                                System.out.println("Se ha descontado el 20% de lo donado, es decir, : "+descontado);
                                }else{
                                 descontado =  (valorConvertido *17) /100;
                                 gol = (descontado * 25) / 100;
                                System.out.println("Se ha descontado el 17% de lo donado, es decir, : "+descontado);
                                }
                                System.out.println("Registro exitoso!");
                                opcion3 = 2;
                            }else{
                                System.out.println("Huvo un error de registro");
                            }
                        } else
                        {
                            System.out.println("El valor a transferir no corresponde a lo acordado");
                        }
                        break;
                    case 3:
                        System.out.print("Digite el valor en Pesos argentinos a transferir : ");
                        valor = teclado.nextInt();
                        valorConvertido = donaciones.argentinoPesos(valor);
                        if (valorConvertido > 999999 && valorConvertido <= 2000000)
                        {
                            donadores = new Donadores(documento, nombre, apellido, valor, nombreF);
                            donaciones = new Donaciones(documento, "Pesos Argentinos", valor, fechi);
                            imprimir = new ImprimirCsv(documento, nombre, valorConvertido, nombreF, fechi);
                            if (DB.insertarDonador(donadores) && DB.insertarDonaciones(donaciones)  && DB.insertarCsv(imprimir))
                            {
                                if (valorConvertido >= 1800000 && valorConvertido <= 2000000)
                                {
                                descontado =  (valorConvertido * 20) / 100;//lo que quita la empresa
                                gol = (descontado * 25) / 100;//lo que se queda la empresa al devolver el dinero
                                System.out.println("Se ha descontado el 20% de lo donado, es decir, : "+descontado);
                                }else{
                                 descontado =  (valorConvertido *17) /100;
                                 gol = (descontado * 25) / 100;
                                System.out.println("Se ha descontado el 17% de lo donado, es decir, : "+descontado);
                                }
                                System.out.println("Registro exitoso!");
                                opcion3 = 2;
                            }else{
                                System.out.println("Huvo un error de registro");
                            }
                        } else
                        {
                            System.out.println("El valor a transferir no corresponde a lo acordado");
                        }
                        break;
                    case 4:
                        System.out.print("Digite el valor en Dolares a transferir : ");
                        valor = teclado.nextInt();
                        valorConvertido = donaciones.DolarPeso(valor);
                        if (valorConvertido> 999999 && valorConvertido <= 2000000)
                        {
                            donadores = new Donadores(documento, nombre, apellido, valor, nombreF);
                            donaciones = new Donaciones(documento, "Dolar", valor, fechi);
                            imprimir = new ImprimirCsv(documento, nombre, valorConvertido, nombreF, fechi);
                           if (DB.insertarDonador(donadores) && DB.insertarDonaciones(donaciones) && DB.insertarCsv(imprimir))
                            {
                                if (valorConvertido >= 1800000 && valorConvertido <= 2000000)
                                {
                                descontado =  (valorConvertido * 20) / 100;//lo que quita la empresa
                                gol = (descontado * 25) / 100;//lo que se queda la empresa al devolver el dinero
                                System.out.println("Se ha descontado el 20% de lo donado, es decir, : "+descontado);
                                }else{
                                 descontado =  (valorConvertido *17) /100;
                                 gol = (descontado * 25) / 100;
                                System.out.println("Se ha descontado el 17% de lo donado, es decir, : "+descontado);
                                }
                                System.out.println("Registro exitoso!");
                                opcion3 = 2;
                            }else{
                                System.out.println("Huvo un error de registro");
                            }
                        } else
                        {
                            System.out.println("El valor a transferir no corresponde a lo acordado");
                        }
                        break;
                    case 5:
                        System.out.print("Digite el valor en Pesos Colombianos a transferir : ");
                        valor = teclado.nextInt();
                        valorConvertido = valor;
                        if (valorConvertido > 999999 && valorConvertido <= 2000000)
                        {
                            donadores = new Donadores(documento, nombre, apellido, valor, nombreF);
                            donaciones = new Donaciones(documento, "Pesos Colombianos", valor, fechi);
                            imprimir = new ImprimirCsv(documento, nombre, valorConvertido, nombreF, fechi);
                            if (DB.insertarDonador(donadores) && DB.insertarDonaciones(donaciones) && DB.insertarCsv(imprimir))
                            {
                                if (valorConvertido >= 1800000 && valorConvertido <= 2000000)
                                {
                                descontado =  (valor * 20) / 100;//lo que quita la empresa
                                gol = (descontado * 25) / 100;//lo que se queda la empresa al devolver el dinero
                                System.out.println("Se ha descontado el 20% de lo donado, es decir, : "+descontado);
                                }else{
                                 descontado =  (valor *17) /100;
                                 gol = (descontado * 25) / 100;
                                System.out.println("Se ha descontado el 17% de lo donado, es decir, : "+descontado);
                                }
                                System.out.println("Registro exitoso!");
                                opcion3 = 2;
                            }else{
                                System.out.println("Huvo un error de registro");
                            }
                        } else{
                            System.out.println("El valor a transferir no corresponde a lo acordado");
                        }
                        break;
                    default:
                        System.out.println("Valor invalido");
                }
            } while (opcion3 != 2);
                      do{
                System.out.println("");
                System.out.println("Menu");
                System.out.println("1. Quiero mi certificado de registro y donacion");
                System.out.println("2. Me quiero retirar");
                System.out.println("3. Salir");
                opcion4 = teclado.nextInt();
                
                switch (opcion4)
                {
                    case 1:
                        Csv csv = new Csv();
                        List<ImprimirCsv> lista = DB.listarCliente();
                        csv.toCsv(lista);
                        break;
                    case 2:
                        System.out.println("");
                        b = (int) (b - valorConvertido);
                        int total = descontado - gol;
                        int mTotal = valorConvertido - gol;
                        if (b == 0)
                        {
                            System.out.println("No hay devuleta de dinero has donado todo!");
                        }else{
                            System.out.println("Los donadores que se retiran, la fundacion decuenta un 25% del valor total de su donacion");
                            System.out.println("De los "+descontado+" tu saldo devuelto es : "+total);
                            System.out.println("De "+valorConvertido+" se te han devuelto : "+mTotal);
                            opcion2 = 1;
                            opcion4 = 3;
                        }
                        break;
                    case 3:
                        opcion4 = 3;
                        break;
                    default:
                        System.out.println("Valor invalido");
                }
            }while(opcion4 != 3);
            
        } while (opcion2 != 1 );
        
        
        
    }
}
