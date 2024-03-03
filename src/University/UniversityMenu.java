package University;

import Input.DataInput;
import Search.FindInFaculty;
import Tables.DrawTable;
import University.Faculty;
import University.Kafedra;

import java.io.IOException;

public class UniversityMenu {
    DataInput dataInput = new DataInput();
    public Faculty faculty = new Faculty();
    public Kafedra departure = new Kafedra();

    DrawTable table = new DrawTable();

    public void runMenu() throws IOException {
        int choice;
        do {
            displayMainMenu();
            choice = dataInput.getInt("Виберіть опцію: ");
            if (choice != 0) {
                processChoice(choice);
            }
        } while (choice != 6);
    }

    // Метод для відображення головного меню
    private void displayMainMenu() {
        System.out.println("-----------------------------");
        System.out.println("<<ГОЛОВНЕ МЕНЮ УНІВЕРСИТЕТУ>>");
        System.out.println("-----------------------------");
        System.out.println("1. Створити факультет");
        System.out.println("2. Видалити факультет");
        System.out.println("3. Редагувати факультет");
        System.out.println("4. Пошук");
        System.out.println("5. Виведення");
        System.out.println("6. Вихід");
    }

    // Метод для обробки вибору користувача
    private void processChoice(int choice) throws IOException {
        switch (choice) {
            case 1:
                createFaculty();
                break;
            case 2:
                deleteFaculty();
                break;
            case 3:
                editFaculty();
                break;
            /*case 4:
                searchFaculty();
                break;
            case 5:
                displayFaculty();
                break;*/
            case 6:
                System.out.println("До побачення!");
                break;
            default:
                System.out.println("Неправильний вибір. Спробуйте ще раз.");
        }
    }

    // Метод для створення факультету
    private void createFaculty() throws IOException {
        System.out.println("Створення факультету...");
        System.out.println("Введіть назву факультету, який бажаєте створити: ");
        String facultyName = dataInput.getString();
        faculty.addFaculty(new Faculty(facultyName)); // Додати новий факультет з порожнім списком кафедр
        System.out.println("Факультет з назвою \"" + facultyName + "\" успішно створено.");
        backToMainMenu();
    }

    // Метод для видалення факультету
    private void deleteFaculty() throws IOException {
        System.out.println("Видалення факультету...");
        table.getTable(2, faculty.getArrFaculty().size(), faculty.getArrDataFaculty());

        int choice = dataInput.getInt("Виберіть факультет для видалення: ");
        if (choice > 0 && choice <= faculty.getArrFaculty().size()) {
            String nameDelete = faculty.getArrFaculty().get(choice - 1).getNameFaculty();

            faculty.removeFaculty(choice); // Видалити факультет зі списку
            System.out.println("Факультет \"" + nameDelete + "\" успішно видалено.");
        } else System.out.println("Неправильний вибір факультету.");

        backToMainMenu();
    }

    // Метод для редагування факультету
    private void editFaculty() throws IOException {
        System.out.println("Редагування факультету...");
        table.getTable(2, faculty.getArrFaculty().size(), faculty.getArrDataFaculty());

        int choice = dataInput.getInt("Виберіть факультет для редагування: ");
        if (choice > 0 && choice <= faculty.getArrFaculty().size()) {
            int chooseId = faculty.getArrFaculty().get(choice - 1).getId();
            editFacultyOptions(chooseId - 1);
        } else System.out.println("Неправильний вибір факультету.");
        backToMainMenu();
    }

    // Метод для вибору опцій редагування факультету
    private void editFacultyOptions(int id) throws IOException {
        System.out.println("Оберіть, що саме ви хочете зробити:");
        System.out.println("1. Змінити назву факультету");
        System.out.println("2. Створити кафедру");
        System.out.println("3. Видалити кафедру");
        System.out.println("4. Редагувати кафедру");
        int choice = dataInput.getInt("Виберіть опцію: ");
        switch (choice) {
            case 1:
                changeFacultyName(id);
                break;
            case 2:
                createDepartment(id);
                break;
            case 3:
                deleteDepartment(id);
                break;
            /*case 4:
                editDepartment(facultyName);
                break;*/
            default:
                System.out.println("Неправильний вибір опції.");
        }
    }

    // Метод для зміни назви факультету
    private void changeFacultyName(int id) throws IOException {
        System.out.println("Зміна назви факультету...");
        System.out.println("Поточна назва факультету: " + faculty.getArrFaculty().get(id).getNameFaculty());
        System.out.println("Введіть нову назву факультету ");
        String newFacultyName = dataInput.getString();
        if (!newFacultyName.isEmpty()) {
            faculty.changeName(id + 1, newFacultyName, departure); // Замінити назву факультету в мапі
            System.out.println("Назва факультету успішно змінена на \"" + newFacultyName + "\".");
        } else System.out.println("Неправильний вибір факультету.");
    }

    // Метод для створення кафедри
    public void createDepartment(int id) throws IOException {
        System.out.println("Створення кафедри...");
        String departmentName = dataInput.getString("Введіть назву кафедри: ");

        departure.addKafedra(new Kafedra(faculty.getArrFaculty().get(id).getNameFaculty(), departmentName));
        System.out.println("Кафедра \"" + departmentName + "\" на факультеті \"" + faculty.getArrFaculty().get(id).getNameFaculty() + "\" успішно створена.");
        table.getTable(3, departure.getArrKafedra().size(), departure.getArrData());
    }

    // Метод для видалення кафедри
    public void deleteDepartment(int id) throws IOException {
        System.out.println("Видалення кафедри...");
        System.out.println("Оберіть кафедру для видалення:");

        String[][] arr = departure.formTableCondition(departure.getArrKafedra().get(id).getNameFaculty());
        table.getTable(3, arr[0].length - 1, arr);

        int choice = dataInput.getInt("Виберіть кафедру для видалення: ");
        if (choice > 0 && choice <= departure.getArrKafedra().size()) {
            String deletedDepartment = departure.getArrKafedra().get(choice - 1).getNameKaf();

            departure.remove(choice);

            System.out.println(
                    "Кафедра \""
                            + deletedDepartment
                            + "\" на факультеті \""
                            + departure.getArrKafedra().get(id).getNameFaculty()
                            + "\" успішно видалена.");
        } else System.out.println("Неправильний вибір кафедри.");
    }

    // Метод для редагування кафедри
    /*private void editDepartment(String facultyName) throws IOException {
        System.out.println("Редагування кафедри...");
        System.out.println("Оберіть кафедру для редагування:");
        List<String> departments = faculties.get(facultyName);
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i));
        }
        int departmentChoice = dataInput.getInt("Виберіть кафедру для редагування: ");
        if (departmentChoice < 1 || departmentChoice > departments.size()) {
            System.out.println("Неправильний вибір кафедри.");
            return;
        }
        String selectedDepartment = departments.get(departmentChoice - 1);
        System.out.println("Обрана кафедра: " + selectedDepartment);
        int option;
        do {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Змінити назву кафедри");
            System.out.println("2. Додати студента/студентку");
            System.out.println("3. Видалити студента/студентку");
            System.out.println("4. Редагувати викладача");
            System.out.println("5. Повернутися назад");
            option = dataInput.getInt("Виберіть опцію: ");
            switch (option) {
                case 1:
                    changeDepartmentName(facultyName, selectedDepartment);
                    break;
                case 2:
                    addStudentToDepartment(facultyName, selectedDepartment);
                    break;
                case 3:
                    deleteStudentFromDepartment(facultyName, selectedDepartment);
                    break;
                case 4:
                    editProfessor(facultyName, selectedDepartment);
                    break;
                case 5:
                    System.out.println("Повернення назад...");
                    break;
                default:
                    System.out.println("Неправильна опція. Спробуйте ще раз.");
            }
        } while (option != 5);
    }
    // Метод для зміни назви кафедри
    private void changeDepartmentName(String facultyName, String departmentName) throws IOException {
        System.out.println("Зміна назви кафедри...");
        System.out.println("Введіть нову назву кафедри:");
        String newDepartmentName = dataInput.getString();
        List<String> departments = faculties.get(facultyName);
        departments.set(departments.indexOf(departmentName), newDepartmentName);
        System.out.println("Назва кафедри успішно змінена на \"" + newDepartmentName + "\".");
    }

    // Метод для додавання студента/студентки до кафедри
    private void addStudentToDepartment(String facultyName, String departmentName) throws IOException {
        System.out.println("Додавання студента/студентки...");
        System.out.println("Введіть ПІБ студента/студентки:");
        String studentName = dataInput.getString();
        System.out.println("Введіть курс студента/студентки:");
        String course = dataInput.getString();
        System.out.println("Введіть групу студента/студентки:");
        String group = dataInput.getString();
        // Операції для додавання студента до кафедри
        // Це може бути, наприклад, додавання інформації про студента до бази даних
    }

    // Метод для видалення студента/студентки з кафедри
    private void deleteStudentFromDepartment(String facultyName, String departmentName) throws IOException {
        System.out.println("Видалення студента/студентки...");
        System.out.println("Введіть ПІБ студента/студентки, якого потрібно видалити:");
        String studentName = dataInput.getString();
        // Операції для видалення студента з кафедри
        // Наприклад, видалення інформації про студента з бази даних
    }


    // Метод для редагування викладача кафедри
    private void editProfessor(String facultyName, String departmentName) throws IOException {
        System.out.println("Редагування викладача...");
        System.out.println("Введіть ПІБ викладача, якого потрібно редагувати:");
        String professorName = dataInput.getString();
        System.out.println("Введіть нове ПІБ для викладача:");
        String newProfessorName = dataInput.getString();
        // Операції для редагування викладача
        // Наприклад, оновлення інформації про викладача в базі даних
    }
*/


    // Метод для пошуку факультету
    private void searchFaculty() throws IOException {
        System.out.println("Пошук факультету...");

        FindInFaculty find = new FindInFaculty();
        backToMainMenu();
    }

    // Метод для виведення факультету
    /*private void displayFaculty() throws IOException {
        System.out.println("Виведення факультету...");
        for (String faculty : faculties.keySet()) {
            System.out.println(faculty);
            List<String> departments = faculties.get(faculty);
            for (String department : departments) {
                System.out.println("  - " + department);
            }
        }
        backToMainMenu();
    }*/

    // Метод для повернення назад до головного меню
    private void backToMainMenu() throws IOException {
        System.out.println("Натисніть Enter для повернення до меню");
        if (!dataInput.getString().isEmpty()) {
            runMenu(); // Повернутися до головного меню
        }
    }
}
