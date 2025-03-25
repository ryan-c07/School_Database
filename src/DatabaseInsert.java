public class DatabaseInsert {
    public static void main(String[] args) {
        // INSERT INTO Students ( StudentID, Name ) VALUES ( 5000 , 'Student200 ');
        for (int i = 1; i <= 5000; i++) {
            System.out.println("INSERT INTO Students ( StudentID, Name ) VALUES ( " + i + ", 'Student" + i + "' );");
        }






    }
}
