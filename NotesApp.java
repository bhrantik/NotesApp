import java.io.*;
import java.util.Scanner;

class NotesApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n--- NOTES APP ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch(ch) {
                case 1:
                    addNote(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while(ch != 3);
        sc.close();
    }

    static void addNote(Scanner sc) {
        try {
            FileWriter fw = new FileWriter("notes.txt", true);
            System.out.print("Write your note: ");
            String note = sc.nextLine();
            fw.write(note + "\n");
            fw.close();
            System.out.println("Note saved.");
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void viewNotes() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("notes.txt"));
            String line;
            System.out.println("\n--- Saved Notes ---");
            while((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
            br.close();
        } catch(FileNotFoundException e) {
            System.out.println("No notes found. Please add some first.");
        } catch(IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
