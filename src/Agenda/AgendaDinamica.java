
package Agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class AgendaDinamica {


    public static void main(String[] args) {

        Vector<Contacto> v = new Vector<Contacto>();


        //ler 5 contactos
        for(int i=0; i<2; i++)
            v.add(insereContacto());
        imprimirContactos(v);

    }


    private static Contacto insereContacto(){
         Scanner ler=new Scanner(System.in);
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
    private static void imprimirContactos(Vector<Contacto> tab){
      for (int i=0;i<tab.size();i++)
          imprimeContacto(tab.get(i));

    }


    public static Vector<Contacto> carregaContactos() {

        Contacto.initContaNum(0);
        Vector<Contacto> aux=new Vector<Contacto>();
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
                aux.add(new Contacto(
                        Integer.parseInt(cont[0]),
                        cont[1],
                        Integer.parseInt(cont[2]),
                        Boolean.parseBoolean(cont[3])
                        ));


                linha=in.readLine();
            }
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

    public static void guardaContactos(Vector<Contacto> ag) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("contactos.txt"));
            //várias formas de transformar um inteiro num string
            //out.write(String.valueOf(Contacto.getContaNum()));
            //out.write(Integer.toString(Contacto.getContaNum()));
            out.write(Contacto.getContaNum()+"");
            out.newLine();
            for(int i=0;i<ag.size();i++){
               out.write(ag.get(i).getNumero()+","+
                       ag.get(i).getNome()+","+
                       ag.get(i).getTelefone()+","+
                       ag.get(i).isMovel());
               out.newLine();
            }


            out.close();
        }
        catch (IOException ex) {
            System.out.println("Erro de escrita!");

        }
    }
}