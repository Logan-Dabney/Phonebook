import java.util.*;
import java.io.File;

public class phoneBook {
    // Written by Logan Dabney
    // This program allows the user to create phone book with a max of 200 contacts
    // The user can use commands e for new entry,
    // f to find someone, l to list all, and q to quit.
    // This program uses the entry class to execute all these commands.
public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    String command, number, note;
    File Contacts = new File("Contacts");

    command = "23";

    Entry.ReadPhoneBook(Contacts);
    System.out.println("Codes are entered as 1 to 8 characters.");
    System.out.println("Use \"e\" for enter, \"f\" for find," +
            " \"l\" for list, \"q\" for quit.");
    while (command.charAt(0) != 'q') {
        System.out.println();
        System.out.print("Command: ");
        command = input.nextLine();

        if (command.charAt(0) == 'e') {
            System.out.print("Enter number: ");
            number = input.nextLine();
            if (number.equals(""))
                number = "N/A";
            System.out.print("Enter notes: ");
            note = input.nextLine();
            if (note.equals(""))
                note = "N/A";

            Entry.entryList[Entry.entryNum] = new Entry(command.substring(2),
                    number, note);
        } else if (command.charAt(0) == 'f')
            System.out.println(Entry.Find(command.substring(2).toLowerCase()));
        else if (command.charAt(0) == 'l')
            Entry.List();
    }
    Entry.WritePhoneBook(Contacts);
}
}
