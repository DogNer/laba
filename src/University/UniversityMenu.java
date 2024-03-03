package University;

import Input.DataInput;
import OutputData.OutputAllStudent;
import PeopleModel.OneStudent;
import PeopleModel.OneTeacher;
import Search.FindInFaculty;
import Tables.DrawTableFaculty;
import Tables.DrawTableKafedra;
import Tables.DrawTablePeople;
import Tables.DrawTableTeacher;

import java.io.IOException;

public class UniversityMenu {
    DataInput dataInput = new DataInput();
    public Faculty faculty = new Faculty();
    public Kafedra departure = new Kafedra();

    //DrawTableFaculty table = new DrawTableFaculty();

    DrawTableKafedra tableKaf = new DrawTableKafedra();
    DrawTableFaculty tableFac = new DrawTableFaculty();
    DrawTablePeople tableStudent = new DrawTablePeople();
    DrawTableTeacher tableTeacher = new DrawTableTeacher();
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
            case 4:
                searchFaculty();
                break;
            case 5:
                displayFaculty();
                break;
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

        faculty.addFaculty(new Faculty(facultyName));

        System.out.println("Факультет з назвою \"" + facultyName + "\" успішно створено.");
        backToMainMenu();
    }

    // Метод для видалення факультету
    private void deleteFaculty() throws IOException {
        System.out.println("Видалення факультету...");
        //table.getTable(2, faculty.getArrFaculty().size(), faculty.getArrDataFaculty());

        tableFac.getTable(faculty.getArrFaculty());
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
        //table.getTable(2, faculty.getArrFaculty().size(), faculty.getArrDataFaculty());

        tableFac.getTable(faculty.getArrFaculty());
        int choice = dataInput.getInt("Виберіть факультет для редагування: ");
        if (choice > 0 && choice <= faculty.getArrFaculty().size()) {
            editFacultyOptions(choice);
        }
        else System.out.println("Неправильний вибір факультету.");
    }

    // Метод для вибору опцій редагування факультету
    private void editFacultyOptions(int id) throws IOException {
        System.out.println("Оберіть, що саме ви хочете зробити:");
        System.out.println("1. Змінити назву факультету");
        System.out.println("2. Створити кафедру");
        System.out.println("3. Видалити кафедру");
        System.out.println("4. Редагувати кафедру");
        System.out.println("5. Назад");
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
            case 4:
                editDepartment(id);
                break;
            case 5:
                backToMainMenu();
                break;
            default:
                System.out.println("Неправильний вибір опції.");
        }
    }

    // Метод для зміни назви факультету
    private void changeFacultyName(int id) throws IOException {
        System.out.println("Зміна назви факультету...");
        System.out.println("Поточна назва факультету: " + faculty.getArrFaculty().get(id - 1).getNameFaculty());
        System.out.println("Введіть нову назву факультету ");
        String newFacultyName = dataInput.getString();
        if (!newFacultyName.isEmpty()) {
            faculty.changeName(id, newFacultyName); // Замінити назву факультету в мапі
            System.out.println("Назва факультету успішно змінена на \"" + newFacultyName + "\".");
        } else System.out.println("Неправильний вибір факультету.");
        editFacultyOptions(id);
    }

    // Метод для створення кафедри
    public void createDepartment(int id) throws IOException {
        System.out.println("Створення кафедри...");
        String departmentName = dataInput.getString("Введіть назву кафедри: ");

        faculty.getArrFaculty().get(id - 1).addKafedra(new Kafedra(faculty.getArrFaculty().get(id - 1).getNameFaculty(), departmentName));
        tableKaf.getTable(faculty.getArrFaculty().get(id - 1).getListKafedra());
        System.out.println("Кафедра \"" + departmentName + "\" на факультеті \""
                + faculty.getArrFaculty().get(id - 1).getNameFaculty() + "\" успішно створена.");

        editFacultyOptions(id);
    }

    // Метод для видалення кафедри
    public void deleteDepartment(int idFculty) throws IOException {
        System.out.println("Видалення кафедри...");
        System.out.println("Оберіть кафедру для видалення:");

        //table.getTable(3, faculty.getArrFaculty().get(idFculty).getListKafedra().size(), faculty.getArrFaculty().get(idFculty).getDataKafedraList());

        tableKaf.getTable(faculty.getArrFaculty().get(idFculty - 1).getListKafedra());
        int choice = dataInput.getInt("Виберіть кафедру для видалення: ");
        if (choice > 0 && choice <= faculty.getArrFaculty().get(idFculty - 1).getListKafedra().size()) {
            String deletedDepartment = faculty.getArrFaculty().get(idFculty - 1).getListKafedra().get(choice - 1).getNameKaf();
            faculty.getArrFaculty().get(idFculty - 1).removeKafedra(idFculty, choice);

            System.out.println(
                    "Кафедра \""
                            + deletedDepartment
                            + "\" на факультеті \""
                            + faculty.getArrFaculty().get(idFculty - 1).getNameFaculty()
                            + "\" успішно видалена.");
        } else System.out.println("Неправильний вибір кафедри.");
        editFacultyOptions(idFculty);
    }

    // Метод для редагування кафедри
    private void editDepartment(int id) throws IOException {
        System.out.println("Редагування кафедри...");
        System.out.println("Оберіть кафедру для редагування:");

        tableKaf.getTable(faculty.getArrFaculty().get(id - 1).getListKafedra());

        int departmentChoice = dataInput.getInt("Виберіть кафедру для редагування: ");
        if (departmentChoice < 1 || departmentChoice > faculty.getArrFaculty().get(id - 1).getListKafedra().size()) {
            System.out.println("Неправильний вибір кафедри.");
            return;
        }

        String selectedDepartment = faculty.getArrFaculty().get(id - 1)
                .getListKafedra().get(departmentChoice - 1).getNameKaf();

        System.out.println("Обрана кафедра: " + selectedDepartment);
        int option;
        do {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Змінити назву кафедри");
            System.out.println("2. Додати студента");
            System.out.println("3. Додати викладача");
            System.out.println("4. Видалити студента");
            System.out.println("5. Видалити викладача");
            System.out.println("6. Редагування студента");
            System.out.println("7. Редагування викладача");
            System.out.println("8. Повернутися назад");
            option = dataInput.getInt("Виберіть опцію: ");
            switch (option) {
                case 1:
                    changeDepartmentName(id, departmentChoice);
                    break;
                case 2:
                    addStudentToDepartment(id, departmentChoice);
                    break;
                case 3:
                    addTeacherToDepartment(id, departmentChoice);
                    break;
                case 4:
                    deleteStudentFromDepartment(id,  departmentChoice);
                    break;
                case 5:
                    deleteTeacherFromDepartment(id, departmentChoice);
                    break;
                case 6:
                    editStudent(id,  departmentChoice);
                    break;
                case 7:
                    editProfessor(id, departmentChoice);
                    break;
                case 8:
                    System.out.println("Повернення назад...");
                    break;
                default:
                    System.out.println("Неправильна опція. Спробуйте ще раз.");
            }
        } while (option != 8);
        editFacultyOptions(id);
    }

    // Метод для зміни назви кафедри
    private void changeDepartmentName(int idFaculty, int idDeparture) throws IOException {
        System.out.println("Зміна назви кафедри...");
        System.out.println("Введіть нову назву кафедри:");
        String newDepartmentName = dataInput.getString();

        faculty.getArrFaculty().get(idFaculty - 1).changeNameKafedra(idDeparture, newDepartmentName);
        tableKaf.getTable(faculty.getArrFaculty().get(idFaculty - 1).getListKafedra());
        System.out.println("Назва кафедри успішно змінена на \"" + newDepartmentName + "\".");
    }

    // Метод для додавання студента/студентки до кафедри
    private void addStudentToDepartment(int idFaculty, int idDeparture) throws IOException {
        System.out.println("Додавання студента...");
        String studentName = dataInput.getString("Введіть ім'я студента:");
        String studentSurName = dataInput.getString("Введіть прізвище студента:");
        int course = dataInput.getInt("Введіть курс студента:");

        faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1)
                .addStudent(new OneStudent(studentName, studentSurName,
                        faculty.getArrFaculty().get(idFaculty - 1).getNameFaculty(),
                        faculty.getArrFaculty().get(idFaculty - 1).getListKafedra().get(idDeparture - 1).getNameKaf(),
                        course));

        tableStudent.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getStList());
    }

    private void addTeacherToDepartment(int idFaculty, int idDeparture) throws IOException {
        System.out.println("Додавання викладача...");
        String studentName = dataInput.getString("Введіть ім'я викладача:");
        String studentSurName = dataInput.getString("Введіть прізвище викладача:");

        faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1)
                .addTeacher(new OneTeacher(studentName, studentSurName,
                        faculty.getArrFaculty().get(idFaculty - 1).getNameFaculty(),
                        faculty.getArrFaculty().get(idFaculty - 1).getListKafedra().get(idDeparture - 1).getNameKaf()));

        tableTeacher.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getTcList());
    }

    // Метод для видалення студента/студентки з кафедри
    private void deleteStudentFromDepartment(int idFaculty, int idDeparture) throws IOException {
        System.out.println("Видалення студента/студентки...");

        tableStudent.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getStList());

        int studentName = dataInput.getInt("Введіть id студента, якого потрібно видалити:");

        faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).removeSt(studentName);

        tableStudent.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getStList());
    }

    private void deleteTeacherFromDepartment(int idFaculty, int idDeparture) throws IOException {
        System.out.println("Видалення студента/студентки...");

        tableTeacher.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getTcList());

        int studentTeacher = dataInput.getInt("Введіть id студента, якого потрібно видалити:");

        faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).removeTeacher(studentTeacher);

        tableTeacher.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getTcList());
    }


    // Метод для редагування викладача кафедри
    private void editProfessor(int idFaculty, int idDeparture) throws IOException {
        System.out.println("Редагування викладача...");

        tableTeacher.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getTcList());

        int idTeacher = dataInput.getInt("Введіть id викладача, якого потрібно редагувати:");
        String newname = dataInput.getString("Введіть нове ім'я викладача:");
        String newSurname = dataInput.getString("Введіть нове прізвище викладача:");

        faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).changeNameTeacher(idTeacher, new OneTeacher(newname, newSurname));

        tableTeacher.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getTcList());
    }

    private void editStudent(int idFaculty, int idDeparture) throws IOException {
        System.out.println("Редагування студента...");

        tableStudent.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getStList());

        int idStudent = dataInput.getInt("Введіть id студента, якого потрібно редагувати:");
        String newname = dataInput.getString("Введіть нове ім'я викладача:");
        String newSurname = dataInput.getString("Введіть нове прізвище викладача:");

        faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).changeNameStudent(idStudent, new OneStudent(newname, newSurname));

        tableStudent.getTable(faculty.getArrFaculty().get(idFaculty - 1)
                .getListKafedra().get(idDeparture - 1).getStList());
    }


    // Метод для пошуку факультету
    private void searchFaculty() throws IOException {
        System.out.println("Пошук факультету...");

        FindInFaculty find = new FindInFaculty();
        backToMainMenu();
    }

    private void displayFaculty() {
        /*OutputAllStudent outputSt = new OutputAllStudent(faculty);
        outputSt.getSortStudents();*/
    }

    // Метод для повернення назад до головного меню
    private void backToMainMenu() throws IOException {
        System.out.println("Натисніть Enter для повернення до меню");
        if (!dataInput.getString().isEmpty()) {
            runMenu(); // Повернутися до головного меню
        }
    }
}
