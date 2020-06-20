public class ExperimentsWithTransliterator {
    public static void main(String[] args) throws Exception {
        char[] rus = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        String[] eng = {"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "ie", "y", "", "e", "iu", "ia"};
        //тесты 1
        Transliterator t = new Transliterator(rus, eng);
        System.out.println(t.translateOneSymbol('я')); // ia
        System.out.println(t.translateOneSymbol('$')); // $
        System.out.println(t.translate("экзамен")); // ekzamen
        System.out.println(t.translate("катя"));

        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String[] texts = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        //тесты 1.1
        Transliterator n = new Transliterator(nums, texts);
        System.out.println(n.translateOneSymbol('я')); // я
        System.out.println(n.translateOneSymbol('0')); // ноль
        System.out.println(n.translate("1875")); // одинвосемьсемьпять
        System.out.println(n.translate("90")); // девятьноль

        //тесты 2.1
        System.out.println(t.translateOneSymbol('Р')); // R
        System.out.println(t.translateOneSymbol('Я')); // Ia
        System.out.println(t.translateOneSymbol('Ь')); //
        System.out.println(t.translate("Катя")); // Katia
        System.out.println(t.translate("Яблоко")); // Iabloko
        System.out.println(t.translate("ПАРАШЮТ")); // PARAShIuT

        // тесты 2.2
        Transliterator r = Transliterator.createICAO_DOC_9303();
        System.out.println(r.translate("Катя")); // Katya
        System.out.println(r.translate("Яблоко")); // Yabloko
        System.out.println(r.translate("ПАРАШЮТ")); // PARAShYuT
        System.out.println(r.translate("Сложная строка с объявлением")); // Slozhnaya stroka s ob``yavleniem

        // тесты 3
        t.translateFile("exam/a.txt", "exam/b.txt");
    }
}