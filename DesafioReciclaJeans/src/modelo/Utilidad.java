package modelo;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utilidad {
	
	public static void tEspera(int tEspera) {
		try {
			TimeUnit.SECONDS.sleep(tEspera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
	
	public static void pressEnterToContinue()
    { 
        @SuppressWarnings("unused")
		String seguir;
        @SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
        System.out.println("\nPresiona \"Enter\" para continuar...");
        try
          {
           seguir = teclado.nextLine();
          }   
       catch(Exception e)
        {}  
   }

}
