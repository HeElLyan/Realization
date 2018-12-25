package HomeworkProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class EGEFile implements FileReader {

    public String filename;

    public EGEFile(String filename){
        this.filename = filename;
    }
    Commands cmd = new Commands();

    public void readFile(){
        try {
            String s = "";
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                s += scanner.nextLine() + "\r\n";
            }
            if (cmd.countWords(s) >= 150 & cmd.countWords(s) <= 280) {
                System.out.println("Words:" + cmd.countWords(s) + "- that's okay");
            } else if (cmd.countWords(s) < 150){
                System.out.println("Words:" + cmd.countWords(s) + " - not enough");
            } else if (cmd.countWords(s) > 280){
                System.out.println("Words:" + cmd.countWords(s) + " - too much");
            }
            System.out.println("Sentences:" + cmd.countSentences(s));
            System.out.println("Do you want to find some words on repetition?");
            Scanner sc = new Scanner(System.in);
            String something1 = sc.nextLine();
            if(something1.equals("Yes") | something1.equals("yes")){
                System.out.println("Enter the word you want to find on repetition:");
                String word = sc.nextLine();
                if(cmd.countWordRepeat(word,s) <= 2){
                    System.out.println(cmd.countWordRepeat(word,s) + " - that's okay.");
                } else {
                    System.out.println(cmd.countWordRepeat(word,s) + " - too much repeated words! Please, replace some of them with synonyms.");
                }
            }
            System.out.println("Do you want to find some symbols on repetition?");
            String something2 = sc.nextLine();
            if (something2.equals("yes") | something2.equals("Yes")){
                System.out.println("Enter the symbol you want to find on repetition in whole file:");
                char word1 = sc.next().charAt(0);
                System.out.println("Symbols:" + cmd.countChar(s, word1));
            }
            System.out.println("Do you want to replace any words?");
            String something3 = sc.nextLine();
            if(something3.equals("yes") | something3.equals("Yes")){
                System.out.println("Enter the word you want to replace:");
                String word3 = sc.nextLine();
                System.out.println("Enter the word you want to replace on the previous word:");
                String word4 = sc.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
    }


}
