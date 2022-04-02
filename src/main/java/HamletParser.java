import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){

        return hamletData;
    }

    public String findHoratio(){
        String text = hamletData;
        String patternString = "[H,h][o,O][R,r][a,A][t,T][I,i][o,O]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        hamletData = matcher.replaceAll("Tariq");
        return hamletData;
    }

    public String findHamlet(){
        String text = hamletData;
        String patternString = "[h,H][a,A][m,M][l,L][e,E][t,T]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        hamletData = matcher.replaceAll("Leon");
        return hamletData;
    }

    public String setHamlettoLeon(){


        System.out.println(hamletData);
        return null;

    }

    public String setHoratiotoTariq(){
        return null;
    }

}
