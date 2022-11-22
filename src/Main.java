public class Main {
    public static void main(String[] args) {
        //String s = "ПРиВЕТ МИР!", key = "КЛЮЧ";
        String s = "ЦШСИНЪБУСШ!", key = "КЛЮЧ";

        long startTime = System.currentTimeMillis();
        TrithemiusCipher.encode(s, key);
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime-startTime) + "ms");
        System.out.println("Исходная строка: " + s);
        s = TrithemiusCipher.encode(s, key);
        System.out.println("Зашифрованная строка: " + s);
        s = TrithemiusCipher.decode(s, key);
        System.out.println("Расшифрованная строка: " + s);
        s = TrithemiusCipher.decode(s, key);
        System.out.println("2xРасшифрованная строка: " + s);
    }
}
