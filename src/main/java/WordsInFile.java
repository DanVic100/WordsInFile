import java.io.*;

import java.util.*;

public class WordsInFile {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/exmple.txt");
        /*FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader= new BufferedReader(fileReader);*/
        Scanner scanner = new Scanner(file,"utf-8");

        Map<String, Integer> statistics = new HashMap<>();
        Set<String> words = new TreeSet<>();

        Map<String, Integer> wordMax = new HashMap<>();
        int simbolNum = 0;

        while(scanner.hasNext()){
            String word = scanner.useDelimiter("\\s+").next();
                    Integer count = statistics.get(word);
            if (count == null) {
                count = 0;
            }
            statistics.put(word, ++count);
            words.add(word);
        }

        /*
        System.out.println("Слова в файле: ");*/
        System.out.println("Отсортированные слова в файле: ");
        System.out.println(words);
        System.out.println("Количество различных слов  в файле: ");
        System.out.println(statistics);

        for (Map.Entry<String, Integer> value:statistics.entrySet()){
            if (value.getValue()>simbolNum)
            {
                wordMax.clear();
                simbolNum = value.getValue();
                wordMax.put(value.getKey(),value.getValue());
            } else if(value.getValue() == simbolNum)
            {
                wordMax.put(value.getKey(),value.getValue());
            }
        }
        System.out.println("Слово с максимальным количеством повторений: ");
        System.out.println(wordMax);
    }
}
