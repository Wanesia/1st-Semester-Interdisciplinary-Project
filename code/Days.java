//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.concurrent.TimeUnit;
//import java.time.temporal.ChronoUnit;
//
//
//
//public class Days{
//    public static long getDifferenceDays(Date d1, Date d2) {
//        long diff = d2.getTime() - d1.getTime();
//        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//    }
//    public static void main(String[] args){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
//
//        LocalDate d1 = LocalDate.of(2014, 9, 11);
//        LocalDate d2 = LocalDate.of(2014, 9, 15);
//        long daysBetween = ChronoUnit.DAYS.between(d1, d2);
//        System.out.println(daysBetween);
//
//    ////////OR
//
//        Date date = new Date(2014,3,3);
//        Date date2 = new Date(2014,3,5);
//        daysBetween = getDifferenceDays(date,date2);
//        System.out.println(daysBetween);
//
//
//
//    }
//}