package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //...

        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        List<FrogCommand> commands = new ArrayList<FrogCommand>();
        Frog frog = new Frog();
        int curCommand = -1;
        System.out.println("+N - в право на N прыжков\n" +
                "-N - в лево на N прыжков\n" +
                "<< - отмена последней команды\n" +
                ">> - повтор отмененной команды\n" +
                "!! - повтор последней команды\n" +
                "0 - выход");
        System.out.println("Введите команды для лягушки:");

        while (true) {
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            String inputCommand = bReader.readLine();
            if ("0".equals(inputCommand)) break;
            if ("<<".equals(inputCommand)) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
            } else if (">>".equals(inputCommand)) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего возвращать!");
                } else {
                    curCommand++;
                    commands.get(curCommand).move();
                }
            } else if ("!!".equals(inputCommand)) {
                if (curCommand == commands.size() - 1 && curCommand != -1) {
                    commands.add(commands.get(curCommand));
                    curCommand++;
                    commands.get(curCommand).move();
                } else {
                    System.out.println("Нечего повторять!");
                }
            } else {
                if (curCommand != commands.size() - 1) {
                    while (commands.size() - 1 > curCommand) {
                        commands.remove(commands.size() - 1);
                    }
                }
            }
            int stepValue = 0;

            try {
                stepValue = Integer.parseInt(inputCommand);
            } catch (NumberFormatException e) {
            }

            FrogCommand frogCommand = null;
            if (stepValue > 0) {
                frogCommand = FrogCommands.jumpRightCommand(frog, stepValue);
            } else if (stepValue < 0) {
                frogCommand = FrogCommands.jumpLeftCommand(frog, stepValue * -1);
            }

            if (frogCommand != null) {
                curCommand++;
                commands.add(frogCommand);
                frogCommand.move();
            }
        }
        System.out.println(frog.toString());
    }
}