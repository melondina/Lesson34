import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    // Как известно, в США президент выбирается не прямым голосованием, а путем двухуровневого
    // голосования.
    // Сначала проводятся выборы в каждом штате, и определяется победитель выборов в данном штате.
    // Затем проводятся государственные выборы:
    // на этих выборах каждый штат имеет определенное число голосов — число выборщиков от этого штата.
    // На практике, все выборщики от штата голосуют в соответствии с результатами голосования внутри
    // штата, то есть на заключительной стадии выборов в голосовании участвуют штаты,
    // имеющие различное число голосов.

    // В первой строке дано количество записей.
    // Каждая запись содержит фамилию кандидата и число голосов,
    // отданных за него в одном из штатов.
    //
    // Подведите итоги выборов: для каждого из участников голосования
    // определите число отданных за него голосов.

    // Пример ввода:
//         5
//         McCain 10
//         McCain 5
//         Obama 9
//         Obama 8
//         McCain 1

    // Пример вывода:
    // McCain 16
    // Obama 17

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> result = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int spaceIndex = line.indexOf(' ');
            String name = line.substring(0, spaceIndex);
            String voiceStr = line.substring(spaceIndex + 1);
            int voices = Integer.parseInt(voiceStr);

            if(!result.containsKey(name)) {
              result.put(name, 0);
            }
            result.put(name, result.get(name) + voices);
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}