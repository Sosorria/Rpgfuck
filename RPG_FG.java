import java.util.Scanner;
import java.util.Random;

public class RPG_FG{

static int AtaqueUsuario() {
    Scanner leitor = new Scanner(System.in);
    System.out.println("Escolha seu ataque");
    System.out.println("(1) - Soco");
    System.out.println("(2) - Especial");
    System.out.println("(3) - poção");
    return leitor.nextInt();
}
static int AtaqueInimigo(){

    Random gerador = new Random();
    return gerador.nextInt(3)+1; //retorna um número entre 1 e 3 

}

static void imprimeHp(int Hpusuario, int HpComputador, int ContagemDeEspecial, int QuantidadeDePoções, int Money){

    System.out.println("===================");
    System.out.println("- Hp Usuario: " + Hpusuario);
    System.out.println("- Hp Computador "+ HpComputador);
    System.err.println("Contagem de especiais " + ContagemDeEspecial );
    System.out.println("Poções restantes: " + QuantidadeDePoções);
    System.out.println("Dinheiro: " + Money);
    System.out.println("===================");
}

// Área principal do sistema de mercado do Rpg

static void mercado(){
   //int PoçõesValor = 50
   System.out.println("O que você deseja comprar? ");  
   System.out.println("(1) - poção.");
   System.out.println("(2) - Não quero comprar nada.");      
    }


       //Sistema de lutas do Rpg 

static void batalhas(){
    Scanner leitor = new Scanner(System.in);
    int Hpusuario = 150;
    int HpComputador = 11;
    int ContagemDeEspecial = 5;
    int DanoDoESpecial = 20;
    int ContagemDemortes = 0;
    int EscolhaAtaque;
    int QuantidadeDePoções = 1;
    int Money = 0;
    int i = 1;
    int m = 1;
    int continua = 1;
    while (Hpusuario > 0 && HpComputador > 0) {
        
        System.out.println("************************");
        System.out.println("INIMIGO " + i);
        System.out.println("************************\n");

        imprimeHp(Hpusuario, HpComputador, ContagemDeEspecial, QuantidadeDePoções,Money);
        EscolhaAtaque = AtaqueUsuario();
        switch (EscolhaAtaque) {
            case 1:
                System.out.println("O usuario aplicou um soco");
                HpComputador -= 7;
                break;
            case 2:
            System.out.println("O usuario aplicou um ataque especial");
            HpComputador -= DanoDoESpecial;
            ContagemDeEspecial --; // Contagem de especial é = a ContagemDeEspecial - 1
            if (ContagemDeEspecial <= 0) {
                DanoDoESpecial = 0;
                ContagemDeEspecial = 0;
            }
            break;
            case 3:
              System.out.println("Você usou uma poção.\n");
              Hpusuario +=50;
              if (Hpusuario > 150) {
                Hpusuario = 150;
              } 
              QuantidadeDePoções--;
                break;

            default:
            System.out.println("Opção invalida.");
                break;
        }
        if(HpComputador > 0){
            EscolhaAtaque = AtaqueInimigo();
            switch (EscolhaAtaque) {
                case 1:
                System.out.println ("o Computador aplicou um soco");   
                Hpusuario -= 2 + (int)(i/10);
                    break;
                case 2:         
                System.out.println(" O computador aplicou um chute");
                Hpusuario -=3 + (int)(i/10);
                    break;
                case 3:
                System.out.println(" O computador aplicou um ataque especial");
                Hpusuario -=4 + (int)(i/20);
                 break;
            }
        }
        if (HpComputador <= 0) {
          System.out.println("Inimigo derrotado");
          HpComputador = 10 + i;
          i++;
          ContagemDemortes = ContagemDemortes + m; // Contagem de mortes + 1(m)
          Money = Money + 5; 

          Hpusuario += 5;
          if (Hpusuario > 150) {

              Hpusuario = 150;
          }
          if (i % 10 == 0) {
              ContagemDeEspecial++ ;
              if (ContagemDeEspecial >= 5) {
                  ContagemDeEspecial = 5;

      
             } 
          }
        } 
            
        } 
        
        
        if (Hpusuario <= 0){

            System.out.println("VOCÊ FOI DERROTADO.\n");
            System.out.println("++++++++++++++++++++");
            System.out.println("VocÊ matou:  " + ContagemDemortes);
            System.out.println("++++++++++++++++++++");
        }

        // Sistema de compras.
          

         if (ContagemDemortes % 5 == 0) {
            mercado();
         }

          
     
           
           
           


 }   
    public static void main(String[]args){
    Scanner leitor = new Scanner(System.in);
    int continua = 1;
    while(continua == 1){
        
        batalhas();

        System.out.println("Fim do jogo. Dejesa continuar? (1) sim (2) nâo");
        continua = leitor.nextInt();
    
    }
  }
}


