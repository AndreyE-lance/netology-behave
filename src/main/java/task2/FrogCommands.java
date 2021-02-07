package task2;

public class FrogCommands{
    public static FrogCommand jumpRightCommand(final Frog frog, final int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return new FrogCommand() {
            public boolean move() {
                return frog.jump(steps);
            }

            public boolean undo() {
                return frog.jump(steps * -1);
            }
        };
    }

    public static FrogCommand jumpLeftCommand(final Frog frog, final int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return new FrogCommand() {
            public boolean move() {
                return frog.jump(steps*-1);
            }

            public boolean undo() {
                return frog.jump(steps);
            }
        };
    }


}
