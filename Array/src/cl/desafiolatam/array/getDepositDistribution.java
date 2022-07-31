package cl.desafiolatam.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class getDepositDistribution {
	
	public static List<String> getListByAmountOrderId = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
			getDepositDistribution(1,"Frist",12000,20222110);
			withDraw();
				
		
	}

	public static void getDepositDistribution(final int user_id, 
											  final String goal,
											  final int amount,
											  final Date created_at) {
		Date paid_at = new Date() ;
		int dia =created_at.getDay() + 2;
		paid_at.setDate(dia + created_at.getMonth() + created_at.getYear());
		
		getListByAmountOrderId.add("UsuerId: "+ user_id +
						   " Deposit: "+ goal +
						   "Monto Depositado:"+ amount +
						   "Se Paga: " + paid_at +
						   "Fecha de Creacion" + created_at);
	}
	public static  void withDraw() {
		Collections.sort(getListByAmountOrderId);
		for (int i = 0; i < getListByAmountOrderId.size(); i++) {					
			System.out.println(getListByAmountOrderId.get(i));
			
		}
	}
	
}
