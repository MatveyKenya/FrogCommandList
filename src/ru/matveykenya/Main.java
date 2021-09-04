package ru.matveykenya;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frog frog = new Frog();
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        System.out.println("Программа Лягушка");
        System.out.println(frog);
        while (true) {
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            System.out.println("введите команду для лягушки (>> << +число -число !! 0-выход:");
            String input = scanner.nextLine();
            if (input.equals("0")) break;

            if (input.equals("<<")) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).ungo();
                    curCommand--;
                }
            } else if (input.equals(">>")) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего отменять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).go();
                }
            } else { //пользователь ввёл новое движение для лягушки
                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                    commands.subList(curCommand+1, commands.size()).clear();
                }

                FrogCommand cmd;
                if (input.equals("!!")){
                    cmd = commands.get(curCommand);
                } else {
                    int steps = Integer.parseInt(input);
                    cmd = FrogCommands.jumpCommand(frog, steps);
                }

                if (cmd.go()){
                    curCommand++;
                    commands.add(cmd);
                }
            }

            //рисуем поле после команды
            System.out.println(frog);

        }
        System.out.println("конец программы");
    }


}
