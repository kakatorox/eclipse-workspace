import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal= new GregorianCalendar();
		cal.set(Calendar.YEAR,1984);
		cal.set(Calendar.DAY_OF_MONTH,31);
		cal.set(Calendar.MONTH,9);
	
		System.out.println(cal.getTime());
	}

}
