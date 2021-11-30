import java.io.*;
import java.util.Scanner;

public class Entry {
public String name, number, notes;
static Entry[] entryList = new Entry[200];
static int entryNum, readNum;

Entry(String n, String num, String not) {
    name = n;
    number = num;
    notes = not;
    entryNum++;
}

public static String Find(String var) {
    for (int i = 0; i < entryNum; i++) {
        if (entryList[i].name.toLowerCase().equals(var)) {
            var = "-- " + entryList[i].name + "\n-- "
                    + entryList[i].number + "\n-- " + entryList[i].notes;
            return var;
        }
    }
    return "No entry with code " + var;
}

public static void List() {
    for (int n = 0; n < entryNum; n++) {
        System.out.println();
        System.out.println("-- " + entryList[n].name);
        if (!entryList[n].number.equals("N/A"))
            System.out.println("-- " + entryList[n].number);
        if (!entryList[n].notes.equals("N/A"))
            System.out.println("-- " + entryList[n].notes);
    }
}

public static void ReadPhoneBook(File Contacts) throws Exception {
    Scanner fileInput = new Scanner(Contacts);
    LineNumberReader reader = new LineNumberReader(new FileReader(Contacts));
    String temp;
    String[] entryNew;

    while ((reader.readLine()) != null) {
        readNum++;
    }
    for (int k = 0; k < readNum; k++) {
        temp = fileInput.nextLine();
        entryNew = temp.split("\t");
        Entry.entryList[k] = new Entry(entryNew[0], entryNew[1], entryNew[2]);
    }
}

public static void WritePhoneBook(File Contacts) throws Exception {
    PrintStream P = new PrintStream(Contacts);
    for (int i = 0; i < entryNum; i++) {
        P.println(entryList[i].name + "\t" +
                entryList[i].number + "\t" + entryList[i].notes);
    }
    P.close();
    System.out.println("Phonebook stored.");
}
}
