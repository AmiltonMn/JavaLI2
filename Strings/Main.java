import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collector;
import java.util.stream.Collectors;

// Precisa baixar novamente o CSV para este código funcionar!

public class Main {

    public static void main(String[] args)  throws IOException{

        float quantidadeObitos = Files.lines(Paths.get("INFLUD21.csv"), Charset.forName("UTF-8"))
            .map((item) -> item.split(";"))
            .filter((item) -> item[106].equals("5"))
            .filter((item) -> item[109].equals("2"))
            .count();

        float quantidadeObitosVacinados = Files.lines(Paths.get("INFLUD21.csv"), Charset.forName("UTF-8"))
            .map((item) -> item.split(";"))
            .filter((item) -> item[154].equals("1"))
            .filter((item) -> item[109].equals("2"))
            .filter((item) -> item[106].equals("5"))
            .count();

        float quantidadeObitosNaoVacinados = Files.lines(Paths.get("INFLUD21.csv"), Charset.forName("UTF-8"))
            .map((item) -> item.split(";"))
            .filter((item) -> item[109].equals("2"))
            .filter((item) -> item[154].equals("2"))
            .filter((item) -> item[106].equals("5"))
            .count();

        float quantidadeCuras = Files.lines(Paths.get("INFLUD21.csv"), Charset.forName("UTF-8"))
            .map((item) -> item.split(";"))
            .filter((item) -> item[109].equals("1"))
            .filter((item) -> item[106].equals("5"))
            .count();

        System.out.println("Quantidade de Obitos total: " + quantidadeObitos);
        System.out.println("Quantidade de Pacientes Curados: " + quantidadeCuras);
        System.out.println("Quantidade de Obitos de Pessoas Vacinadas: " + quantidadeObitosVacinados);
        System.out.println("Quantidade de Obitos de Pessoas Nao Vacinadas: " + quantidadeObitosNaoVacinados);

        System.out.println("Porcentagem de Obitos: " + (quantidadeObitos * 100 / (quantidadeObitos + quantidadeCuras)) + "%");
        System.out.println("Porcentagem de Curas: " + (quantidadeCuras * 100 / (quantidadeObitos + quantidadeCuras)) + "%");
        System.out.println("Porcentagem de Obitos de Pessoas Vacinadas: " + (quantidadeObitosVacinados * 100 / (quantidadeObitos)) + "%");
        System.out.println("Porcentagem de Obitos de Pessoas Nao Vacinadas: " + (quantidadeObitosNaoVacinados * 100 / (quantidadeObitos)) + "%");

    }   
}