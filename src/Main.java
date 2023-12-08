import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // data
        Opp rice = new Opp("Rice", 100, 25);
        Opp ghost = new Opp("Ghost", 200, 40);
        Opp titan = new Opp("titan", 299, 100);
        Opp odin = new Opp("Odin", 4, 75);

        User player = new User(7, 300, 250, 100);
        String username = player.registration();
        System.out.println(username + " вітаємо вас у Fight");

        // menu
        String result;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("     МЕНЮ     \n 1.Мої характеристики \n 2.Бій \n 3.Магазин \n 4.Розробники, завершити\n(Вам потрібно вводити тільки цифру)");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Рівень: " + player.lvl + "\nГроші: " + player.cash + "\nБроня: " + player.hp + "\nШкода: " + player.damage);
                    break;
                case 2:
                    if (player.lvl == 1) {
                        result = rice.fight(player.hp, player.damage);
                    } else if (player.lvl == 3) {
                        result = ghost.fight(player.hp, player.damage);
                    } else if (player.lvl == 5) {
                        result = titan.fight(player.hp, player.damage);
                    } else {
                        result = odin.fight(player.hp, player.damage);
                    }
                    if (result.equalsIgnoreCase("win")) {
                        player.cash += 1500;
                        player.lvl += 2;
                        if (player.lvl > 7) {
                            System.out.println("  Вітаю ви пройшли гру!\n  Вітаю ви пройшли гру!  \n  Вітаю ви пройшли гру!");
                        }
                        System.out.println("Ви перемогли! \n Нагорода:" + 1500 + "\n Ваш рівень:" + player.lvl);
                    } else if (result.equalsIgnoreCase("lose")) {
                        player.cash += 250;
                        System.out.println("Ви програли \n Нагорода:" + 250 + "\n Ваш рівень:" + player.lvl);
                    }
                    break;
                case 3:
                    player.shop();
                    break;
                case 4:
                    System.out.println("Yura Voytovych\nAndriy Shmyhelskiy");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }
}
