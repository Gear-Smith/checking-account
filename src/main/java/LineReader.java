import java.util.Scanner;

public class LineReader {
    private static Scanner scanner;

    public LineReader() {
        scanner = new Scanner(System.in);
    }

    public String readLine(){
        scanner.next();
        return scanner.nextLine();
    }

    public int readInt() {
        scanner.next();
        return scanner.nextInt();
        
    }

}
