//Importações
import java.util.Scanner;
//Inicio Classe
public class Viper_Game{
  
//Variáveis Globais
  static Scanner entrada = new Scanner (System.in); //Scanner
  static int opcaoluta, opcaomenu, voltamenu; //Seleção Menus
  static int escolhaclasse, ConfirmarClasseVita; //Escolha Classe
  static int[] V_inimigos = {10,20,30,40,50,60,70,80};//Vida Inimigos
  static int[] F_inimigos = {1,2,03,4,5,6,7,8};//Força Inimigos
  static int[] V_perso = {50,55,60,45};//Vida Personagens
  static int[] F_perso = {5,4,3,7};//Força Personagens                   
  static int inimigo_at=0;//Inimigo Que está lutando
  static int historia_at=1;//Parte da História
  static int pontuacao = 0;//Pontuação
  //Vetor Nome das Classes
  static String classes[] = {"Android","Robô","Ciborgue","Humano"};
  //Vetor Nome dos Inimigos|
  static String inimigos[] = {"Uhktan Lança","Uhktan Arqueiro","Uhktan Guerreiro","Grande Uhktan","Chefe Uhktan","Mestre Uhktan","Lorde Uhktan","Boss-Tankunh"};

  //Main   
  public static void main(String[] args) {
    nomeviper(); //Slogan
      do{ //Laço Menu Inicial
        menujogo();
        opcaomenu = entrada.nextInt();
        switch(opcaomenu){
        case 1: //Opção: Jogar
          quadroIntroducao();
        break;
        case 2: //Opção: Como jogar
          quadroComoJogar();
        break;
        case 3: //Opção: Créditos
          quadroCreditos();
        break;
        case 4: //Opção: Sair
        break;
        default:
          System.out.println("|=================================|");  
          System.out.println("|  ***   Opção Inválida...   ***  |");
          System.out.println("|=================================|");
        }//Fim Switch
      }while(opcaomenu !=4);  //Fim Do-While , Saida do laço
        System.out.println("    ***  Jogo Encerrado  ***  ");
        System.out.println("|=============================|");
        System.out.println("|  Obrigado por jogar Viper   |");
        System.out.println("|=============================|");
 }//Fim Main
  
//---------------------------FUNÇÕES|
  //Cenas História
  public static void historia (int h){
  h=historia_at;
   switch(h){
    case 1:
      historia01();
    break;
    case 2:
      historia02();
    break;
     case 3:
      historia03();
    break;
     case 4:
      historia04();
    break;
    case 5:
      historia05();
    break;
    case 6:
      historia06();
    break;
    case 7:
      historia07();
    break;
    case 8:
      historia08();
    break;
     case 9:
      historia09();
   }
 }
//Contagem de Pontos
  //Ganha Pontos
  public static void ganhaponto (int p){
    p=pontuacao++;
    System.out.println("               ***  Parabéns  ***  ");
    System.out.println("|=============================================");
    System.out.println("| Você derrotou ["+inimigos[inimigo_at]+"].");
    System.out.println("| Você ganhou + [1] Ponto.");
    System.out.println("| Sua Pontuação: ["+pontuacao+"].");
    System.out.println("|=============================================");
    System.out.println("|");
    tecleParaContinuar();
  } // Fim Ganha Ponto

  //Não Ganha Pontos
  public static void naoganhaponto (int p){
    p=pontuacao+0;
    System.out.println("        ***  Você conseguiu fugir!!!  ***  ");
    System.out.println("|=============================================");
    System.out.println("| Você não derrotou ["+inimigos[inimigo_at]+"].");
    System.out.println("| Você não ganhou ponto nessa luta.");
    System.out.println("| Sua Pontuação: ["+p+"].");
    System.out.println("|=============================================");
    System.out.println("|");
    tecleParaContinuar();
  } //Fim Não Ganha Ponto
  
  //Perde Pontos
  public static void perdeponto(int p){
    p=pontuacao--;    
    System.out.println("           ***  Ahn Não Você Morreu!!!  ***  ");
    System.out.println("|=============================================");
    System.out.println("| Você perdeu para ["+inimigos[inimigo_at]+"].");
    System.out.println("| Você perdeu [1] Ponto.");
    System.out.println("| Sua Pontuação: ["+p+"].");
    System.out.println("|=============================================");
    System.out.println("|");
    tecleParaContinuar();
  } //Fim Perde Pontos
//Fim Contagem de Pontos
  
  //SelecionarClasse
  static void selecionarClasse(){
    escolhaclasse = entrada.nextInt();
    switch(escolhaclasse){
      case 1: case 2: case 3: case 4:
        System.out.println("");
        System.out.println("| - Você escolheu a Classe ["+escolhaclasse+" - "+classes[escolhaclasse-1]+"]");
        System.out.println("| *** Digite [1] Para Confirmar; [2] Para Sair. ***");
        ConfirmarClasseVita = entrada.nextInt();
        if(ConfirmarClasseVita == 1) {
          historia(historia_at);
          quadroLuta();
        }else{
          quadroEscolhaClasse();
        }
      break;
      case 5://Opção "Voltar ao Menu"
      break;
    default:
      System.out.println("");
      System.out.println("|=================================|");  
      System.out.println("|    ***  Opção Inválida...  ***  |");
      System.out.println("|=================================|");
      System.out.println("");
      } //Fim Switch  
  } //Fim Selecionar Classe
  
  //Decisão Luta
  static void decisaoluta(){      
    opcaoluta = entrada.nextInt(); 
    switch(opcaoluta){
      case 1: //Lutar
        if(V_perso[escolhaclasse-1]>V_inimigos[inimigo_at]){
          ganhaponto(pontuacao);
          inimigo_at++;
          historia_at++;
          historia(historia_at);
          quadroLuta();
        }
        else{
          perdeponto(pontuacao);
          inimigo_at++;
          historia_at++;
          historia(historia_at);
          quadroLuta();
        }
      break;
      case 2: //Fugir
        if(inimigo_at<8){
          naoganhaponto(pontuacao);
          inimigo_at++;
          historia_at++;
          historia(historia_at);
          quadroLuta();
        }else{
          quadroterminoujogo();
          }
      break;
    default:
      System.out.println("|=================================|");  
      System.out.println("|  ***   Opção Inválida...   ***  |");
      System.out.println("|=================================|");
      } //Fim Switch
  }//Fim Decisão Luta

  //Tecle para continuar
  public static void tecleParaContinuar(){
		System.out.println("===============================");
		System.out.println("|Tecle Enter para Continuar...|");
		System.out.println("===============================");
		try {
			System.in.read();
			entrada.nextLine();
		} catch (Exception e) {
		}
	}//Fim Tecle para continuar

  //Tecle para Voltar
  public static void tecleParaVoltar(){
		System.out.println("===============================");
		System.out.println("|  Tecle Enter para Voltar... |");
		System.out.println("===============================");
		try {
			System.in.read();
			entrada.nextLine();
		} catch (Exception e) {
		}
	}//Fim Tecle para Voltar
  
  //batalha
  
  
//-------------------------FIM FUNCIONALIDADES|

//-------------------------QUADROS HISTÓRIA|  
  //Quadro História 0.1
  static void historia01(){
    System.out.println("                                     *Inicio da Jornada*");
    System.out.println("|=============================================================================================|");
    System.out.println("|                    A equipe Viper se prepara para sua missão em Valtrovia                   |");
    System.out.println("|                            afim de enfrentar diretamente os ???,                            |");
    System.out.println("|             eles embarcam em uma nave junto com uma tropa do Exercito Vitroviano.           |");
    System.out.println("|                            Quando estavam próximos de Valtrovia                             |");
    System.out.println("|      foram surpreendidos pelos inimigos que começaram a abater as naves aliadas...          |");
    System.out.println("|     Várias naves foram abatidas no ar, outras em acidentes com as naves abatidas...         |");
    System.out.println("|                                                                                             |");
    System.out.println("|                       Alguns sobrevivem, porem outros morreram ali mesmo...                 |");
    System.out.println("|    antes mesmo de conseguirem chegar ao solo. No solo tem muitos destroços caindo no céus,  |");
    System.out.println("|                       a equipe Viper pula da nave e consegue aterrissar,                    |");
    System.out.println("|                                é hora de enfrentar os inimigos:                             |");
    System.out.println("|=============================================================================================|"); 
    tecleParaContinuar();
  }//Fim Quadro História 0.1 

  //Quadro História 0.2
  static void historia02(){
    System.out.println("|=============================================================================================|");
    System.out.println("|           Os Viper demonstram resultados positivos em batalha contra os ???,                |");
    System.out.println("|    a esperança surge e eles avançam o inimigo. Sem alternativa e percebendo a derrota,      |");
    System.out.println("|           os ??? ordena um ataque de bombas, onde todos foram atingidos...                  |");
    System.out.println("|                                                                                             |");
    System.out.println("|        PLAYER acorda desorientado e levanta, ao seu redor só resta destruição e caos,       |");
    System.out.println("|                  PLAYER se concentra em buscar recursos para sobreviver.                    |");
    System.out.println("|                Ele tenta encontrar seus companheiros, mas todos estão mortos,               |");
    System.out.println("|              os inimigos que sobrevivem estão feridos. PLAYER tenta se comunicar,           |");
    System.out.println("|                        porém seus meios de comunicação não funcionam...                     |");
    System.out.println("|=============================================================================================|");
    tecleParaContinuar();
    System.out.println("|=============================================================================================|");
    System.out.println("| PLAYER Decide seguir em frente para encontrar algum local seguro e prosseguir com a missão, |");
    System.out.println("| ele avista uma fumaça no horizonte e segue na sua direção, se afastando dos inimigos vivos. |");
    System.out.println("|                                                                                             |");
    System.out.println("|                  Ele acaba encontrando outro Viper, Ronam que é seu amigo,                  |");
    System.out.println("|                         ele está preso sob os destroços de metais.                          |");
    System.out.println("|                                                                                             |");
    System.out.println("|      PLAYER decide ajudá-lo, mesmo Ronam pedindo que vá embora, pois poderia ser visto.     |");
    System.out.println("|                          PLAYER se recusa a deixar Ronam para trás,                         |");
    System.out.println("|                  e usa sua força para tirar seu amigo de lá.  Após retirá-lo,               |");
    System.out.println("|    eles continuam caminhando e encontram Zoe outro Soldado Viper, que está muito ferida,    |"); 
    System.out.println("|                             PLAYER e Ronam decidem carregá-la.                              |");
    System.out.println("|                                                                                             |");
    System.out.println("|           Eles encontram um local seguro e fazem curativos utilizando a sua bolsa.          |");
    System.out.println("|    Enquanto eles estavam ajudando Zoe, eles ouvem inimigos se aproximando, e se escondem,   |");
    System.out.println("|              eles percebem que é um grupo de busca inimigo. Para proteger Zoe,              |");
    System.out.println("|                PLAYER e Ronam decidem enfrentar o pequeno grupo de inimigos:                |");
    System.out.println("|=============================================================================================|");
    tecleParaContinuar();
  }//Fim História 0.2
    
  //Quadro História 0.3
  static void historia03(){
    System.out.println("|=============================================================================================|");
    System.out.println("|       O grupo decide ficar até que Zoe se recupere. Devido a sua modificação genética,      |");
    System.out.println("|   Zoe se recupera rapidamente e partem para encontrar maiores informações sobre o inimigo.  |");
    System.out.println("|                    Eles tentam fazer contato com a base, mas sem sucesso.                   |");
    System.out.println("|                                                                                             |");
    System.out.println("| Sem muitas escolhas, decidem seguir por uma vasta floresta de onde vieram o grupo de busca. |");
    System.out.println("|          E após algum tempo de caminhada, eles identificam um acampamento inimigo.          |");
    System.out.println("|     Ronam faz o reconhecimento do acampamento com cautela e cria um plano para atacarem.    |"); 
    System.out.println("|                 São poucos inimigos que não esperam nenhum tipo de contato.                 |");
    System.out.println("|                                                                                             |");
    System.out.println("|                        Zoe utiliza de sua habilidade com Sniper,                            |");
    System.out.println("|          e começa a eliminar os vigias do acampamento e o grupo prontamente invadem,        |");
    System.out.println("|                            combatendo os inimigos um a um.                                  |");
    System.out.println("|                                                                                             |");
    System.out.println("|                    PLAYER se depara com um inimigo diferente dos demais,                    |"); 
    System.out.println("|      ele vem na sua direção para ataca-lo com toda sua força. É hora de pensar rápido:      |");
    System.out.println("|=============================================================================================|");
    tecleParaContinuar();
  }//Fim História 0.3
  
  //Quadro História 0.4
  static void historia04(){
    System.out.println("|=============================================================================================|"); 
    System.out.println("|         Após derrotarem os inimigos no acampamento, o grupo investiga todo o local e        |");
    System.out.println("|                conseguem obter informações sobre as atividades do inimigo.                  |");
    System.out.println("|                        Zoe coleta algumas amostras para pesquisa.                           |"); 
    System.out.println("|                   O coronel Shi'ar, ordena que eles prossigam com a missão                  |");
    System.out.println("|                         e identifiquem a base principal dos (…),                            |");
    System.out.println("|              o Coronel também informa que terá um esquadrão a caminho para se               |");
    System.out.println("|                           juntar a eles no decorrer do caminho.                             |");
    System.out.println("|                                                                                             |");
    System.out.println("|                            E assim Player e seus companheiros,                              |");
    System.out.println("|         tomam um dos veículos no acampamento e seguem na direção da sua nova missão.        |"); 
    System.out.println("|        Durante o trajeto eles saem da floresta e vão por um estrada que acabam tendo        |");
    System.out.println("|                     problemas no veículo e decidem parar em uma cidade próxima,             |");
    System.out.println("|                             que está inabitada devido a guerra.                             |");
    System.out.println("|                                                                                             |");
    System.out.println("|            Eles pretendem consertar o veículo e revisar os passos que devem seguir.         |"); 
    System.out.println("|                    Com um mapa que conseguiram no acampamento da floresta,                  |"); 
    System.out.println("|                       eles veem que passarão por mais um acampamento,                       |");
    System.out.println("|                   inimigo durante o caminho e traçam um plano de invasão,                   |");
    System.out.println("|                  e por isso decidem passar a noite e recuperar as energias.                 |");
    System.out.println("|                                                                                             |");
    System.out.println("|                O grupo encontra itens necessários para sobrevivência e que,                 |");
    System.out.println("|                             ajudaram no concerto do veículo.                                |");
    System.out.println("|                 Na manhã seguinte eles partem em direção ao acampamento,                    |");
    System.out.println("|          ao chegarem começam a invadir de forma furtiva para não serem detectados.          |");
    System.out.println("|                                                                                             |");
    System.out.println("|                        Porém percebem que o acampamento está vazio,                         |");
    System.out.println("|               eles não entendem e decidem investigar o que está acontecendo...              |"); 
    System.out.println("|           Até entrarem em um galpão, são surpreendidos por uma armadilha inimiga.           |"); 
    System.out.println("|         Eles iniciam um confronto com os (…), que surgem atrás de caixas empilhadas,        |");
    System.out.println("|   um outro inimigo surge atrás de PLAYER com intenção de matá-lo.Você precisa ser rápido:   |");     
    System.out.println("|=============================================================================================|"); 
    tecleParaContinuar();
  }//Fim História 0.4
  
  //Quadro História 0.5
  static void historia05(){
    System.out.println("|=============================================================================================|");
    System.out.println("|            Após se livrar de alguns inimigos, Zoe Ronam e PLAYER percebem que               |");
    System.out.println("|                estão em menor número e que é melhor eles fugirem dali.                      |");
    System.out.println("|                                                                                             |");
    System.out.println("|   O grupo rapidamente consegue uma rota de fuga e saem do acampamento, mas não antes de     |"); 
    System.out.println("|   Ronam mostrar seu potencial, revelando que plantou explosivos por todo o acampamento e    |"); 
    System.out.println("|   detona tudo, deixando o acampamento em ruinas e dizimando todos os (…) que la estavam.    |");
    System.out.println("|                     Agora o grupo contam com outra preocupação.                             |");
    System.out.println("|                                                                                             |");
    System.out.println("|                     Como os (...) sabiam que os Vitrovianos viriam?                         |");
    System.out.println("|         Eles acham o ultimo (…) sobrevivente daquele acampamento, muito ferido,             |");
    System.out.println("|               e o capturam para interrogarem e descobrirem o que ocorreu.                   |");
    System.out.println("|          No interrogatório eles descobrem que sua comunicação com a base foi                |");
    System.out.println("|                   interceptada, e que sua missão estava comprometida.                       |");
    System.out.println("|                                                                                             |");
    System.out.println("|         Eles decidem seguir ao ponto de encontro com o esquadrão e retornar a               |");
    System.out.println("|                   base para traçarem novos planos junto a seus superiores.                  |");
    System.out.println("|            Após terminarem, uma patrulha de Elite inimiga(...) foi enviada para             |");
    System.out.println("|   finalizar a emboscada e pega-los. Eles não esperavam por isso.  Agora terão que lutar:    |");
    System.out.println("|=============================================================================================|");
    tecleParaContinuar();
  }//Fim História 0.5
  
  //Quadro História 0.6
  static void historia06(){
    System.out.println("|=============================================================================================|");
    System.out.println("|              O grupo consegue se despistar e correm para o ponto de encontro                |");
    System.out.println("|   com os Vitrovianos e retornam para sua base. Ao chegarem na base, notam algo estranho...  |");
    System.out.println("|                 Há destroços espalhados pelo chão a entrada foi destruída.                  |");
    System.out.println("|                                                                                             |");
    System.out.println("|             Eles veem alguns inimigos mortos no chão, e continuam andando até               |");
    System.out.println("|           acharem seus superiores junto com alguns Solados na Ala de Emergência.            |");
    System.out.println("|            Eles informam que após o último contato, foram rastreados e atacados,            |");
    System.out.println("|                   um pequeno grupo de inimigo chegou e foram derrotados,                    |"); 
    System.out.println("|            mas os sensores apontam uma tropa inimiga a caminho, eles tem alguns             |"); 
    System.out.println("|            minutos até que a tropa chegue. Mas dessa vez estarão preparados.                |");
    System.out.println("|                                                                                             |");
    System.out.println("|                Todos estão em posição, seguindo os protocolos de emergência,                |");
    System.out.println("|    utilizando armamento pesado de artilharia e de combate aéreo que não ficou destruído,    |");
    System.out.println("|       os Vitrovianos estão estrategicamente posicionados, as muralhas em volta da base      |");
    System.out.println("|        foram ativadas. O inimigos finalmente chegaram! É hora de defender a base:           |");
    System.out.println("|=============================================================================================|");
    tecleParaContinuar();
  }//Fim História 0.6

  //Quadro História 0.7
  static void historia07(){
    System.out.println("|=============================================================================================|");
    System.out.println("|    A Base consegue resistir e vencer ao ataque inimigo, todos estão a salvo por enquanto.   |");
    System.out.println("|                 Alguns oficiais acreditam que após o surgimento da equipe Viper,            |");
    System.out.println("|           o inimigo está utilizando de toda a sua força para conquistar de vez Vitron,      |");
    System.out.println("|          mas as suas tentativas de ataque levantou suspeitas da base principal dos(...),    |");
    System.out.println("|                      todas naves e veículos vieram da mesma direção e                       |");
    System.out.println("|                      a Base deve estar próxima das montanhas de Varum.                      |");
    System.out.println("|                                                                                             |");
    System.out.println("|                       O coronel Shi'ar aparece com informações novas,                       |");
    System.out.println("|              obtida através de pesquisas feitas com o material coletado por Zoe,            |");
    System.out.println("|        que mostra que os (...) são seres que possuem uma mente interligada entre eles,      |");
    System.out.println("|                e todas comandadas por um imperador que é a mente dominante.                 |");
    System.out.println("|                                                                                             |");
    System.out.println("|         É o que precisavam para montar um plano de ataque e acabar de vez com os (...).     |");
    System.out.println("|    Porém o coronel Shi'ar também informa que, por conta dos ataques recorrentes dos (...),  |");
    System.out.println("|     todo exército Vitroviano estará focado na defesa das bases e das cidades de Vitron,     |");
    System.out.println("|                        e que por conta do bombardeio em Valtrovia,                          |");
    System.out.println("|              eles serão a única força especializada capaz de executar essa missão.          |");
    System.out.println("|                                                                                             |");
    System.out.println("|                   Player Ronam e Zoe serão mandados para capital Vitron,                    |");
    System.out.println("|                            que fica no meio do caminho até Varum,                           |");
    System.out.println("|            onde receberão todo equipamento e preparo para o ato final nas montanhas.        |");
    System.out.println("|                                                                                             |");
    System.out.println("|                      Eles embarcam numa nave a caminho da Capital,                          |");
    System.out.println("|                       Player Zoe e Ronam descansaram no caminho,                            |");
    System.out.println("|                  eles receberam novos equipamentos de última geração,                       |");
    System.out.println("|         uma Mach-Tech, que é uma armadura, drones de suporte ao combate e Nanobôs,          |");
    System.out.println("|     que são nano robôs de combate que ajudaram a enfrentar o grande número de inimigos.     |");
    System.out.println("|                                                                                             |");
    System.out.println("|                    Player Zoe Ronam, estudam a área e planejam o ataque,                    |"); 
    System.out.println("|                    eles irão pelo espaço aéreo e saltaram até o inimigo.                    |");
    System.out.println("|             Eles se preparam até que cheguem ao local por um transporte aéreo,              |");
    System.out.println("|                         que consegue chegar a grandes altitudes.                            |");
    System.out.println("|                                Toda cautela é necessária.                                   |");
    System.out.println("|                                                                                             |");
    System.out.println("|  Eles chegaram ao ponto exato, O grupo salta e pousa com sucesso, sem alarmar o inimigo...  |");
    System.out.println("|               Zoe se encarrega de ficar dando cobertura a distância com sua Sniper,         |");
    System.out.println("|    assim ela consegue obter informação de posição do inimigo com os Nanobôs e drones.       |"); 
    System.out.println("|          Ela os envia, mas o inimigo tem um campo de detecção, o Grupo foi descoberto,      |");
    System.out.println("|                    agora todos sabem que estão ali... Que a Batalha comece:                 |");
    System.out.println("|=============================================================================================|");
    tecleParaContinuar();
  }//Fim História 0.7

  //Quadro História 0.8
  static void historia08(){
    System.out.println("|===========================================================================================|");
    System.out.println("|                                    Já era de se esperar,                                  |");
    System.out.println("|         com os novos equipamentos o grupo ganhou grande vantagem contra o inimigo,        |");
    System.out.println("|                              mas eles perceberam algo diferente,                          |");
    System.out.println("|    os inimigos pararam de atacar e uma luz forte vermelha reluz de dentro da montanha.    |"); 
    System.out.println("|                         A Elite inimiga surge para tentar detê-los.                       |");
    System.out.println("|                                                                                           |");
    System.out.println("|       Após um combate intenso contra a Elite de (…) o grupo agora está limitado,          |");
    System.out.println("|        com poucos recursos e balas, estão exaustos e sem metade de seus drones.           |");
    System.out.println("|                Zoe se aproxima com um drone perto da entrada da montanha...               |");
    System.out.println("|                               Um exercito de (…) marchando???                             |");
    System.out.println("|                                                                                           |");
    System.out.println("|                     O exercito entra em formação de frente ao grupo,                      |");
    System.out.println("|      quando começam a se conectar uns aos outros, eles nunca tinham visto isso antes,     |");
    System.out.println("| todos aqueles soldados amontoados um em cima do outro, estavam formando um corpo gigante. |");
    System.out.println("|                                 ... é o imperador(…)!                                     |");
    System.out.println("|                                                                                           |");
    System.out.println("|   O imperador utilizou seu poder e unificou o seu exercito para formar um grande colosso, |");
    System.out.println("|    e lutar contra o grupo Viper, agora precisam se separar e agir em equipe para vencer.  |");
    System.out.println("|                                     É hora da luta!:                                      |");
    System.out.println("|===========================================================================================|");
    tecleParaContinuar();
  }//Fim História 0.8

  //Final
  static void historia09(){
  System.out.println("|=============================================================================================|");
  System.out.println("|                   O imperador (…) é vencido, juntamente com seu exercito.                   |");
  System.out.println("|                   Todos estão salvos agora, graças a Player, Ronam e Zoe.                   |");
  System.out.println("|                        Vitron está a salvo e não está mais em Guera...                      |");
  System.out.println("|=============================================================================================|");
  tecleParaContinuar();
  System.out.println("|=============================================================================================|");
  System.out.println("|                        Player se depara com Ronam gravemente ferido.                        |");
  System.out.println("|           Zoe e Player correm para resgatá-lo rapidamente dali e conseguir ajuda,           |");
  System.out.println("|                           mas infelizmente Ronam não resiste.                               |");
  System.out.println("|                      Eles retornam à base e são recebidos como heróis.                      |");
  System.out.println("|=============================================================================================|");
  tecleParaContinuar();
  System.out.println("|=============================================================================================|");
  System.out.println("|          Eles são parabenizados por sua bravura e determinação em cumprir a missão.         |");
  System.out.println("|                          PLAYER e Zoe prestam homenagem a Ronam,                            |");
  System.out.println("|                    eles sabem que ele morreu como um verdadeiro herói,                      |");
  System.out.println("|             e se comprometem a continuar o legado da elite Viper em seu nome.               |");
  System.out.println("|=============================================================================================|");
  tecleParaContinuar();
  }//Final
//-------------------------FIM QUADROS HISTÓRIA----|
  
//---------------------------QUADROS JOGO-------|
  //Quadro Terminou Jogo
  static void quadroterminoujogo(){
    System.out.println("|=================================|");
    System.out.println("|  Você concluiu a sua jornada!!! |");
    System.out.println("|         *** Parabéns ***        |");
    System.out.println("|        Sua Pontuação: ["+pontuacao+"].      |"); 
    System.out.println("|=================================|");
    System.out.println("|");
    tecleParaContinuar();
  }//Fim Quadro Terminou Jogo
  
  //Quadro Nome do Jogo(Viper)
  static void nomeviper(){
    System.out.print("|║▌║▌║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌║▌║║▌║|\n");
    System.out.println("|                                                                                                        |");
    System.out.println("|  VVVVVVVV            VVVVVVVV  iiii                                                                    |");
    System.out.println("|  V::::::V            V::::::V i::::i                                                                   |");
    System.out.println("|  V::::::V            V::::::V  iiii                                                                    |");
    System.out.println("|   V:::::V            V::::::V                                                                          |");
    System.out.println("|    V:::::V           V:::::V iiiiiii ppppp   ppppppppp        eeeeeeeeeeee       rrrrr   rrrrrrrrr     |");
    System.out.println("|     V:::::V         V:::::V  i:::::i p::::ppp:::::::::p     ee::::::::::::ee    r::::rrr:::::::::r     |");
    System.out.println("|      V:::::V       V:::::V    i::::i p:::::::::::::::::p  e::::::eeeee:::::ee   r:::::::::::::::::r    |");
    System.out.println("|       V:::::V     V:::::V     i::::i pp::::::ppppp::::::p e::::::e     e:::::e rr::::::rrrrr::::::r    |");
    System.out.println("|        V:::::V   V:::::V      i::::i  p:::::p     p:::::p e:::::::eeeee::::::e   r:::::r     r:::::r   |");
    System.out.println("|         V:::::V V:::::V       i::::i  p:::::p     p:::::p e:::::::::::::::::e    r:::::r     rrrrrrr   |");
    System.out.println("|          V:::::V:::::V        i::::i  p:::::p     p:::::p e::::::eeeeeeeeeee     r:::::r               |");
    System.out.println("|           V:::::::::V         i::::i  p:::::p    p::::::p e:::::::e              r:::::r               |");
    System.out.println("|            V:::::::V         i::::::i p:::::ppppp:::::::p e::::::::e             r:::::r               |");
    System.out.println("|             V:::::V          i::::::i p::::::::::::::::p   e::::::::eeeeeeee     r:::::r               |");
    System.out.println("|              V:::V           i::::::i p::::::::::::::pp     ee:::::::::::::e     r:::::r               |");
    System.out.println("|               VVV            iiiiiiii p::::::pppppppp         eeeeeeeeeeeeee     rrrrrrr               |");
    System.out.println("|                                      p:::::p                                                           |");
    System.out.println("|                                      p:::::p                                                           |");
    System.out.println("|                                     p:::::::p                                                          |");
    System.out.println("|                                     p:::::::p                                                          |");
    System.out.println("|                                     p:::::::p                                                          |");
    System.out.println("|                                     ppppppppp                                                          |");
    System.out.println("|                                                                                                        |");
    System.out.println("|║▌║▌║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌║▌│█║▌║▌▌│█║▌▌║║▌│█║║▌║|");
    tecleParaContinuar();
  }//Fim Quadro Nome do Jogo(Viper)
  
//Quadro Menu do Jogo  
  static void menujogo(){
    System.out.println("                  *MENU JOGO*");
    System.out.println("|============================================|");
    System.out.println("|               [1] - Jogar                  |");
    System.out.println("|--------------------------------------------|");
    System.out.println("|               [2] - Como Jogar             |");
    System.out.println("|--------------------------------------------|");
    System.out.println("|               [3] - Créditos               |");
    System.out.println("|--------------------------------------------|");
    System.out.println("|               [4] - Sair                   |");
    System.out.println("|============================================|");
    System.out.println("|                                            |");
    System.out.println("| - Digite a Opção: ");    
  }//Fim Quadro Menu do Jogo
  
  //Quadro Instruções
  static void quadroComoJogar(){
  System.out.println("");
  System.out.println("                                          *COMO JOGAR VIPER*");
  System.out.println("|===================================================================================================|");
  System.out.println("|                                                                                                   |");
  System.out.println("|  Viper é um jogo de luta básico, após criar seu Vittas, você enfrentará seus inimigos um a um.    |");
  System.out.println("|                                                                                                   |");
  System.out.println("|  Você sempre verá os Status de Vida, Força e Defesa do oponente, você sempre atacará primeiro.    |");
  System.out.println("|                                                                                                   |");
  System.out.println("|           Os ataques sempre serão feitos um de cada vez, o seu ataque, depois o oponente.         |");
  System.out.println("|                                                                                                   |");
  System.out.println("|            O seu ataque resume em 'Sua Força' - ('Vida Oponente' + 'Defesa do Oponente').         |");
  System.out.println("|                                                                                                   |");
  System.out.println("|                    Você só seguirá na história caso fuja ou derrote o oponente.                   |");
  System.out.println("|                                                                                                   |");
  System.out.println("|                          Se sua vida chegar a 0 pontos você perde o jogo.                         |");
  System.out.println("|                                                                                                   |");
  System.out.println("|===================================================================================================|");
  System.out.println("");
  tecleParaVoltar();             
  }//Fim Quadro Instruções

  //Quadro Créditos
  static void quadroCreditos(){
    
    System.out.println("                *CRÉDITOS*");
    System.out.println("|======================================|");
    System.out.println("|                  Igor                |");
    System.out.println("|--------------------------------------|");
    System.out.println("|                  Caio                |");
    System.out.println("|--------------------------------------|");
    System.out.println("|          Nycolas Arrombado           |");
    System.out.println("|======================================|");
    System.out.println("            *FIM DOS CRÉDITOS*"); 
    System.out.println("");
    tecleParaVoltar();
  }//Fim Quadro Créditos

  //Quadro Introdução
  static void quadroIntroducao(){
  System.out.println(""); 
  System.out.println("|===================================================================================================|");
  System.out.println("|                Quando o Planeta Vitron completava a sua 92º volta na orbita do seu sol,           |");
  System.out.println("|     os Vitrovianos se depararam com uma invasão de um Exercito Alienígenas não identificados      |");
  System.out.println("|                        que destruíram Valtrovia , uma região localizada ao Sul,                   |");
  System.out.println("|                  os Vitrovianos não estavam preparados revidar e milhares morerram...             |");
  System.out.println("|                                  Os Vitrovianos chamaram eles de (…)                              |");
  System.out.println("|              e travaram uma guerra que permanece há mais 2 voltas de orbitas Vitroviana.          |");
  System.out.println("|===================================================================================================|");
  tecleParaContinuar();
  quadroEscolhaClasse();
}//Fim Quadro Introdução

  //Quadro Escolha Classe
  static void quadroEscolhaClasse(){
    System.out.println("|=============================================================================================|");
    System.out.println("|          Durante a guerra, as autoridades de Vitron selecionaram a Elite de seus            |");
    System.out.println("|         melhores soldados para formar a equipe Viper, um grupo de Super-soldados,           |");
    System.out.println("|                geneticamente aprimorados e que possuem maior vitalidade,                    |");
    System.out.println("|        resistência e força, para que tivessem maior capacidade de combater os (…).          |");
    System.out.println("|                                                                                             |");
    System.out.println("|                              *Legenda: V = Vida; F = Força.*                                |");
    System.out.println("|---------------------------------------------------------------------------------------------|");
    System.out.println("|                                     *LISTA DE CLASSES*                                       ");
    System.out.println("|                                                                                              ");
    System.out.println("|     [1] - "+classes[0]+"   -  [V = "+V_perso[0]+"] [F = "+F_perso[0]+"]                      ");
    System.out.println("|     [2] - "+classes[1]+"      -  [V = "+V_perso[1]+"] [F = "+F_perso[1]+"]                   ");
    System.out.println("|     [3] - "+classes[2]+"  -  [V = "+V_perso[2]+"] [F = "+F_perso[2]+"]                       ");
    System.out.println("|     [4] - "+classes[3]+"    -  [V = "+V_perso[3]+"] [F = "+F_perso[3]+"]                     ");
    System.out.println("|     [5] - Voltar ao Menu do Jogo                                                             ");
    System.out.println("===============================================================================================");
    System.out.println("|");
    System.out.println("| - Escolha sua classe: ");
    selecionarClasse();
  }//Fim Quadro Escolha Classe

  //Quadro Luta  
  static void quadroLuta(){
    if(inimigo_at<8){
    System.out.println("            *** Um Inimigo Apareceu... ***       ");
    System.out.println("|================================================");
    System.out.println("|               ["+inimigos[inimigo_at]+"].      ");
    System.out.println("|   Vida [V = "+V_inimigos[inimigo_at]+"]; Força [F = "+F_inimigos[inimigo_at]+"].    ");
    System.out.println("|================================================");
    System.out.println("| Seus Atributos ["+classes[escolhaclasse-1]+"] - V = "+V_perso[escolhaclasse-1]+" ; F = "+F_perso[escolhaclasse-1]);
    System.out.println("| Sua pontuação: "+pontuacao);
    System.out.println("|================================================");
    System.out.println("| - [1] - Lutar");
    System.out.println("| - [2] - Fugir");
    System.out.println("|");
    System.out.println("| - Digite a Opção: ");
      decisaoluta();
     }else{
       quadroterminoujogo();
     }
  }//Fim Quadro Luta
//-------------------FIM QUADROS JOGOS----|

}//Fim Class