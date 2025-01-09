// Интерфейс для геометрических фигур
interface Shape {
    double calculateArea(); // Метод для расчета площади
    String getFillColor(); // Метод для получения цвета заливки
    String getBorderColor(); // Метод для получения цвета границы

    // Дефолтный метод для расчета периметра
    default double calculatePerimeter() {
        return 0;
    }
}

// Класс для круга
class Circle implements Shape {
    private double radius; // Радиус круга
    private String fillColor; // Цвет заливки
    private String borderColor; // Цвет границы

    // Конструктор класса круга
    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; // Площадь круга
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius; // Периметр круга
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс для прямоугольника
class Rectangle implements Shape {
    private double width; // Ширина прямоугольника
    private double height; // Высота прямоугольника
    private String fillColor; // Цвет заливки
    private String borderColor; // Цвет границы

    // Конструктор класса прямоугольник
    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height; // Площадь прямоугольника
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height); // Периметр прямоугольника
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс для треугольника
class Triangle implements Shape {
    private double base; // Основание треугольника
    private double height; // Высота треугольника
    private String fillColor; // Цвет заливки
    private String borderColor; // Цвет границы

    // Конструктор класса Triangle
    public Triangle(double base, double height, String fillColor, String borderColor) {
        this.base = base; // Устанавливаем основание
        this.height = height; // Устанавливаем высоту
        this.fillColor = fillColor; // Устанавливаем цвет заливки
        this.borderColor = borderColor; // Устанавливаем цвет границы
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height; // рассчитанная площадь
    }

    @Override
    public double calculatePerimeter() {

        return 0;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Главный класс для демонстрации
public class GeometricShapes {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Зеленый", "Синий");
        Shape triangle = new Triangle(4, 3, "Желтый", "Фиолетовый");

        printShapeInfo("Круг", circle);
        printShapeInfo("Прямоугольник", rectangle);
        printShapeInfo("Треугольник", triangle);
    }

    // печатаем информацию о фигуре
    public static void printShapeInfo(String shapeName, Shape shape) {
        System.out.println(shapeName + ":");
        System.out.println("Площадь: " + shape.calculateArea()); // Выводим площадь
        System.out.println("Периметр: " + shape.calculatePerimeter()); // Выводим периметр
        System.out.println("Цвет заливки: " + shape.getFillColor()); // Выводим цвет заливки
        System.out.println("Цвет границы: " + shape.getBorderColor()); // Выводим цвет границы
        System.out.println();
    }
}
