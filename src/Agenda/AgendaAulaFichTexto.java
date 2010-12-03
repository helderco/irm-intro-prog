/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agenda;

/**
 *
 * @author Rita
 */
import java.io.*;
import java.util.Scanner;
public class AgendaAulaFichTexto {

    /**
     * @param args the command line arguments
     */
    static Scanner ler=new Scanner(System.in);
    public static int nReg=0;
    public static void main(String[] args) {
       
        Contacto[] agenda=new Contacto[50];
        //ler os contactos do ficheiro
        agenda=carregaContactos();
        imprimirContactos(agenda,nReg);
        //Inserir 1 contactos
        int inicio=nReg;
       
        for(int i=inicio;i<inicio+1;i++){
            agenda[i]=insereContacto();
            ler.nextLine();
            nReg++;
        }
        if (nReg>0)
            guardaContactos(agenda);

    }


    private static Contacto insereContacto(){

        String nomeC; int tel; boolean t;
        char op;
        System.out.println("Nome:");
        nomeC=ler.nextLine();
        do{
            System.out.println("Nº Telefone:");
            tel=ler.nextInt();
        }while(tel<100000000||tel>999999999);

        do{
            System.out.println("Tipo (m/f):");
            op=ler.next().charAt(0);

        }while(op!='m'&& op!='M'&& op!='f'&& op!='F');

        if (op=='m'||op=='M')
            t=true;
        else
            t=false;
        return new Contacto(nomeC,tel,t);
    }

    private static void imprimeContacto(Contacto c){
        System.out.println("Nº:"+c.getNumero());
        System.out.println("Nome:"+c.getNome());
        System.out.println("Telefone:"+c.getTelefone());
        if (c.isMovel()==true)
         System.out.println("Móvel");
        else
            System.out.println("Fixo");
    }
    private static void imprimirContactos(Contacto [] tab, int nElem){
      for (int i=0;i<nElem;i++)
          imprimeContacto(tab[i]);

    }

    private static Contacto[] carregaContactos() {
        int i=0;
        Contacto.initContaNum(0);
        Contacto [] aux=new Contacto[50];
        try {
            BufferedReader in = new BufferedReader(new FileReader("contactos.txt"));
            String [] cont;
            
            String linha=in.readLine();
            // se o ficheiro já existe
            if (linha!=null)
                Contacto.initContaNum(Integer.parseInt(linha));
            linha=in.readLine();
            while(linha!=null){
                cont=linha.split(",");
                //inteiro, string,inteiro, booleano
                aux[i]=new Contacto(
                        Integer.parseInt(cont[0]),
                        cont[1],
                        Integer.parseInt(cont[2]),
                        Boolean.parseBoolean(cont[3])
                        );
                i++;

                linha=in.readLine();
            }
            nReg=i;
            in.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro inexistente!");

        }
        catch (IOException ex) {
            System.out.println("Erro de leitura!");
           
        }

        finally{
             return aux;
        }
    }

    private static void guardaContactos(Contacto[] ag) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("contactos.txt"));
            //várias formas de transformar um inteiro num string
            //out.write(String.valueOf(Contacto.getContaNum()));
            //out.write(Integer.toString(Contacto.getContaNum()));
            out.write(Contacto.getContaNum()+"");
            out.newLine();
            for(int i=0;i<nReg;i++){
               out.write(ag[i].getNumero()+","+
                       ag[i].getNome()+","+
                       ag[i].getTelefone()+","+
                       ag[i].isMovel());
               out.newLine();
            }
            
            
            out.close();
        }
        catch (IOException ex) {
            System.out.println("Erro de escrita!");

        }


    }


    }


