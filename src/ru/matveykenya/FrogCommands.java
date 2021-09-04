package ru.matveykenya;

public class FrogCommands {
    public static FrogCommand jumpCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .go(), то лягушка её выполнит,
        // если вызвать .ungo(), то лягушка её отменит
        return new FrogCommand() {

            @Override
            public boolean go() {
                return frog.jump(steps);
            }

            @Override
            public boolean ungo() {
                return frog.jump(-steps);
            }
        };
    }
}
