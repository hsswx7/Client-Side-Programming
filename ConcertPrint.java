import java.util.Comparator;

//import testDay.WeekDay;

public class ConcertPrint implements Comparable<ConcertPrint> {
	
	public String concertName;
	public String bandName;
	public String venueName;
	public String dayOfConcert;
	public String time;
	public String hallCapacity;
	public String cost;
	
	
	public ConcertPrint(){} // default costructor 
	public ConcertPrint (String concertName, String bandName, String venueName, String dayOfConcert, String time, String hallCapacity, String cost) 
	{
		this.concertName = concertName;
		this.bandName = bandName;
		this.venueName = venueName;
		this.dayOfConcert = dayOfConcert; 
		this.time = time;
		this.hallCapacity = hallCapacity;
		this.cost = cost;
	}
	public String Display () // sending string back to be displayed on the screen
	{
		return("Concert: " + this.concertName + ", Band: " 
				+ this.bandName + ", Venue: " + this.venueName + ", Day: " +
				this.dayOfConcert +  ", Time: " + this.time + 
				", Capacity: " + this.hallCapacity +
				", Cost: " + this.cost);
	}
	public String DisplayDay () // sending string back to be displayed on the screen
	{
		return("Time: " + this.time +", Venue: " + this.venueName + ", Band: " 
				+ this.bandName);
	}
	public String getconcertName() {
         return concertName;
    }
	public String getbandName() {
        return bandName;
   }
	public String getvenueName() {
        return venueName;
   }
	public String getdayOfConcert() {
        return dayOfConcert;
   }
	public String time() {
        return time;
   }
	public String hallCapacity() {
        return concertName;
   }
	public String cost() {
        return cost;
   }

	public enum WeekDay{
		Mon, Tue, Wed, Thu, Fri, Sat, Sun;

		public static int compare(String getdayOfConcert, String getdayOfConcert2) {
			
			System.out.println("Compaing: " + getdayOfConcert + " " + getdayOfConcert2);
			if (getdayOfConcert.equals("Mon") || getdayOfConcert2.equals(Mon))
			{
				return -1;
			}
			else if (getdayOfConcert.equals("Mon") && getdayOfConcert2.equals("Mon"))
			{
				return 0;
			}
			else if (getdayOfConcert.equals("Mon") && getdayOfConcert2.equals("Tue"))
			{
				return -1;
			}
			else if (getdayOfConcert.equals("Tue") && getdayOfConcert2.equals("Mon"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Tue") && getdayOfConcert2.equals("Tue"))
			{
				return 0;
			}
			else if (getdayOfConcert.equals("Tue") && getdayOfConcert2.equals("Wed"))
			{
				return -1;
			}
			else if (getdayOfConcert.equals("Tue") && getdayOfConcert2.equals("Thu"))
			{
				return -1;
			}
			else if (getdayOfConcert.equals("Tue") && getdayOfConcert2.equals("Fri"))
			{
				return -1;
			}
			else if (getdayOfConcert.equals("Tue") && getdayOfConcert2.equals("Sat"))
			{
				return -1;
			}
			else if (getdayOfConcert.equals("Tue") && getdayOfConcert2.equals("Sun"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Tue") && getdayOfConcert.equals("Tue"))
			{
				return 0;
			}
			else if (getdayOfConcert2.equals("Tue") && getdayOfConcert.equals("Wed"))
			{
				return 1;
			}
			else if (getdayOfConcert2.equals("Tue") && getdayOfConcert.equals("Thu"))
			{
				return 1;
			}
			else if (getdayOfConcert2.equals("Tue") && getdayOfConcert.equals("Fri"))
			{
				return 1;
			}
			else if (getdayOfConcert2.equals("Tue") && getdayOfConcert.equals("Sat"))
			{
				return 1;
			}
			else if (getdayOfConcert2.equals("Tue") && getdayOfConcert.equals("Sun"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Wed") && getdayOfConcert2.equals("Wed"))
			{
				return 0;
			}
			else if (getdayOfConcert.equals("Wed") && getdayOfConcert2.equals("Thu"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Wed") && getdayOfConcert.equals("Thu"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Wed") && getdayOfConcert2.equals("Fri"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Wed") && getdayOfConcert.equals("Fri"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Wed") && getdayOfConcert2.equals("Sat"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Wed") && getdayOfConcert.equals("Sat"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Wed") && getdayOfConcert2.equals("Sun"))
			{
				//System.out.println("Wed is smaller than Sun");
				return -1;
			}
			else if (getdayOfConcert2.equals("Wed") && getdayOfConcert.equals("Sun"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Thu") && getdayOfConcert2.equals("Thu"))
			{
				return 0;
			}
			else if (getdayOfConcert.equals("Thu") && getdayOfConcert2.equals("Fri"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Thu") && getdayOfConcert.equals("Fri"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Thu") && getdayOfConcert2.equals("Sat"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Thu") && getdayOfConcert.equals("Sat"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Thu") && getdayOfConcert2.equals("Sun"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Thu") && getdayOfConcert.equals("Sun"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Fri") && getdayOfConcert2.equals("Fri"))
			{
				return 0;
			}
			else if (getdayOfConcert2.equals("Fri") && getdayOfConcert.equals("Fri"))
			{
				return 0;
			}
			else if (getdayOfConcert.equals("Fri") && getdayOfConcert2.equals("Sat"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Fri") && getdayOfConcert.equals("Sat"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Fri") && getdayOfConcert2.equals("Sat"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Fri") && getdayOfConcert.equals("Sat"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Fri") && getdayOfConcert2.equals("Sat"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Fri") && getdayOfConcert.equals("Sat"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Fri") && getdayOfConcert2.equals("Sun"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Fri") && getdayOfConcert.equals("Sun"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Sat") && getdayOfConcert2.equals("Sat"))
			{
				return 0;
			}
			else if (getdayOfConcert2.equals("Sat") && getdayOfConcert.equals("Sat"))
			{
				return 0;
			}
			else if (getdayOfConcert.equals("Sat") && getdayOfConcert2.equals("Sun"))
			{
				return -1;
			}
			else if (getdayOfConcert2.equals("Sat") && getdayOfConcert.equals("Sun"))
			{
				return 1;
			}
			else if (getdayOfConcert.equals("Sun") && getdayOfConcert2.equals("Sun"))
			{
				return 0;
			}
			else if (getdayOfConcert2.equals("Sun") && getdayOfConcert.equals("Sun"))
			{
				return 0;
			}
				return 0;
		}
	}
	public static Comparator<ConcertPrint> getdayOfConcert1() {
		return new Comparator<ConcertPrint>(){

			@Override
			public int compare(ConcertPrint arg0, ConcertPrint arg1) {
				// TODO Auto-generated method stub
				System.out.println(arg0.getdayOfConcert() + arg1.getdayOfConcert());
				return WeekDay.compare(arg0.getdayOfConcert(), arg1.getdayOfConcert());
			}	
		};
	}

	@Override
	public int compareTo(ConcertPrint compVenueName) {
		// 1 - This particular object is grater than the object we're comparing against 
		// 0 - This particular object is equal to the object we're comparing against
		//-1 - This particualr object is less than the object we're comparing against 
		
		return this.venueName.compareTo(compVenueName.getvenueName());
		//return 0;
	}

	
} 