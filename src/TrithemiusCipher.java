public class TrithemiusCipher {
    private static final int rows = 5, columns = 7;
    private static final StringBuilder uniqueBuilder = new StringBuilder();

    public static String encode(String s, String key) {
        StringBuilder builder = new StringBuilder();
        s = s.toUpperCase();
        TrithemiusCipher.getUniqueBuilder(key);

        int ind, len = 0;
        while (len != s.length()) {
            if (uniqueBuilder.toString().contains(Character.toString(s.charAt(len)))) {
                ind = uniqueBuilder.toString().indexOf(s.charAt(len));
                if (ind <= (rows - 1) * columns - 1)
                    builder.append(uniqueBuilder.toString().charAt(ind + columns));
                else
                    builder.append(uniqueBuilder.toString().charAt(ind - (rows - 1) * columns));
            } else
                builder.append(s.charAt(len));
            len++;
        }

        return builder.toString();
    }

    public static String decode(String s, String key) {
        StringBuilder builder = new StringBuilder();
        s = s.toUpperCase();
        TrithemiusCipher.getUniqueBuilder(key);
        int ind,len = 0;
        while (len != s.length()) {
            if (uniqueBuilder.toString().contains(Character.toString(s.charAt(len)))) {
                ind = uniqueBuilder.toString().indexOf(s.charAt(len));
                if (ind >= columns)
                    builder.append(uniqueBuilder.toString().charAt(ind - columns));
                else
                    builder.append(uniqueBuilder.toString().charAt(ind + (rows - 1) * columns));
            } else
                builder.append(s.charAt(len));
            len++;
        }
        return builder.toString();
    }

    private static void getUniqueBuilder(String key) {
        StringBuilder tempBuilder = new StringBuilder();
        key = key.toUpperCase();
        tempBuilder.append(TrithemiusCipher.getUniqueSymbols(key));

        for (int i = 0; i <= 34; i++) {
            if (i == 6) // 'Ё' 1025
                tempBuilder.append((char) 1025);
            if (i < 32) // до 'Я' 1071
                tempBuilder.append((char) (1040 + i));
            else {
                if (i == 32) // ' ' 32
                    tempBuilder.append((char) 32);
                if (i == 33) // '.' 46
                    tempBuilder.append((char) 46);
            }
        }
        uniqueBuilder.append(TrithemiusCipher.getUniqueSymbols(tempBuilder.toString()));
    }

    public static StringBuilder getUniqueSymbols(String s) {
        StringBuilder builder = new StringBuilder();
        s.chars().distinct().forEach(c -> builder.append((char) c));
        return builder;
    }
}
