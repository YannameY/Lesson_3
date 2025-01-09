
class Animal {
    protected static int animalCount = 0; // Счетчик животных

    // Конструктор класса Animal
    public Animal() {
        animalCount++; // Увеличиваем счетчик животных
    }

    public void run(int distance) {} // Метод для бега животного
    public void swim(int distance) {} // Метод для плавания животного
    public static int getAnimalCount() {  // Метод для получения общего количества животных
        return animalCount; // Возвращаем текущее значение счетчика животных
    }
}

// Класс Собака, наследуется от класса Animal
class Dog extends Animal {
    private static int dogCount = 0; // Счетчик собак
    private String name; // Имя собаки

    // Конструктор класса Dog
    public Dog(String name) {
        super(); // Вызов конструктора родительского класса
        this.name = name; // Присваиваем имя
        dogCount++; // Увеличиваем счетчик собак
    }

    // Переопределенный метод для бега собаки
    @Override
    public void run(int distance) {
        // Проверяем, если собака может пробежать указанное расстояние
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м."); // Выводим сообщение о пробеге
        } else {
            System.out.println(name + " не может пробежать больше 500 м."); // Выводим сообщение о превышении расстояния
        }
    }

    // Переопределенный метод для плавания собаки
    @Override
    public void swim(int distance) {
        // Проверяем, если собака может проплыть указанное расстояние
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м."); // Выводим сообщение о плавании
        } else {
            System.out.println(name + " не может плавать более 10 м."); // Выводим сообщение о превышении расстояния
        }
    }

    // Метод для получения общего количества собак
    public static int getDogCount() {
        return dogCount; // Возвращаем текущее значение счетчика собак
    }
}

// Класс Кот, наследуется от класса Animal
class Cat extends Animal {
    private static int catCount = 0; // Счетчик котов
    private boolean isFull = false; // Состояние сытости кота
    private static final int distanceMax = 200; // Максимальная дистанция для бега кота
    private String name; // Имя кота

    // Конструктор класса Cat
    public Cat(String name) {
        super(); // Вызов конструктора родительского класса
        this.name = name; // Присваиваем имя
        catCount++; // Увеличиваем счетчик котов
    }

    // Переопределенный метод для бега кота
    @Override
    public void run(int distance) {
        // Проверяем, если кот может пробежать указанное расстояние
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м."); // Выводим сообщение о пробеге
        } else {
            System.out.println(name + " не может пробежать больше 200 м."); // Выводим сообщение о превышении расстояния
        }
    }

    // Переопределенный метод для плавания кота
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    // Метод, позволяющий коту поесть из миски
    public boolean eat(FoodBowl foodBowl) {
        // Проверяем, есть ли еда в миске
        if (foodBowl.getFoodAmount() > 0) {
            foodBowl.decreaseFood(1); // Кот кушает 1 единицу еды
            isFull = true; // Кот сыт
            System.out.println(name + " поел.");
            return true; // Возвращаем успешный результат
        } else {
            System.out.println("В миске недостаточно еды для " + name + ".");
            return false; // Возвращаем неуспешный результат
        }
    }
    // Метод для проверки, сыт ли кот
    public boolean isFull() {
        return isFull; // Возвращаем состояние сытости кота
    }
    // Геттер для имени кота
    public String getName() {
        return name; // Возвращаем имя кота
    }
    // Метод для получения общего количества котов
    public static int getCatCount() {
        return catCount; // Возвращаем текущее значение счетчика котов
    }
}
// Класс для миски с едой
class FoodBowl {
    private int foodAmount; // Количество еды в миске

    // Конструктор класса FoodBowl
    public FoodBowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0); // Не допускаем отрицательного значения
    }

    // Геттер для получения количества еды в миске
    public int getFoodAmount() {
        return foodAmount; // Возвращаем текущее количество еды
    }

    // Метод для уменьшения количества еды в миске
    public void decreaseFood(int amount) {
        // Проверяем, достаточно ли еды для уменьшения
        if (foodAmount >= amount) {
            foodAmount -= amount;
        } else {
            System.out.println("Недостаточно еды в миске. Еды осталось: " + foodAmount);
        }
    }

    // Метод для добавления еды в миску
    public void addFood(int amount) {
        // Проверяем, что добавляемое количество положительное
        if (amount > 0) {
            foodAmount += amount; // Увеличиваем количество еды
            System.out.println("Добавлено " + amount + " еды в миску. Теперь в миске: " + foodAmount);
        } else {
            System.out.println("Нельзя добавлять отрицательное количество еды.");
        }
    }
}

// Главный класс
class Main {
    public static void main(String[] args) {
        // Создаем массив из собак
        Dog [] dogs = {
                      new Dog("Рекс"),
                      new Dog("Мухтар")
        };
        for (Dog dog : dogs) {
            dog.run(300); // Собаки пробежали 300 м.
            dog.swim(5);  // Собаки проплылыли 5 м.
        }
        // Создаем массив из котов
        Cat[] cats = {
                new Cat("Боня"),
                new Cat("Мурзик"),
                new Cat("Барсик")
        };

        FoodBowl foodBowl = new FoodBowl(0); // Создаем миску с 0 единицами еды

        System.out.println();
        // Каждый кот пробегает фиксированную дистанцию и пытается поплыть
        for (Cat cat : cats) {
            cat.run(150); // Кот пытается пробежать 150 м.
            cat.swim(0); // Кот "пытается" поплыть (вывод сообщения о том, что не умеет плавать)
        }

        System.out.println();
        foodBowl.addFood(3); // Добавляем 3 единицы еды в миску
        // Каждый кот пытается покушать из миски
        for (Cat cat : cats) {
            cat.eat(foodBowl); // Вызываем метод eat для каждого кота
        }

        // Вывод информации о сытости котов
        for (Cat cat : cats) {
            System.out.println(cat.getName() + (cat.isFull() ? " сыт." : " голоден.")); // Проверяем состояние сытости и выводим результат
        }

        // Вывод количества созданных животных
        System.out.println();
        System.out.println("Котов создано: " + Cat.getCatCount()); // Выводим количество котов
        System.out.println("Собак создано: " + Dog.getDogCount()); // Выводим количество собак
        System.out.println("Всего животных создано: " + Animal.getAnimalCount()); // Выводим общее количество животных
    }
}
