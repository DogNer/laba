package Interfaces;

import University.Kafedra;

public interface KafedraRefactor {
    void addKafedra(Kafedra el);
    void remove(int pos);
    void changeName(int pos, String newName);
}
