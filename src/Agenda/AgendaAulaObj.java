package Agenda;

/**
 *
 * @author Rita
 */
import java.io.*;
import java.util.Scanner;

public class AgendaAulaObj{

    /*
     NReg controla o número de registos introduzidos
     */
    public static int nReg=0;
    static Scanner ler=new Scanner(System.in);
    public static void main(String[] args){

        Contacto[] agenda=new Contacto[50];
        if (carregaContactos()!=null){
            agenda=carregaContactos();
        }

        System.out.println(Contacto.getContaNum());
        imprimirContactos(agenda,nReg);
        
         
        
        //Inserir 2 contactos
       /*int inicio=nReg;
        System.out.println(inicio);
        for(int i=inicio;i<inicio+2;i++){
            agenda[i]=insereContacto();
            ler.nextLine();
            nReg++;
        }*/
           
       //só faz sentido criar um ficheiro se houver registos para guardar
       //mas funciona sem o if
       if(nReg>0)
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

    private static int eliminaContactov1(Contacto[] v, int pos, int nElem){

        for (int i=pos;i<nElem-1;i++)
          v[i]=v[i+1];

        return --nElem;
    }

    private static int eliminaContactov2(Contacto[] v, int pos,int nElem){

         v[pos]=v[nElem-1];

        return --nElem;
    }

    private static int pesqTelefone(Contacto[]v, int nElem, int numT){

        int i=0;
        while(i<nElem && numT!=v[i].getTelefone())
            i++;
        if (i<nElem)
            return i;
        else
            return -1;

    }

    private static int pesqNome(Contacto[]v, int nElem, String nomeP){

        int i=0;
        while(i<nElem && !nomeP.equalsIgnoreCase(v[i].getNome()))
            i++;
        
        if (i<nElem)
            return i;
        else
            return -1;

    }

    private static void imprimirContactos(Contacto [] tab, int nElem){
      for (int i=0;i<nElem;i++)
          imprimeContacto(tab[i]);
            
    }

    private static void listarTipo(Contacto [] tab, int nElem, boolean tipo){
      for (int i=0;i<nElem;i++)
          if (tab[i].isMovel()==tipo){
             imprimeContacto(tab[i]);
            }
    }

    private static Contacto [] carregaContactos(){
        Contacto [] aux=new Contacto[50];
        Contacto.initContaNum(0);
        try {
            ObjectInputStream in=
                    new ObjectInputStream(new FileInputStream("contactos.dat"));
            nReg=in.readInt();
            Contacto.initContaNum(in.readInt());
            aux=(Contacto []) in.readObject();        
            in.close();
            return aux;

        }
        catch (ClassNotFoundException ex) {
            System.out.println("Classe inexistente!");
            return null;
        }
        catch (FileNotFoundException ex)  {
            System.out.println("Ficheiro inexistente!");
            return null;

        }
        catch (IOException ex) {
            System.out.println("Erro de leitura!");
            return null;
        }

        
    }

    // guarda nRegistos, último número atribuido ao contacto e array de contactos
    private static void guardaContactos(Contacto[] ag) {

        try {
            ObjectOutputStream out=
                    new ObjectOutputStream(new FileOutputStream("contactos.dat"));
            out.writeInt(nReg);
            out.writeInt(Contacto.getContaNum());
            out.writeObject(ag);
            out.close();
        }
        catch (IOException ex) {
            System.out.println("Erro de escrita!");
        }


    }


    }


